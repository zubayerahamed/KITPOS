package com.kit.pos.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.kit.pos.entity.pk.CategoryPK;
import com.kit.pos.enums.CategoryType;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zubayer Ahamed
 * @since Jul 25, 2022
 */
@Data
@Entity
@IdClass(CategoryPK.class)
@Table(name = "CATEGORY")
@EqualsAndHashCode(of = { "businessId","categoryId"}, callSuper = false)
public class Category extends BaseEntity<String> {

	private static final long serialVersionUID = 5436365650636024958L;

	@Id
	@Basic(optional = false)
	private String businessId;

	@Id
	@Basic(optional = false)
	private String categoryId;

	private String categoryName;

	private int seqn;

	private String parentCategoryId;

	@Enumerated(EnumType.STRING)
	private CategoryType type;

	@Column(name = "status", length = 1)
	private int status = 1;
}
