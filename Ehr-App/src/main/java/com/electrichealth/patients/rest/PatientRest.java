package com.electrichealth.patients.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.electrichealth.allergy.data.AllergyDetails;
import com.electrichealth.allergy.data.PatientAllergy;
import com.electrichealth.allergy.service.AllergyDetailService;
import com.electrichealth.patient.data.PatientData;
import com.electrichealth.patient.service.PatientService;

@Path("/patient")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public class PatientRest {

	@Qualifier("psJpaImpl")
	@Autowired
	private PatientService ps;

	@Autowired
	private AllergyDetailService as;

	@POST
	public Response create(final PatientData patient) {

		final PatientData entity = ps.createPatient(patient);

		return Response.ok().entity(entity).build();
	}

	@POST
	@Path("/allergy")
	public Response create(final PatientAllergy patAll) {

		final PatientAllergy entity = ps.createPatientAllergy(patAll);

		return Response.ok().entity(entity).build();
	}

	@GET
	@Path("/{patId}")
	public Response find(@PathParam("patId") final Long key) {
		final PatientData entity = ps.findPatient(key);
		return Response.ok().entity(entity).build();
	}

	@PUT
	public Response modify(final PatientData patient) {
		ps.modifyPatient(patient);
		return Response.noContent().build();
	}

	@GET
	@Path("/search")
	public Response search(@QueryParam("firstName") final String firstName, @QueryParam("zipCode") final Long zipCode,
			@QueryParam("gender") final String gender, @QueryParam("dob") final String dob) {
		final List<PatientData> patientResult = ps.searchPatient(firstName, zipCode, gender, dob);
		/*
		 * if u use SEarchPatientsReults //if u use SEarchPatientsReults
		 * PatientSearchResults entity = new
		 * PatientSearchResults(patientResult); return
		 * Response.ok().entity(entity).build();
		 */
		return Response.ok().entity(patientResult).build();

	}

	@GET
	@Path("/allergy/{allergyCode}")
	public Response findAllergy(@PathParam("allergyCode") final Long allergyCode) {
		final AllergyDetails entity = as.findallergy(allergyCode);

		return Response.ok().entity(entity).build();
	}

	@DELETE
	@Path("/allergy/{patallergyId}")
	public Response removeAllergy(@PathParam("patallergyId") final Long patallergyId) {
		as.removeAllergy(patallergyId);
		return Response.noContent().build();
	}
}
