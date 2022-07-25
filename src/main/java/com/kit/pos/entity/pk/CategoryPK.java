package com.kit.pos.entity.pk;

import java.io.Serializable;

import lombok.Data;

@Data
public class CategoryPK implements Serializable {

	private static final long serialVersionUID = 1384578712742074168L;

	private String businessId;
	private String categoryId;
}
