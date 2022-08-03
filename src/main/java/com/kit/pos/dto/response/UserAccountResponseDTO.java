package com.kit.pos.dto.response;

import com.kit.pos.enums.UserType;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zubayer Ahamed
 * @since Aug 2, 2022
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserAccountResponseDTO extends BaseResponseDTO {

	private String username;
	private String name;
	private boolean admin;
	private boolean waiter;
	private boolean cashier;
	private String roles;
	private int status;
	private String businessId;
	private String division;
	private String shop;
	private String password;
	private UserType userType;
}
