package com.kit.pos.dto.request;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.BeanUtils;

import com.kit.pos.entity.Category;
import com.kit.pos.enums.CategoryType;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zubayer Ahamed
 * @since Aug 3, 2022
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CategoryRequestDTO extends BaseRequestDTO<Category> {
	@NotBlank
	private String name;
	private int seqn;
	private String parentCategory;
	private CategoryType type;
	private int status = 1;

	@Override
	public Category getBean() {
		Category c = new Category();
		BeanUtils.copyProperties(this, c);
		return c;
	}

	
}
