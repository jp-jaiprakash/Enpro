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

import in.jaiprakash.entities.Job;
import in.jaiprakash.exception.NotFoundException;
import in.jaiprakash.models.JobModel;
import in.jaiprakash.repo.JobRepository;
import in.jaiprakash.services.JobsServices;
import in.jaiprakash.utils.Utils;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;

/**
 * @author Jai Prakash Email: prakashjai01@gmail.com
 *
 */

@Service
public class JobServicesImpl implements JobsServices {

	private static final Logger logsl4j = Logger.getLogger(JobsServices.class);

	@Autowired
	private JobRepository jobRepository;

	@Autowired
	private MapperFactory mapperFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.jaiprakash.services.JobsServices#createAJob(in.jaiprakash.models.
	 * JobModel)
	 */
	@Override
	public JobModel createAJob(JobModel job) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.jaiprakash.services.JobsServices#getById(int)
	 */
	@Override
	public JobModel getById(int jobId) throws NotFoundException {

		// TODO Auto-generated method stub
		Optional<Job> jbmEntity = jobRepository.findById(jobId);
		return convertToModel(jbmEntity.get());

	}

	private JobModel convertToModel(Job jobDetails) {
		try {
			MapperFacade mapper = mapperFactory.getMapperFacade();
			return mapper.map(jobDetails, JobModel.class);
		} catch (Exception exception) {
			logsl4j.error(exception);
			System.out.println(exception);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.jaiprakash.services.JobsServices#saveJob(in.jaiprakash.models.
	 * JobModel)
	 */
	@Override
	public JobModel saveJob(JobModel jobModel) {
		// TODO Auto-generated method stub
		try {
			// job status
			// 0, 1, 2
			jobModel.setJobname(jobModel.getJobid() + "_" + jobModel.getJobdeliverydate().toString() + "_"
					+ jobModel.getJobclientname());
			jobModel.setJobstatus(0);

			MapperFacade mapper = mapperFactory.getMapperFacade();
			Job job = mapper.map(jobModel, Job.class);
			job.setModifieddate(Utils.getTodaysUTCdate());
			job = jobRepository.save(job);
			return convertToModel(job);
		} catch (Exception ex) {
			logsl4j.error(ex);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.jaiprakash.services.JobsServices#jobids()
	 */
	@Override
	public List<String> jobids() {
		try {
			return jobRepository.getJobIds();
		} catch (Exception ex) {
			System.out.println(ex);
			return null;
		}
	}

	@Override
	public List<String> subjobids() {
		try {
			return jobRepository.getSubJobIds();
		} catch (Exception ex) {
			System.out.println(ex);
			return null;
		}
//		List<Object[]> lst = jobRepository.getSubJobIds();
//		List<String> lstJobids = new ArrayList<>();
//		for (Object[] obj : lst) {
//			lstJobids.add((String) obj[0]);
//		}
//		return lstJobids;
	}

	@Override
	public List<String> stockjobids() {
		try {
			return jobRepository.getStockJobIds();
		} catch (Exception ex) {
			System.out.println(ex);
			return null;
		}
//		List<Object[]> lst = jobRepository.getStockJobIds();
//		List<String> lstJobids = new ArrayList<>();
//		for (Object[] obj : lst) {
//			lstJobids.add((String) obj[0]);
//		}
//		return lstJobids;
	}

}
