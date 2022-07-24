package com.kit.pos.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kit.pos.config.AppConfig;
import com.kit.pos.dto.BusinessDTO;
import com.kit.pos.entity.Business;
import com.kit.pos.entity.pk.BusinessPK;
import com.kit.pos.model.ResponseHelper;
import com.kit.pos.service.BusinessService;

/**
 * @author Zubayer Ahamed
 * @since Jul 24, 2022
 */
@RestController
@RequestMapping("/api/kitpos")
public class BusinessSetupController {

	@Autowired private BusinessService businessService;
	@Autowired private AppConfig appConfig;
	@Autowired private ResponseHelper response;

	@GetMapping("/business")
	public Map<String, Object> getCurrentBusinessInfo() {
		BusinessDTO dto = new BusinessDTO();

		Business b = businessService.find(new BusinessPK(appConfig.getBusinessId(), appConfig.getDivision(), appConfig.getShop(), appConfig.getCounter()));
		
		if(b == null) {
			response.setErrorStatusAndMessage("Business not saved!");
			BeanUtils.copyProperties(new Business(), dto);
			response.addDataToResponse("business", dto);
			return response.getResponse();
		}
		response.setSuccessStatusAndMessage("Business found");
		BeanUtils.copyProperties(b, dto);
		response.addDataToResponse("business", dto);
		return response.getResponse();
	}
}
