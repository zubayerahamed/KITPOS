package com.kit.pos.service;

import com.kit.pos.dto.BusinessRequestDTO;
import com.kit.pos.dto.BusinessResponseDTO;
import com.kit.pos.util.Response;

/**
 * @author Zubayer Ahamed
 * @since Jul 24, 2022
 */
public interface BusinessService {

	public Response<BusinessResponseDTO> find();

	public Response<BusinessResponseDTO> save(BusinessRequestDTO businessRequestDTO);
}
