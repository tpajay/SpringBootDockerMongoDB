package com.tpajay.springbootdocker.patientappointment;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/* 
 * Patient Appointments Microservice [Model/Entity]
 * 
 * @author  Jason Muse
 * LinkedIn: https://www.linkedin.com/in/jason-muse-570a03110
 * GitHub: https://github.com/tpajay/SpringBootDockerMongoDB
 * 
 * @Document ties this object to be a Mongo Document and provides the collection name
 */
@Document(collection="appointments")
public class PatientAppointment {

	@Id
	private String apptId;
	private int patientId;
	private int physicianId;
	private String description;
	private String apptDttm;
	
	
	public String getApptId() {
		return apptId;
	}
	public void setApptId(String apptId) {
		this.apptId = apptId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getPhysicianId() {
		return physicianId;
	}
	public void setPhysicianId(int physicianId) {
		this.physicianId = physicianId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getApptDttm() {
		return apptDttm;
	}
	public void setApptDttm(String apptDttm) {
		this.apptDttm = apptDttm;
	}
	
	
}
