package com.kit.pos.dto.request;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.kit.pos.entity.SignInAndOut;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zubayer Ahamed
 * @since Aug 15, 2022
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SignInAndOutReqDto extends BaseRequestDTO<SignInAndOut> {

	private Date signInTime;
	private Date signOutTime;

	@Override
	public SignInAndOut getBean() {
		SignInAndOut s = new SignInAndOut();
		BeanUtils.copyProperties(this, s);
		return s;
	}
}
