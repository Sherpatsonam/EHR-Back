package com.electrichealth.rest.config;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/ehr")
public class EhrApp {

	@GET
	public String welcome(){
		return "Welcome to EHR webservice";
	}
}
