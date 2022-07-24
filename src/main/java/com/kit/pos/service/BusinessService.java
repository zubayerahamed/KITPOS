package com.kit.pos.service;

import com.kit.pos.entity.Business;
import com.kit.pos.entity.pk.BusinessPK;

/**
 * @author Zubayer Ahamed
 * @since Jul 24, 2022
 */
public interface BusinessService {

	public Business find(BusinessPK businessPk);
}
