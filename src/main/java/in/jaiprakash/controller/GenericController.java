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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.jaiprakash.models.UnitModel;
import in.jaiprakash.models.UserRolesModel;
import in.jaiprakash.services.GeneralServices;

/**
 * @author Jai Prakash
 * Email: prakashjai01@gmail.com
 *
 */
@CrossOrigin
@RestController
@RequestMapping(value="/general")
public class GenericController {
	
	@Autowired
	private GeneralServices generalServices;

	@GetMapping(value="/units")
	public ResponseEntity<List<UnitModel>> getAllUnits(){
		List<UnitModel> lst = generalServices.getUnits();
		return new ResponseEntity<>(lst, HttpStatus.OK);
	}
	
	@GetMapping(value="/userroles")
	public ResponseEntity<List<UserRolesModel>> getAllRoles(){
		List<UserRolesModel> lst = generalServices.getAllRoles();
		return new ResponseEntity<>(lst, HttpStatus.OK);
	}
}
