package com.kit.pos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kit.pos.dto.request.SignInAndOutReqDto;
import com.kit.pos.dto.response.SignInAndOutResDto;
import com.kit.pos.entity.SignInAndOut;
import com.kit.pos.service.SignInAndOutService;

import io.swagger.annotations.Api;

/**
 * @author Zubayer Ahamed
 * @since Aug 15, 2022
 */
@RestController
@RequestMapping("/api/kitpos/signinandout")
@Api(tags = {"Sign In And Out"}, description = "API", produces = "application/json", consumes = "application/json")
public class SignInAndOutController extends KITAbstractController<SignInAndOut, SignInAndOutResDto, SignInAndOutReqDto>{

	private SignInAndOutService<SignInAndOutResDto, SignInAndOutReqDto> signInAndOutService;

	public SignInAndOutController(SignInAndOutService<SignInAndOutResDto, SignInAndOutReqDto> signInAndOutService) {
		super(signInAndOutService);
		this.signInAndOutService = signInAndOutService;
	}
}
