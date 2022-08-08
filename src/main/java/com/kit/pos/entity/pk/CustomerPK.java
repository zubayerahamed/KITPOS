package com.kit.pos.entity.pk;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Zubayer Ahamed
 * @since Jul 26, 2022
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerPK implements Serializable {

	private static final long serialVersionUID = -6381956906841662801L;
	private String businessId;
	private String customerId;
}
