package in.jaiprakash.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the materials database table.
 * 
 */
@Entity
@Table(name="materials")
@NamedQuery(name="Material.findAll", query="SELECT m FROM Material m")
public class Material implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int materialid;

	private double available;

//	@Temporal(TemporalType.TIMESTAMP)
//	private Date createddate;

	private String materialname;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modifieddate;

	private double reserved;

	private double total;

	//bi-directional many-to-one association to Materialissue
//	@OneToMany(mappedBy="material")
//	private List<Materialissue> materialissues;

	//bi-directional many-to-one association to Unit
	@ManyToOne
	@JoinColumn(name="unit")
	private Unit unitBean;

	//bi-directional many-to-one association to User
//	@ManyToOne
//	@JoinColumn(name="createdby")
//	private User user1;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="modifiedby")
	private User user2;

	//bi-directional many-to-one association to Materialsmapping
	@OneToMany(mappedBy="material")
	private List<Materialsmapping> materialsmappings;

	
	
	/**
	 * @param available
	 * @param createddate
	 * @param materialname
	 * @param modifieddate
	 * @param reserved
	 * @param total
	 * @param unitBean
	 * @param user2
	 */
	public Material(double available, Date createddate, String materialname, Date modifieddate, double reserved,
			double total, Unit unitBean, User user2) {
		super();
		this.available = available;
		this.materialname = materialname;
		this.modifieddate = modifieddate;
		this.reserved = reserved;
		this.total = total;
		this.unitBean = unitBean;
		this.user2 = user2;
	}

	public Material() {
	}

	public int getMaterialid() {
		return this.materialid;
	}

	public void setMaterialid(int materialid) {
		this.materialid = materialid;
	}

	public double getAvailable() {
		return this.available;
	}

	public void setAvailable(double available) {
		this.available = available;
	}

//	public Date getCreateddate() {
//		return this.createddate;
//	}
//
//	public void setCreateddate(Date createddate) {
//		this.createddate = createddate;
//	}

	public String getMaterialname() {
		return this.materialname;
	}

	public void setMaterialname(String materialname) {
		this.materialname = materialname;
	}

	public Date getModifieddate() {
		return this.modifieddate;
	}

	public void setModifieddate(Date modifieddate) {
		this.modifieddate = modifieddate;
	}

	public double getReserved() {
		return this.reserved;
	}

	public void setReserved(double reserved) {
		this.reserved = reserved;
	}

	public double getTotal() {
		return this.total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

//	public List<Materialissue> getMaterialissues() {
//		return this.materialissues;
//	}
//
//	public void setMaterialissues(List<Materialissue> materialissues) {
//		this.materialissues = materialissues;
//	}
//
//	public Materialissue addMaterialissue(Materialissue materialissue) {
//		getMaterialissues().add(materialissue);
//		materialissue.setMaterial(this);
//
//		return materialissue;
//	}
//
//	public Materialissue removeMaterialissue(Materialissue materialissue) {
//		getMaterialissues().remove(materialissue);
//		materialissue.setMaterial(null);
//
//		return materialissue;
//	}

	public Unit getUnitBean() {
		return this.unitBean;
	}

	public void setUnitBean(Unit unitBean) {
		this.unitBean = unitBean;
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

	public List<Materialsmapping> getMaterialsmappings() {
		return this.materialsmappings;
	}

	public void setMaterialsmappings(List<Materialsmapping> materialsmappings) {
		this.materialsmappings = materialsmappings;
	}

	public Materialsmapping addMaterialsmapping(Materialsmapping materialsmapping) {
		getMaterialsmappings().add(materialsmapping);
		materialsmapping.setMaterial(this);

		return materialsmapping;
	}

	public Materialsmapping removeMaterialsmapping(Materialsmapping materialsmapping) {
		getMaterialsmappings().remove(materialsmapping);
		materialsmapping.setMaterial(null);

		return materialsmapping;
	}

}