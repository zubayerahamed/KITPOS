package com.kit.pos.dto.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zubayer Ahamed
 * @since Aug 2, 2022
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserAccountRequestDTO extends BaseRequestDTO {

	private String username;
	private String password;
	private String name;
	private boolean admin;
	private boolean waiter;
	private boolean cashier;
	private int status;
}
