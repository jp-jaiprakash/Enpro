/**
 * 
 */
package in.jaiprakash.models;

import java.util.Date;
import java.util.List;

import in.jaiprakash.entities.Materialsmapping;
import in.jaiprakash.entities.Unit;
import in.jaiprakash.entities.User;

/**
 * @author Jai Prakash
 * Email: prakashjai01@gmail.com
 *
 */
public class MaterialModel {

	private int materialid;

	private double available;

	private Date createddate;

	private String materialname;

	private Date modifieddate;

	private double reserved;

	private double total;

	private UnitModel unitBean;
	
	// only in model
	private Double unitPrice;
	
	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	// created by
	private UserModel user1;

// modified by
	private UserModel user2;

	// will return all the materialmappings
	private List<MaterialsmappingModel> materialsmappings;
	
	/**
	 * 
	 */
	public MaterialModel() {
		// TODO Auto-generated constructor stub
	}

	public int getMaterialid() {
		return materialid;
	}

	public void setMaterialid(int materialid) {
		this.materialid = materialid;
	}

	public double getAvailable() {
		return available;
	}

	public void setAvailable(double available) {
		this.available = available;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public String getMaterialname() {
		return materialname;
	}

	public void setMaterialname(String materialname) {
		this.materialname = materialname;
	}

	public Date getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(Date modifieddate) {
		this.modifieddate = modifieddate;
	}

	public double getReserved() {
		return reserved;
	}

	public void setReserved(double reserved) {
		this.reserved = reserved;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public UnitModel getUnitBean() {
		return unitBean;
	}

	public void setUnitBean(UnitModel unitBean) {
		this.unitBean = unitBean;
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

	public List<MaterialsmappingModel> getMaterialsmappings() {
		return materialsmappings;
	}

	public void setMaterialsmappings(List<MaterialsmappingModel> materialsmappings) {
		this.materialsmappings = materialsmappings;
	}


	
}
