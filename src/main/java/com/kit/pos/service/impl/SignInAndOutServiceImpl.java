package com.kit.pos.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.kit.pos.dto.request.SignInAndOutReqDto;
import com.kit.pos.dto.response.SignInAndOutResDto;
import com.kit.pos.model.KITUserDetails;
import com.kit.pos.repository.SignInAndOutRepository;
import com.kit.pos.service.JWTService;
import com.kit.pos.service.SignInAndOutService;
import com.kit.pos.util.Response;

import io.jsonwebtoken.Claims;

/**
 * @author Zubayer Ahamed
 * @since Aug 15, 2022
 */
@Service
public class SignInAndOutServiceImpl extends AbstractBaseService<SignInAndOutResDto, SignInAndOutReqDto> implements SignInAndOutService<SignInAndOutResDto, SignInAndOutReqDto>{

	@Autowired private SignInAndOutRepository repo;
	@Autowired private JWTService jwtService;

	@Override
	public Response<SignInAndOutResDto> find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public Response<SignInAndOutResDto> doSignInOrOut(SignInAndOutReqDto e, String token) {
		String username = null;
		String jwt = null;

		if (token != null && token.startsWith("Bearer ")) {
			jwt = token.substring(7);
			username = jwtService.extractUsername(jwt);
		}

		if(StringUtils.isBlank(username)) return getErrorResponse("User not found");
		
		
		Claims c = jwtService.extractAllClaims(jwt);
		KITUserDetails userd = null;
//		c.entrySet().stream().forEach(s -> {
//			if("userDetails".equalsIgnoreCase(s.getKey())) {
//				userd = (KITUserDetails) s.getValue();
//			}
//			System.out.println(s.getKey() + " --- " + s.getValue());
//		});

		return getSuccessResponse("Sign in");
	}

	@Override
	public Response<SignInAndOutResDto> save(SignInAndOutReqDto reqDto) {
		return null;
	}

	@Override
	public Response<SignInAndOutResDto> update(SignInAndOutReqDto reqDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response<SignInAndOutResDto> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
