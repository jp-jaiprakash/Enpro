package in.jaiprakash.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the substockjobs database table.
 * 
 */
@Entity
@Table(name="substockjobs")
@NamedQuery(name="Substockjob.findAll", query="SELECT s FROM Substockjob s")
public class Substockjob implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int substockjobautoid;

//	@Temporal(TemporalType.TIMESTAMP)
//	private Date creationdate;

	private String jobid;

	private int jobtype;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modifidationdate;

	//bi-directional many-to-one association to Materialsmapping
	@ManyToOne
	@JoinColumn(name="materialmappingid")
	private Materialsmapping materialsmapping;

	//bi-directional many-to-one association to User
//	@ManyToOne
//	@JoinColumn(name="createdby")
//	private User user1;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="modifiedby")
	private User user2;

	public Substockjob() {
	}

	public int getSubstockjobautoid() {
		return this.substockjobautoid;
	}

	public void setSubstockjobautoid(int substockjobautoid) {
		this.substockjobautoid = substockjobautoid;
	}

//	public Date getCreationdate() {
//		return this.creationdate;
//	}
//
//	public void setCreationdate(Date creationdate) {
//		this.creationdate = creationdate;
//	}

	public String getJobid() {
		return this.jobid;
	}

	public void setJobid(String jobid) {
		this.jobid = jobid;
	}

	public int getJobtype() {
		return this.jobtype;
	}

	public void setJobtype(int jobtype) {
		this.jobtype = jobtype;
	}

	public Date getModifidationdate() {
		return this.modifidationdate;
	}

	public void setModifidationdate(Date modifidationdate) {
		this.modifidationdate = modifidationdate;
	}

	public Materialsmapping getMaterialsmapping() {
		return this.materialsmapping;
	}

	public void setMaterialsmapping(Materialsmapping materialsmapping) {
		this.materialsmapping = materialsmapping;
	}

//	public User getUser1() {
//		return this.user1;
//	}
//
//	public void setUser1(User user1) {
//		this.user1 = user1;
//	}

	public User getUser2() {
		return this.user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}

}