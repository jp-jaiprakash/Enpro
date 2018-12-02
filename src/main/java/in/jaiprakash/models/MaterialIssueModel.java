/**
 * 
 */
package in.jaiprakash.models;

import java.util.Date;

import in.jaiprakash.entities.User;

/**
 * @author Jai Prakash
 * Email: prakashjai01@gmail.com
 *
 */
public class MaterialIssueModel {

	private int materialissueid;

	private Date dateofissue;

	private String jobid;

	private int jobtype;

	private int materialmappingid;

	private int materialqty;

	private Date modifieddate;

	private int materiaId;
	private UserModel user2;

	private MaterialsmappingModel materialsmapping;

	public int getMaterialissueid() {
		return materialissueid;
	}





	public int getMateriaId() {
		return materiaId;
	}





	public void setMateriaId(int materiaId) {
		this.materiaId = materiaId;
	}





	public void setMaterialissueid(int materialissueid) {
		this.materialissueid = materialissueid;
	}

	public Date getDateofissue() {
		return dateofissue;
	}

	public void setDateofissue(Date dateofissue) {
		this.dateofissue = dateofissue;
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

	public int getMaterialmappingid() {
		return materialmappingid;
	}

	public void setMaterialmappingid(int materialmappingid) {
		this.materialmappingid = materialmappingid;
	}

	public int getMaterialqty() {
		return materialqty;
	}

	public void setMaterialqty(int materialqty) {
		this.materialqty = materialqty;
	}

	public Date getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(Date modifieddate) {
		this.modifieddate = modifieddate;
	}

	public UserModel getUser2() {
		return user2;
	}

	public void setUser2(UserModel user2) {
		this.user2 = user2;
	}

	public MaterialsmappingModel getMaterialsmapping() {
		return materialsmapping;
	}

	public void setMaterialsmapping(MaterialsmappingModel materialsmapping) {
		this.materialsmapping = materialsmapping;
	}
	
	
}
