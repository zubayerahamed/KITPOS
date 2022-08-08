package com.kit.pos.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kit.pos.config.AppConfig;
import com.kit.pos.dto.request.BusinessRequestDTO;
import com.kit.pos.dto.response.BusinessResponseDTO;
import com.kit.pos.entity.Business;
import com.kit.pos.entity.pk.BusinessPK;
import com.kit.pos.repository.BusinessRepository;
import com.kit.pos.service.BusinessService;
import com.kit.pos.util.Response;

/**
 * @author Zubayer Ahamed
 * @since Jul 24, 2022
 */
@Service
public class BusinessServiceImpl extends AbstractBaseService<BusinessResponseDTO, BusinessRequestDTO> implements BusinessService<BusinessResponseDTO, BusinessRequestDTO> {

	@Autowired private BusinessRepository businessRepository;
	@Autowired private AppConfig appConfig;

	@Override
	public Response<BusinessResponseDTO> find() {
		Optional<Business> optional = businessRepository.findById(new BusinessPK(appConfig.getBusinessId(), appConfig.getDivision(), appConfig.getShop(), appConfig.getCounter()));
		Business business = optional.isPresent() ? optional.get() : null;

		if(business == null) return getErrorResponse(null, "Business not found!");

		BusinessResponseDTO responseDto = new BusinessResponseDTO();
		BeanUtils.copyProperties(business, responseDto);
		
		Response<BusinessResponseDTO> response = new Response<BusinessResponseDTO>();
		response.setObj(responseDto);
		return getSuccessResponse(null, "Business found", response);
	}

	@Override
	public Response<BusinessResponseDTO> save(BusinessRequestDTO BusinessDTO) {
		if(BusinessDTO == null) return getErrorResponse(null, "Business is null");

		// validation

		Business business  = new Business();
		BeanUtils.copyProperties(BusinessDTO, business);

		business = businessRepository.save(business);
		if(business == null) return getErrorResponse(null, "Business not saved");

		BusinessResponseDTO responseDTO = new BusinessResponseDTO();
		BeanUtils.copyProperties(business, responseDTO);

		Response<BusinessResponseDTO> response = new Response<BusinessResponseDTO>();
		response.setObj(responseDTO);
		return getSuccessResponse(null, "Business saved successfully", response);
	}

	@Override
	public Response<BusinessResponseDTO> find(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response<BusinessResponseDTO> update(BusinessRequestDTO e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response<BusinessResponseDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
