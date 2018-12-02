/**
 * 
 */
package in.jaiprakash.services;

import java.util.List;

import in.jaiprakash.models.JobByStatus;
import in.jaiprakash.models.SubStockJobModel;

/**
 * @author Jai Prakash
 * Email: prakashjai01@gmail.com
 *
 */
public interface SubStockJobServices {

	SubStockJobModel saveSubStock(SubStockJobModel substock);
	
	List<JobByStatus> getJobsByStatus(String status);
}
