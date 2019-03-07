package com.electrichealth.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQuery(name = QueryConstants.QUERY_AllERY_SEARCH, query = "select c from AllergyDetailsEntity c WHERE c.allergyCode=?1")

@Table(name = "ALLERGYDETAILS")
public class AllergyDetailsEntity {

	@Id
	@Column(name = "ALLERGY_ID")
	@SequenceGenerator(name = "PatIdSeq", sequenceName = "JPA_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "PatIdSeq")
	private Long allergyID;

	@Column(name = "ALLERGY_CODE")
	private Long allergyCode;

	@Column(name = "AllERGY_DESCRP")
	private String allergyDescription;

	public Long getAllergyID() {
		return allergyID;
	}

	public void setAllergyID(Long allergyID) {
		this.allergyID = allergyID;
	}

	public Long getAllergyCode() {
		return allergyCode;
	}

	public void setAllergyCode(Long allergyCode) {
		this.allergyCode = allergyCode;
	}

	public String getAllergyDescription() {
		return allergyDescription;
	}

	public void setAllergyDescription(String allergyDescription) {
		this.allergyDescription = allergyDescription;
	}

	@Override
	public String toString() {
		return "AllergyDetailsEntity [allergyID=" + allergyID + ", allergyCode=" + allergyCode + ", allergyDescription="
				+ allergyDescription + "]";
	}

}
