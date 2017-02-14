package com.tpajay.springbootdocker;

import org.springframework.data.mongodb.repository.MongoRepository;

//Does not require implementation as Spring will wire the implementation.
//Patient is type of object to persist, String in unique id
public interface PatientRepository extends MongoRepository<Patient, String> {

}
