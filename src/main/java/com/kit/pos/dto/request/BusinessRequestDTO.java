package com.kit.pos.dto.request;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zubayer Ahamed
 * @since Jul 24, 2022
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BusinessRequestDTO extends BaseRequestDTO{

	@NotBlank
	private String businessId;
	@NotBlank
	private String division;
	@NotBlank
	private String shop;
	@NotBlank
	private String counter;
	@NotBlank
	private String name;
	private int status;
}
