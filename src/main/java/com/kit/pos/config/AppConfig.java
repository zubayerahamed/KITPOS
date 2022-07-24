package com.kit.pos.config;

import org.springframework.stereotype.Service;

import lombok.Data;

/**
 * @author Zubayer Ahamed
 * @since Jul 24, 2022
 */
@Data
@Service
public class AppConfig {

	private String businessId;
	private String division;
	private String shop;
	private String counter;
}
