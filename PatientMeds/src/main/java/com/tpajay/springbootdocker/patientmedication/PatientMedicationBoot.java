package com.tpajay.springbootdocker.patientmedication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;

/* 
 * Patient Medications Microservice [Spring Boot]
 * 
 * @author  Jason Muse
 * LinkedIn: https://www.linkedin.com/in/jason-muse-570a03110
 * GitHub: https://github.com/tpajay/SpringBootDockerMongoDB
 * 
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class PatientMedicationBoot {

	   public static void main(String[] args) {
	        SpringApplication.run(PatientMedicationBoot.class);
	    }
	
	   
	   @Autowired
		private Environment env;


	   
	   
}
