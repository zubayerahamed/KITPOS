package com.kit.pos.dto.response;

import java.util.Date;

import com.kit.pos.entity.SignInAndOut;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zubayer Ahamed
 * @since Aug 15, 2022
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SignInAndOutResDto extends BaseResponseDTO<SignInAndOut>{

	private String businessId;
	private String division;
	private String shop;
	private String counter;
	private String rowId;

	private Date date;
	private Date signInTime;
	private Date signOutTime;
	private int status;
	private String username;
}
