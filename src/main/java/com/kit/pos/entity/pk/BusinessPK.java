package com.kit.pos.entity.pk;

import java.io.Serializable;

import lombok.Data;

/**
 * @author Zubayer Ahamed
 * @since Jul 24, 2022
 */
@Data
public class BusinessPK implements Serializable {

	private static final long serialVersionUID = 7566010260343844722L;

	private String businessId;
	private String division;
	private String shop;
	private String counter;

}
