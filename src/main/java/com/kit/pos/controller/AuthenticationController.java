package com.kit.pos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kit.pos.model.AuthenticationRequest;
import com.kit.pos.model.AuthenticationResponse;
import com.kit.pos.service.JWTService;
import com.kit.pos.service.impl.UserServiceImpl;

import io.swagger.annotations.Api;

/**
 * @author Zubayer Ahamed
 * @since Aug 1, 2022
 */
@RestController
@RequestMapping("/api/kitpos")
@Api(value = "Authentication API", description = "Authentication Key Generator")
public class AuthenticationController {

	@Autowired private AuthenticationManager authenticationManager;
	@Autowired private UserServiceImpl userService;
	@Autowired private JWTService jwtUtil;

	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authRequest) throws BadCredentialsException {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new BadCredentialsException("Incorrect username or password", e);
		}
		
		final UserDetails userDetails = userService.loadUserByUsername(authRequest.getUsername());
		final String jwt = jwtUtil.generateToken(userDetails);
		
		AuthenticationResponse response = new AuthenticationResponse(jwt);
		return ResponseEntity.ok(response);
	}
}
