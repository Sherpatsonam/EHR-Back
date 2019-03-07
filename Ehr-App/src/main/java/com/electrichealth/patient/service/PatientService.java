package com.electrichealth.patient.service;

import java.util.List;

import com.electrichealth.allergy.data.PatientAllergy;
import com.electrichealth.patient.data.PatientData;

public interface PatientService {
	PatientData createPatient(final PatientData patient);

	void modifyPatient(final PatientData patient);

	PatientData findPatient(final Long id);

	List<PatientData> searchPatient(final String firstName, final Long zipCode, final String gender, final String dob);

	PatientAllergy createPatientAllergy(final PatientAllergy patAll);

}
