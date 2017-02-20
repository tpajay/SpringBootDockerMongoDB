package com.tpajay.springbootdocker.patientmedication;

import org.springframework.data.mongodb.repository.MongoRepository;

/* 
 * Patient Medications Microservice [Repository]
 * 
 * @author  Jason Muse
 * LinkedIn: https://www.linkedin.com/in/jason-muse-570a03110
 * GitHub: https://github.com/tpajay/SpringBootDockerMongoDB
 * 
 * Does not require implementation as Spring will wire the implementation.
 */

//PatientMedication is type of object to persist, String in unique id
public interface PatientMedicationRepository extends MongoRepository<PatientMedication, String> {

}
