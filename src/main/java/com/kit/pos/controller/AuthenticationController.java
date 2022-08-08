package com.kit.pos.controller;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kit.pos.dto.request.AuthenticationRequestDTO;
import com.kit.pos.dto.response.AuthenticationResponseDTO;
import com.kit.pos.entity.UserAccount;
import com.kit.pos.service.AuthenticationService;
import com.kit.pos.util.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author Zubayer Ahamed
 * @since Aug 1, 2022
 */
@RestController
@RequestMapping("/api/kitpos/authenticate")
@Api(tags = {"Authentication"}, description = "API", produces = "application/json", consumes = "application/json")
public class AuthenticationController extends KITAbstractController<UserAccount, AuthenticationResponseDTO, AuthenticationRequestDTO> {

	private AuthenticationService<AuthenticationResponseDTO, AuthenticationRequestDTO> authenticationService;

	public AuthenticationController (AuthenticationService<AuthenticationResponseDTO, AuthenticationRequestDTO> authenticationService){
		super(authenticationService);
		this.authenticationService = authenticationService;
	}

	@PostMapping("/token")
	@ApiOperation(value = "Get Authentication Token")
	public Response<AuthenticationResponseDTO> getAuthenticationToken(@RequestBody AuthenticationRequestDTO reqDto) throws BadCredentialsException {
		return authenticationService.getAuthenticationToken(reqDto);
	}

	@ApiIgnore
	@Override
	public Response<AuthenticationResponseDTO> getAll() {
		// TODO Auto-generated method stub
		return super.getAll();
	}

	@ApiIgnore
	@Override
	public Response<AuthenticationResponseDTO> save(AuthenticationRequestDTO e) {
		// TODO Auto-generated method stub
		return super.save(e);
	}

	@ApiIgnore
	@Override
	public Response<AuthenticationResponseDTO> update(AuthenticationRequestDTO e) {
		// TODO Auto-generated method stub
		return super.update(e);
	}

	@ApiIgnore
	@Override
	public Response<AuthenticationResponseDTO> find(String id) {
		// TODO Auto-generated method stub
		return super.find(id);
	}

	
}
