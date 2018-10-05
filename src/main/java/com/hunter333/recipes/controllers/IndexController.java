package com.hunter333.recipes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author Hunter333
 * @date 22.09.2018 г.
 */
@Controller
public class IndexController {

	@RequestMapping({ "", "/", "/index" })
	public String getIndex() {
		return "index";
	}
}
