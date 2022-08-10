package com.kit.pos.entity;

import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.kit.pos.entity.pk.ProductPK;
import com.kit.pos.enums.DiscountType;
import com.kit.pos.enums.ProductGroup;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zubayer Ahamed
 * @since Jul 25, 2022
 */
@Data
@Entity
@Table(name = "PRODUCT")
@IdClass(ProductPK.class)
@EqualsAndHashCode(of = { "businessId","productId"}, callSuper = false)
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

	private int seqn;

	@Enumerated(EnumType.STRING)
	private ProductGroup productGroup;

	private String categoryId;

	private BigDecimal rate;

	private String purchaseUom;

	private BigDecimal purchaseCf;

	private String sellUom;

	private BigDecimal sellCf;

	private String stockUom;

	@Enumerated(EnumType.STRING)
	private DiscountType discountType;
	private BigDecimal discountRate;
	private BigDecimal discountAmount;
	private boolean discountApplicable;

	private BigDecimal vatRate;
	private BigDecimal vatAmt;

	private BigDecimal suppDutyRate;
	private BigDecimal suppDutyAmt;

	private boolean setMenu;
	private boolean setItem;
	private boolean addOnItem;
	private boolean forPromotion;

	private String image;

	@Column(name = "status", length = 1)
	private int status = 1;
}
