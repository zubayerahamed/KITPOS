package com.kit.pos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kit.pos.model.AuthenticationRequest;
import com.kit.pos.model.AuthenticationResponse;
import com.kit.pos.service.JWTService;
import com.kit.pos.service.KITUserDetailsService;

/**
 * @author Zubayer Ahamed
 * @since Jul 24, 2022
 */
@RestController
public class MainController {

	@Autowired private AuthenticationManager authenticationManager;
	@Autowired private KITUserDetailsService userDetailsService;
	@Autowired private JWTService jwtUtil;

	@GetMapping("/")
	public String entryPoint() {
		return "entry";
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello world";
	}

	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authRequest) throws BadCredentialsException {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new BadCredentialsException("Incorrect username or password", e);
		}
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
		final String jwt = jwtUtil.generateToken(userDetails);
		
		AuthenticationResponse response = new AuthenticationResponse(jwt);
		return ResponseEntity.ok(response);
	}
}
