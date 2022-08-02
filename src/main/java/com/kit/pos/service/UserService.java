package com.kit.pos.service;

import com.kit.pos.dto.response.UserAccountResponseDTO;
import com.kit.pos.util.Response;

/**
 * @author Zubayer Ahamed
 * @since Jul 24, 2022
 */
public interface UserService {

	public Response<UserAccountResponseDTO> findByUsername(String username);
}
