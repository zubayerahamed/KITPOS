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
public class BusinessPK implements Serializable {

	private static final long serialVersionUID = 7566010260343844722L;

	private String businessId;
	private String division;
	private String shop;
	private String counter;

}
