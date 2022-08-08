package com.kit.pos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kit.pos.dto.request.BusinessRequestDTO;
import com.kit.pos.dto.response.BusinessResponseDTO;
import com.kit.pos.entity.Business;
import com.kit.pos.service.BusinessService;
import com.kit.pos.util.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author Zubayer Ahamed
 * @since Jul 24, 2022
 */
@RestController
@RequestMapping("/api/kitpos/business")
@Api(tags = {"Business"}, description = "API", produces = "application/json", consumes = "application/json")
public class BusinessController extends KITAbstractController<Business, BusinessResponseDTO, BusinessRequestDTO> {

	private BusinessService<BusinessResponseDTO, BusinessRequestDTO> businessService;

	public BusinessController(BusinessService<BusinessResponseDTO, BusinessRequestDTO> businessService) {
		super(businessService);
		this.businessService = businessService;
	}

	@ApiOperation(value = "Get Current Business Info")
	@GetMapping("/currentbusiness")
	public Response<BusinessResponseDTO> findCurrentBusiness() {
		return businessService.find();
	}

	@ApiIgnore
	@Override
	public Response<BusinessResponseDTO> find(String id) {
		return null;
	}

	@ApiIgnore
	@Override
	public Response<BusinessResponseDTO> getAll() {
		return null;
	}

	@ApiIgnore
	@Override
	public Response<BusinessResponseDTO> update(BusinessRequestDTO e) {
		return null;
	}

}
