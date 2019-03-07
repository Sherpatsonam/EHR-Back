package com.electrichealth.allergy.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.electrichealth.allergy.data.AllergyDetails;
import com.electrichealth.allergy.data.PatientAllergy;
import com.electrichealth.entity.AllergyDetailsEntity;
import com.electrichealth.entity.PatientAllergyEntity;
import com.electrichealth.exception.NoRecordFoundException;

@Service("pallJpaImpl")
@Transactional
public class AllergiesJpaImpl implements AllergyService {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private AllergyMapper mapper;

	@Override
	public List<PatientAllergyEntity> createAllergyRecord(List<PatientAllergy> patientAllergy) {
		List<PatientAllergyEntity> allergyList = new ArrayList<PatientAllergyEntity>();
		for (PatientAllergy algr : patientAllergy) {
			String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
			algr.setDateCreated(timeStamp);

			PatientAllergyEntity entity = mapper.mapToPatallEntity(new PatientAllergyEntity(), algr);
			final AllergyDetailsEntity allDetEntity = em.find(AllergyDetailsEntity.class, algr.getAllergyId());

			em.persist(entity);

			// entity.setPatientAllergyId(entity.getPatientAllergyId());
			entity.setDetails(allDetEntity);

			allergyList.add(entity);
		}

		return allergyList;

	}

	public AllergyDetails findallergy(Long allergyId) {
		final AllergyDetailsEntity entity = em.find(AllergyDetailsEntity.class, allergyId);
		if (entity == null) {
			throw new NoRecordFoundException(
					" The Allergy Description with allergy code: " + allergyId + "is not found");
		}

		final AllergyDetails all = mapper.mapToAllergyDetails(entity);
		return all;
	}

}
