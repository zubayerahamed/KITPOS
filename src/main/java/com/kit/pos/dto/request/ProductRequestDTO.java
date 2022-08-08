package com.kit.pos.dto.request;

import java.math.BigDecimal;

import org.springframework.beans.BeanUtils;

import com.kit.pos.entity.Product;
import com.kit.pos.enums.DiscountType;
import com.kit.pos.enums.ProductGroup;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zubayer Ahamed
 * @since Aug 3, 2022
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ProductRequestDTO extends BaseRequestDTO<Product> {

	private String productId;

	private String name;

	private String shortCode;

	private int seqn;

	private ProductGroup productGroup;

	private String categoryId;

	private BigDecimal rate;

	private String uom;

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

	private int status = 1;

	@Override
	public Product getBean() {
		Product p = new Product();
		BeanUtils.copyProperties(this, p);
		return p;
	}

}
