package com.kit.pos.dto.response;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.springframework.beans.BeanUtils;

import com.kit.pos.entity.Product;
import com.kit.pos.enums.DiscountType;
import com.kit.pos.enums.ProductGroup;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Zubayer Ahamed
 * @since Aug 3, 2022
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ProductResponseDTO extends BaseResponseDTO<Product> {

	public ProductResponseDTO(Product product){
		BeanUtils.copyProperties(product, this);
	}

	private String productId;

	private String name;

	private String shortCode;

	private int seqn;

	@Enumerated(EnumType.STRING)
	private ProductGroup productGroup;

	private String categoryId;

	private BigDecimal rate;

	private String purchaseUom;

	private String sellUom;
	
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
