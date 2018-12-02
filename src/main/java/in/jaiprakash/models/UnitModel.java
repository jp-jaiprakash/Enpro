/**
 * 
 */
package in.jaiprakash.models;

/**
 * @author Jai Prakash
 * Email: prakashjai01@gmail.com
 *
 */
public class UnitModel {

	private int unitid;

	private String unitvalue;
	
	/**
	 * 
	 */
	
	public UnitModel() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param unitid
	 */
	public UnitModel(int unitid) {
		super();
		this.unitid = unitid;
	}

	public UnitModel(String unitvalue) {
		super();
		this.unitvalue = unitvalue;
	}

	public int getUnitid() {
		return unitid;
	}

	public void setUnitid(int unitid) {
		this.unitid = unitid;
	}

	public String getUnitvalue() {
		return unitvalue;
	}

	public void setUnitvalue(String unitvalue) {
		this.unitvalue = unitvalue;
	}
	
	
}
