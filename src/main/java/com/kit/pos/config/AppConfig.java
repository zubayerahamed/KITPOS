package com.kit.pos.config;

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

	@Value("${app.shop}")
	private String shop;

	@Value("${app.counter}")
	private String counter;
}
