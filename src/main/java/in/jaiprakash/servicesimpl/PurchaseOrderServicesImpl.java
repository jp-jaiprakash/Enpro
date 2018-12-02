/**
 * 
 */
package in.jaiprakash.servicesimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.util.concurrent.CycleDetectingLockFactory.PotentialDeadlockException;

import in.jaiprakash.entities.Materialsmapping;
import in.jaiprakash.entities.Purchaseorder;
import in.jaiprakash.models.MaterialModel;
import in.jaiprakash.models.MaterialNameValue;
import in.jaiprakash.models.PurchaseorderModel;
import in.jaiprakash.repo.MaterialsMappingRepo;
import in.jaiprakash.repo.PORepo;
import in.jaiprakash.services.MaterialServices;
import in.jaiprakash.services.PurchaseOrderServices;
import in.jaiprakash.utils.Utils;
import ma.glasnost.orika.MapperFactory;

/**
 * @author Jai Prakash Email: prakashjai01@gmail.com
 *
 */
@Service
public class PurchaseOrderServicesImpl implements PurchaseOrderServices {

	@Autowired
	private PORepo porepo;

	@Autowired
	private MapperFactory mapperFactory;

	@Autowired
	private MaterialsMappingRepo materialsMappingRepo;

	@Autowired
	private MaterialServices materialServices;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * in.jaiprakash.services.PurchaseOrderServices#savePo(in.jaiprakash.models.
	 * PurchaseorderModel, java.lang.String)
	 */
	@Override
	public PurchaseorderModel savePo(PurchaseorderModel po, String potype) {
		// TODO Auto-generated method stub
		try{
			// every po means saving in mapping mster
			// save in material
			// save in po
			MaterialModel mm = po.getMaterial();
			mm.setUser2(po.getUser2());
			mm.setTotal(po.getPurchasedqty()); // Purchase order purchased quantity same as total in material mapping
			MaterialNameValue mmv= materialServices.addOldMaterial(mm, potype);
			Materialsmapping mme = materialsMappingRepo.getOne(mmv.getMappingMaterialId());
			
			Purchaseorder poentities = mapperFactory.getMapperFacade().map(po, Purchaseorder.class);
			poentities.setModificationdate(Utils.getTodaysUTCdate());
			poentities.setMaterialsmapping(mme);
			
			poentities = porepo.save(poentities);
			return mapperFactory.getMapperFacade().map(poentities, PurchaseorderModel.class);
			
		}catch(Exception ex){
			System.out.println(ex);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see in.jaiprakash.services.PurchaseOrderServices#getPo(in.jaiprakash.models.PurchaseorderModel)
	 */
	@Override
	public List<PurchaseorderModel> getPo(PurchaseorderModel po) {
		// TODO Auto-generated method stub
		List<Purchaseorder> poe = porepo.findByJobid(po.getJobid());
		List<PurchaseorderModel> lst = new ArrayList<PurchaseorderModel>();
		for(Purchaseorder pofor: poe){
			PurchaseorderModel pm = mapperFactory.getMapperFacade().map(pofor, PurchaseorderModel.class);
			lst.add(pm);
		}
		return lst;
	}

}
