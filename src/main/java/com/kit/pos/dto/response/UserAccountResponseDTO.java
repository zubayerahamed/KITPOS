package com.kit.pos.dto.response;

import org.springframework.beans.BeanUtils;

import com.kit.pos.entity.UserAccount;
import com.kit.pos.enums.UserType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Zubayer Ahamed
 * @since Aug 2, 2022
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class UserAccountResponseDTO extends BaseResponseDTO<UserAccount> {

	UserAccountResponseDTO(UserAccount u){
		BeanUtils.copyProperties(u, this);
	}

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
