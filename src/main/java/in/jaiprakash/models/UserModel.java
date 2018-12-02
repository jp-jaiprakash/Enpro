/**
 * 
 */
package in.jaiprakash.models;

/**
 * @author Jai Prakash
 * Email: prakashjai01@gmail.com
 *
 */
public class UserModel {

	private int userid;

	private String username;

	private String userpassword;
	
	/**
	 * 
	 */
	public UserModel() {
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

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	
	
}
