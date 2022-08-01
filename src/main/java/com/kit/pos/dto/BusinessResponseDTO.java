package com.kit.pos.dto;

import lombok.Data;

/**
 * @author Zubayer Ahamed
 * @since Aug 1, 2022
 */
@Data
public class BusinessResponseDTO {

	private String businessId;
	private String division;
	private String shop;
	private String counter;
	private String name;
	private int status;
}
