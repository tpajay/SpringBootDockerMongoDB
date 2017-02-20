package com.tpajay.springbootdocker.patient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/* 
 * Patient Microservice [Controller]
 * Microservice to create and retrieve patients 
 * using REST post and get methods, stored in MongoDB collection
 * 
 * @author  Jason Muse
 * LinkedIn: https://www.linkedin.com/in/jason-muse-570a03110
 * GitHub: https://github.com/tpajay/SpringBootDockerMongoDB
 * 
 */
@RestController
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	PatientRepository patientRepository;

	//add new patient
	@RequestMapping(method = RequestMethod.POST)
	public Patient create(@RequestBody Patient patient){
		
		Patient result = patientRepository.save(patient);
		return result;
	}
	
	//get patient by patient_id
	@RequestMapping(method = RequestMethod.GET, value="/{patientId}")
	public Patient get(@PathVariable String patientId){
		return patientRepository.findOne(patientId);
	}
	
	//get all patients
	@RequestMapping(method = RequestMethod.GET, value="")
	public List<Patient> getAll() {
		return patientRepository.findAll();
	}		
	
}
