package com.kit.pos.dto.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zubayer Ahamed
 * @since Jul 24, 2022
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BusinessRequestDTO extends BaseRequestDTO{

	private String businessId;
	private String division;
	private String shop;
	private String counter;
	private String name;
	private int status;
}
