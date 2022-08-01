package com.kit.pos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zubayer Ahamed
 * @since Jul 24, 2022
 */
@RestController
public class MainController {

	@GetMapping("/")
	public String entryPoint() {
		return "hellow";
	}

}
