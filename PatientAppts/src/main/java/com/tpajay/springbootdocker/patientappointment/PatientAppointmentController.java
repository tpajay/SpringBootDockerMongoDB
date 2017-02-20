package com.tpajay.springbootdocker.patientappointment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/* 
 * Patient Appointments Microservice [Controller]
 * Microservice to create and retrieve appointments for a patient
 * using REST post and get methods, stored in MongoDB collection
 * 
 * @author  Jason Muse
 * LinkedIn: https://www.linkedin.com/in/jason-muse-570a03110
 * GitHub: https://github.com/tpajay/SpringBootDockerMongoDB
 * 
 */
@RestController
@RequestMapping("/appointment")
public class PatientAppointmentController {
	
	@Autowired
	PatientAppointmentRepository patientAppointmentRepository;

	//add new appt
	@RequestMapping(method = RequestMethod.POST)
	public PatientAppointment create(@RequestBody PatientAppointment appt){
		
		PatientAppointment result = patientAppointmentRepository.save(appt);
		return result;
	}
	
	//get appt by appt_id
	@RequestMapping(method = RequestMethod.GET, value="/{apptId}")
	public PatientAppointment get(@PathVariable String apptId){
		return patientAppointmentRepository.findOne(apptId);
	}
	
	//get all patients
	@RequestMapping(method = RequestMethod.GET, value="")
	public List<PatientAppointment> getAll() {
		return patientAppointmentRepository.findAll();
	}		
	
}
