package in.jaiprakash.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the purchaseorder database table.
 * 
 */
@Entity
@NamedQuery(name="Purchaseorder.findAll", query="SELECT p FROM Purchaseorder p")
public class Purchaseorder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int poautoid;

//	@Temporal(TemporalType.TIMESTAMP)
//	private Date creationdate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateofpurchase;

	private String jobid;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modificationdate;

	private String poid;

	private int purchasedqty;

	private int requiredqty;

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

	public Purchaseorder() {
	}

	public int getPoautoid() {
		return this.poautoid;
	}

	public void setPoautoid(int poautoid) {
		this.poautoid = poautoid;
	}

//	public Date getCreationdate() {
//		return this.creationdate;
//	}
//
//	public void setCreationdate(Date creationdate) {
//		this.creationdate = creationdate;
//	}

	public Date getDateofpurchase() {
		return this.dateofpurchase;
	}

	public void setDateofpurchase(Date dateofpurchase) {
		this.dateofpurchase = dateofpurchase;
	}

	public String getJobid() {
		return this.jobid;
	}

	public void setJobid(String jobid) {
		this.jobid = jobid;
	}

	public Date getModificationdate() {
		return this.modificationdate;
	}

	public void setModificationdate(Date modificationdate) {
		this.modificationdate = modificationdate;
	}

	public String getPoid() {
		return this.poid;
	}

	public void setPoid(String poid) {
		this.poid = poid;
	}

	public int getPurchasedqty() {
		return this.purchasedqty;
	}

	public void setPurchasedqty(int purchasedqty) {
		this.purchasedqty = purchasedqty;
	}

	public int getRequiredqty() {
		return this.requiredqty;
	}

	public void setRequiredqty(int requiredqty) {
		this.requiredqty = requiredqty;
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