package com.kit.pos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Zubayer Ahamed
 * @since Jul 24, 2022
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequestDTO {

	private String username;
	private String password;
}
