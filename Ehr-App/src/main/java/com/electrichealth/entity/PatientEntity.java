package com.electrichealth.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQueries({
		@NamedQuery(name = QueryConstants.QUERY_PATIENT_SEARCH, query = "select c from PatientEntity c where c.firstName=?1 AND c.gender=?4 OR c.address.zipCode=?2 OR c.dob=?3"),
		// @NamedQuery(name = QueryConstants.QUERY_LIST_PATIENTS, query =
		// "select c from PatientEntity c"),
		@NamedQuery(name = QueryConstants.QUERY_FIND_PATIENT, query = "select c from PatientEntity c where  c.firstName=?1 AND c.gender=?4 AND c.address.zipCode=?2 AND c.dob=?3") })
@Table(name = "PATIENT")
public class PatientEntity {

	@Id
	@Column(name = "ID")
	@SequenceGenerator(name = "PatIdSeq", sequenceName = "PATIENT_ID", allocationSize = 1)
	@GeneratedValue(generator = "PatIdSeq")
	private Long id;

	@Column(name = "FIRSTNAME")
	private String firstName;

	@Column(name = "MIDDLENAME")
	private String middleName;

	@Column(name = "LASTNAME")
	private String lastName;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "DOB")
	private String dob;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "DATECREATED")
	private String dateCreated;

	@Column(name = "DATEMODIFIED")
	private String dateModified;

	@Column(name = "PATIENTCODE")
	private String patientCode;

	@Embedded
	private AddressEntity address;

	@Embedded
	private ContactEntity contactInfo;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "pat")
	private List<PatientAllergyEntity> patAll;

	public List<PatientAllergyEntity> getPatAll() {
		if (patAll == null) {
			patAll = new ArrayList<PatientAllergyEntity>();
		}
		return patAll;
	}

	public void setPatAll(List<PatientAllergyEntity> patAll) {
		this.patAll = patAll;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getDateModified() {
		return dateModified;
	}

	public void setDateModified(String dateModified) {
		this.dateModified = dateModified;
	}

	public String getPatientCode() {
		return patientCode;
	}

	public void setPatientCode(String patientCode) {
		this.patientCode = patientCode;
	}

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}

	public ContactEntity getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(ContactEntity contactInfo) {
		this.contactInfo = contactInfo;
	}

	@Override
	public String toString() {
		return "PatientEntity [id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", gender=" + gender + ", dob=" + dob + ", status=" + status + ", dateCreated="
				+ dateCreated + ", dateModified=" + dateModified + ", patientCode=" + patientCode + ", address="
				+ address + ", contactInfo=" + contactInfo + "]";
	}

}
