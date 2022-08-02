package com.kit.pos.service.impl;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kit.pos.constant.BaseConstant;
import com.kit.pos.dto.response.BusinessResponseDTO;
import com.kit.pos.dto.response.UserAccountResponseDTO;
import com.kit.pos.entity.UserAccount;
import com.kit.pos.entity.pk.UserPK;
import com.kit.pos.model.KITUserDetails;
import com.kit.pos.repository.UserRepository;
import com.kit.pos.service.BaseService;
import com.kit.pos.service.BusinessService;
import com.kit.pos.service.UserService;
import com.kit.pos.util.Response;

/**
 * @author Zubayer Ahamed
 * @since Jul 24, 2022
 */
@Service
public class UserServiceImpl extends BaseService<UserAccountResponseDTO> implements UserService, UserDetailsService {

	@Autowired private BusinessService businessService;
	@Autowired UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if(StringUtils.isBlank(username)) {
			throw  new UsernameNotFoundException("User not found in the system");
		}

		UserAccountResponseDTO user = null;
		if(BaseConstant.SYSTEM_ADMIN_USERNAME.equalsIgnoreCase(username)) {
			user = getSystemAdminUser();
		} else {
			user = findByUsername(username).getObj();
		}
		if(user == null) throw  new UsernameNotFoundException("User not found in the system");
		if(user.getStatus() == 0) throw  new UsernameNotFoundException("User is inactive");


		BusinessResponseDTO businessResponseDTO = businessService.find().getObj();
		if(businessResponseDTO == null) throw  new UsernameNotFoundException("Business is not correct");
		if(businessResponseDTO.getStatus() == 0) throw  new UsernameNotFoundException("Business is inactive");

		return new KITUserDetails(user, businessResponseDTO);
	}


	@Override
	public Response<UserAccountResponseDTO> findByUsername(String username) {
		Optional<UserAccount> optional = userRepository.findById(new UserPK(appConfig.getBusinessId(), username, appConfig.getDivision(), appConfig.getShop(), appConfig.getCounter()));
		UserAccount user = optional.isPresent() ? optional.get() : null;
		if(user == null) getErrorResponse(null, "User not found!");

		Response<UserAccountResponseDTO> response = getSuccessResponse(null, "User found");
		UserAccountResponseDTO responseDto = new UserAccountResponseDTO();
		BeanUtils.copyProperties(user, responseDto);
		response.setObj(responseDto);
		return response;
	}

}
