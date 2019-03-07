package com.electrichealth.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Access(AccessType.FIELD)
public class ContactEntity {

	@Column(name = "Email")
	private String email;

	@Column(name = "homePhone")
	private Long homePhone;

	@Column(name = "CELLPhone")
	private Long cellPhone;

	@Column(name = "METHOD")
	private String method;

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
		return "ContactEntity [email=" + email + ", homePhone=" + homePhone + ", cellPhone=" + cellPhone + ", method="
				+ method + "]";
	}

}
