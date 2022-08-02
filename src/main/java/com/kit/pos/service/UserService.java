package com.kit.pos.service;

import com.kit.pos.entity.UserAccount;

/**
 * @author Zubayer Ahamed
 * @since Jul 24, 2022
 */
public interface UserService {

	public UserAccount findByUsername(String username);
}
