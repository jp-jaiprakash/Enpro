package in.jaiprakash.entities;
import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the materialissue database table.
 * 
 */
@Entity
@NamedQuery(name="Materialissue.findAll", query="SELECT m FROM Materialissue m")
public class Materialissue implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int materialissueid;

//	@Temporal(TemporalType.TIMESTAMP)
//	private Date creationdate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateofissue;

	private String jobid;

	private int jobtype;

	private int materialmappingid;

	private int materialqty;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modifieddate;

	//bi-directional many-to-one association to Material
//	@ManyToOne
//	@JoinColumn(name="materialid", insertable= false, updatable=false)
//	private Material material;

	//bi-directional many-to-one association to User
//	@ManyToOne
//	@JoinColumn(name="createdby", insertable= false, updatable=false)
//	private User user1;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="modifiedby")
	private User user2;

	@ManyToOne
	@JoinColumn(name="materialmappingid", insertable= false, updatable=false)
	private Materialsmapping materialsmapping;
	
	public Materialissue() {
	}

	public int getMaterialissueid() {
		return this.materialissueid;
	}

	public void setMaterialissueid(int materialissueid) {
		this.materialissueid = materialissueid;
	}

//	public Date getCreationdate() {
//		return this.creationdate;
//	}
//
//	public void setCreationdate(Date creationdate) {
//		this.creationdate = creationdate;
//	}

	public Date getDateofissue() {
		return this.dateofissue;
	}

	public void setDateofissue(Date dateofissue) {
		this.dateofissue = dateofissue;
	}

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

	public int getMaterialmappingid() {
		return this.materialmappingid;
	}

	public void setMaterialmappingid(int materialmappingid) {
		this.materialmappingid = materialmappingid;
	}

	public int getMaterialqty() {
		return this.materialqty;
	}

	public void setMaterialqty(int materialqty) {
		this.materialqty = materialqty;
	}

	public Date getModifieddate() {
		return this.modifieddate;
	}

	public void setModifieddate(Date modifieddate) {
		this.modifieddate = modifieddate;
	}

//	public Material getMaterial() {
//		return this.material;
//	}
//
//	public void setMaterial(Material material) {
//		this.material = material;
//	}
//
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

	public Materialsmapping getMaterialsmapping() {
		return materialsmapping;
	}

	public void setMaterialsmapping(Materialsmapping materialsmapping) {
		this.materialsmapping = materialsmapping;
	}

}