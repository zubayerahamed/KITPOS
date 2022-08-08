package com.kit.pos.dto.response;

import org.springframework.beans.BeanUtils;

import com.kit.pos.entity.Business;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Zubayer Ahamed
 * @since Aug 1, 2022
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class BusinessResponseDTO extends BaseResponseDTO<Business> {

	BusinessResponseDTO(Business business){
		BeanUtils.copyProperties(business, this);
	}

	private String businessId;
	private String division;
	private String shop;
	private String counter;
	private String name;
	private int status;
}
