package com.electricalhealth.exhandler;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.electrichealth.exception.DuplicateDataException;
import com.electrichealth.exception.ErrorResponse;

@Provider
public class DuplicateDataProvider implements ExceptionMapper<DuplicateDataException> {

	@Override
	public Response toResponse(DuplicateDataException exception) {

		final ErrorResponse entity = new ErrorResponse();
		entity.setErrorCode("PATIENT-1002");
		entity.setErrorDesc("Duplicate data to create or update patient");

		return Response.status(510).type(MediaType.APPLICATION_JSON).entity(entity).build();
	}

}
