package com.electricalhealth.exhandler;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.electrichealth.exception.ErrorResponse;
import com.electrichealth.exception.NoRecordFoundException;

@Provider
public class NoRecordFoundProvider implements ExceptionMapper<NoRecordFoundException> {

	@Override
	public Response toResponse(NoRecordFoundException exception) {
		final ErrorResponse entity = new ErrorResponse();
		entity.setErrorCode("Error-101");
		entity.setErrorDesc(exception.getMessage());

		return Response.status(509).entity(entity).build();
	}

}
