package com.kit.pos.util;

import java.util.List;

import com.kit.pos.dto.response.UserAccountResponseDTO;

/**
 * @author Zubayer Ahamed
 * @since Aug 2, 2022
 */
public interface CommonFunctions<R> {

	Response<R> getSuccessResponse(String message);

	Response<R> getSuccessResponse(String code, String message);

	Response<R> getSuccessResponse(String message, R r);

	Response<R> getSuccessResponse(String code, String message, R r);

	Response<R> getSuccessResponse(String message, List<R> list);

	Response<R> getSuccessResponse(String code, String message, List<R> list);

	Response<R> getSuccessResponse(String message, Response<R> response);

	Response<R> getSuccessResponse(String code, String message, Response<R> response);

	Response<R> getErrorResponse(String message);

	Response<R> getErrorResponse(String code, String message);

	Response<R> getErrorResponse(String code, String message, Response<R> response);

	UserAccountResponseDTO getSystemAdminUser();
}
