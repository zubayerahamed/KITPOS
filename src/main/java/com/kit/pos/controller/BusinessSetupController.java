package com.kit.pos.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kit.pos.dto.BusinessRequestDTO;
import com.kit.pos.service.BusinessService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Zubayer Ahamed
 * @since Jul 24, 2022
 */
@RestController
@RequestMapping("/api/kitpos")
@Api(value = "Business API")
public class BusinessSetupController extends KITAbstractController {

	@Autowired private BusinessService businessService;

	@ApiOperation(value = "Get Current Business Info")
	@GetMapping("/business")
	public Map<String, Object> getCurrentBusinessInfo() {
		return businessService.find(response);
	}

	@PostMapping("/business/save")
	@ApiOperation(value = "Create Business")
	public Map<String, Object> saveBusiness(BusinessRequestDTO businessDTO){
		return businessService.save(businessDTO, response);
	}
}
