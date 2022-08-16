package com.kit.pos.service;

import com.kit.pos.util.Response;

/**
 * @author Zubayer Ahamed
 * @since Aug 15, 2022
 */
public interface SignInAndOutService<R, E> extends BaseService<R, E> {

	public Response<R> doSignInOrOut(E e, String token);
}
