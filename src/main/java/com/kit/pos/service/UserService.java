package com.kit.pos.service;

import com.kit.pos.entity.UserAccount;
import com.kit.pos.entity.pk.UserPK;

/**
 * @author Zubayer Ahamed
 * @since Jul 24, 2022
 */
public interface UserService {

	public UserAccount find(UserPK userPk);
}
