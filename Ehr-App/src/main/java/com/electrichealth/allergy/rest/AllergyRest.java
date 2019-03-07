/*
 * package com.electrichealth.allergy.rest;
 * 
 * import javax.ws.rs.Consumes; import javax.ws.rs.DELETE; import
 * javax.ws.rs.GET; import javax.ws.rs.Path; import javax.ws.rs.PathParam;
 * import javax.ws.rs.Produces; import javax.ws.rs.core.MediaType; import
 * javax.ws.rs.core.Response;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.beans.factory.annotation.Qualifier;
 * 
 * import com.electrichealth.allergy.data.AllergyDetails; import
 * com.electrichealth.allergy.service.AllergyDetailService;
 * 
 * @Path("/allergy")
 * 
 * @Consumes({ MediaType.APPLICATION_JSON })
 * 
 * @Produces({ MediaType.APPLICATION_JSON }) public class AllergyRest {
 * 
 * @Qualifier("alJpaImpl")
 * 
 * @Autowired private AllergyDetailService as;
 * 
 * @GET
 * 
 * @Path("/{allergyCode}") public Response findAllergy(@PathParam("allergyCode")
 * final Long allergyCode) { final AllergyDetails entity =
 * as.findallergy(allergyCode); return Response.ok().entity(entity).build(); }
 * 
 * @DELETE
 * 
 * @Path("/{patallergyId}") public Response
 * removeAllergy(@PathParam("patallergyId") final Long patallergyId) {
 * as.removeAllergy(patallergyId); return Response.noContent().build(); }
 * 
 * }
 * 
 * @GET
 * 
 * @Path("/patAllegies")
 * 
 * public Response listAllergies(@QueryParam("patientId") final Long patientId)
 * { final List<PatientAllergy> allergyList = as.listAllergies(patientId);
 * ListAllergies entity = new ListAllergies(allergyList); return
 * Response.ok().entity(entity).build();
 * 
 * }
 * 
 * }
 */