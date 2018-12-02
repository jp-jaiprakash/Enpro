/**
 * 
 */
package in.jaiprakash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.jaiprakash.models.MaterialModel;
import in.jaiprakash.models.MaterialNameValue;
import in.jaiprakash.models.Request;
import in.jaiprakash.services.MaterialServices;

/**
 * @author Jai Prakash Email: prakashjai01@gmail.com
 *
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/materials")
public class MaterialController {

	@Autowired
	private MaterialServices materialServices;

	@GetMapping(value = "/{materialId}")
	public ResponseEntity<MaterialModel> getMaterialUsingId(@PathVariable Integer materialId) {
		MaterialModel mnv = materialServices.getSingleValue(materialId);
		return new ResponseEntity<>(mnv, HttpStatus.OK);
	}

	@GetMapping(value = "/all")
	public ResponseEntity<List<MaterialNameValue>> getMaterialNameNValue() {
		List<MaterialNameValue> lst = materialServices.getAllMaterials();
		return new ResponseEntity<>(lst, HttpStatus.OK);
	}

	@RequestMapping(value = "/addOldMaterial", method = RequestMethod.POST)
	public ResponseEntity<MaterialNameValue> addOldMaterial(@RequestBody Request<MaterialModel> request) {
		MaterialNameValue mnv = materialServices.addOldMaterial(request.getPayload(), "Old Material");
		return new ResponseEntity<>(mnv, HttpStatus.OK);
	}
	
	@GetMapping(value = "/allwithqty")
	public ResponseEntity<List<MaterialModel>> getMaterialWithQty() {
		List<MaterialModel> lst = materialServices.getMaterialsForExport();
		return new ResponseEntity<>(lst, HttpStatus.OK);
	}
}
