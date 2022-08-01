package com.kit.pos.service;

import java.util.Map;

import com.kit.pos.dto.BusinessRequestDTO;
import com.kit.pos.model.ResponseHelper;

/**
 * @author Zubayer Ahamed
 * @since Jul 24, 2022
 */
public interface BusinessService {

	public Map<String, Object> find(BusinessRequestDTO businessDTO, ResponseHelper helper);

	public Map<String, Object> save(BusinessRequestDTO businessDTO, ResponseHelper helper);
}
