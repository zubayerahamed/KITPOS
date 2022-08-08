package com.kit.pos.dto.request;

import com.kit.pos.dto.BaseDTO;

/**
 * @author Zubayer Ahamed
 * @since Aug 2, 2022
 */
public abstract class BaseRequestDTO<E> implements BaseDTO<E> {

	abstract E getBean();
}
