package com.hunter333.recipes.servicies;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.hunter333.recipes.models.Recipe;
import com.hunter333.recipes.repositories.RecipeRepository;

public class RecipesServiceImplTest {

	RecipesService recipeService;

	@Mock
	RecipeRepository recipeRepository;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		recipeService = new RecipesServiceImpl(recipeRepository);
	}

	@Test
	public void testGetRecipes() {

		Recipe recipe = new Recipe();
		List<Recipe> recipeMock = new ArrayList<>();
		recipeMock.add(recipe);

		Mockito.when(recipeService.getRecipes()).thenReturn(recipeMock);

		List<Recipe> recipes = recipeService.getRecipes();

		assertEquals(1, recipes.size());
		Mockito.verify(recipeRepository, Mockito.times(1)).findAll();
	}

}
