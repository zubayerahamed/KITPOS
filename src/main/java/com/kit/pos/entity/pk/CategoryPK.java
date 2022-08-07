package com.kit.pos.entity.pk;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryPK implements Serializable {

	private static final long serialVersionUID = 1384578712742074168L;

	private String businessId;
	private String name;
}
