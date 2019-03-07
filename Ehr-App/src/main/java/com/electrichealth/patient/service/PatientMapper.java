package com.electrichealth.patient.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.electrichealth.entity.AddressEntity;
import com.electrichealth.entity.ContactEntity;
import com.electrichealth.entity.PatientEntity;
import com.electrichealth.patient.data.AddressData;
import com.electrichealth.patient.data.ContactData;
import com.electrichealth.patient.data.PatientData;

@Component
public class PatientMapper {
	// While creating the Record
	public PatientEntity mapToPatientEntity(final PatientData patientData) {
		Random random = new Random();
		patientData.setPatientCode(String.format("%08d", random.nextInt(99999999)));
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
		patientData.setDateCreated(timeStamp);

		AddressData add = patientData.getAddress();
		ContactData contact = patientData.getContactInfo();
		return mapToPatientEntity(new PatientEntity(), new AddressEntity(), new ContactEntity(), patientData, add,
				contact);
	}

	// While updating the record
	public PatientEntity mapToPatientEntity(final PatientEntity entity, final AddressEntity addEntity,
			final ContactEntity conEntity, final PatientData patientData, final AddressData add,
			final ContactData contact) {

		entity.setFirstName(patientData.getFirstName());
		entity.setMiddleName(patientData.getMiddleName());
		entity.setLastName(patientData.getLastName());
		entity.setGender(patientData.getGender());
		entity.setDob(patientData.getDob());
		entity.setStatus(patientData.getStatus());
		entity.setPatientCode(patientData.getPatientCode());
		entity.setDateCreated(patientData.getDateCreated());
		entity.setDateModified(patientData.getDateModified());

		addEntity.setCity(add.getCity());
		addEntity.setState(add.getState());
		addEntity.setZipCode(add.getZipCode());
		addEntity.setStreet(add.getCity());

		entity.setAddress(addEntity);

		conEntity.setCellPhone(contact.getCellPhone());
		conEntity.setEmail(contact.getEmail());
		conEntity.setHomePhone(contact.getHomePhone());
		conEntity.setMethod(contact.getMethod());

		entity.setContactInfo(conEntity);
		return entity;
	}

	// While getting/finding the record
	public PatientData mapToPatientData(final PatientEntity entity) {

		PatientData patientData = new PatientData();
		AddressData addData = new AddressData();
		ContactData conData = new ContactData();
		patientData.setId(entity.getId());
		patientData.setFirstName(entity.getFirstName());
		patientData.setLastName(entity.getLastName());
		patientData.setMiddleName(entity.getMiddleName());
		patientData.setGender(entity.getGender());
		patientData.setDob(entity.getDob());
		patientData.setStatus(entity.getStatus());
		patientData.setPatientCode(entity.getPatientCode());
		patientData.setDateCreated(entity.getDateCreated());
		patientData.setDateModified(entity.getDateModified());

		addData.setCity(entity.getAddress().getCity());
		addData.setState(entity.getAddress().getState());
		addData.setStreet(entity.getAddress().getState());
		addData.setZipCode(entity.getAddress().getZipCode());

		patientData.setAddress(addData);

		conData.setCellPhone(entity.getContactInfo().getCellPhone());
		conData.setEmail(entity.getContactInfo().getEmail());
		conData.setHomePhone(entity.getContactInfo().getHomePhone());
		conData.setMethod(entity.getContactInfo().getMethod());
		patientData.setContactInfo(conData);

		return patientData;
	}

	// While searching the record
	public List<PatientData> mapToPatientDataList(final List<PatientEntity> source) {

		final List<PatientData> results = new ArrayList<PatientData>();

		for (PatientEntity entity : source) {
			results.add(mapToPatientData(entity));
		}
		return results;
	}
}
