package com.electrichealth.patient.data;

public class ContactData {
	private String email;
	private Long homePhone;
	private Long cellPhone;
	private String method;
	
	public ContactData(){};
	
	
	public ContactData(String email, Long homePhone, Long cellPhone, String method) {
		super();
		this.email = email;
		this.homePhone = homePhone;
		this.cellPhone = cellPhone;
		this.method = method;
	}


	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(Long homePhone) {
		this.homePhone = homePhone;
	}
	public Long getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(Long cellPhone) {
		this.cellPhone = cellPhone;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	@Override
	public String toString() {
		return "Contact [email=" + email + ", homePhone=" + homePhone + ", cellPhone=" + cellPhone + ", method="
				+ method + "]";
	}
}
