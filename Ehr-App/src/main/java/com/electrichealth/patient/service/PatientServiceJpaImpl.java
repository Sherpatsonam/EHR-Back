package com.electrichealth.patient.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.electrichealth.allergy.data.PatientAllergy;
import com.electrichealth.allergy.service.AllergyMapper;
import com.electrichealth.allergy.service.AllergyService;
import com.electrichealth.entity.AddressEntity;
import com.electrichealth.entity.AllergyDetailsEntity;
import com.electrichealth.entity.ContactEntity;
import com.electrichealth.entity.PatientAllergyEntity;
import com.electrichealth.entity.PatientEntity;
import com.electrichealth.entity.QueryConstants;
import com.electrichealth.exception.DuplicateDataException;
import com.electrichealth.exception.NoRecordFoundException;
import com.electrichealth.patient.data.AddressData;
import com.electrichealth.patient.data.ContactData;
import com.electrichealth.patient.data.PatientData;

@Service("psJpaImpl")
@Transactional
public class PatientServiceJpaImpl implements PatientService {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private PatientMapper mapper;

	@Autowired
	private AllergyMapper almapper;

	@Autowired
	private AllergyService as;

	@Override
	public PatientData createPatient(PatientData patient) {
		DuplicatePatientRecord(patient);
		PatientEntity entity = mapper.mapToPatientEntity(patient);
		em.persist(entity);
		patient.setId(entity.getId());
		List<PatientAllergy> allergy = patient.getPatAll();
		List<PatientAllergyEntity> allergyList = as.createAllergyRecord(allergy);
		setPatientAllergyList(patient, entity, allergy, allergyList);

		return patient;
	}

	/*
	 * @Override public PatientData createPatient(PatientData patient) { Random
	 * random = new Random(); patient.setPatientCode(String.format("%08d",
	 * random.nextInt(99999999))); String timeStamp = new
	 * SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
	 * patient.setDateCreated(timeStamp);
	 * 
	 * PatientEntity entity = mapper.mapToPatientEntity(patient);
	 * 
	 * if (entity == null) { throw new InvalidDataException("invalid entity"); }
	 * 
	 * List<PatientEntity> listPE = listPatient(); for (PatientEntity lpe :
	 * listPE) { System.out.println(lpe.getFirstName() + " new: " +
	 * entity.getFirstName()); if
	 * (lpe.getFirstName().equalsIgnoreCase(entity.getFirstName())) { //
	 * System.out.println("name matched"); if
	 * (lpe.getDob().equalsIgnoreCase(entity.getDob())) { //
	 * System.out.println("name and dob matched");
	 * 
	 * if (lpe.getGender().equalsIgnoreCase(entity.getGender())) { //
	 * System.out.println("name dob zip gender matched"); throw new
	 * DuplicateDataException("the patient exists"); } else { //
	 * System.out.println("no duplicate gender"); }
	 * 
	 * } else { // System.out.println("no duplicate dob,zip,gender"); } } else {
	 * // System.out.println("no duplicate record"); } }
	 * 
	 * em.persist(entity); patient.setId(entity.getId()); List<PatientAllergy>
	 * allergy = patient.getPatAll(); List<PatientAllergyEntity> allergyList =
	 * as.createAllergyRecord(allergy); for (PatientAllergyEntity all :
	 * allergyList) { entity.getPatAll().add(all);
	 * 
	 * all.setPat(entity);
	 * 
	 * for (PatientAllergy patallData : allergy) {
	 * patallData.setPatientId(patient.getId());
	 * patallData.setPatientAllergyId(all.getPatientAllergyId());
	 * 
	 * } }
	 * 
	 * return patient; }
	 */
	@Override
	public void modifyPatient(PatientData patient) {
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
		patient.setDateModified(timeStamp);
		AddressData add = patient.getAddress();
		ContactData contact = patient.getContactInfo();
		PatientEntity entity = em.find(PatientEntity.class, patient.getId());
		AddressEntity addEntity = entity.getAddress();
		ContactEntity conEntity = entity.getContactInfo();
		entity = mapper.mapToPatientEntity(entity, addEntity, conEntity, patient, add, contact);
		em.persist(entity);

	}

