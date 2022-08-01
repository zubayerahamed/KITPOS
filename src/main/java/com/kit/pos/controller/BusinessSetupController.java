package com.kit.pos.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kit.pos.config.AppConfig;
import com.kit.pos.dto.BusinessRequestDTO;
import com.kit.pos.entity.Business;
import com.kit.pos.entity.pk.BusinessPK;
import com.kit.pos.model.ResponseHelper;
import com.kit.pos.service.BusinessService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Zubayer Ahamed
 * @since Jul 24, 2022
 */
@RestController
@RequestMapping("/api/kitpos")
@Api(value = "Business API", description = "Business Setup Operations")
public class BusinessSetupController {

	@Autowired private BusinessService businessService;
	@Autowired private AppConfig appConfig;
	@Autowired private ResponseHelper response;

	@ApiOperation(value = "Get Current Business Info")
//	@ApiResponses(value = {
//		@ApiResponse(code = 143, message = "143 is for Success"),
//		@ApiResponse(code = 420, message = "420 is for Exception")
//	})
	@GetMapping("/business")
	public Map<String, Object> getCurrentBusinessInfo() {
		BusinessRequestDTO dto = new BusinessRequestDTO();
		BeanUtils.copyProperties(new BusinessPK(appConfig.getBusinessId(), appConfig.getDivision(), appConfig.getShop(), appConfig.getCounter()), dto);

		return businessService.find(dto, response);
	}

	@PostMapping("/business/save")
	public Map<String, Object> saveBusiness(BusinessRequestDTO businessDTO){
		return businessService.save(businessDTO, response);
	}
}
