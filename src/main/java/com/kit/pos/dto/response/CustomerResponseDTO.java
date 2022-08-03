package com.kit.pos.dto.response;

import com.kit.pos.enums.CustomerType;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zubayer Ahamed
 * @since Aug 3, 2022
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CustomerResponseDTO extends BaseResponseDTO {

	private String customerId;

	private String name;
	private String email;
	private String phone1;
	private String phone2;
	private String country;
	private String district;
	private String postOffice;
	private String zipCode;
	private String addressLine1;
	private String addressLine2;
	private String nid;
	private CustomerType customerType;
	private int status = 1;
}
