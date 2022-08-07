package com.kit.pos.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.kit.pos.entity.pk.BusinessPK;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zubayer Ahamed
 * @since Jul 24, 2022
 */
@Data
@Entity
@Table(name = "BUSINESS")
@IdClass(BusinessPK.class)
@EqualsAndHashCode(of = { "businessId", "division", "shop", "counter" }, callSuper = false)
public class Business extends BaseEntity<String> {

	private static final long serialVersionUID = -542521281879142952L;

	@Id
	@Basic(optional = false)
	private String businessId;

	@Id
	@Basic(optional = false)
	private String division = "01";

	@Id
	@Basic(optional = false)
	private String shop = "01";

	@Id
	@Basic(optional = false)
	private String counter = "01";

	private String name;

	private String email;

	private String phone;

	private String address;

	private String website;

	private String logo;

	private String tinNp;

	private String vatRegNo;

	private String currency;

	private String xdformat;

	@Column(name = "status", length = 1)
	private int status = 1;
}
