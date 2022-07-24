package com.kit.pos.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kit.pos.entity.User;
import com.kit.pos.entity.pk.UserPK;
import com.kit.pos.repository.UserRepository;
import com.kit.pos.service.UserService;

/**
 * @author Zubayer Ahamed
 * @since Jul 24, 2022
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired UserRepository userRepository;

	@Override
	public User find(UserPK userPk) {
		Optional<User> optional = userRepository.findById(userPk);
		return optional.isPresent() ? optional.get() : null;
	}

	
}
