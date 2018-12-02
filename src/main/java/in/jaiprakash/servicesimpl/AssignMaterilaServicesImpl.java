/**
 * 
 */
package in.jaiprakash.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.jaiprakash.entities.Material;
import in.jaiprakash.entities.Materialissue;
import in.jaiprakash.models.MaterialIssueModel;
import in.jaiprakash.models.MaterialModel;
import in.jaiprakash.models.MaterialNameValue;
import in.jaiprakash.repo.MaterialIssueRepo;
import in.jaiprakash.repo.MaterialRepo;
import in.jaiprakash.repo.MaterialsMappingRepo;
import in.jaiprakash.services.AssignMaterialServices;
import in.jaiprakash.services.MaterialServices;
import in.jaiprakash.utils.Utils;
import ma.glasnost.orika.MapperFactory;

/**
 * @author Jai Prakash
 * Email: prakashjai01@gmail.com
 *
 */
@Service
public class AssignMaterilaServicesImpl implements AssignMaterialServices{

	@Autowired
	private MaterialRepo materialRepo;
	
	@Autowired
	private MaterialIssueRepo materialIssuerepo;

	@Autowired
	private MapperFactory mapperFactory;

	@Autowired
	private MaterialsMappingRepo materialsMappingRepo;

	@Autowired
	private MaterialServices materialServices;
	
	@Override
	public boolean assignMaterial(MaterialIssueModel materialIssueModel) {
		// TODO Auto-generated method stub
		try{
			MaterialModel mm = new MaterialModel();
			mm.setMaterialid(materialIssueModel.getMateriaId());
			mm.setUser2(materialIssueModel.getUser2());
			mm.setUnitPrice(0.0); // or fetch the latesh price from mapping master only
			mm.setTotal(materialIssueModel.getMaterialqty());
			
			Material mat = materialRepo.getOne(materialIssueModel.getMateriaId());
			String source = Utils.getJobType(materialIssueModel.getJobid()) + " Assignment";
			MaterialNameValue materialNameValue = materialServices.saveInMappingOld(mat, mm, source);
			
			materialIssueModel.setMaterialmappingid(materialNameValue.getMappingMaterialId());
//			materialIssueModel.setDateofissue(Utils.getTodaysUTCdate());
			materialIssueModel.setModifieddate(Utils.getTodaysUTCdate());
			
			Materialissue materialIssue = mapperFactory.getMapperFacade().map(materialIssueModel, Materialissue.class);
			materialIssuerepo.save(materialIssue);
			return true;
		}catch(Exception ex){
			return false;
		}
	
		
		
	}

}
