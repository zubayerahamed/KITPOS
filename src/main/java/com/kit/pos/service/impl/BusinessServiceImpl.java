package com.kit.pos.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kit.pos.entity.Business;
import com.kit.pos.entity.pk.BusinessPK;
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
	public Business find(BusinessPK businessPk) {
		Optional<Business> optional = businessRepository.findById(businessPk);
		return optional.isPresent() ? optional.get() : null;
	}

	
}
