package com.kit.pos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kit.pos.dto.request.DataListRequestDTO;
import com.kit.pos.dto.response.DataListResponseDTO;
import com.kit.pos.entity.DataList;
import com.kit.pos.service.DataListService;
import com.kit.pos.util.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Zubayer Ahamed
 * @since Aug 10, 2022
 */
@RestController
@RequestMapping("/api/kitpos/uom")
@Api(tags = {"Unit of Meserment"}, description = "API", produces = "application/json", consumes = "application/json")
public class UOMController extends KITAbstractController<DataList, DataListResponseDTO, DataListRequestDTO> {

	DataListService<DataListResponseDTO, DataListRequestDTO> dlService;

	public UOMController(DataListService<DataListResponseDTO, DataListRequestDTO> service) {
		super(service);
		this.dlService = service;
	}

	@GetMapping("/{code}")
	@ApiOperation(value = "Find By Code")
	@Override
	public Response<DataListResponseDTO> find(@PathVariable String code) {
		return service.find(code);
	}

	@GetMapping("/{code}/{actualvalue}")
	@ApiOperation(value = "Find By Code and Actual value")
	public Response<DataListResponseDTO> findByCodeAndActualValue(@PathVariable String code, @PathVariable String actualvalue) {
		return dlService.findByCodeAndActualValue(code, actualvalue);
	}
}
