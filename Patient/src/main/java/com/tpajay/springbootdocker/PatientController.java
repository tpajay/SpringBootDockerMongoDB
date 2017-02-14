package com.tpajay.springbootdocker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	PatientRepository patientRepository;

	@RequestMapping(method = RequestMethod.POST)
	public Patient create(@RequestBody Patient patient){
		
		Patient result = patientRepository.save(patient);
		return result;
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/{patientId}")
	public Patient get(@PathVariable String patientId){
		return patientRepository.findOne(patientId);
	}
	
	
}
