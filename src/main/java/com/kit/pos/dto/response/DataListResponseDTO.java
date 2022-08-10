package com.kit.pos.dto.response;

import org.springframework.beans.BeanUtils;

import com.kit.pos.entity.DataList;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zubayer Ahamed
 * @since Aug 10, 2022
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DataListResponseDTO extends BaseResponseDTO<DataList>{

	public DataListResponseDTO(DataList d){
		BeanUtils.copyProperties(d, this);
	}

	private String code;
	private String actualValue;
	private String valueDesc;
	private String lsvl1;
	private String lsvl2;
	private String lsvl3;
	private String lsvl4;
	private String lsvl5;
	private String lsvl6;
}
