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
@AllArgsConstructor
@NoArgsConstructor
public class ProductPK implements Serializable {

	private static final long serialVersionUID = 7305196791266389548L;

	private String businessId;
	private String productId;
}
