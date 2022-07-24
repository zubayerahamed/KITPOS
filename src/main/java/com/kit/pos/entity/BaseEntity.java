package com.kit.pos.entity;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

/**
 * @author Zubayer Ahamed
 * @since Jul 24, 2022
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity <U> implements Serializable {

	private static final long serialVersionUID = 280920752398523356L;

	@CreatedBy
	private U createdBy;

	@LastModifiedBy
	private U modifiedBy;

	private String createdFrom;

	private String updatedFrom;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn = new Date();

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedOn = new Date();

	@PrePersist
	public void onPersist() {
		try {
			setCreatedFrom(InetAddress.getLocalHost().toString());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	@PreUpdate
	public void onUpdate() {
		try {
			setUpdatedFrom(InetAddress.getLocalHost().toString());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
