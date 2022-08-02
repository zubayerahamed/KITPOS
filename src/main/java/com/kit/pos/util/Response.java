package com.kit.pos.util;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import lombok.Data;

/**
 * @author Zubayer Ahamed
 * @since Aug 2, 2022
 */
@Data
public class Response<R> {

	private boolean success = true;
	private boolean info = false;
	private boolean warning = false;
	private boolean valid = false;

	private String code;
	private String message;

	private Map<String, R> model;
	private List<R> items;
	private R obj;
	private Page<R> page;
}
