package com.kit.pos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kit.pos.dto.request.InvoiceRequestDTO;
import com.kit.pos.dto.response.InvoiceResponseDTO;
import com.kit.pos.util.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Zubayer Ahamed
 * @since Aug 3, 2022
 */
@RestController
@RequestMapping("/api/kitpos/invoice")
@Api(tags = {"Invoice"}, description = "API")
public class InvoiceController extends KITAbstractController {

	@PostMapping(produces = "application/json", consumes = "application/json")
	@ApiOperation(value = "Create Invoice")
	public Response<InvoiceResponseDTO> save(@RequestBody InvoiceRequestDTO reqDto){
		
		
		return null;
	}

	@PutMapping(produces = "application/json", consumes = "application/json")
	@ApiOperation(value = "Update Invoice")
	public Response<InvoiceResponseDTO> update(@RequestBody InvoiceRequestDTO reqDto){
		
		
		return null;
	}

	@GetMapping
	@ApiOperation(value = "Gell All Invoice")
	public Response<InvoiceResponseDTO> getAllInvoice(){
		
		
		return null;
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Find Invoice by Id")
	public Response<InvoiceResponseDTO> findInvoiceById(@PathVariable String id){
		
		
		return null;
	}

	
}
