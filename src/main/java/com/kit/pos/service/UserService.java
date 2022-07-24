package com.kit.pos.service;

import com.kit.pos.entity.User;
import com.kit.pos.entity.pk.UserPK;

/**
 * @author Zubayer Ahamed
 * @since Jul 24, 2022
 */
public interface UserService {

	public User find(UserPK userPk);
}
