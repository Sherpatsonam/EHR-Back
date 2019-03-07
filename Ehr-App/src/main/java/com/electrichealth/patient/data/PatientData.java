package com.electrichealth.patient.data;

import java.util.List;

import com.electrichealth.allergy.data.PatientAllergy;

public class PatientData {

	private Long id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String gender;
	private String dob;
	private String status;
	private String dateCreated;
	private String dateModified;
	private String patientCode;
	private AddressData address;
	private ContactData contactInfo;

	private List<PatientAllergy> patAll;

	public PatientData() {
	};

	public PatientData(Long id, String firstName, String middleName, String lastName, String gender, String dob,
			String status, String dateCreated, String dateModified, String patientCode, AddressData add,
			ContactData con) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.gender = gender;
		this.dob = dob;
		this.status = status;
		this.dateCreated = dateCreated;
		this.dateModified = dateModified;
		this.patientCode = patientCode;
		this.address = add;
		this.contactInfo = con;
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

	public AddressData getAddress() {
		return address;
	}

	public void setAddress(AddressData address) {
		this.address = address;
	}

	public ContactData getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(ContactData contactInfo) {
		this.contactInfo = contactInfo;
	}

	@Override
	public String toString() {
		return "PatientData [id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", gender=" + gender + ", dob=" + dob + ", status=" + status + ", dateCreated="
				+ dateCreated + ", dateModified=" + dateModified + ", patientCode=" + patientCode + ", address="
				+ address + ", contactInfo=" + contactInfo + "]";
	}

	public List<PatientAllergy> getPatAll() {
		return patAll;
	}

	public void setPatAll(List<PatientAllergy> patAll) {
		this.patAll = patAll;
	}

}
