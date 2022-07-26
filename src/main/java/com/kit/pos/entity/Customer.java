package com.kit.pos.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.kit.pos.entity.pk.CustomerPK;
import com.kit.pos.enums.CustomerType;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zubayer Ahamed
 * @since Jul 26, 2022
 */
@Data
@Entity
@IdClass(CustomerPK.class)
@Table(name = "CUSTOMER")
@EqualsAndHashCode(of = { "businessId","customerId"}, callSuper = false)
public class Customer extends BaseEntity<String>{

	private static final long serialVersionUID = 2911833679722844391L;

	@Id
	@Basic(optional = false)
	private String businessId;
	@Id
	@Basic(optional = false)
	private String customerId;

	private String name;
	private String email;
	private String phone1;
	private String phone2;
	private String country;
	private String district;
	private String postOffice;
	private String zipCode;
	private String addressLine1;
	private String addressLine2;
	private String nid;
	@Enumerated(EnumType.STRING)
	private CustomerType customerType;

	@Column(name = "status", length = 1)
	private int status = 1;

}
