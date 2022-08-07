package com.kit.pos.service;

import com.kit.pos.dto.request.CategoryRequestDTO;
import com.kit.pos.dto.response.CategoryResponseDTO;
import com.kit.pos.util.Response;

/**
 * @author Zubayer Ahamed
 * @since Aug 4, 2022
 */
public interface CategoryService {

	public Response<CategoryResponseDTO> findByCategoryName(String name);

	public Response<CategoryResponseDTO> save(CategoryRequestDTO reqDto);

	public Response<CategoryResponseDTO> update(CategoryRequestDTO reqDto);

	public Response<CategoryResponseDTO> getAllCategories();

	public Response<CategoryResponseDTO> getAllParentCategories(String currentCategoryName);

	public Response<CategoryResponseDTO> getAllChildCategories(String currentCategoryName);
}
