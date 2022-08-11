package com.kit.pos.dto.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;

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

	@NotBlank
	private String name;

	private String shortCode;

	private int seqn;

	@NotBlank
	private ProductGroup productGroup;

	@NotBlank
	private String categoryId;

	@NotBlank
	private BigDecimal rate;

	private String purchaseUom;

	@NotBlank
	private String sellUom;
	
	private String stockUom;

	private DiscountType discountType;
	private BigDecimal discountRate;
	private BigDecimal discountAmount;
	private boolean discountApplicable;

	@NotBlank
	private BigDecimal vatRate;

	@NotBlank
	private BigDecimal suppDutyRate;

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
