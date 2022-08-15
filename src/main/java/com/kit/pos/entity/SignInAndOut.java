package com.kit.pos.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.kit.pos.entity.pk.SignInAndOutPK;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zubayer Ahamed
 * @since Aug 15, 2022
 */
@Data
@Entity
@IdClass(SignInAndOutPK.class)
@Table(name = "SIGN_IN_AND_OUT")
@EqualsAndHashCode(callSuper = false, of = {"businessId", "division", "shop", "counter", "rowId"})
public class SignInAndOut extends BaseEntity<String>{

	private static final long serialVersionUID = -5358893841324514140L;

	@Id
	@Basic(optional = false)
	private String businessId;
	@Id
	@Basic(optional = false)
	private String division;
	@Id
	@Basic(optional = false)
	private String shop;
	@Id
	@Basic(optional = false)
	private String counter;
	@Id
	@Basic(optional = false)
	private String rowId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	@Temporal(TemporalType.TIMESTAMP)
	private Date signInTime;
	@Temporal(TemporalType.TIMESTAMP)
	private Date signOutTime;

	@Column(name = "status", length = 1)
	private int status = 1;

	private String username;
}
