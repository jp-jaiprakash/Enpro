/**
 * 
 */
package in.jaiprakash.models;

import java.util.Date;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import in.jaiprakash.entities.Uerrole;

/**
 * @author Jai Prakash
 * Email: prakashjai01@gmail.com
 *
 */
public class UserMappingModel {

	private int usermapid;

	private String userrole;
	
	/**
	 * 
	 */
	public UserMappingModel() {
		// TODO Auto-generated constructor stub
	}

	public int getUsermapid() {
		return usermapid;
	}

	public void setUsermapid(int usermapid) {
		this.usermapid = usermapid;
	}

	public String getUserrole() {
		return userrole;
	}

	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}
	
	
}
