package com.kit.pos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kit.pos.dto.BusinessRequestDTO;
import com.kit.pos.dto.BusinessResponseDTO;
import com.kit.pos.service.BusinessService;
import com.kit.pos.util.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Zubayer Ahamed
 * @since Jul 24, 2022
 */
@RestController
@RequestMapping("/api/kitpos")
@Api(tags = {"Business"}, description = "API")
public class BusinessController extends KITAbstractController {

	@Autowired private BusinessService businessService;

	@ApiOperation(value = "Get Current Business Info")
	@GetMapping("/business")
	public Response<BusinessResponseDTO> getCurrentBusinessInfo() {
		return businessService.find();
	}

	@PostMapping("/business/save")
	@ApiOperation(value = "Create Business")
	public Response<BusinessResponseDTO> saveBusiness(BusinessRequestDTO reqDto){
		return businessService.save(reqDto);
	}
}
