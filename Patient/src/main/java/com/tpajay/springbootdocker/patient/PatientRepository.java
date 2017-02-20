package com.tpajay.springbootdocker.patient;

import org.springframework.data.mongodb.repository.MongoRepository;

/* 
 * Patient Microservice [Repository]
 * 
 * @author  Jason Muse
 * LinkedIn: https://www.linkedin.com/in/jason-muse-570a03110
 * GitHub: https://github.com/tpajay/SpringBootDockerMongoDB
 * 
 * Does not require implementation as Spring will wire the implementation.
 */

//Patient is type of object to persist, String in unique id
public interface PatientRepository extends MongoRepository<Patient, String> {

}
