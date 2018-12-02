/**
 * 
 */
package in.jaiprakash.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.jaiprakash.models.Request;
import in.jaiprakash.models.UserAndRoleInsertModel;
import in.jaiprakash.models.UserAndRoleModel;
import in.jaiprakash.models.UserModel;
import in.jaiprakash.services.UserServices;

/**
 * @author Jai Prakash
 * Email: prakashjai01@gmail.com
 *
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/user")
public class UserController {

	private static final Logger logsl4j = Logger.getLogger(UserController.class);
	
	@Autowired
	private UserServices userservices;
	
	@PostMapping(value="/login")
	public ResponseEntity<UserAndRoleModel> loginuser(@RequestBody Request<UserModel> request){
		try{
			UserAndRoleModel ur = userservices.loginUser(request.getPayload());
			return new ResponseEntity<>(ur, HttpStatus.OK);
		}catch(Exception ex){
			logsl4j.error(ex);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value="/adduserandrole")
	public ResponseEntity<UserAndRoleInsertModel> addUserAndRole(@RequestBody Request<UserAndRoleInsertModel> request){
		try{
			UserAndRoleInsertModel ur = userservices.insertIntoUser(request.getPayload());
			return new ResponseEntity<>(ur, HttpStatus.OK);
		}catch(Exception ex){
			logsl4j.error(ex);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
