package com.kit.pos.util;

import com.kit.pos.dto.response.UserAccountResponseDTO;

/**
 * @author Zubayer Ahamed
 * @since Aug 2, 2022
 */
public interface CommonFunctions<R> {

	Response<R> getSuccessResponse(String code, String message);

	Response<R> getSuccessResponse(String code, String message, Response<R> response);

	Response<R> getErrorResponse(String code, String message);

	Response<R> getErrorResponse(String code, String message, Response<R> response);

	UserAccountResponseDTO getSystemAdminUser();
}
