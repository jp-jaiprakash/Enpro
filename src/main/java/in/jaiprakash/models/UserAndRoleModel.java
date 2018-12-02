/**
 * 
 */
package in.jaiprakash.models;

import java.util.List;

/**
 * @author Jai Prakash
 * Email: prakashjai01@gmail.com
 *
 */
public class UserAndRoleModel {

	private int userid;
	
	private String username;
	
	private List<UserMappingModel> lstOfRoles;
	
	/**
	 * 
	 */
	public UserAndRoleModel() {
		// TODO Auto-generated constructor stub
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<UserMappingModel> getLstOfRoles() {
		return lstOfRoles;
	}

	public void setLstOfRoles(List<UserMappingModel> lstOfRoles) {
		this.lstOfRoles = lstOfRoles;
	}
	
	
}
