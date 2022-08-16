package com.kit.pos.dto.request;

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

	private boolean signIn;

	@Override
	public SignInAndOut getBean() {
		SignInAndOut s = new SignInAndOut();
		BeanUtils.copyProperties(this, s);
		return s;
	}
}
