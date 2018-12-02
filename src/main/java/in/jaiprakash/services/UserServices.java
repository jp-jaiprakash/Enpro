/**
 * 
 */
package in.jaiprakash.services;

import in.jaiprakash.models.UserAndRoleInsertModel;
import in.jaiprakash.models.UserAndRoleModel;
import in.jaiprakash.models.UserModel;

/**
 * @author Jai Prakash
 * Email: prakashjai01@gmail.com
 *
 */
public interface UserServices {

	UserAndRoleModel loginUser(UserModel user);
	
	UserAndRoleInsertModel insertIntoUser(UserAndRoleInsertModel user);
}
