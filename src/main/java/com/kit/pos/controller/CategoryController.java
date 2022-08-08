package com.kit.pos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kit.pos.dto.request.CategoryRequestDTO;
import com.kit.pos.dto.response.CategoryResponseDTO;
import com.kit.pos.entity.Category;
import com.kit.pos.service.CategoryService;
import com.kit.pos.util.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Zubayer Ahamed
 * @since Aug 3, 2022
 */
@RestController
@RequestMapping("/api/kitpos/category")
@Api(tags = {"Category"}, description = "API", produces = "application/json", consumes = "application/json")
public class CategoryController extends KITAbstractController<Category, CategoryResponseDTO, CategoryRequestDTO> {

	private CategoryService<CategoryResponseDTO, CategoryRequestDTO> categoryService;

	public CategoryController(CategoryService<CategoryResponseDTO, CategoryRequestDTO> categoryService) {
		super(categoryService);
		this.categoryService = categoryService;
	}

	@GetMapping("/parentselection/{name}")
	@ApiOperation(value = "Get Categories List for Parent Selection")
	public Response<CategoryResponseDTO> getCategoriesListForParentSelection(@PathVariable String name){
		return categoryService.getAllParentCategories(name);
	}

	@GetMapping("/childs/{name}")
	@ApiOperation(value = "Get all child Categories")
	public Response<CategoryResponseDTO> getAllChildCategories(@PathVariable String name){
		return categoryService.getAllChildCategories(name);
	}

}
