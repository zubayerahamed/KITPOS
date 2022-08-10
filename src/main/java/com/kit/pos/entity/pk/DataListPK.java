package com.kit.pos.entity.pk;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Zubayer Ahamed
 * @since Aug 10, 2022
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataListPK implements Serializable {

	private static final long serialVersionUID = -5889931200576902539L;

	private String businessId;
	private String code;
	private String actualValue;
}
