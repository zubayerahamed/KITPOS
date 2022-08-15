package com.kit.pos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kit.pos.dto.request.SignInAndOutReqDto;
import com.kit.pos.dto.response.SignInAndOutResDto;
import com.kit.pos.repository.SignInAndOutRepository;
import com.kit.pos.service.SignInAndOutService;
import com.kit.pos.util.Response;

/**
 * @author Zubayer Ahamed
 * @since Aug 15, 2022
 */
@Service
public class SignInAndOutServiceImpl extends AbstractBaseService<SignInAndOutResDto, SignInAndOutReqDto> implements SignInAndOutService<SignInAndOutResDto, SignInAndOutReqDto>{

	@Autowired private SignInAndOutRepository repo;

	@Override
	public Response<SignInAndOutResDto> find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response<SignInAndOutResDto> save(SignInAndOutReqDto reqDto) {
		// TODO Auto-generated method stub
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
