/**
 * 
 */
package in.jaiprakash.models;

import java.util.Date;

/**
 * @author Jai Prakash
 * Email: prakashjai01@gmail.com
 *
 */
public class MaterialsmappingModel {

	
	private int materialsmappingid;

	private Date additiondate;

	private String materialsource;

	private int quantity;

	private double unitprice;
	
	// added by
	private UserModel user;
	
	/**
	 * 
	 */
	public MaterialsmappingModel() {
		// TODO Auto-generated constructor stub
	}

	public int getMaterialsmappingid() {
		return materialsmappingid;
	}

	public void setMaterialsmappingid(int materialsmappingid) {
		this.materialsmappingid = materialsmappingid;
	}

	public Date getAdditiondate() {
		return additiondate;
	}

	public void setAdditiondate(Date additiondate) {
		this.additiondate = additiondate;
	}

	public String getMaterialsource() {
		return materialsource;
	}

	public void setMaterialsource(String materialsource) {
		this.materialsource = materialsource;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(double unitprice) {
		this.unitprice = unitprice;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}
	
	
}
