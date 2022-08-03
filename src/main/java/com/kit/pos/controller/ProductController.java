package com.kit.pos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kit.pos.dto.request.ProductRequestDTO;
import com.kit.pos.dto.response.ProductResponseDTO;
import com.kit.pos.util.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Zubayer Ahamed
 * @since Aug 3, 2022
 */
@RestController
@RequestMapping("/api/kitpos/product")
@Api(tags = {"Product"}, description = "API")
public class ProductController extends KITAbstractController {

	@PostMapping
	@ApiOperation(value = "Create Product")
	public Response<ProductResponseDTO> save(ProductRequestDTO reqDto){
		
		
		return null;
	}

	@PutMapping
	@ApiOperation(value = "Update Product")
	public Response<ProductResponseDTO> update(ProductRequestDTO reqDto){
		
		
		return null;
	}

	@GetMapping
	@ApiOperation(value = "Get All Products")
	public Response<ProductResponseDTO> getAll(){
		
		
		return null;
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Get All Products")
	public Response<ProductResponseDTO> findById(@PathVariable String id){
		
		
		return null;
	}

	@GetMapping("/bycategory/{name}")
	@ApiOperation(value = "Get All Products by Category name")
	public Response<ProductResponseDTO> getAllByCategoryName(@PathVariable String name){
		
		
		return null;
	}

}
