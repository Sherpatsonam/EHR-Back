package com.electrichealth.allergy.service;

import java.util.List;

import com.electrichealth.allergy.data.PatientAllergy;
import com.electrichealth.entity.PatientAllergyEntity;

public interface AllergyService {

	List<PatientAllergyEntity> createAllergyRecord(final List<PatientAllergy> allergy);

}
