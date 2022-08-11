package com.kit.pos.service;

import com.kit.pos.util.Response;

/**
 * @author Zubayer Ahamed
 * @since Aug 10, 2022
 */
public interface DataListService<R, E> extends BaseService<R, E> {

	public Response<R> findByCodeAndActualValue(String code, String actualValue);
}
