/**
 * 
 */
package in.jaiprakash.services;

import java.util.List;

import in.jaiprakash.models.UnitModel;
import in.jaiprakash.models.UserAndRoleModel;
import in.jaiprakash.models.UserRolesModel;

/**
 * @author Jai Prakash
 * Email: prakashjai01@gmail.com
 *
 */
public interface GeneralServices {

	List<UnitModel> getUnits();
	
	List<UserRolesModel> getAllRoles();
}
