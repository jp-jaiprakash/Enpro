/**
 * 
 */
package in.jaiprakash.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
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

import in.jaiprakash.exception.NotFoundException;
import in.jaiprakash.models.JobByStatus;
import in.jaiprakash.models.JobModel;
import in.jaiprakash.models.Request;
import in.jaiprakash.models.SubStockJobModel;
import in.jaiprakash.services.JobsServices;
import in.jaiprakash.services.SubStockJobServices;

/**
 * @author Jai Prakash Email: prakashjai01@gmail.com
 *
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/jobs")
public class JobController {

	private static final Logger logsl4j = Logger.getLogger(JobController.class);

	@Autowired
	private JobsServices jobServices;

	@Autowired
	private SubStockJobServices subStockJobServices;

	@RequestMapping(value = "/newjob", method = RequestMethod.POST)
	public ResponseEntity<JobModel> addNeJob(@RequestBody Request<JobModel> request) {
		try {
			JobModel jbm = jobServices.createAJob(request.getPayload());
			return new ResponseEntity<>(jbm, HttpStatus.CREATED);
		} catch (Exception ex) {
			logsl4j.error(ex);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/jobids")
	public ResponseEntity<List<String>> getJobIds() {
		try {
			List<String> jbm = jobServices.jobids();
			return new ResponseEntity<>(jbm, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}
	}

	@GetMapping(value = "/subjobids")
	public ResponseEntity<List<String>> getSubJobIds() {
		try {
			List<String> jbm = jobServices.subjobids();
			return new ResponseEntity<>(jbm, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}
	}

	@GetMapping(value = "/stockjobids")
	public ResponseEntity<List<String>> getStockJobIds() {
		try {
			List<String> jbm = jobServices.stockjobids();
			return new ResponseEntity<>(jbm, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}
	}

	@GetMapping(value = "/getById/{id}")
	public ResponseEntity<JobModel> getAJobId(@PathVariable Integer id) {
		try {
			JobModel jbm = jobServices.getById(id);
			return new ResponseEntity<>(jbm, HttpStatus.OK);
		} catch (NotFoundException nfex) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}
	}

	@PostMapping(value = "/savejob")
	public ResponseEntity<JobModel> saveAJob(@RequestBody Request<JobModel> jobModel) {
		try {
			JobModel jbm = jobServices.saveJob(jobModel.getPayload());
			return new ResponseEntity<>(jbm, HttpStatus.OK);
		} catch (Exception ex) {
			logsl4j.error(ex);
		}
		return null;
	}

	@PostMapping(value = "/savestockjob")
	public ResponseEntity<SubStockJobModel> saveStockJob(@RequestBody Request<SubStockJobModel> subStockJobModel) {
		try {
			SubStockJobModel ssj = subStockJobServices.saveSubStock(subStockJobModel.getPayload());
			return new ResponseEntity<>(ssj, HttpStatus.OK);
		} catch (Exception ex) {
			logsl4j.error(ex);
		}
		return null;
	}

	@GetMapping(value = "/jobByStatus/{status}")
	public ResponseEntity<List<JobByStatus>> getJobByStatus(@PathVariable String status) {
		try {
			List<JobByStatus> newlst = new ArrayList<>();

			newlst = subStockJobServices.getJobsByStatus(status);

			return new ResponseEntity<>(newlst, HttpStatus.OK);
		} catch (Exception ex) {
			logsl4j.error(ex);
		}
		return null;
	}
}
