package com.kit.pos.service.impl;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kit.pos.config.AppConfig;
import com.kit.pos.constant.BaseConstant;
import com.kit.pos.dto.BusinessResponseDTO;
import com.kit.pos.entity.Business;
import com.kit.pos.entity.UserAccount;
import com.kit.pos.entity.pk.BusinessPK;
import com.kit.pos.entity.pk.UserPK;
import com.kit.pos.enums.UserType;
import com.kit.pos.model.KITUserDetails;
import com.kit.pos.repository.UserRepository;
import com.kit.pos.service.BusinessService;
import com.kit.pos.service.UserService;

/**
 * @author Zubayer Ahamed
 * @since Jul 24, 2022
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired private BusinessService businessService;
	@Autowired private AppConfig appConfig;
	@Autowired UserRepository userRepository;
	@Autowired BCryptPasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if(StringUtils.isBlank(username)) {
			throw  new UsernameNotFoundException("User not found in the system");
		}

		UserAccount user = null;
		if(BaseConstant.SYSTEM_ADMIN_USERNAME.equalsIgnoreCase(username)) {
			user = getSystemAdminUser();
		} else {
			user = findByUsername(username);
		}
		if(user == null) throw  new UsernameNotFoundException("User not found in the system");
		if(user.getStatus() == 0) throw  new UsernameNotFoundException("User is inactive");


		BusinessResponseDTO businessResponseDTO = businessService.find().getObj();
		if(businessResponseDTO == null) throw  new UsernameNotFoundException("Business is not correct");
		if(businessResponseDTO.getStatus() == 0) throw  new UsernameNotFoundException("Business is inactive");

		return new KITUserDetails(user, businessResponseDTO);
	}

	private UserAccount getSystemAdminUser() {
		UserAccount user = new UserAccount();
		user.setBusinessId(appConfig.getBusinessId());
		user.setUsername(BaseConstant.SYSTEM_ADMIN_USERNAME);
		user.setPassword(passwordEncoder.encode(BaseConstant.SYSTEM_ADMIN_PASSWORD));
		user.setDivision(appConfig.getDivision());
		user.setShop(appConfig.getShop());
		user.setCounter(appConfig.getCounter());
		user.setStatus(1);
		user.setSystemadmin(true);
		user.setUserType(UserType.POS);
		return user;
	}

	@Override
	public UserAccount findByUsername(String username) {
		Optional<UserAccount> optional = userRepository.findById(new UserPK(appConfig.getBusinessId(), username, appConfig.getDivision(), appConfig.getShop(), appConfig.getCounter()));
		return optional.isPresent() ? optional.get() : null;
	}

}
