package com.kit.pos.dto;

import lombok.Data;

/**
 * @author Zubayer Ahamed
 * @since Jul 24, 2022
 */
@Data
public class BusinessDTO {

	private String businessId;
	private String division;
	private String shop;
	private String counter;
	private String name;
	private int status;
}
