package com.kit.pos.entity.pk;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @author Zubayer Ahamed
 * @since Aug 1, 2022
 */
@Data
public class ProductArchivePK implements Serializable {

	private static final long serialVersionUID = -5727359822630673825L;
	private String businessId;
	private String productId;
	private Date archivedAt;
}
