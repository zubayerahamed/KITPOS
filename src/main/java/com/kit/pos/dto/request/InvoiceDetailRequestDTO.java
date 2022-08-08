package com.kit.pos.dto.request;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.kit.pos.entity.InvoiceDetail;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zubayer Ahamed
 * @since Aug 3, 2022
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class InvoiceDetailRequestDTO extends BaseRequestDTO<InvoiceDetail> {

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

	@Override
	InvoiceDetail getBean() {
		InvoiceDetail d = new InvoiceDetail();
		BeanUtils.copyProperties(this, d);
		return d;
	}

	
}
