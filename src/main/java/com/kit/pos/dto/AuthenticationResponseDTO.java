package com.kit.pos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Zubayer Ahamed
 * @since Jul 24, 2022
 */
@Data
@AllArgsConstructor
public class AuthenticationResponseDTO {

	private final String token;
}