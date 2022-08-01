package com.kit.pos.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.kit.pos.entity.pk.ProductArchivePK;
import com.kit.pos.enums.DiscountType;
import com.kit.pos.enums.ProductGroup;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zubayer Ahamed
 * @since Aug 1, 2022
 */
@Data
@Entity
@Table(name = "PRODUCT_ARCHIVE")
@IdClass(ProductArchivePK.class)
@EqualsAndHashCode(of = { "businessId","productId","archivedAt"}, callSuper = false)
public class ProductArchive extends BaseEntity<String> {

	private static final long serialVersionUID = 270037700129675200L;

	@Id
	@Basic(optional = false)
	private String businessId;

	@Id
	@Basic(optional = false)
	private String productId;

	@Id
	@Basic(optional = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date archivedAt;

	private String name;

	private String shortCode;

	private int seqn;

	@Enumerated(EnumType.STRING)
	private ProductGroup productGroup;

	private String categoryId;

	private BigDecimal rate;

	private String uom;

	@Enumerated(EnumType.STRING)
	private DiscountType discountType;
	private BigDecimal discountRate;
	private BigDecimal discountAmount;
	private boolean discountApplicable;

	private BigDecimal vatRate;
	private BigDecimal vatAmt;

	private BigDecimal suppDutyRate;
	private BigDecimal suppDutyAmt;

	private boolean isSet;
	private boolean isSetItem;
	private boolean isAddOnItem;

	private String image;

	@Column(name = "status", length = 1)
	private int status = 1;
}
