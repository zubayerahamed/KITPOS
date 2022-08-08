package com.kit.pos.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.kit.pos.util.Response;

/**
 * @author Zubayer Ahamed
 * @since Aug 1, 2022
 */
public interface KITBaseController<R, E> {

	public Response<R> getAll();

	public Response<R> save(@RequestBody E e);

	public Response<R> update(@RequestBody E e);

	public Response<R> find(@PathVariable String id);
}
