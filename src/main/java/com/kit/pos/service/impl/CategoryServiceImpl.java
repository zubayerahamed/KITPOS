package com.kit.pos.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kit.pos.dto.request.CategoryRequestDTO;
import com.kit.pos.dto.response.CategoryResponseDTO;
import com.kit.pos.entity.Category;
import com.kit.pos.entity.pk.CategoryPK;
import com.kit.pos.enums.CategoryType;
import com.kit.pos.repository.CategoryRepository;
import com.kit.pos.service.AbstractBaseService;
import com.kit.pos.service.CategoryService;
import com.kit.pos.util.Response;

/**
 * @author Zubayer Ahamed
 * @since Aug 7, 2022
 */
@Service
public class CategoryServiceImpl extends AbstractBaseService<CategoryResponseDTO, CategoryRequestDTO> implements CategoryService<CategoryResponseDTO, CategoryRequestDTO>{

	@Autowired private CategoryRepository repository;

	@Override
	public Response<CategoryResponseDTO> find(String name) {
		if(StringUtils.isBlank(name)) return getErrorResponse(null, "Category name required");

		Optional<Category> category = repository.findById(new CategoryPK(appConfig.getBusinessId(), name));
		if(!category.isPresent()) return getErrorResponse(null, "Category not found");

		CategoryResponseDTO resDto = new CategoryResponseDTO();
		BeanUtils.copyProperties(category.get(), resDto);
		resDto = getAllChildCategoriesList(resDto);

		return getSuccessResponse(null, "Category found", resDto);
	}

	@Transactional
	@Override
	public Response<CategoryResponseDTO> save(CategoryRequestDTO reqDto) {
		if(reqDto == null) return getErrorResponse(null, "");

		// Validation
		if(StringUtils.isBlank(reqDto.getName())) return getErrorResponse(null, "Category name required");
		// check duplicate
		Optional<Category> excategory = repository.findById(new CategoryPK(appConfig.getBusinessId(), reqDto.getName()));
		if(excategory.isPresent()) return getErrorResponse(null, "Category already exist");

		if(StringUtils.isBlank(reqDto.getParentCategory())) {
			reqDto.setType(CategoryType.CATEGORY);
		} else {
			// check valid parent category
			List<Category> parents = getAllParentCategoriesList(reqDto.getName());
			if(parents.stream().filter(f -> f.getName().equalsIgnoreCase(reqDto.getParentCategory())).collect(Collectors.toList()).isEmpty()) return getErrorResponse("Invalid parent category");
			reqDto.setType(CategoryType.SUB_CATEGORY);
		}

		Category category = new Category();
		BeanUtils.copyProperties(reqDto, category);
		category.setBusinessId(appConfig.getBusinessId());

		category  = repository.save(category);
		if(category == null) return getErrorResponse(null, "Can't save category");

		CategoryResponseDTO responseDto = new CategoryResponseDTO();
		BeanUtils.copyProperties(category, responseDto);
		responseDto = getAllChildCategoriesList(responseDto);
		return getSuccessResponse(null, "Category saved successfully", responseDto);
	}

	@Transactional
	@Override
	public Response<CategoryResponseDTO> update(CategoryRequestDTO reqDto) {
		if(reqDto == null) return getErrorResponse(null, "");

		// Validation
		if(StringUtils.isBlank(reqDto.getName())) return getErrorResponse(null, "Category name required");
		// check exist or not for update
		Optional<Category> excategory = repository.findById(new CategoryPK(appConfig.getBusinessId(), reqDto.getName()));
		if(!excategory.isPresent()) return getErrorResponse(null, "Category not exist");

		if(StringUtils.isBlank(reqDto.getParentCategory())) {
			reqDto.setType(CategoryType.CATEGORY);
		} else {
			// check valid parent category
			List<Category> parents = getAllParentCategoriesList(reqDto.getName());
			if(parents.stream().filter(f -> f.getName().equalsIgnoreCase(reqDto.getParentCategory())).collect(Collectors.toList()).isEmpty()) return getErrorResponse("Invalid parent category");
			reqDto.setType(CategoryType.SUB_CATEGORY);
		}

		Category category = excategory.get();
		BeanUtils.copyProperties(reqDto, category);
		category  = repository.save(category);
		if(category == null) return getErrorResponse(null, "Can't update category");

		CategoryResponseDTO responseDto = new CategoryResponseDTO();
		BeanUtils.copyProperties(category, responseDto);
		responseDto = getAllChildCategoriesList(responseDto);
		return getSuccessResponse(null, "Category updated successfully", responseDto);
	}

	@Override
	public Response<CategoryResponseDTO> getAll() {
		List<Category> categories = repository.findAll();
		if(categories == null || categories.isEmpty()) return getErrorResponse("No Categories found");

		List<CategoryResponseDTO> list  = categories.stream().map(data -> new ModelMapper().map(data, CategoryResponseDTO.class)).collect(Collectors.toList());
		list.stream().forEach(l -> {
			l = getAllChildCategoriesList(l);
		});
		return getSuccessResponse(null, "Categories list found", list);
	}

	@Override
	public Response<CategoryResponseDTO> getAllParentCategories(String currentCategoryName) {
		List<Category> categories = getAllParentCategoriesList(currentCategoryName);
		if(categories == null || categories.isEmpty()) return getErrorResponse("No Parent Categories found");

		List<CategoryResponseDTO> list  = categories.stream().map(data -> new ModelMapper().map(data, CategoryResponseDTO.class)).collect(Collectors.toList());
		return getSuccessResponse(null, "Parent Categories list found", list);
	}

	@Override
	public Response<CategoryResponseDTO> getAllChildCategories(String currentCategoryName) {

		if(StringUtils.isBlank(currentCategoryName)) return getErrorResponse("Current category name required");
		Optional<Category> excategory = repository.findById(new CategoryPK(appConfig.getBusinessId(), currentCategoryName));
		if(!excategory.isPresent()) return getErrorResponse(null, "Category doesn't exist");

		CategoryResponseDTO parentCategory = new CategoryResponseDTO();
		BeanUtils.copyProperties(excategory.get(), parentCategory);
		parentCategory = getAllChildCategoriesList(parentCategory);

		return getSuccessResponse(null, "Child categories list", parentCategory);
	}

	private CategoryResponseDTO getAllChildCategoriesList(CategoryResponseDTO parent) {
		if(parent == null) return parent;

		List<Category> childCategories = repository.findByParentCategoryAndBusinessId(parent.getName(), appConfig.getBusinessId());
		if(childCategories == null || childCategories.isEmpty()) return parent;

		for(Category child : childCategories) {
			CategoryResponseDTO childDto = new CategoryResponseDTO();
			BeanUtils.copyProperties(child, childDto);
			parent.getChilds().add(childDto);
			parent.getChildCategoriesName().add(childDto.getName());

			// recursive here
			getAllChildCategoriesList(childDto);

			parent.getChildCategoriesName().addAll(childDto.getChildCategoriesName());
		}

		return parent;
	}

	private List<Category> getAllParentCategoriesList(String currentCategoryName) {
		List<Category> categories = repository.findAll();
		if(categories == null || categories.isEmpty()) return Collections.emptyList();

		if(StringUtils.isBlank(currentCategoryName)) return categories;

		return categories.stream().filter(d -> !d.getName().equalsIgnoreCase(currentCategoryName)).collect(Collectors.toList());
	}
}
