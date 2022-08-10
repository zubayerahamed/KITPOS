package com.kit.pos.entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.kit.pos.entity.pk.DataListPK;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zubayer Ahamed
 * @since Aug 10, 2022
 */
@Data
@Entity
@IdClass(DataListPK.class)
@Table(name = "DATALIST")
@EqualsAndHashCode(of= {"businessId", "code", "actualValue"}, callSuper = false)
public class DataList extends BaseEntity<String> {

	private static final long serialVersionUID = 5212235824566598795L;

	@Id
	@Basic(optional = false)
	private String businessId;
	@Id
	@Basic(optional = false)
	private String code;
	@Id
	@Basic(optional = false)
	private String actualValue;

	private String valueDesc;

	private String lsvl1;
	private String lsvl2;
	private String lsvl3;
	private String lsvl4;
	private String lsvl5;
	private String lsvl6;
	
}
