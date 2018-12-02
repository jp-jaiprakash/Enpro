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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.jaiprakash.models.PurchaseorderModel;
import in.jaiprakash.models.Request;
import in.jaiprakash.services.PurchaseOrderServices;
import in.jaiprakash.utils.Utils;

/**
 * @author Jai Prakash Email: prakashjai01@gmail.com
 *
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/po")
public class PoController {

	@Autowired
	private PurchaseOrderServices purchaseOrderServices;

	@PostMapping(value="/save")
	public ResponseEntity<PurchaseorderModel> savepo(@RequestBody Request<PurchaseorderModel> request){
		String type=Utils.getJobType(request.getPayload().getJobid()) + "PO";
		PurchaseorderModel pom = purchaseOrderServices.savePo(request.getPayload(), type);
		return new ResponseEntity<>(pom, HttpStatus.OK);
	}
	
	@PostMapping(value="/getjobid")
	public ResponseEntity<List<PurchaseorderModel>> getpo(@RequestBody Request<PurchaseorderModel> request){
		String type=Utils.getJobType(request.getPayload().getJobid()) + "PO";
		List<PurchaseorderModel> pom = purchaseOrderServices.getPo(request.getPayload());
		return new ResponseEntity<>(pom, HttpStatus.OK);
	}

}

/*
 * IN case of PO
 * 
 * 
 */