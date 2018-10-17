package com.hunter333.recipes.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import com.hunter333.recipes.models.Recipe;
import com.hunter333.recipes.servicies.RecipesService;

public class IndexControllerTest {

	IndexController indexController;

	@Mock
	RecipesService recipesService;
	@Mock
	Model model;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		indexController = new IndexController(recipesService);
	}

	@Test
	public void testGetIndex() {
		String viewPage = indexController.getIndex(model);

		assertEquals("index", viewPage);
		Mockito.verify(recipesService, Mockito.times(0)).getRecipes();
		Mockito.verify(model, Mockito.times(1)).addAttribute(Mockito.eq("recipes"), Mockito.anyList());
	}

	@Test
	public void testMockMVC() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();

		mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.view().name("index"));

	}

	@SuppressWarnings("unchecked")
	@Test
	public void testGetRecipies() {
		// given
		List<Recipe> recipes = new ArrayList<>();
		recipes.add(new Recipe());
		recipes.add(new Recipe());

		Mockito.when(recipesService.getRecipes()).thenReturn(recipes);

		ArgumentCaptor<List<Recipe>> argumentCaptor = ArgumentCaptor.forClass(List.class);

		// when
		String viewPage = indexController.getRecipies(model);
		// then
		assertEquals("index", viewPage);
		Mockito.verify(recipesService, Mockito.times(1)).getRecipes();
		Mockito.verify(model, Mockito.times(1)).addAttribute(Mockito.eq("recipes"), argumentCaptor.capture());
		List<Recipe> listInController = argumentCaptor.getValue();
		assertEquals(2, listInController.size());
	}

}
