package com.electrichealth.allergy.service;

import com.electrichealth.allergy.data.AllergyDetails;

public interface AllergyDetailService {

	void removeAllergy(final Long patientAllergyId);

	AllergyDetails findallergy(final Long allergyCode);

}
