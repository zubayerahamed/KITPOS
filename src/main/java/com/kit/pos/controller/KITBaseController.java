package com.kit.pos.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.kit.pos.model.ResponseHelper;

/**
 * @author Zubayer Ahamed
 * @since Aug 1, 2022
 */
public class KITBaseController {

	@Autowired protected ResponseHelper response;
}
