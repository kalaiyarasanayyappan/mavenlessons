package com.chainsys.mavenlessons.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Appointment")
public class Appointment {
	@Id
	@Column(name = "APPOINTMENT_ID")
	private int id;
	@Column(name = "APPOINTMENT_DATE")
	private Date appointDate;
	@Column(name = "PATIENT_NAME")
	private String patName;
	@Column(name = "PATIENT_PHNO")
	private long phNo;
	@Column(name = "FEE_COLLECTED")
	private float fee;
	@Column(name = "DOC_ID")
	private int docId;
//	@Joincolumn maps the column(Doc_ID) of the current Entity Appointment
//	with the PrimaryKey column(Id) of the associated Entity Doctor 
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOC_ID" , nullable = false,
	insertable = false ,updatable = false)
	@JsonIgnore
	private Doctor doctor; //it points to an Entity class 
	public Doctor getDoctor() {  
		return this.doctor;
	}
	public void setDoctor(Doctor doc) {
		this.doctor=doc;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getAppointDate() {
		return appointDate;
	}
	public void setAppointDate(Date appointDate) {
		this.appointDate = appointDate;
	}
	public String getPatName() {
		return patName;
	}
	public void setPatName(String patName) {
		this.patName = patName;
	}
	public long getPhNo() {
		return phNo;
	}
	public void setPhNo(long phNo) {
		this.phNo = phNo;
	}
	public float getFee() {    
		return fee;
	}
	public void setFee(float fee) {
		this.fee = fee;
	}
	public int getDocId() {
		return docId;
	}
	public void setDocId(int docId) {
		this.docId = docId;
	}
	@Override
	public String toString() {
		return String.format("%d, %s, %s, %d, %.2f",id, 
				appointDate, patName, phNo, fee );
	}
	

}