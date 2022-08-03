package com.kit.pos.service;

import com.kit.pos.dto.request.UserAccountRequestDTO;
import com.kit.pos.dto.response.UserAccountResponseDTO;
import com.kit.pos.util.Response;

/**
 * @author Zubayer Ahamed
 * @since Jul 24, 2022
 */
public interface UserService {

	public Response<UserAccountResponseDTO> findByUsername(String username);

	public Response<UserAccountResponseDTO> save(UserAccountRequestDTO reqDto);

	public Response<UserAccountResponseDTO> update(UserAccountRequestDTO reqDto);

	public Response<UserAccountResponseDTO> getAllUsers();
}
