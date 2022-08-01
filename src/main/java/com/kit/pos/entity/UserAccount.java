package com.kit.pos.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;

import com.kit.pos.entity.pk.UserPK;
import com.kit.pos.enums.UserRole;
import com.kit.pos.enums.UserType;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zubayer Ahamed
 * @since Jul 24, 2022
 */
@Data
@Entity
@IdClass(UserPK.class)
@Table(name = "USER_ACCOUNT")
@EqualsAndHashCode(of = { "businessId","username","division","shop","counter"}, callSuper = false)
public class UserAccount extends BaseEntity<String> {

	private static final long serialVersionUID = -5366744299983993402L;

	@Id
	@Basic(optional = false)
	private String businessId;

	@Id
	@Basic(optional = false)
	private String username;

	@Id
	@Basic(optional = false)
	private String division;

	@Id
	@Basic(optional = false)
	private String shop;

	@Id
	@Basic(optional = false)
	private String counter;

	private String password;

	private String name;

	@Column(name = "status", length = 1)
	private int status = 1;

	@Enumerated(EnumType.STRING)
	private UserType userType;

	private boolean systemadmin;

	private boolean admin;

	private boolean waiter;

	private boolean cashier;

	@Transient
	private String roles;

	public String getRoles() {
		this.roles = "";
		if(Boolean.TRUE.equals(systemadmin)) roles += UserRole.SYSTEM_ADMIN.getCode() + ',';
		if(Boolean.TRUE.equals(admin)) roles += UserRole.ADMIN.getCode() + ',';
		if(Boolean.TRUE.equals(waiter)) roles += UserRole.WAITER.getCode() + ',';
		if(Boolean.TRUE.equals(cashier)) roles += UserRole.CASHIER.getCode() + ',';

		if(StringUtils.isBlank(roles)) return roles;

		int lastComma = roles.lastIndexOf(',');
		String finalString = roles.substring(0, lastComma);
		roles = finalString;
		return roles;
	}
}
