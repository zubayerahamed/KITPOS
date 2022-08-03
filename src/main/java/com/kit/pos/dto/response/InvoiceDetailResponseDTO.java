package com.kit.pos.dto.response;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zubayer Ahamed
 * @since Aug 3, 2022
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class InvoiceDetailResponseDTO extends BaseResponseDTO {

	private String invoiceId;
	private String rowId;
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
}