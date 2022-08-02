package com.kit.pos.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zubayer Ahamed
 * @since Jul 24, 2022
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AuthenticationResponseDTO extends BaseResponseDTO {

	private final String token;
}