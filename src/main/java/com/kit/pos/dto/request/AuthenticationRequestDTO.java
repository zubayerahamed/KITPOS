package com.kit.pos.dto.request;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Zubayer Ahamed
 * @since Jul 24, 2022
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AuthenticationRequestDTO extends BaseRequestDTO<Object> {

	@NotBlank
	private String username;
	@NotBlank
	private String password;

	@Override
	Object getBean() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
