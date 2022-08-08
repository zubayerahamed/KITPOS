package com.kit.pos.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.kit.pos.config.AppConfig;
import com.kit.pos.constant.BaseConstant;
import com.kit.pos.dto.response.UserAccountResponseDTO;
import com.kit.pos.entity.UserAccount;
import com.kit.pos.enums.UserType;
import com.kit.pos.util.CommonFunctions;
import com.kit.pos.util.Response;

/**
 * @author Zubayer Ahamed
 * @since Aug 2, 2022
 */
public abstract class AbstractBaseService<R, E> implements CommonFunctions<R> {

	@Autowired protected EntityManager em;
	@Autowired protected AppConfig appConfig;
	@Autowired protected JWTService jwtUtil;
	@Autowired protected BCryptPasswordEncoder passwordEncoder;

	@Override
	public Response<R> getSuccessResponse(String message) {
		Response<R> response = new Response<R>();
		response.setSuccess(true);
		response.setMessage(message);
		return response;
	}

	@Override
	public Response<R> getSuccessResponse(String code, String message) {
		Response<R> response = new Response<R>();
		response.setSuccess(true);
		response.setCode(code);
		response.setMessage(message);
		return response;
	}

	@Override
	public Response<R> getSuccessResponse(String code, String message, R r) {
		Response<R> response = new Response<R>();
		response.setSuccess(true);
		response.setCode(code);
		response.setMessage(message);
		response.setObj(r);
		return response;
	}

	@Override
	public Response<R> getSuccessResponse(String code, String message, List<R> list) {
		Response<R> response = new Response<R>();
		response.setSuccess(true);
		response.setCode(code);
		response.setMessage(message);
		response.setItems(list);
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
	public Response<R> getErrorResponse(String message) {
		Response<R> response = new Response<R>();
		response.setSuccess(false);
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

	@Override
	public UserAccountResponseDTO getSystemAdminUser() {
		UserAccountResponseDTO responseDto = new UserAccountResponseDTO();
		UserAccount user = new UserAccount();
		user.setBusinessId(appConfig.getBusinessId());
		user.setUsername(BaseConstant.SYSTEM_ADMIN_USERNAME);
		user.setPassword(passwordEncoder.encode(BaseConstant.SYSTEM_ADMIN_PASSWORD));
		user.setDivision(appConfig.getDivision());
		user.setShop(appConfig.getShop());
		user.setStatus(1);
		user.setSystemadmin(true);
		user.setUserType(UserType.POS);
		BeanUtils.copyProperties(user, responseDto);
		return responseDto;
	}

}
