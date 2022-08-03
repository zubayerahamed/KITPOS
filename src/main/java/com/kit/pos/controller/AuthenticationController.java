package com.kit.pos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kit.pos.dto.request.AuthenticationRequestDTO;
import com.kit.pos.dto.response.AuthenticationResponseDTO;
import com.kit.pos.service.AuthenticationService;
import com.kit.pos.util.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Zubayer Ahamed
 * @since Aug 1, 2022
 */
@RestController
@RequestMapping("/api/kitpos")
@Api(tags = {"Authentication"}, description = "API")
public class AuthenticationController extends KITAbstractController {

	@Autowired private AuthenticationService authenticationService;

	@ApiOperation(value = "Get Authentication Token")
	@PostMapping(value="/authenticate", produces = "application/json", consumes = "application/json")
	public Response<AuthenticationResponseDTO> getAuthenticationToken(@RequestBody AuthenticationRequestDTO reqDto) throws BadCredentialsException {
		return authenticationService.getAuthenticationToken(reqDto);
	}
}
