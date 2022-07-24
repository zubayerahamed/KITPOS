package com.kit.pos.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Zubayer Ahamed
 * @since Jul 24, 2022
 */
@Data
@AllArgsConstructor
public class AuthenticationResponse {

	private final String jwt;
}