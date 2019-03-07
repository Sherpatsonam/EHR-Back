package com.electrichealth.patients.rest;

import java.util.List;

import com.electrichealth.patient.data.PatientData;

public class PatientSearchResults {

	private List<PatientData> patients;

	public PatientSearchResults() {

	}

	public PatientSearchResults(List<PatientData> patients) {
		super();
		this.patients = patients;
	}

	public List<PatientData> getPatients() {
		return patients;
	}

	public void setPatients(List<PatientData> patients) {
		this.patients = patients;
	}

	
}
