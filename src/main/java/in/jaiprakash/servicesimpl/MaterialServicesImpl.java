/**
 * 
 */
package in.jaiprakash.servicesimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.jaiprakash.entities.Material;
import in.jaiprakash.entities.Materialsmapping;
import in.jaiprakash.entities.Unit;
import in.jaiprakash.entities.User;
import in.jaiprakash.models.MaterialModel;
import in.jaiprakash.models.MaterialNameValue;
import in.jaiprakash.models.MaterialsmappingModel;
import in.jaiprakash.models.UnitModel;
import in.jaiprakash.repo.MaterialRepo;
import in.jaiprakash.repo.MaterialsMappingRepo;
import in.jaiprakash.repo.UsersMappingRepo;
import in.jaiprakash.repo.UsersRepo;
import in.jaiprakash.services.MaterialServices;
import in.jaiprakash.utils.Utils;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;

/**
 * @author Jai Prakash Email: prakashjai01@gmail.com
 *
 */
@Service
public class MaterialServicesImpl implements MaterialServices {

	private static final Logger logsl4j = Logger.getLogger(MaterialServicesImpl.class);

	@Autowired
	private MaterialRepo materialRepo;

	@Autowired
	private MapperFactory mapperFactory;

	@Autowired
	private MaterialsMappingRepo materialsMappingRepo;

	@Autowired
	private UsersRepo userRepo;

	@Override
	public MaterialModel getSingleValue(Integer materialId) {
		Material material = materialRepo.getOne(materialId);

		try {
			MapperFacade mapper = mapperFactory.getMapperFacade();
			return mapper.map(material, MaterialModel.class);
		} catch (Exception exception) {
			logsl4j.error(exception);
			System.out.println(exception);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.jaiprakash.services.MaterialServices#getAllMaterials()
	 */
	@Override
	public List<MaterialNameValue> getAllMaterials() {
		// TODO Auto-generated method stub
		try {
			List<Object[]> lstMaterilaNameNValue = materialRepo.fetchMaterialNamesNValues();
			List<MaterialNameValue> lst = new ArrayList<>();
			if (lstMaterilaNameNValue.size() > 0) {
				for (Object[] obj : lstMaterilaNameNValue) {
					int matid = obj[0] != null ? (Integer) obj[0] : -1;
					String matname = obj[1] != null ? (String) obj[1] : "";

					MaterialNameValue mnv = new MaterialNameValue(matid, matname);
					lst.add(mnv);
				}
				return lst;
			}
		} catch (Exception ex) {
			logsl4j.error(ex);
		}

		return new ArrayList<>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * in.jaiprakash.services.MaterialServices#addOldMaterial(in.jaiprakash.
	 * models.MaterialModel) please note taht getTotal is where we set added
	 * quantity
	 */
	@Override
	public MaterialNameValue addOldMaterial(MaterialModel material, String source) {
		// TODO Auto-generated method stub
		/*
		 * Search if the name exists, and if not present then only add it
		 */
		try {
			List<Material> lst = checkIfmaterialPresent(material.getMaterialname());
			Material mat;
			if (lst.size() > 0) {
				// just update it
				// But before updating needs to update materialsmapping
				mat = lst.get(0);

			} else {
				// if it is a new record then first save the record

				/**
				 * @param available
				 * @param createddate
				 * @param materialname
				 * @param modifieddate
				 * @param reserved
				 * @param total
				 * @param unitBean
				 * @param user2
				 */
				mat = new Material(material.getTotal(), Utils.getTodaysUTCdate(), material.getMaterialname(),
						Utils.getTodaysUTCdate(), 0, material.getTotal(), new Unit(material.getUnitBean().getUnitid()),
						new User(material.getUser2().getUserid()));

				mat = materialRepo.save(mat);
			}
			return saveInMappingOld(mat, material, source);
		} catch (Exception ex) {
			logsl4j.error(ex);
		}

		return null;
	}

	public List<Material> checkIfmaterialPresent(String materialname) {
		return materialRepo.findBymaterialname(materialname);
	}

	// public MaterialsmappingModel getMaterialMapping(){
	//
	// }
	@Override
	public MaterialNameValue saveInMappingOld(Material mat, MaterialModel material, String source) {
		try {
			User user2 = new User(material.getUser2().getUserid());
			// User usr3 = userRepo.getOne(material.getUser2().getUserid());
			double unitprice = null != material.getUnitPrice() ? material.getUnitPrice() : 0;

			Materialsmapping materialsmapping = new Materialsmapping(Utils.getTodaysUTCdate(), source.toUpperCase(),
					((Double) material.getTotal()).intValue(), unitprice, mat, user2);
			// save in
			materialsmapping = materialsMappingRepo.save(materialsmapping);

			if (source.contains("Assignment")) {
				mat.setTotal((mat.getTotal() - material.getTotal()));
				mat.setAvailable(mat.getAvailable() - material.getTotal());
			} else {

				mat.setAvailable(mat.getAvailable() + material.getTotal());
				mat.setTotal(mat.getTotal() + material.getTotal());
			}
			mat.setModifieddate(Utils.getTodaysUTCdate());

			mat = materialRepo.save(mat);
			return new MaterialNameValue(mat.getMaterialid(), mat.getMaterialname(),
					materialsmapping.getMaterialsmappingid());
		} catch (Exception ex) {
			System.out.println(ex);
		}
		// modified by
		return null;
	}

	public String processmaterialName(String matName) {
		return matName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.jaiprakash.services.MaterialServices#getMaterialsForExport()
	 */
	@Override
	public List<MaterialModel> getMaterialsForExport() {
		// TODO Auto-generated method stub
		List<Object[]> lst = materialRepo.fetchMaterialsWithQuantity();
		List<MaterialModel> lstmm= new ArrayList<>();
		for(Object[] obj: lst){
			MaterialModel mm = new MaterialModel();
			mm.setMaterialid((Integer) obj[0]);
			mm.setMaterialname((String)obj[1]);
			mm.setTotal( (Double) obj[2] );
			mm.setReserved((Double) obj[3]);
			mm.setAvailable((Double) obj[4]);
			mm.setUnitBean(new UnitModel((String)obj[5]));
			
			lstmm.add(mm);
		}
		return lstmm;
	}

}
