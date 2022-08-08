package com.kit.pos.dto.response;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.kit.pos.entity.Invoice;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Zubayer Ahamed
 * @since Aug 3, 2022
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class InvoiceResponseDTO extends BaseResponseDTO<Invoice>{

	InvoiceResponseDTO(Invoice i){
		BeanUtils.copyProperties(i, this);
	}

	private String invoiceId;
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

	private List<InvoiceDetailResponseDTO> orderDetails;
}
