package com.hunter333.recipes.controllers;

import java.util.Collections;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hunter333.recipes.servicies.RecipesService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Hunter333
 * @date 22.09.2018 г.
 */
@Slf4j
@Controller
public class IndexController {

	private RecipesService recipesService;

	public IndexController(RecipesService recipesService) {
		super();
		this.recipesService = recipesService;
	}

	@RequestMapping({ "", "/", "/index" })
	public String getIndex(Model model) {
		log.debug("Index controller requested");
		model.addAttribute("recipes", Collections.emptyList());
		return "index";
	}

	@RequestMapping("/getRecipes")
	public String getRecipies(Model model) {
		model.addAttribute("recipes", recipesService.getRecipes());
		return "index";
	}
}
