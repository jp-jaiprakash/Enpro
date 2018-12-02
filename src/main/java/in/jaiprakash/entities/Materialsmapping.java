package in.jaiprakash.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the materialsmapping database table.
 * 
 */
@Entity
@NamedQuery(name="Materialsmapping.findAll", query="SELECT m FROM Materialsmapping m")
public class Materialsmapping implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int materialsmappingid;

	@Temporal(TemporalType.TIMESTAMP)
	private Date additiondate;

	private String materialsource;

	private int quantity;

	private double unitprice;

	//bi-directional many-to-one association to Materialissue
	@OneToMany(mappedBy="materialsmapping")
	private List<Materialissue> materialissues;

	//bi-directional many-to-one association to Material
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="materialid")
	private Material material;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="materialaddedby")
	private User user;

	//bi-directional many-to-one association to Purchaseorder
	@OneToMany(mappedBy="materialsmapping")
	private List<Purchaseorder> purchaseorders;

	//bi-directional many-to-one association to Substockjob
	@OneToMany(mappedBy="materialsmapping")
	private List<Substockjob> substockjobs;

	public Materialsmapping() {
	}

	/**
	 * @param todaysUTCdate
	 * @param upperCase
	 * @param intValue
	 * @param d
	 * @param mat
	 * @param usr3
	 */

	public int getMaterialsmappingid() {
		return this.materialsmappingid;
	}

	/**
	 * @param materialsmappingid
	 * @param additiondate
	 * @param materialsource
	 * @param quantity
	 * @param unitprice
	 * @param materialissues
	 * @param material
	 * @param user
	 * @param purchaseorders
	 * @param substockjobs
	 */
	public Materialsmapping( Date additiondate, String materialsource, int quantity,
			double unitprice, Material material, User user) {
		super();
		this.additiondate = additiondate;
		this.materialsource = materialsource;
		this.quantity = quantity;
		this.unitprice = unitprice;
		this.material = material;
		this.user = user;
	}

	public void setMaterialsmappingid(int materialsmappingid) {
		this.materialsmappingid = materialsmappingid;
	}

	public Date getAdditiondate() {
		return this.additiondate;
	}

	public void setAdditiondate(Date additiondate) {
		this.additiondate = additiondate;
	}

	public String getMaterialsource() {
		return this.materialsource;
	}

	public void setMaterialsource(String materialsource) {
		this.materialsource = materialsource;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getUnitprice() {
		return this.unitprice;
	}

	public void setUnitprice(double unitprice) {
		this.unitprice = unitprice;
	}

	public List<Materialissue> getMaterialissues() {
		return this.materialissues;
	}

	public void setMaterialissues(List<Materialissue> materialissues) {
		this.materialissues = materialissues;
	}

	public Materialissue addMaterialissue(Materialissue materialissue) {
		getMaterialissues().add(materialissue);
		materialissue.setMaterialsmapping(this);

		return materialissue;
	}

	public Materialissue removeMaterialissue(Materialissue materialissue) {
		getMaterialissues().remove(materialissue);
		materialissue.setMaterialsmapping(null);

		return materialissue;
	}

	public Material getMaterial() {
		return this.material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Purchaseorder> getPurchaseorders() {
		return this.purchaseorders;
	}

	public void setPurchaseorders(List<Purchaseorder> purchaseorders) {
		this.purchaseorders = purchaseorders;
	}

	public Purchaseorder addPurchaseorder(Purchaseorder purchaseorder) {
		getPurchaseorders().add(purchaseorder);
		purchaseorder.setMaterialsmapping(this);

		return purchaseorder;
	}

	public Purchaseorder removePurchaseorder(Purchaseorder purchaseorder) {
		getPurchaseorders().remove(purchaseorder);
		purchaseorder.setMaterialsmapping(null);

		return purchaseorder;
	}

	public List<Substockjob> getSubstockjobs() {
		return this.substockjobs;
	}

	public void setSubstockjobs(List<Substockjob> substockjobs) {
		this.substockjobs = substockjobs;
	}

	public Substockjob addSubstockjob(Substockjob substockjob) {
		getSubstockjobs().add(substockjob);
		substockjob.setMaterialsmapping(this);

		return substockjob;
	}

	public Substockjob removeSubstockjob(Substockjob substockjob) {
		getSubstockjobs().remove(substockjob);
		substockjob.setMaterialsmapping(null);

		return substockjob;
	}

}