package com.kit.pos.entity.pk;

import java.io.Serializable;

import lombok.Data;

/**
 * @author Zubayer Ahamed
 * @since Jul 26, 2022
 */
@Data
public class CustomerPK implements Serializable {

	private static final long serialVersionUID = -6381956906841662801L;
	private String businessId;
	private String customerId;
}
