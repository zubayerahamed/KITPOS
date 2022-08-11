package com.kit.pos.dto.request;

import javax.validation.constraints.NotBlank;

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
public class DataListRequestDTO extends BaseRequestDTO<DataList>{

	@NotBlank
	private String code;
	@NotBlank
	private String actualValue;
	private String valueDesc;
	private String lsvl1;
	private String lsvl2;
	private String lsvl3;
	private String lsvl4;
	private String lsvl5;
	private String lsvl6;

	@Override
	public DataList getBean() {
		DataList d = new DataList();
		BeanUtils.copyProperties(this, d);
		return d;
	}

}
