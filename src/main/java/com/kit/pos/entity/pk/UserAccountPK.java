package com.kit.pos.entity.pk;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Zubayer Ahamed
 * @since Jul 24, 2022
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAccountPK implements Serializable {

	private static final long serialVersionUID = 5651050026205231628L;

	private String businessId;
	private String username;
	private String division;
	private String shop;
}
