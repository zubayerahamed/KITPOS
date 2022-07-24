package com.kit.pos.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kit.pos.config.AppConfig;
import com.kit.pos.entity.Business;
import com.kit.pos.entity.User;
import com.kit.pos.entity.pk.BusinessPK;
import com.kit.pos.entity.pk.UserPK;
import com.kit.pos.model.KITUserDetails;

/**
 * @author Zubayer Ahamed
 * @since Jul 24, 2022
 */
@Service
public class KITUserDetailsService implements UserDetailsService{

	@Autowired private BusinessService businessService;
	@Autowired private UserService userService;
	@Autowired private AppConfig appConfig;
	@Autowired private BCryptPasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if(StringUtils.isBlank(username)) {
			throw  new UsernameNotFoundException("User not found in the system");
		}

		UserPK u = new UserPK();
		u.setBusinessId(appConfig.getBusinessId());
		u.setDivision(appConfig.getDivision());
		u.setShop(appConfig.getShop());
		u.setCounter(appConfig.getCounter());
		u.setUsername(username);

		User user = userService.find(u);
		if(user == null) throw  new UsernameNotFoundException("User not found in the system");
		if(user.getStatus() == 0) throw  new UsernameNotFoundException("User is inactive");

		BusinessPK b = new BusinessPK();
		b.setBusinessId(appConfig.getBusinessId());
		b.setDivision(appConfig.getDivision());
		b.setShop(appConfig.getShop());
		b.setCounter(appConfig.getCounter());

		Business business = businessService.find(b);
		if(business == null) throw  new UsernameNotFoundException("Business is not correct");
		if(business.getStatus() == 0) throw  new UsernameNotFoundException("Business is inactive");

//		User user = new User();
//		user.setBusinessId("100000");
//		user.setUsername("admin");
//		user.setPassword(passwordEncoder.encode("1234"));
//		user.setDivision("01");
//		user.setShop("01");
//		user.setCounter("01");
//		user.setStatus(1);
//		user.setAdmin(true);
//		
//		Business business  = new Business();
//		business.setBusinessId("100000");
//		business.setDivision("01");
//		business.setShop("01");
//		business.setCounter("01");
//		business.setStatus(1);
//		business.setName("KIT");

		return new KITUserDetails(user, business);
	}

}
