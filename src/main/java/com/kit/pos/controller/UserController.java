package com.kit.pos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kit.pos.dto.request.UserAccountRequestDTO;
import com.kit.pos.dto.response.UserAccountResponseDTO;
import com.kit.pos.entity.UserAccount;
import com.kit.pos.service.UserService;

import io.swagger.annotations.Api;

/**
 * @author Zubayer Ahamed
 * @since Aug 2, 2022
 */
@RestController
@RequestMapping("/api/kitpos/user")
@Api(tags = {"User Account"}, description = "API", produces = "application/json", consumes = "application/json")
public class UserController extends KITAbstractController<UserAccount, UserAccountResponseDTO, UserAccountRequestDTO> {

	@Autowired private UserService<UserAccountResponseDTO, UserAccountRequestDTO> userService;

	public UserController(UserService<UserAccountResponseDTO, UserAccountRequestDTO> userService){
		super(userService);
		this.userService = userService;
	}

	
}
