package com.hunter333.recipes.servicies;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hunter333.recipes.models.Recipe;
import com.hunter333.recipes.repositories.RecipeRepository;

/**
 * 
 * @author Hunter333
 * @date 7.10.2018 г.
 */
@Service
public class RecipesServiceImpl implements RecipesService {
	private RecipeRepository recipeRepository;

	public RecipesServiceImpl(RecipeRepository recipeRepository) {
		super();
		this.recipeRepository = recipeRepository;
	}

	@Override
	public List<Recipe> getRecipes() {
		return (List<Recipe>) recipeRepository.findAll();

	}

}
