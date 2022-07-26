package com.kit.pos.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zubayer Ahamed
 * @since Jul 27, 2022
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Invoice extends BaseEntity<String> {

	private static final long serialVersionUID = -6732965529625037338L;

	private String businessId;
	private String invoiceId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date invoiceDate;

	private String customer;
	private String phone;
	private String waiterId;

	private String tokenNo;
	private String paymentType;
	private String paymentTerm;

	private BigDecimal giftAmt;
	private BigDecimal cardAmt;
	private BigDecimal cashAmt;
	private BigDecimal creditAmt;
	private BigDecimal changeAmt;
	private BigDecimal roundingAmt;
	private BigDecimal discountRate;
	private BigDecimal discountAmt;
	private BigDecimal discountAmtFlat;
	private BigDecimal serviceChargeAmt;
	private BigDecimal suppTaxRate;
	private BigDecimal suppTaxAmt;
	private BigDecimal vatRate;
	private BigDecimal vatAmt;
	private BigDecimal paidAmt;
	private BigDecimal totalAmt;
	private BigDecimal netAmt;

	private String note;
	private String giftNote;
	private String cancelNote;

	private String status;
	private String printStatus;
}
