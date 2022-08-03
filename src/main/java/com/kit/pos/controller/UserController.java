package com.kit.pos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kit.pos.dto.request.UserAccountRequestDTO;
import com.kit.pos.dto.response.UserAccountResponseDTO;
import com.kit.pos.util.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Zubayer Ahamed
 * @since Aug 2, 2022
 */
@RestController
@RequestMapping("/api/kitpos/user")
@Api(tags = {"User Account"}, description = "API")
public class UserController extends KITAbstractController {

	@PostMapping(produces = "application/json", consumes = "application/json")
	@ApiOperation(value = "Create User")
	public Response<UserAccountResponseDTO> save(@RequestBody UserAccountRequestDTO reqDto){
		
		
		return null;
	}

	@PutMapping(produces = "application/json", consumes = "application/json")
	@ApiOperation(value = "Update User Info")
	public Response<UserAccountResponseDTO> update(@RequestBody UserAccountRequestDTO reqDto){
		
		
		return null;
	}

	@GetMapping("/{username}")
	@ApiOperation(value = "Find User Info by Username")
	public Response<UserAccountResponseDTO> findByUsername(@PathVariable String username){
		
		
		return null;
	}

	@GetMapping
	@ApiOperation(value = "Get all users info")
	public Response<UserAccountResponseDTO> getAll(){
		
		
		return null;
	}
	
}
