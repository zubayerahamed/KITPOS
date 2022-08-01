package com.kit.pos.service.impl;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kit.pos.dto.BusinessRequestDTO;
import com.kit.pos.dto.BusinessResponseDTO;
import com.kit.pos.entity.Business;
import com.kit.pos.entity.pk.BusinessPK;
import com.kit.pos.model.ResponseHelper;
import com.kit.pos.repository.BusinessRepository;
import com.kit.pos.service.BusinessService;

/**
 * @author Zubayer Ahamed
 * @since Jul 24, 2022
 */
@Service
public class BusinessServiceImpl implements BusinessService {

	@Autowired private BusinessRepository businessRepository;

	@Override
	public Map<String, Object> find(BusinessRequestDTO reqDto, ResponseHelper helper) {
		BusinessPK pk = new BusinessPK();
		BeanUtils.copyProperties(reqDto, pk);
		
		Optional<Business> optional = businessRepository.findById(pk);
		Business business = optional.isPresent() ? optional.get() : null;

		if(business == null) {
			helper.setErrorStatusAndMessage("Business not found");
			return helper.getResponse();
		}

		BusinessResponseDTO responseDto = new BusinessResponseDTO();
		BeanUtils.copyProperties(business, responseDto);
		helper.addDataToResponse("data", responseDto);
		helper.setSuccessStatusAndMessage("Business found");
		return helper.getResponse();
	}

	@Override
	public Map<String, Object> save(BusinessRequestDTO BusinessDTO, ResponseHelper helper) {
		if(BusinessDTO == null) {
			helper.setErrorStatusAndMessage("Business is null");
			return helper.getResponse();
		}

		// validation

		Business business  = new Business();
		BeanUtils.copyProperties(BusinessDTO, business);

		business = businessRepository.save(business);
		if(business == null) {
			helper.setErrorStatusAndMessage("Business not saved");
			return helper.getResponse();
		}

		BusinessResponseDTO responseDTO = new BusinessResponseDTO();
		BeanUtils.copyProperties(business, responseDTO);
		helper.addDataToResponse("data", responseDTO);
		helper.setSuccessStatusAndMessage("Business saved successfully");
		return helper.getResponse();
	}

	
}
