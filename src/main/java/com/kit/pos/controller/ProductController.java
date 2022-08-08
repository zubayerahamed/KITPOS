package com.kit.pos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kit.pos.dto.request.ProductRequestDTO;
import com.kit.pos.dto.response.ProductResponseDTO;
import com.kit.pos.entity.Product;
import com.kit.pos.service.ProductService;

import io.swagger.annotations.Api;

/**
 * @author Zubayer Ahamed
 * @since Aug 3, 2022
 */
@RestController
@RequestMapping("/api/kitpos/product")
@Api(tags = {"Product"}, description = "API", produces = "application/json", consumes = "application/json")
public class ProductController extends KITAbstractController<Product, ProductResponseDTO, ProductRequestDTO> {

	private ProductService<ProductResponseDTO, ProductRequestDTO> service;

	public ProductController(ProductService<ProductResponseDTO, ProductRequestDTO> service) {
		super(service);
		this.service = service;
	}


}
