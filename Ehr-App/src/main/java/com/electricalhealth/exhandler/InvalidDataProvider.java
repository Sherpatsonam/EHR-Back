package com.electricalhealth.exhandler;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.electrichealth.exception.ErrorResponse;
import com.electrichealth.exception.InvalidDataException;

@Provider
public class InvalidDataProvider implements ExceptionMapper<InvalidDataException> {

	@Override
	public Response toResponse(InvalidDataException exception) {
		final ErrorResponse entity = new ErrorResponse();
		entity.setErrorCode("PATIENT-100");
		entity.setErrorDesc("Invalid data to create patient");

		return Response.status(511).type(MediaType.APPLICATION_JSON).entity(entity).build();
	}

}
