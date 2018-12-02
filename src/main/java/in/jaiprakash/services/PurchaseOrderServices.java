/**
 * 
 */
package in.jaiprakash.services;

import java.util.List;

import in.jaiprakash.models.PurchaseorderModel;

/**
 * @author Jai Prakash
 * Email: prakashjai01@gmail.com
 *
 */
public interface PurchaseOrderServices {

	PurchaseorderModel savePo(PurchaseorderModel po, String potype);
	
	List<PurchaseorderModel> getPo(PurchaseorderModel po);
	
}
