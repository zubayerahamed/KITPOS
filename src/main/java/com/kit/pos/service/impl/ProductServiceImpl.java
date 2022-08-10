package com.kit.pos.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kit.pos.dto.request.ProductRequestDTO;
import com.kit.pos.dto.response.ProductResponseDTO;
import com.kit.pos.entity.Category;
import com.kit.pos.entity.Product;
import com.kit.pos.entity.pk.CategoryPK;
import com.kit.pos.entity.pk.ProductPK;
import com.kit.pos.repository.CategoryRepository;
import com.kit.pos.repository.ProductRepository;
import com.kit.pos.service.ProductService;
import com.kit.pos.util.Response;

/**
 * @author Zubayer Ahamed
 * @since Aug 8, 2022
 */
@Service
public class ProductServiceImpl extends AbstractBaseService<ProductResponseDTO, ProductRequestDTO> implements ProductService<ProductResponseDTO, ProductRequestDTO>{

	@Autowired private ProductRepository productRepository;
	@Autowired private CategoryRepository categoryRepo;

	@Override
	public Response<ProductResponseDTO> find(String id) {
		if(StringUtils.isBlank(id)) return getErrorResponse("Id required");

		Optional<Product> product = productRepository.findById(new ProductPK(appConfig.getBusinessId(), id));
		if(!product.isPresent()) return getErrorResponse("Product not found");

		return getSuccessResponse(null, "Product found", new ProductResponseDTO(product.get()));
	}

	@Override
	public Response<ProductResponseDTO> save(ProductRequestDTO reqDto) {
		if(reqDto == null) return getErrorResponse("Data required to do save");
		
		// validation

		// checck category exist??
		if(StringUtils.isBlank(reqDto.getCategoryId())) return getErrorResponse("Category required");
		Optional<Category> category = categoryRepo.findById(new CategoryPK(appConfig.getBusinessId(), reqDto.getCategoryId()));
		if(!category.isPresent()) return getErrorResponse("Invalid category selected");

		if(reqDto.getProductGroup() == null) return getErrorResponse("Product group required");

		if(reqDto.getRate() == null) return getErrorResponse("Rate required");
		if(reqDto.getRate().compareTo((BigDecimal.ZERO)) == -1) return getErrorResponse("Invalid rate");
		if(StringUtils.isBlank(reqDto.getSellUom())) return getErrorResponse("Selling unit of meserment required");
		if(appConfig.isActiveInventory() && StringUtils.isBlank(reqDto.getStockUom())) return getErrorResponse("Stock unit of meserment required"); 
		
		
		
		// create id
		reqDto.setProductId(idGenerator.getNewProductId());
		reqDto.setBusinessId(appConfig.getBusinessId());
		
		
		Product p = productRepository.save(reqDto.getBean());
		if(p == null) return getErrorResponse("Can't save product");

		return getSuccessResponse(null, "Product saved successfully", new ProductResponseDTO(p));
	}

	@Override
	public Response<ProductResponseDTO> update(ProductRequestDTO reqDto) {
		if(reqDto == null) return getErrorResponse("Data required to do update");

		// validation
		if(StringUtils.isBlank(reqDto.getProductId())) return getErrorResponse("Id required");

		// check existing
		Optional<Product> exProduct = productRepository.findById(new ProductPK(appConfig.getBusinessId(), reqDto.getProductId()));
		if(!exProduct.isPresent()) return getErrorResponse("Product not found");

		Product p = exProduct.get();
		BeanUtils.copyProperties(reqDto, p);

		p = productRepository.save(p);
		if(p == null) return getErrorResponse("Can't update product");

		return getSuccessResponse(null, "Product updated successfully", new ProductResponseDTO(p));
	}

	@Override
	public Response<ProductResponseDTO> getAll() {
		List<Product> list = productRepository.findAll();
		if(list == null || list.isEmpty()) return getErrorResponse("No Product found");

		List<ProductResponseDTO> response = list.stream().map(data -> new ModelMapper().map(data, ProductResponseDTO.class)).collect(Collectors.toList());
		return getSuccessResponse(null, "Found products", response);
	}


}
