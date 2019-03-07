package com.electrichealth.rest.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.electricalhealth.exhandler.DuplicateDataProvider;
import com.electricalhealth.exhandler.InvalidDataProvider;
import com.electricalhealth.exhandler.NoRecordFoundProvider;
import com.electrichealth.patients.rest.PatientRest;

@Configuration
public class EHRRestConfig extends ResourceConfig {

	public EHRRestConfig() {
		register(EhrApp.class);
		register(PatientRest.class);
		// register(AllergyRest.class);
		register(InvalidDataProvider.class);
		register(NoRecordFoundProvider.class);
		register(DuplicateDataProvider.class);
	}
}
