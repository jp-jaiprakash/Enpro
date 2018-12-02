package in.jaiprakash.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userid;

	private String username;

	private String userpassword;

	//bi-directional many-to-one association to Job
//	@OneToMany(mappedBy="user1")
//	private List<Job> jobs1;

	//bi-directional many-to-one association to Job
//	@OneToMany(mappedBy="user2")
//	private List<Job> jobs2;

	//bi-directional many-to-one association to Materialissue
//	@OneToMany(mappedBy="user1")
//	private List<Materialissue> materialissues1;
//
//	//bi-directional many-to-one association to Materialissue
//	@OneToMany(mappedBy="user2")
//	private List<Materialissue> materialissues2;
//
//	//bi-directional many-to-one association to Material
//	@OneToMany(mappedBy="user1")
//	private List<Material> materials1;
//
//	//bi-directional many-to-one association to Material
//	@OneToMany(mappedBy="user2")
//	private List<Material> materials2;
//
//	//bi-directional many-to-one association to Materialsmapping
//	@OneToMany(mappedBy="user")
//	private List<Materialsmapping> materialsmappings;
//
//	//bi-directional many-to-one association to Purchaseorder
//	@OneToMany(mappedBy="user1")
//	private List<Purchaseorder> purchaseorders1;
//
//	//bi-directional many-to-one association to Purchaseorder
//	@OneToMany(mappedBy="user2")
//	private List<Purchaseorder> purchaseorders2;
//
//	//bi-directional many-to-one association to Substockjob
//	@OneToMany(mappedBy="user1")
//	private List<Substockjob> substockjobs1;
//
//	//bi-directional many-to-one association to Substockjob
//	@OneToMany(mappedBy="user2")
//	private List<Substockjob> substockjobs2;
//
//	//bi-directional many-to-one association to Usermappingtable
//	@OneToMany(mappedBy="user1")
//	private List<Usermappingtable> usermappingtables1;
//
//	//bi-directional many-to-one association to Usermappingtable
//	@OneToMany(mappedBy="user2")
//	private List<Usermappingtable> usermappingtables2;

	public User() {
	}

	/**
	 * @param userid2
	 */
	public User(int userid) {
		// TODO Auto-generated constructor stub
		super();
		this.userid = userid;
	}

	public int getUserid() {
		return this.userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword() {
		return this.userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

//	public List<Job> getJobs1() {
//		return this.jobs1;
//	}
//
//	public void setJobs1(List<Job> jobs1) {
//		this.jobs1 = jobs1;
//	}

//	public Job addJobs1(Job jobs1) {
//		getJobs1().add(jobs1);
//		jobs1.setUser1(this);
//
//		return jobs1;
//	}
//
//	public Job removeJobs1(Job jobs1) {
//		getJobs1().remove(jobs1);
//		jobs1.setUser1(null);
//
//		return jobs1;
//	}
//
//	public List<Job> getJobs2() {
//		return this.jobs2;
//	}
//
//	public void setJobs2(List<Job> jobs2) {
//		this.jobs2 = jobs2;
//	}

//	public Job addJobs2(Job jobs2) {
//		getJobs2().add(jobs2);
//		jobs2.setUser2(this);
//
//		return jobs2;
//	}
//
//	public Job removeJobs2(Job jobs2) {
//		getJobs2().remove(jobs2);
//		jobs2.setUser2(null);
//
//		return jobs2;
//	}

//	public List<Materialissue> getMaterialissues1() {
//		return this.materialissues1;
//	}
//
//	public void setMaterialissues1(List<Materialissue> materialissues1) {
//		this.materialissues1 = materialissues1;
//	}
//
//	public Materialissue addMaterialissues1(Materialissue materialissues1) {
//		getMaterialissues1().add(materialissues1);
//		materialissues1.setUser1(this);
//
//		return materialissues1;
//	}
//
//	public Materialissue removeMaterialissues1(Materialissue materialissues1) {
//		getMaterialissues1().remove(materialissues1);
//		materialissues1.setUser1(null);
//
//		return materialissues1;
//	}
//
//	public List<Materialissue> getMaterialissues2() {
//		return this.materialissues2;
//	}
//
//	public void setMaterialissues2(List<Materialissue> materialissues2) {
//		this.materialissues2 = materialissues2;
//	}
//
//	public Materialissue addMaterialissues2(Materialissue materialissues2) {
//		getMaterialissues2().add(materialissues2);
//		materialissues2.setUser2(this);
//
//		return materialissues2;
//	}
//
//	public Materialissue removeMaterialissues2(Materialissue materialissues2) {
//		getMaterialissues2().remove(materialissues2);
//		materialissues2.setUser2(null);
//
//		return materialissues2;
//	}
//
//	public List<Material> getMaterials1() {
//		return this.materials1;
//	}
//
//	public void setMaterials1(List<Material> materials1) {
//		this.materials1 = materials1;
//	}
//
//	public Material addMaterials1(Material materials1) {
//		getMaterials1().add(materials1);
//		materials1.setUser1(this);
//
//		return materials1;
//	}
//
//	public Material removeMaterials1(Material materials1) {
//		getMaterials1().remove(materials1);
//		materials1.setUser1(null);
//
//		return materials1;
//	}
//
//	public List<Material> getMaterials2() {
//		return this.materials2;
//	}
//
//	public void setMaterials2(List<Material> materials2) {
//		this.materials2 = materials2;
//	}
//
//	public Material addMaterials2(Material materials2) {
//		getMaterials2().add(materials2);
//		materials2.setUser2(this);
//
//		return materials2;
//	}
//
//	public Material removeMaterials2(Material materials2) {
//		getMaterials2().remove(materials2);
//		materials2.setUser2(null);
//
//		return materials2;
//	}
//
//	public List<Materialsmapping> getMaterialsmappings() {
//		return this.materialsmappings;
//	}
//
//	public void setMaterialsmappings(List<Materialsmapping> materialsmappings) {
//		this.materialsmappings = materialsmappings;
//	}
//
//	public Materialsmapping addMaterialsmapping(Materialsmapping materialsmapping) {
//		getMaterialsmappings().add(materialsmapping);
//		materialsmapping.setUser(this);
//
//		return materialsmapping;
//	}
//
//	public Materialsmapping removeMaterialsmapping(Materialsmapping materialsmapping) {
//		getMaterialsmappings().remove(materialsmapping);
//		materialsmapping.setUser(null);
//
//		return materialsmapping;
//	}
//
//	public List<Purchaseorder> getPurchaseorders1() {
//		return this.purchaseorders1;
//	}
//
//	public void setPurchaseorders1(List<Purchaseorder> purchaseorders1) {
//		this.purchaseorders1 = purchaseorders1;
//	}
//
//	public Purchaseorder addPurchaseorders1(Purchaseorder purchaseorders1) {
//		getPurchaseorders1().add(purchaseorders1);
//		purchaseorders1.setUser1(this);
//
//		return purchaseorders1;
//	}
//
//	public Purchaseorder removePurchaseorders1(Purchaseorder purchaseorders1) {
//		getPurchaseorders1().remove(purchaseorders1);
//		purchaseorders1.setUser1(null);
//
//		return purchaseorders1;
//	}
//
//	public List<Purchaseorder> getPurchaseorders2() {
//		return this.purchaseorders2;
//	}
//
//	public void setPurchaseorders2(List<Purchaseorder> purchaseorders2) {
//		this.purchaseorders2 = purchaseorders2;
//	}
//
//	public Purchaseorder addPurchaseorders2(Purchaseorder purchaseorders2) {
//		getPurchaseorders2().add(purchaseorders2);
//		purchaseorders2.setUser2(this);
//
//		return purchaseorders2;
//	}
//
//	public Purchaseorder removePurchaseorders2(Purchaseorder purchaseorders2) {
//		getPurchaseorders2().remove(purchaseorders2);
//		purchaseorders2.setUser2(null);
//
//		return purchaseorders2;
//	}
//
//	public List<Substockjob> getSubstockjobs1() {
//		return this.substockjobs1;
//	}
//
//	public void setSubstockjobs1(List<Substockjob> substockjobs1) {
//		this.substockjobs1 = substockjobs1;
//	}
//
//	public Substockjob addSubstockjobs1(Substockjob substockjobs1) {
//		getSubstockjobs1().add(substockjobs1);
//		substockjobs1.setUser1(this);
//
//		return substockjobs1;
//	}
//
//	public Substockjob removeSubstockjobs1(Substockjob substockjobs1) {
//		getSubstockjobs1().remove(substockjobs1);
//		substockjobs1.setUser1(null);
//
//		return substockjobs1;
//	}
//
//	public List<Substockjob> getSubstockjobs2() {
//		return this.substockjobs2;
//	}
//
//	public void setSubstockjobs2(List<Substockjob> substockjobs2) {
//		this.substockjobs2 = substockjobs2;
//	}
//
//	public Substockjob addSubstockjobs2(Substockjob substockjobs2) {
//		getSubstockjobs2().add(substockjobs2);
//		substockjobs2.setUser2(this);
//
//		return substockjobs2;
//	}
//
//	public Substockjob removeSubstockjobs2(Substockjob substockjobs2) {
//		getSubstockjobs2().remove(substockjobs2);
//		substockjobs2.setUser2(null);
//
//		return substockjobs2;
//	}
//
//	public List<Usermappingtable> getUsermappingtables1() {
//		return this.usermappingtables1;
//	}
//
//	public void setUsermappingtables1(List<Usermappingtable> usermappingtables1) {
//		this.usermappingtables1 = usermappingtables1;
//	}
//
//	public Usermappingtable addUsermappingtables1(Usermappingtable usermappingtables1) {
//		getUsermappingtables1().add(usermappingtables1);
//		usermappingtables1.setUser1(this);
//
//		return usermappingtables1;
//	}
//
//	public Usermappingtable removeUsermappingtables1(Usermappingtable usermappingtables1) {
//		getUsermappingtables1().remove(usermappingtables1);
//		usermappingtables1.setUser1(null);
//
//		return usermappingtables1;
//	}
//
//	public List<Usermappingtable> getUsermappingtables2() {
//		return this.usermappingtables2;
//	}
//
//	public void setUsermappingtables2(List<Usermappingtable> usermappingtables2) {
//		this.usermappingtables2 = usermappingtables2;
//	}
//
//	public Usermappingtable addUsermappingtables2(Usermappingtable usermappingtables2) {
//		getUsermappingtables2().add(usermappingtables2);
//		usermappingtables2.setUser2(this);
//
//		return usermappingtables2;
//	}
//
//	public Usermappingtable removeUsermappingtables2(Usermappingtable usermappingtables2) {
//		getUsermappingtables2().remove(usermappingtables2);
//		usermappingtables2.setUser2(null);
//
//		return usermappingtables2;
//	}

}