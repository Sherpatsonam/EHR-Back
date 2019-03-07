package com.electrichealth.allergy.service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.electrichealth.allergy.data.AllergyDetails;
import com.electrichealth.entity.AllergyDetailsEntity;
import com.electrichealth.entity.PatientAllergyEntity;
import com.electrichealth.entity.QueryConstants;
import com.electrichealth.exception.NoRecordFoundException;

@Service("aljpaImpl")
@Transactional
public class AllergyDetailsJpaImpl implements AllergyDetailService {
	@PersistenceContext
	private EntityManager em;

	@Autowired
	private AllergyMapper mapper;

	@Override
	public void removeAllergy(Long patientAllergyId) {
		final PatientAllergyEntity entity = em.find(PatientAllergyEntity.class, patientAllergyId);
		em.remove(entity);

	}

	@Override
	public AllergyDetails findallergy(Long allergyCode) {
		try {
			TypedQuery<AllergyDetailsEntity> query = em.createNamedQuery(QueryConstants.QUERY_AllERY_SEARCH,
					AllergyDetailsEntity.class);
			query.setParameter(1, allergyCode);
			final AllergyDetailsEntity results = query.getSingleResult();

			final AllergyDetails all = mapper.mapToAllergyDetails(results);
			return all;
		} catch (NoResultException ex) {
			throw new NoRecordFoundException("allergynot found");
		}
	}
}
