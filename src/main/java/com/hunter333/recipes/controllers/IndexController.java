package com.hunter333.recipes.controllers;

import java.util.Collections;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hunter333.recipes.servicies.RecipesService;

/**
 * 
 * @author Hunter333
 * @date 22.09.2018 г.
 */
@Controller
public class IndexController {

	private RecipesService recipesService;

	public IndexController(RecipesService recipesService) {
		super();
		this.recipesService = recipesService;
	}

	@RequestMapping({ "", "/", "/index" })
	public String getIndex(Model model) {
		model.addAttribute("recipes", Collections.EMPTY_LIST);
		return "index";
	}

	@RequestMapping("/getRecipes")
	public String getRecipies(Model model) {
		model.addAttribute("recipes", recipesService.getRecipes());
		return "index";
	}
}
