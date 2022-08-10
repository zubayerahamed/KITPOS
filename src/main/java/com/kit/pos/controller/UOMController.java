package com.kit.pos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kit.pos.dto.request.DataListRequestDTO;
import com.kit.pos.dto.response.DataListResponseDTO;
import com.kit.pos.entity.DataList;
import com.kit.pos.service.DataListService;

import io.swagger.annotations.Api;

/**
 * @author Zubayer Ahamed
 * @since Aug 10, 2022
 */
@RestController
@RequestMapping("/api/kitpos/uom")
@Api(tags = {"Unit of Meserment"}, description = "API", produces = "application/json", consumes = "application/json")
public class UOMController extends KITAbstractController<DataList, DataListResponseDTO, DataListRequestDTO> {

	public UOMController(DataListService<DataListResponseDTO, DataListRequestDTO> service) {
		super(service);
	}

}
