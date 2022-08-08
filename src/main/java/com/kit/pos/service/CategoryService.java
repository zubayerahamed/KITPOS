package com.kit.pos.service;

import com.kit.pos.util.Response;

/**
 * @author Zubayer Ahamed
 * @since Aug 4, 2022
 */
public interface CategoryService <R, E> extends BaseService<R, E> {

	public Response<R> getAllParentCategories(String currentCategoryName);

	public Response<R> getAllChildCategories(String currentCategoryName);
}
