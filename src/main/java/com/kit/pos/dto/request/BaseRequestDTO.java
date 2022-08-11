package com.kit.pos.dto.request;

import com.kit.pos.dto.BaseDTO;

import lombok.Data;

/**
 * @author Zubayer Ahamed
 * @since Aug 2, 2022
 */
@Data
public abstract class BaseRequestDTO<E> implements BaseDTO<E> {

	public abstract E getBean();
}
