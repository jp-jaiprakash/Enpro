/**
 * 
 */
package in.jaiprakash.repo;

import java.util.List;

import in.jaiprakash.entities.Purchaseorder;

/**
 * @author Jai Prakash
 * Email: prakashjai01@gmail.com
 *
 */
public interface PORepo extends GenericRepository<Purchaseorder, Integer> {

	/**
	 * @return
	 */
	List<Purchaseorder> findByJobid(String jobid);

}
