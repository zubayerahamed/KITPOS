package com.kit.pos.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zubayer Ahamed
 * @since Aug 1, 2022
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BusinessResponseDTO extends BaseResponseDTO {

	private String businessId;
	private String division;
	private String shop;
	private String counter;
	private String name;
	private int status;
}
