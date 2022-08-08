package com.kit.pos.dto.response;

import org.springframework.beans.BeanUtils;

import com.kit.pos.entity.Customer;
import com.kit.pos.enums.CustomerType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Zubayer Ahamed
 * @since Aug 3, 2022
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class CustomerResponseDTO extends BaseResponseDTO<Customer> {

	public CustomerResponseDTO(Customer customer){
		BeanUtils.copyProperties(customer, this);
	}

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
