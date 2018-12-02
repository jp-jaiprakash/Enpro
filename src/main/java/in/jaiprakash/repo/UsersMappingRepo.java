/**
 * 
 */
package in.jaiprakash.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import in.jaiprakash.entities.Usermappingtable;

/**
 * @author Jai Prakash
 * Email: prakashjai01@gmail.com
 *
 */
public interface UsersMappingRepo extends GenericRepository<Usermappingtable, Integer> {

	@Transactional
	@Modifying
	@Query(value="insert into enprosyst.usermappingtable  (userid, userrole, createdby) values (:userid,:userrole,:createdby)" , nativeQuery=true)
	void addRoles(@Param("userid") Integer userid, @Param("userrole") Integer userrole, @Param("createdby") Integer createdby);

	@Transactional
	@Modifying
	@Query(value="delete from enprosyst.usermappingtable  where userid = :userid" , nativeQuery=true)
	void removeRoles(@Param("userid") Integer userid);

}
