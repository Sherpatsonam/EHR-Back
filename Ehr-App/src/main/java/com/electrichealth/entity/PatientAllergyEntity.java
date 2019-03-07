package com.electrichealth.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PATIENT_ALLERGY")

public class PatientAllergyEntity {

	@Id
	@Column(name = "PATALL_ID")
	@SequenceGenerator(name = "PatIdSeq", sequenceName = "JPA_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "PatIdSeq")
	private Long patientAllergyId;

	@Column(name = "DATECREATED")
	private String dateCreated;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ALLGID_FK")
	private AllergyDetailsEntity details;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PATID_FK")
	private PatientEntity pat;

	public Long getPatientAllergyId() {
		return patientAllergyId;
	}

	public void setPatientAllergyId(Long patientAllergyId) {
		this.patientAllergyId = patientAllergyId;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public AllergyDetailsEntity getDetails() {
		return details;
	}

	public void setDetails(AllergyDetailsEntity details) {
		this.details = details;
	}

	public PatientEntity getPat() {
		return pat;
	}

	public void setPat(PatientEntity pat) {
		this.pat = pat;
	}

	@Override
	public String toString() {
		return "PatientAllergyEntity [patientAllergyId=" + patientAllergyId + ", dateCreated=" + dateCreated + "]";
	}

}
