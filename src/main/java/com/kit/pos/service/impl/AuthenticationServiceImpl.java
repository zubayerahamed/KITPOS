package com.kit.pos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.kit.pos.dto.request.AuthenticationRequestDTO;
import com.kit.pos.dto.response.AuthenticationResponseDTO;
import com.kit.pos.service.AuthenticationService;
import com.kit.pos.service.BaseService;
import com.kit.pos.util.Response;

/**
 * @author Zubayer Ahamed
 * @since Aug 2, 2022
 */
@Service
public class AuthenticationServiceImpl extends BaseService<AuthenticationResponseDTO> implements AuthenticationService {

	@Autowired private AuthenticationManager authenticationManager;
	@Autowired private UserServiceImpl userService;

	@Override
	public Response<AuthenticationResponseDTO> getAuthenticationToken(AuthenticationRequestDTO reqDto) {
		// Try to authenticate
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(reqDto.getUsername(), reqDto.getPassword()));
		} catch (BadCredentialsException e) {
			return getErrorResponse(null, e.getMessage());
		}

		// if authentication success then generate token
		final UserDetails userDetails = userService.loadUserByUsername(reqDto.getUsername());
		final String jwt = jwtUtil.generateToken(userDetails);
	
		Response<AuthenticationResponseDTO> response = getSuccessResponse(null, "Token generate successfully");
		AuthenticationResponseDTO resDto = new AuthenticationResponseDTO(jwt);
		response.setObj(resDto);
		return response;
	}

}
