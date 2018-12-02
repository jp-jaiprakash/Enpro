/**
 * 
 */
package in.jaiprakash.servicesimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.jaiprakash.entities.User;
import in.jaiprakash.models.UserAndRoleInsertModel;
import in.jaiprakash.models.UserAndRoleModel;
import in.jaiprakash.models.UserMappingModel;
import in.jaiprakash.models.UserModel;
import in.jaiprakash.repo.UsersMappingRepo;
import in.jaiprakash.repo.UsersRepo;
import in.jaiprakash.services.UserServices;

/**
 * @author Jai Prakash Email: prakashjai01@gmail.com
 *
 */
@Service
public class UserServicesImpl implements UserServices {

	@Autowired
	private UsersRepo usersRepo;

	@Autowired
	private UsersMappingRepo usersMappingRepo;

	/*
	 * (non-Javadoc)
	 * 
	 * @see in.jaiprakash.services.UserServices#loginUser(in.jaiprakash.models.
	 * UserModel)
	 */
	@Override
	public UserAndRoleModel loginUser(UserModel user) {
		// TODO Auto-generated method stub
		UserAndRoleModel urm = new UserAndRoleModel();
		int userid = 0;
		String username = null;
		List<UserMappingModel> lstumm = new ArrayList<UserMappingModel>();
		List<Object[]> lst = usersRepo.fetchUserRoles(user.getUsername(), user.getUserpassword());
		for (Object[] obj : lst) {
			userid = (Integer) obj[0];
			username = (String) obj[1];
			UserMappingModel umm = new UserMappingModel();
			umm.setUsermapid((Integer) obj[2]);
			umm.setUserrole((String) obj[3]);
			lstumm.add(umm);
		}

		urm.setLstOfRoles(lstumm);
		urm.setUserid(userid);
		urm.setUsername(username);

		return urm;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * in.jaiprakash.services.UserServices#insertIntoUser(in.jaiprakash.models.
	 * UserAndRoleInsertModel)
	 */
	@Override
	public UserAndRoleInsertModel insertIntoUser(UserAndRoleInsertModel user) {
		/*
		 * First check if user exists If user exists in user table => delete all
		 * the enteries from usermapping table and insert If user does not exist
		 * => save the user in user table and then save the values in
		 * usermapping table
		 */
		// String response = "";
		try {
			Integer userid = usersRepo.getByUserNameAndPassword(user.getUsername(), user.getPassword());
			if (null == userid) {
				User userEntity = new User();
				userEntity.setUsername(user.getUsername());
				userEntity.setUserpassword(user.getPassword());
				usersRepo.save(userEntity);
			} else {
//				usersMappingRepo.removeRoles(userid);
			}
			for (int roleid : user.getLstOfRoles()) {
				usersMappingRepo.addRoles(userid, roleid, user.getCreator());
			}
			// response = "SUCCESS";
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			// response = "FAIL";
			return null;
		}
		user.setInsertresponse("SUCCESS");
		// remove all the existing roles
		return user;
	}

}