	@Override
	public PatientData findPatient(Long id) {
		final PatientEntity entity = em.find(PatientEntity.class, id);

		if (entity == null) {
			throw new NoRecordFoundException("The patient with id=" + id + "is not found in our service");
		}

		final PatientData result = mapper.mapToPatientData(entity);
		List<PatientAllergy> list = new ArrayList<PatientAllergy>();
		List<PatientAllergyEntity> listPatall = entity.getPatAll();
		// System.out.println("array>>>>>>>>>>>>" + listPatall);
		for (PatientAllergyEntity pae : listPatall) {
			list.add(almapper.mapToPateintAllergy(pae));
			pae.setPat(entity);

		}
		for (PatientAllergy pad : list) {
			pad.setPatientId(entity.getId());
		}
		result.setPatAll(list);
		return result;
	}

	@Override
	public List<PatientData> searchPatient(String firstName, Long zipCode, String gender, String dob) {
		TypedQuery<PatientEntity> query = em.createNamedQuery(QueryConstants.QUERY_PATIENT_SEARCH, PatientEntity.class);
		query.setParameter(1, firstName);
		query.setParameter(2, zipCode);
		query.setParameter(3, dob);
		query.setParameter(4, gender);

		final List<PatientEntity> results = query.getResultList();
		if (results.size() == 0) {
			throw new NoRecordFoundException("No Patient Found");
		}
		return mapper.mapToPatientDataList(results);
	}

	@Override
	public PatientAllergy createPatientAllergy(PatientAllergy patAll) {
		final PatientEntity pentity = em.find(PatientEntity.class, patAll.getPatientId());
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
		patAll.setDateCreated(timeStamp);
		final AllergyDetailsEntity adentity = em.find(AllergyDetailsEntity.class, patAll.getAllergyId());
		final PatientAllergyEntity paentity = almapper.mapToPatallEntity(new PatientAllergyEntity(), patAll);

		paentity.setDetails(adentity);
		paentity.setPat(pentity);
		List<PatientAllergyEntity> lpae = pentity.getPatAll();
		lpae.add(paentity);
		pentity.setPatAll(lpae);
		em.persist(pentity);
		em.persist(paentity);
		patAll.setPatientAllergyId(paentity.getPatientAllergyId());
		return patAll;
	}

	/*
	 * public List<PatientEntity> listPatient() { TypedQuery<PatientEntity>
	 * query = em.createNamedQuery(QueryConstants.QUERY_LIST_PATIENTS,
	 * PatientEntity.class); final List<PatientEntity> results =
	 * query.getResultList(); // System.out.println(results); return results; }
	 */

	private void setPatientAllergyList(PatientData patient, PatientEntity entity, List<PatientAllergy> allergy,
			List<PatientAllergyEntity> allergyList) {
		for (PatientAllergyEntity all : allergyList) {
			entity.getPatAll().add(all);

			all.setPat(entity);

			for (PatientAllergy patallData : allergy) {
				patallData.setPatientId(patient.getId());
				patallData.setPatientAllergyId(all.getPatientAllergyId());

			}
		}
	}

	public PatientData DuplicatePatientRecord(PatientData patient) {
		try {
			TypedQuery<PatientEntity> query = em.createNamedQuery(QueryConstants.QUERY_FIND_PATIENT,
					PatientEntity.class);
			query.setParameter(1, patient.getFirstName());
			query.setParameter(2, patient.getAddress().getZipCode());
			query.setParameter(3, patient.getDob());
			query.setParameter(4, patient.getGender());
			final PatientEntity results = query.getSingleResult();
			if (results != null) {
				throw new DuplicateDataException("patient Record Exists");
			} else {
				return patient;
			}
		} catch (NoResultException ex) {

			return patient;
		}

	}

}
