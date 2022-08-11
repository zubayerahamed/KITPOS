package com.kit.pos.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.Data;

/**
 * @author Zubayer Ahamed
 * @since Jul 24, 2022
 */
@Data
@Service
public class AppConfig {

	@Value("${app.business_id}")
	private String businessId;

	@Value("${app.division}")
	private String division;

	public String getDivision() {
		return StringUtils.leftPad(this.division, 2, '0');
	}

	@Value("${app.shop}")
	private String shop;

	public String getShop() {
		return StringUtils.leftPad(this.shop, 2, '0');
	}

	@Value("${app.counter}")
	private String counter;

	public String getCounter() {
		return StringUtils.leftPad(this.counter, 2, '0');
	}

	@Value("${app.max-shift:1}")
	private int maxShift;

	@Value("${app.active-inventory:false}")
	private boolean activeInventory;
}
