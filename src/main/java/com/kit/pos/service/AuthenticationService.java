package com.kit.pos.service;

import com.kit.pos.dto.request.AuthenticationRequestDTO;
import com.kit.pos.dto.response.AuthenticationResponseDTO;
import com.kit.pos.util.Response;

/**
 * @author Zubayer Ahamed
 * @since Aug 2, 2022
 */
public interface AuthenticationService {

	Response<AuthenticationResponseDTO> getAuthenticationToken(AuthenticationRequestDTO reqDto);
}
