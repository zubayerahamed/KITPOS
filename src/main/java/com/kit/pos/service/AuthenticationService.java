package com.kit.pos.service;

import com.kit.pos.util.Response;

/**
 * @author Zubayer Ahamed
 * @since Aug 2, 2022
 */
public interface AuthenticationService<R, E> extends BaseService<R, E> {

	Response<R> getAuthenticationToken(E e);
}
