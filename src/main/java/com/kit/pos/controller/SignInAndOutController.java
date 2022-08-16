package com.kit.pos.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kit.pos.dto.request.SignInAndOutReqDto;
import com.kit.pos.dto.response.SignInAndOutResDto;
import com.kit.pos.entity.SignInAndOut;
import com.kit.pos.service.SignInAndOutService;
import com.kit.pos.util.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

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

	@PostMapping("/do")
	@ApiOperation(value = "Do Sign In or Out")
	public Response<SignInAndOutResDto> doSignInOrOut(@RequestBody SignInAndOutReqDto reqDto, @RequestHeader (name="Authorization") String token) {
		return signInAndOutService.doSignInOrOut(reqDto, token);
	}

	@ApiIgnore
	@Override
	public Response<SignInAndOutResDto> getAll() {
		// TODO Auto-generated method stub
		return super.getAll();
	}

	@ApiIgnore
	@Override
	public Response<SignInAndOutResDto> save(SignInAndOutReqDto e) {
		return super.save(e);
	}

	@ApiIgnore
	@Override
	public Response<SignInAndOutResDto> update(SignInAndOutReqDto e) {
		// TODO Auto-generated method stub
		return super.update(e);
	}

	@ApiIgnore
	@Override
	public Response<SignInAndOutResDto> find(String id) {
		// TODO Auto-generated method stub
		return super.find(id);
	}

	
	
}
