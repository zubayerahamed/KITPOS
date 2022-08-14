package com.kit.pos.dto.request;

import lombok.Data;

/**
 * @author Zubayer Ahamed
 * @since Aug 14, 2022
 */
@Data
public class PageableRequestBodyDTO {

	private Integer page;
	private Integer size;
}
