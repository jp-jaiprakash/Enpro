/**
 * 
 */
package in.jaiprakash.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import in.jaiprakash.entities.Job;

/**
 * @author Jai Prakash
 * Email: prakashjai01@gmail.com
 *
 */
public interface JobRepository extends GenericRepository<Job, Integer> {

	/**
	 * @return
	 */
	@Query(value="select ej.jobid from enprosyst.jobs ej where ej.jobid is not null" , nativeQuery=true)
	List<String> getJobIds();
	
	@Query(value="select ej.jobid from enprosyst.substockjobs ej where ej.jobtype = 2 and ej.jobid is not null" , nativeQuery=true)
	List<String> getSubJobIds();
	
	@Query(value="select ej.jobid from enprosyst.substockjobs ej where ej.jobtype = 3 and  ej.jobid is not null" , nativeQuery=true)
	List<String> getStockJobIds();
	
	@Query(value="select ej.jobid, ej.jobclientname, ej.modifieddate, ej.jobdeliverydate, ej.jobstatus from enprosyst.jobs ej  where ej.jobdeliverydate<=:todaysdate  and ej.jobstatus in (0,1)", nativeQuery=true)
	List<Object[]> getRunningAndCreated(@Param("todaysdate") String todaysdate);
	
	@Query(value="select ej.jobid, ej.jobclientname, ej.modifieddate, ej.jobdeliverydate, ej.jobstatus from enprosyst.jobs ej", nativeQuery=true)
	List<Object[]> getAllJobs();
	
	@Query(value="select ej.jobid, ej.jobclientname, ej.modifieddate, ej.jobdeliverydate, ej.jobstatus from enprosyst.jobs ej where ej.jobdeliverydate<=:fromdate  and ej.jobstatus in (0,1) order by ej.jobdeliverydate asc", nativeQuery=true)
	List<Object[]> deadlineJobs(@Param("fromdate") String fromdate);

}
