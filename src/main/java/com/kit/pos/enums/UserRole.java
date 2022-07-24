package com.kit.pos.enums;

/**
 * @author Zubayer Ahamed
 * @since Jul 24, 2022
 */
public enum UserRole {

	SYSTEM_ADMIN("ROLE_SYSTEM_ADMIN", "System Admin"),
	ADMIN("ROLE_ADMIN", "Admin"),
	WAITER("ROLE_WITER", "Waiter"),
	CASHIER("ROLE_CASHIER", "Cashier");

	private String code;
	private String roleName;

	private UserRole(String code, String roleName) {
		this.code = code;
		this.roleName = roleName;
	}

	public String getCode() {
		return code;
	}

	public String getRoleName() {
		return roleName;
	}
}
