/**
 * 
 */
package in.jaiprakash.models;

import java.util.Date;
import java.util.List;

/**
 * @author Jai Prakash
 * Email: prakashjai01@gmail.com
 *
 */
public class PurchaseorderModel {

	private int poautoid;

	private Date creationdate;

	private Date dateofpurchase;

	private String jobid;

	private Date modificationdate;

	private String poid;

	private int purchasedqty;

	private int requiredqty;

	private List<MaterialsmappingModel> materialsmapping;

//	private UserModel user1;

	private UserModel user2;
	
	// To store Material
	private MaterialModel material;
	
	
	/**
	 * 
	 */
	public PurchaseorderModel() {
		// TODO Auto-generated constructor stub
	}

	
	public MaterialModel getMaterial() {
		return material;
	}


	public void setMaterial(MaterialModel material) {
		this.material = material;
	}


	public int getPoautoid() {
		return poautoid;
	}

	public void setPoautoid(int poautoid) {
		this.poautoid = poautoid;
	}

	public Date getCreationdate() {
		return creationdate;
	}

	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}

	public Date getDateofpurchase() {
		return dateofpurchase;
	}

	public void setDateofpurchase(Date dateofpurchase) {
		this.dateofpurchase = dateofpurchase;
	}

	public String getJobid() {
		return jobid;
	}

	public void setJobid(String jobid) {
		this.jobid = jobid;
	}

	public Date getModificationdate() {
		return modificationdate;
	}

	public void setModificationdate(Date modificationdate) {
		this.modificationdate = modificationdate;
	}

	public String getPoid() {
		return poid;
	}

	public void setPoid(String poid) {
		this.poid = poid;
	}

	public int getPurchasedqty() {
		return purchasedqty;
	}

	public void setPurchasedqty(int purchasedqty) {
		this.purchasedqty = purchasedqty;
	}

	public int getRequiredqty() {
		return requiredqty;
	}

	public void setRequiredqty(int requiredqty) {
		this.requiredqty = requiredqty;
	}

	public List<MaterialsmappingModel> getMaterialsmappinglst() {
		return materialsmapping;
	}

	public void setMaterialsmappinglst(List<MaterialsmappingModel> materialsmappinglst) {
		this.materialsmapping = materialsmappinglst;
	}

//	public UserModel getUser1() {
//		return user1;
//	}
//
//	public void setUser1(UserModel user1) {
//		this.user1 = user1;
//	}

	public UserModel getUser2() {
		return user2;
	}

	public void setUser2(UserModel user2) {
		this.user2 = user2;
	}
	
	
}
