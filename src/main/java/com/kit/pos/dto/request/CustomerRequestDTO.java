package com.kit.pos.dto.request;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.BeanUtils;

import com.kit.pos.entity.Customer;
import com.kit.pos.enums.CustomerType;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zubayer Ahamed
 * @since Aug 3, 2022
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CustomerRequestDTO  extends BaseRequestDTO<Customer> {

	private String customerId;
	@NotBlank
	private String name;
	private String email;
	@NotBlank
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

	@Override
	Customer getBean() {
		Customer c = new Customer();
		BeanUtils.copyProperties(this, c);
		return c;
	}
}
