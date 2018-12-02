/**
 * 
 */
package in.jaiprakash.models;

/**
 * @author Jai Prakash
 * Email: prakashjai01@gmail.com
 *
 */
public class MaterialNameValue {

	private int materialId;
	
	private String materailname;
	
	private int mappingMaterialId;
	/**
	 * 
	 */
	public MaterialNameValue() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param materialId
	 * @param materailname
	 */
	public MaterialNameValue(int materialId, String materailname) {
		super();
		this.materialId = materialId;
		this.materailname = materailname;
	}

	/**
	 * @param materialId
	 * @param materailname
	 * @param mappingMaterialId
	 */
	public MaterialNameValue(int materialId, String materailname, int mappingMaterialId) {
		super();
		this.materialId = materialId;
		this.materailname = materailname;
		this.mappingMaterialId = mappingMaterialId;
	}


	public int getMappingMaterialId() {
		return mappingMaterialId;
	}


	public void setMappingMaterialId(int mappingMaterialId) {
		this.mappingMaterialId = mappingMaterialId;
	}


	public int getMaterialId() {
		return materialId;
	}

	public void setMaterialId(int materialId) {
		this.materialId = materialId;
	}

	public String getMaterailname() {
		return materailname;
	}

	public void setMaterailname(String materailname) {
		this.materailname = materailname;
	}
	
	
}
