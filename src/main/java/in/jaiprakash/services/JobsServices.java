/**
 * 
 */
package in.jaiprakash.services;

import java.util.List;

import in.jaiprakash.exception.NotFoundException;
import in.jaiprakash.models.JobModel;

/**
 * @author Jai Prakash
 * Email: prakashjai01@gmail.com
 *
 */
public interface JobsServices {

	JobModel createAJob(JobModel job);
	
//	JobModel updaeAJob(JobModel job);
	
	JobModel getById(int jobId) throws NotFoundException;

	/**
	 * @param payload
	 * @return
	 */
	JobModel saveJob(JobModel payload);
	
	List<String> jobids();
	
	List<String> subjobids();
	
	List<String> stockjobids();
}
