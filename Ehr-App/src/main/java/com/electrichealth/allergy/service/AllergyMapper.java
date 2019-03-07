package com.electrichealth.allergy.service;

import org.springframework.stereotype.Component;

import com.electrichealth.allergy.data.AllergyDetails;
import com.electrichealth.allergy.data.PatientAllergy;
import com.electrichealth.entity.AllergyDetailsEntity;
import com.electrichealth.entity.PatientAllergyEntity;

@Component
public class AllergyMapper {

	public PatientAllergyEntity mapToPatallEntity(final PatientAllergyEntity entity, final PatientAllergy patAll) {
		entity.setDateCreated(patAll.getDateCreated());

		return entity;

	}

	public AllergyDetails mapToAllergyDetails(AllergyDetailsEntity entity) {
		AllergyDetails allDet = new AllergyDetails();
		allDet.setAllergyCode(entity.getAllergyCode());
		allDet.setAllergyDescription(entity.getAllergyDescription());
		allDet.setAllergyId(entity.getAllergyID());

		return allDet;

	}

	public PatientAllergy mapToPateintAllergy(PatientAllergyEntity pae) {
		PatientAllergy pa = new PatientAllergy();
		pa.setDateCreated(pae.getDateCreated());
		pa.setPatientAllergyId(pae.getPatientAllergyId());
		pa.setAllergyId(pae.getDetails().getAllergyID());

		return pa;
	}

}
