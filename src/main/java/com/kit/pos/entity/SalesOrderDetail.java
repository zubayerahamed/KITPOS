package com.kit.pos.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

/**
 * @author Zubayer Ahamed
 * @since Jul 27, 2022
 */
@Data
public class SalesOrderDetail extends BaseEntity<String> {

	private static final long serialVersionUID = 587998557238326615L;

	private String businessId;
	private String salesOrderId;
	private String rowId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private BigDecimal discountRate;
	private BigDecimal discountAmt;
	private BigDecimal discountAmtFlat;
	private String discountStatus;
	private String discountType;
	private boolean isTakeAway;
	private boolean isGift;
	private boolean isSet;
	private boolean isSetItem;
	private String itemId;
	private String name;

	private BigDecimal price;
	private BigDecimal lineAmt;
	private BigDecimal netAmt;
	private BigDecimal quantity;
	private BigDecimal suppTaxRate;
	private BigDecimal suppTaxAmt;
	private String statusOrder;
	private BigDecimal vatRate;
	private BigDecimal vatAmt;

	private String division;
	private String shift;
	private String shop;
	private String counter;
}
