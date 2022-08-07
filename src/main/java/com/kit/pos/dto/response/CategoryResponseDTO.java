package com.kit.pos.dto.response;

import java.util.ArrayList;
import java.util.List;

import com.kit.pos.enums.CategoryType;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zubayer Ahamed
 * @since Aug 3, 2022
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CategoryResponseDTO extends BaseResponseDTO {
	private String name;
	private int seqn;
	private String parentCategory;
	private CategoryType type;
	private int status = 1;
	private List<CategoryResponseDTO> childs = new ArrayList<>();
	private List<String> childCategoriesName = new ArrayList<String>();
}
