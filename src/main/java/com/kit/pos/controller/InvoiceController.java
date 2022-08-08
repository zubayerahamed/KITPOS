package com.kit.pos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kit.pos.dto.request.InvoiceRequestDTO;
import com.kit.pos.dto.request.UserAccountRequestDTO;
import com.kit.pos.dto.response.InvoiceResponseDTO;
import com.kit.pos.dto.response.UserAccountResponseDTO;
import com.kit.pos.entity.Invoice;
import com.kit.pos.service.UserService;
import com.kit.pos.util.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Zubayer Ahamed
 * @since Aug 3, 2022
 */
@RestController
@RequestMapping("/api/kitpos/invoice")
@Api(tags = {"Invoice"}, description = "API", produces = "application/json", consumes = "application/json")
public class InvoiceController extends KITAbstractController<Invoice, UserAccountResponseDTO, UserAccountRequestDTO> {

	public InvoiceController(UserService<UserAccountResponseDTO, UserAccountRequestDTO> service) {
		super(service);
	}

}
