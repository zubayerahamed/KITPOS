package com.kit.pos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.kit.pos.entity.BaseEntity;
import com.kit.pos.service.BaseService;
import com.kit.pos.util.Response;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

/**
 * @author Zubayer Ahamed
 * @since Aug 1, 2022
 */
@RequiredArgsConstructor
public abstract class KITAbstractController<P extends BaseEntity<String>, R, E> implements KITBaseController<R, E> {

	private final BaseService<R, E> baseService;

	@GetMapping
	@Override
	@ApiOperation(value = "Get All")
	public Response<R> getAll() {
		return baseService.getAll();
	}

	@PostMapping
	@Override
	@ApiOperation(value = "Save")
	public Response<R> save(E e) {
		return baseService.save(e);
	}

	@PutMapping
	@Override
	@ApiOperation(value = "Update")
	public Response<R> update(E e) {
		return baseService.update(e);
	}

	@GetMapping("/{id}")
	@Override
	@ApiOperation(value = "Find")
	public Response<R> find(String id) {
		return baseService.find(id);
	}

}
