package com.kit.pos.entity;

import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import com.kit.pos.enums.ProductGroup;

import lombok.Data;

/**
 * @author Zubayer Ahamed
 * @since Jul 25, 2022
 */
@Data
public class Product extends BaseEntity<String> {

	private static final long serialVersionUID = -7805690517992099886L;

	@Id
	@Basic(optional = false)
	private String businessId;

	@Id
	@Basic(optional = false)
	private String productId;

	private String name;

	private String shortCode;

	@Enumerated(EnumType.STRING)
	private ProductGroup group;

	private String categoryId;

	private BigDecimal cost;
	private BigDecimal price;
	private BigDecimal discountRate;
	private String discountStatus;
	private String discountType;
	private BigDecimal suppTaxRate;
	private BigDecimal suppTaxAmt;
	private BigDecimal vatRate;
	private BigDecimal vatAmt;
	private boolean isSetItem;
	private String unit;
	private String image;

	@Column(name = "status", length = 1)
	private int status = 1;
}
