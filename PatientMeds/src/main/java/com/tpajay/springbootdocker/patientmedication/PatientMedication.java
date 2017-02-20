package com.tpajay.springbootdocker.patientmedication;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/* 
 * Patient Medications Microservice [Model/Entity]
 * 
 * @author  Jason Muse
 * LinkedIn: https://www.linkedin.com/in/jason-muse-570a03110
 * GitHub: https://github.com/tpajay/SpringBootDockerMongoDB
 * 
 * @Document ties this object to be a Mongo Document and provides the collection name
 */
@Document(collection="medications")
public class PatientMedication {

	@Id
	private String prescId;
	private int patientId;
	private int physicianId;
	private String name;
	private String description;
	private String dosage;
	private String frequency;
	private String duration;
	private String startDttm;
	private String endDttm;
	
	
	public String getPrescId() {
		return prescId;
	}
	public void setPrescId(String prescId) {
		this.prescId = prescId;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDosage() {
		return dosage;
	}
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getStartDttm() {
		return startDttm;
	}
	public void setStartDttm(String startDttm) {
		this.startDttm = startDttm;
	}
	public String getEndDttm() {
		return endDttm;
	}
	public void setEndDttm(String endDttm) {
		this.endDttm = endDttm;
	}
	
	
}
