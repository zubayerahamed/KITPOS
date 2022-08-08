package com.kit.pos.service;

import com.kit.pos.util.Response;

/**
 * @author Zubayer Ahamed
 * @since Jul 24, 2022
 */
public interface BusinessService<R, E> extends BaseService<R, E>{

	public Response<R> find();

}
