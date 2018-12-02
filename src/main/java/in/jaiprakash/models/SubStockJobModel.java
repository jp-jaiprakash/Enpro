/**
 * 
 */
package in.jaiprakash.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Jai Prakash
 * Email: prakashjai01@gmail.com
 *
 */
public class SubStockJobModel {

	private int substockjobautoid;

	@Temporal(TemporalType.TIMESTAMP)
	private Date creationdate;

	private String jobid;

	private int jobtype;

	private Date modifidationdate;

	private List<MaterialsmappingModel> materialsmappinglst;

	private UserModel user1;

	private UserModel user2;
	
	// This is to store units
	private int unitId;
	
	// This is the name we need to store
	private String materialNewname;
	
	
	
	public int getUnitId() {
		return unitId;
	}

	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}

	public String getMaterialNewname() {
		return materialNewname;
	}

	public void setMaterialNewname(String materialNewname) {
		this.materialNewname = materialNewname;
	}

	/**
	 * 
	 */
	public SubStockJobModel() {
		// TODO Auto-generated constructor stub
	}

	public int getSubstockjobautoid() {
		return substockjobautoid;
	}

	public void setSubstockjobautoid(int substockjobautoid) {
		this.substockjobautoid = substockjobautoid;
	}

	public Date getCreationdate() {
		return creationdate;
	}

	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}

	public String getJobid() {
		return jobid;
	}

	public void setJobid(String jobid) {
		this.jobid = jobid;
	}

	public int getJobtype() {
		return jobtype;
	}

	public void setJobtype(int jobtype) {
		this.jobtype = jobtype;
	}

	public Date getModifidationdate() {
		return modifidationdate;
	}

	public void setModifidationdate(Date modifidationdate) {
		this.modifidationdate = modifidationdate;
	}

	public List<MaterialsmappingModel> getMaterialsmappinglst() {
		return materialsmappinglst;
	}

	public void setMaterialsmappinglst(List<MaterialsmappingModel> materialsmappinglst) {
		this.materialsmappinglst = materialsmappinglst;
	}

	public UserModel getUser1() {
		return user1;
	}

	public void setUser1(UserModel user1) {
		this.user1 = user1;
	}

	public UserModel getUser2() {
		return user2;
	}

	public void setUser2(UserModel user2) {
		this.user2 = user2;
	}
	
	
}
