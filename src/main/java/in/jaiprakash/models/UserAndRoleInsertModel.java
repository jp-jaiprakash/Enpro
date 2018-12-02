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
public class UserAndRoleInsertModel {

	private String username;
	private String password;
	private Integer creator;
	private List<Integer> lstOfRoles;
	private String insertresponse;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Integer> getLstOfRoles() {
		return lstOfRoles;
	}
	public void setLstOfRoles(List<Integer> lstOfRoles) {
		this.lstOfRoles = lstOfRoles;
	}
	public String getInsertresponse() {
		return insertresponse;
	}
	public void setInsertresponse(String insertresponse) {
		this.insertresponse = insertresponse;
	}
	public Integer getCreator() {
		return creator;
	}
	public void setCreator(Integer creator) {
		this.creator = creator;
	}
	
	
	
}
