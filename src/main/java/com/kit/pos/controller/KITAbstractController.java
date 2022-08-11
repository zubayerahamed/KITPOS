package com.kit.pos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

	protected final BaseService<R, E> service;

	@GetMapping
	@Override
	@ApiOperation(value = "Get All")
	public Response<R> getAll() {
		return service.getAll();
	}

	@PostMapping
	@Override
	@ApiOperation(value = "Save")
	public Response<R> save(@RequestBody E e) {
		return service.save(e);
	}

	@PutMapping
	@Override
	@ApiOperation(value = "Update")
	public Response<R> update(@RequestBody E e) {
		return service.update(e);
	}

	@GetMapping("/{id}")
	@Override
	@ApiOperation(value = "Find")
	public Response<R> find(@PathVariable String id) {
		return service.find(id);
	}

}
