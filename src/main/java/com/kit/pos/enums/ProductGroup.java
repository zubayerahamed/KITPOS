package com.kit.pos.enums;

/**
 * @author Zubayer Ahamed
 * @since Jul 25, 2022
 */
public enum ProductGroup {

	FINISHED_GOOD("Finished Good"),
	RAW_MATERIAL("Raw Material"),
	SERVICE("Service"),
	PACKAGING_ITEM("Packaging Item");

	private String code;

	private ProductGroup(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
