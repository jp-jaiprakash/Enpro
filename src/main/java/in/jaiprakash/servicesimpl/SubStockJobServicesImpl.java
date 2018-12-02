/**
 * 
 */
package in.jaiprakash.servicesimpl;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.jaiprakash.entities.Materialsmapping;
import in.jaiprakash.entities.Substockjob;
import in.jaiprakash.models.JobByStatus;
import in.jaiprakash.models.MaterialModel;
import in.jaiprakash.models.MaterialNameValue;
import in.jaiprakash.models.MaterialsmappingModel;
import in.jaiprakash.models.SubStockJobModel;
import in.jaiprakash.models.UnitModel;
import in.jaiprakash.repo.JobRepository;
import in.jaiprakash.repo.MaterialsMappingRepo;
import in.jaiprakash.repo.SubStockJobRepo;
import in.jaiprakash.services.MaterialServices;
import in.jaiprakash.services.SubStockJobServices;
import in.jaiprakash.utils.Utils;
import ma.glasnost.orika.MapperFactory;

/**
 * @author Jai Prakash Email: prakashjai01@gmail.com
 *
 */
@Service
public class SubStockJobServicesImpl implements SubStockJobServices {

	@Autowired
	private MapperFactory mapperFactory;

	@Autowired
	private SubStockJobRepo subStockJobrepo;

	@Autowired
	private MaterialServices materialServices;

	@Autowired
	private MaterialsMappingRepo materialsMappingRepo;
	
	@Autowired
	private JobRepository jobRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * in.jaiprakash.services.SubStockJobServices#saveSubStock(in.jaiprakash.
	 * models.SubStockJobModel)
	 */
	@Override
	public SubStockJobModel saveSubStock(SubStockJobModel substock) {
		try {
			MaterialModel mm = new MaterialModel();
			List<MaterialsmappingModel> materialsmappinglst = substock.getMaterialsmappinglst();
			mm.setMaterialname(substock.getMaterialNewname());

			mm.setTotal(materialsmappinglst.get(0).getQuantity());
			mm.setUnitBean(new UnitModel(substock.getUnitId()));
			mm.setUser2(substock.getUser2());
			String source = substock.getJobtype() == 2 ? "Stock Job" : "Sub Job";
			// now call add old material method
			MaterialNameValue mmv = materialServices.addOldMaterial(mm, source);
			Materialsmapping mme = materialsMappingRepo.getOne(mmv.getMappingMaterialId());

			Substockjob ssj;
			substock.setCreationdate(Utils.getTodaysUTCdate());
			substock.setModifidationdate(Utils.getTodaysUTCdate());
			ssj = mapperFactory.getMapperFacade().map(substock, Substockjob.class);
			ssj.setMaterialsmapping(mme);
			ssj = subStockJobrepo.save(ssj);
			substock.setJobid(ssj.getJobid());
			return substock;
		} catch (Exception ex) {
			System.out.println(ex);
		}

		return null;
	}

	/* (non-Javadoc)
	 * @see in.jaiprakash.services.SubStockJobServices#getJobsByStatus(java.lang.String)
	 */
	@Override
	public List<JobByStatus> getJobsByStatus(String status) {
		// TODO Auto-generated method stub
		List<Object[]> lst = new ArrayList<>();
		List<JobByStatus> newlst = new ArrayList<>();
		if(status.equals("all")){
			lst = jobRepository.getAllJobs();
		}else if(status.equals("running")){
			lst= jobRepository.getRunningAndCreated(gettodaysdate(null));
		}else if(status.equals("deadline")){
			lst= jobRepository.deadlineJobs(gettodaysdate(null));
		}
		System.out.println(lst.size());
		for(Object[] o:lst){
				String jobid= (String)o[0];
				String clientname = (String)o[1];
				String modifieddate = gettodaysdate((timestampToStr((java.sql.Timestamp)o[2])));
				String deliverydate = gettodaysdate((timestampToStr((java.sql.Timestamp)o[3])));
				Integer statusVal = (Integer)o[4];
				
				JobByStatus jb = new JobByStatus();
				jb.setClientName(clientname);
				jb.setDeliverydate(deliverydate);
				jb.setJobid(jobid);
				jb.setLastModified(modifieddate);
				jb.setStatus(statusVal);
				newlst.add(jb);
				
		}
		return newlst;
	}
	public String timestampToStr(java.sql.Timestamp ts){
		String formattedDate = new SimpleDateFormat("yyyy-MM-dd").format(ts);
		return formattedDate;
	}
	public String gettodaysdate(String value){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		try {
			if(null == value){
				date = new Date();
			}else{
				date = dateFormat.parse(value);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dateFormat.format(date);
	}

}
