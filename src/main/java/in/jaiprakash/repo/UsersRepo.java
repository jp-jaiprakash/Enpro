/**
 * 
 */
package in.jaiprakash.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import in.jaiprakash.entities.User;

/**
 * @author Jai Prakash
 * Email: prakashjai01@gmail.com
 *
 */
public interface UsersRepo extends GenericRepository<User, Integer>{

	@Query(value="select um.userid,u.username,ur.roleid, ur.rolevalue from enprosyst.usermappingtable um inner join enprosyst.users u on (um.userid = u.userid and u.username= :username and u.userpassword= :password)inner join enprosyst.uerroles ur on ur.roleid = um.usermapid" , nativeQuery=true)
	List<Object[]> fetchUserRoles(@Param("username") String username, @Param("password") String password);
	
	@Query(value="select u.userid from enprosyst.users u where u.username=:username and u.userpassword=:password" , nativeQuery=true)
	Integer getByUserNameAndPassword(@Param("username") String username, @Param("password") String password);
}
