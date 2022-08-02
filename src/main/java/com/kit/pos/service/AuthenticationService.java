package com.kit.pos.service;

import com.kit.pos.dto.AuthenticationRequestDTO;
import com.kit.pos.dto.AuthenticationResponseDTO;
import com.kit.pos.util.Response;

/**
 * @author Zubayer Ahamed
 * @since Aug 2, 2022
 */
public interface AuthenticationService {

	Response<AuthenticationResponseDTO> getAuthenticationToken(AuthenticationRequestDTO reqDto);
}
