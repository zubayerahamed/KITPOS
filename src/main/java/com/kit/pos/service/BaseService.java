package com.kit.pos.service;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.kit.pos.config.AppConfig;
import com.kit.pos.util.CommonFunctions;
import com.kit.pos.util.Response;

/**
 * @author Zubayer Ahamed
 * @since Aug 2, 2022
 */
public abstract class BaseService<R> implements CommonFunctions<R> {

	@Autowired protected EntityManager entityManager;
	@Autowired protected AppConfig appConfig;
	@Autowired protected JWTService jwtUtil;

	@Override
	public Response<R> getSuccessResponse(String code, String message) {
		Response<R> response = new Response<R>();
		response.setSuccess(true);
		response.setCode(code);
		response.setMessage(message);
		return response;
	}

	@Override
	public Response<R> getSuccessResponse(String code, String message, Response<R> response) {
		response.setSuccess(true);
		response.setCode(code);
		response.setMessage(message);
		return response;
	}

	@Override
	public Response<R> getErrorResponse(String code, String message) {
		Response<R> response = new Response<R>();
		response.setSuccess(false);
		response.setCode(code);
		response.setMessage(message);
		return response;
	}

	@Override
	public Response<R> getErrorResponse(String code, String message, Response<R> response) {
		response.setSuccess(false);
		response.setCode(code);
		response.setMessage(message);
		return response;
	}
}
