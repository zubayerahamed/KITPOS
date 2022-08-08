package com.kit.pos.service;

import com.kit.pos.util.Response;

/**
 * @author Zubayer Ahamed
 * @since Aug 8, 2022
 */
public interface BaseService<R, E> {

	public Response<R> find(String id);

	public Response<R> save(E reqDto);

	public Response<R> update(E reqDto);

	public Response<R> getAll();
}
