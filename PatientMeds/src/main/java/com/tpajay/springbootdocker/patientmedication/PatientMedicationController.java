package com.tpajay.springbootdocker.patientmedication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/* 
 * Patient Medications Microservice [Controller]
 * Microservice to create and retrieve medications for a patient
 * using REST post and get methods, stored in MongoDB collection
 * 
 * @author  Jason Muse
 * LinkedIn: https://www.linkedin.com/in/jason-muse-570a03110
 * GitHub: https://github.com/tpajay/SpringBootDockerMongoDB
 * 
 */
@RestController
@RequestMapping("/medication")
public class PatientMedicationController {
	
	@Autowired
	PatientMedicationRepository patientMedicationRepository;

	//add new medication
	@RequestMapping(method = RequestMethod.POST)
	public PatientMedication create(@RequestBody PatientMedication medication){
		PatientMedication result = patientMedicationRepository.save(medication);
		return result;
	}
	
	//get medication by patient_id
	@RequestMapping(method = RequestMethod.GET, value="/{prescId}")
	public PatientMedication get(@PathVariable String prescId){
		return patientMedicationRepository.findOne(prescId);
	}
	
	//get all medications
	@RequestMapping(method = RequestMethod.GET, value="")
	public List<PatientMedication> getAll() {
		return patientMedicationRepository.findAll();
	}		
	
}
