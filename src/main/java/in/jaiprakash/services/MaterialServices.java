/**
 * 
 */
package in.jaiprakash.services;

import java.util.List;

import in.jaiprakash.entities.Material;
import in.jaiprakash.models.MaterialModel;
import in.jaiprakash.models.MaterialNameValue;

/**
 * @author Jai Prakash
 * Email: prakashjai01@gmail.com
 *
 */
public interface MaterialServices {

	MaterialModel getSingleValue(Integer materialId);
	
	List<MaterialNameValue> getAllMaterials();
	
	MaterialNameValue addOldMaterial(MaterialModel material, String source);
	
	MaterialNameValue saveInMappingOld(Material mat, MaterialModel material, String source);
	
	List<MaterialModel> getMaterialsForExport();
}
