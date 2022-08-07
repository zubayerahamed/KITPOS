package com.kit.pos.service;

import com.kit.pos.util.Response;

/**
 * @author Zubayer Ahamed
 * @since Aug 7, 2022
 */
public interface ProductService<R, E> {

	public Response<R> find(String name);

	public Response<R> save(E e);

	public Response<R> update(E e);

	public Response<R> getAll();
}
