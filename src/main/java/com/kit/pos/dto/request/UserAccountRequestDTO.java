package com.kit.pos.dto.request;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.BeanUtils;

import com.kit.pos.entity.UserAccount;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zubayer Ahamed
 * @since Aug 2, 2022
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserAccountRequestDTO extends BaseRequestDTO<UserAccount> {

	@NotBlank
	private String username;
	private String password;
	private String name;
	private boolean admin;
	private boolean waiter;
	private boolean cashier;
	private int status;

	@Override
	public UserAccount getBean() {
		UserAccount u = new UserAccount();
		BeanUtils.copyProperties(this, u);
		return u;
	}
	
}
