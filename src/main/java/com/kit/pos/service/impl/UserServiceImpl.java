package com.kit.pos.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kit.pos.constant.BaseConstant;
import com.kit.pos.dto.request.BusinessRequestDTO;
import com.kit.pos.dto.request.UserAccountRequestDTO;
import com.kit.pos.dto.response.BusinessResponseDTO;
import com.kit.pos.dto.response.UserAccountResponseDTO;
import com.kit.pos.entity.UserAccount;
import com.kit.pos.entity.pk.UserAccountPK;
import com.kit.pos.enums.UserType;
import com.kit.pos.model.KITUserDetails;
import com.kit.pos.repository.UserAccountRepository;
import com.kit.pos.service.AbstractBaseService;
import com.kit.pos.service.BusinessService;
import com.kit.pos.service.UserService;
import com.kit.pos.util.Response;

/**
 * @author Zubayer Ahamed
 * @since Jul 24, 2022
 */
@Service
public class UserServiceImpl extends AbstractBaseService<UserAccountResponseDTO, UserAccountRequestDTO> implements UserService<UserAccountResponseDTO, UserAccountRequestDTO>, UserDetailsService {

	@Autowired private BusinessService<BusinessResponseDTO, BusinessRequestDTO> businessService;
	@Autowired UserAccountRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if(StringUtils.isBlank(username)) {
			throw  new UsernameNotFoundException("User not found in the system");
		}

		UserAccountResponseDTO user = null;
		if(BaseConstant.SYSTEM_ADMIN_USERNAME.equalsIgnoreCase(username)) {
			user = getSystemAdminUser();
		} else {
			user = find(username).getObj();
		}
		if(user == null) throw  new UsernameNotFoundException("User not found in the system");
		if(user.getStatus() == 0) throw  new UsernameNotFoundException("User is inactive");

		BusinessResponseDTO businessResponseDTO = businessService.find().getObj();
		if(businessResponseDTO == null) throw  new UsernameNotFoundException("Business is not correct");
		if(businessResponseDTO.getStatus() == 0) throw  new UsernameNotFoundException("Business is inactive");

		return new KITUserDetails(user, businessResponseDTO);
	}


	@Override
	public Response<UserAccountResponseDTO> find(String username) {
		if(StringUtils.isBlank(username)) return getErrorResponse(null, "Username required to find a user");

		Optional<UserAccount> optional = userRepository.findById(new UserAccountPK(appConfig.getBusinessId(), username, appConfig.getDivision(), appConfig.getShop()));
		UserAccount user = optional.isPresent() ? optional.get() : null;
		if(user == null) return getErrorResponse(null, "User not found!");

		Response<UserAccountResponseDTO> response = getSuccessResponse(null, "User found");
		UserAccountResponseDTO responseDto = new UserAccountResponseDTO();
		BeanUtils.copyProperties(user, responseDto);
		response.setObj(responseDto);
		return response;
	}


	@Transactional
	@Override
	public Response<UserAccountResponseDTO> save(UserAccountRequestDTO reqDto) {
		if(reqDto == null) return getErrorResponse(null, "Please insert corret data to create user");

		UserAccount ua = new UserAccount();
		BeanUtils.copyProperties(reqDto, ua);

		// Validation
		if(StringUtils.isBlank(reqDto.getUsername())) return getErrorResponse(null, "Username required");
		if(StringUtils.isBlank(reqDto.getPassword())) return getErrorResponse(null, "Password required");
		if(!reqDto.isAdmin() && !reqDto.isWaiter() && !reqDto.isCashier()) return getErrorResponse(null, "You have to select atleast one role");

		// checck username already exist?? 
		Optional<UserAccount> exist = userRepository.findById(new UserAccountPK(appConfig.getBusinessId(), reqDto.getUsername(), appConfig.getDivision(), appConfig.getShop()));
		if(exist.isPresent()) return getErrorResponse(null, "Username already exist! Try with different one.");

		ua.setBusinessId(appConfig.getBusinessId());
		ua.setDivision(appConfig.getDivision());
		ua.setShop(appConfig.getShop());
		ua.setUserType(UserType.POS);
		ua.setSystemadmin(false);
		ua.setPassword(passwordEncoder.encode(ua.getPassword()));

		ua = userRepository.save(ua);
		if(ua == null) return getErrorResponse(null, "Can't create user");

		UserAccountResponseDTO resDto = new UserAccountResponseDTO();
		BeanUtils.copyProperties(ua, resDto);
		resDto.setPassword("");

		Response<UserAccountResponseDTO> response = getSuccessResponse(null, "User created successfully");
		response.setObj(resDto);
		return response;
	}


	@Transactional
	@Override
	public Response<UserAccountResponseDTO> update(UserAccountRequestDTO reqDto) {
		if(reqDto == null) return getErrorResponse(null, "Please insert corret data to update user");

		// Validation
		if(StringUtils.isBlank(reqDto.getUsername())) return getErrorResponse(null, "Username required");
		if(!reqDto.isAdmin() && !reqDto.isWaiter() && !reqDto.isCashier()) return getErrorResponse(null, "You have to select atleast one role");

		Optional<UserAccount> exist = userRepository.findById(new UserAccountPK(appConfig.getBusinessId(), reqDto.getUsername(), appConfig.getDivision(), appConfig.getShop()));
		if(!exist.isPresent()) return getErrorResponse(null, "User not found in the system to do update");

		UserAccount ua = exist.get();
		if(StringUtils.isNotBlank(reqDto.getPassword())) ua.setPassword(passwordEncoder.encode(reqDto.getPassword()));
		ua.setAdmin(reqDto.isAdmin());
		ua.setWaiter(reqDto.isWaiter());
		ua.setCashier(reqDto.isCashier());
		ua.setStatus(reqDto.getStatus());

		ua = userRepository.save(ua);
		if(ua == null) return getErrorResponse(null, "Can't update user information");

		UserAccountResponseDTO resDto = new UserAccountResponseDTO();
		BeanUtils.copyProperties(ua, resDto);
		resDto.setPassword("");

		Response<UserAccountResponseDTO> response = getSuccessResponse(null, "User info updated successfully");
		response.setObj(resDto);
		return response;
	}


	@Override
	public Response<UserAccountResponseDTO> getAll() {
		List<UserAccount> users = userRepository.findAll();
		List<UserAccountResponseDTO> resDto = users.stream().map(data -> new ModelMapper().map(data, UserAccountResponseDTO.class)).collect(Collectors.toList());
		if(resDto == null || resDto.isEmpty()) return getErrorResponse(null, "No user data found in this system");
		Response<UserAccountResponseDTO> response = getSuccessResponse(null, "User data found");
		response.setItems(resDto);
		return response;
	}

}
