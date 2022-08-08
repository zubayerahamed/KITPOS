package com.kit.pos.dto.response;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.kit.pos.entity.Category;
import com.kit.pos.enums.CategoryType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Zubayer Ahamed
 * @since Aug 3, 2022
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CategoryResponseDTO extends BaseResponseDTO<Category> {

	CategoryResponseDTO(Category category){
		BeanUtils.copyProperties(category, this);
	}

	private String name;
	private int seqn;
	private String parentCategory;
	private CategoryType type;
	private int status = 1;
	private List<CategoryResponseDTO> childs = new ArrayList<>();
	private List<String> childCategoriesName = new ArrayList<String>();
}
