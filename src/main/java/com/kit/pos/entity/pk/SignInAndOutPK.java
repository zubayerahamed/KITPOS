package com.kit.pos.entity.pk;

import java.io.Serializable;

import lombok.Data;

/**
 * @author Zubayer Ahamed
 * @since Aug 15, 2022
 */
@Data
public class SignInAndOutPK implements Serializable{

	private static final long serialVersionUID = 2503716564238666389L;

	private String businessId;
	private String division;
	private String shop;
	private String counter;
	private String rowId;
}
