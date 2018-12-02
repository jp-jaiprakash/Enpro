/**
 * 
 */
package in.jaiprakash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.jaiprakash.models.MaterialIssueModel;
import in.jaiprakash.models.Request;
import in.jaiprakash.services.AssignMaterialServices;

/**
 * @author Jai Prakash
 * Email: prakashjai01@gmail.com
 *
 */
@RestController
@RequestMapping(value = "/assign")
public class AssignMaterialController {

	@Autowired
	private AssignMaterialServices assignMaterialServices;
	
	@PostMapping(value="/assignmaterial")
	public ResponseEntity<String> assignMaterial(@RequestBody Request<MaterialIssueModel> request){
		boolean assigned = assignMaterialServices.assignMaterial(request.getPayload());
		if(assigned)
			return new ResponseEntity<>("Assigned",HttpStatus.OK);
		
		return new ResponseEntity<>("Not Assigned",HttpStatus.OK);
	}
}
