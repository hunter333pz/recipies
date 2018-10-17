package com.hunter333.recipes.models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IngredientTest {

	private Ingredient ingredient;

	@Before
	public void setUp() {
		ingredient = new Ingredient();
	}

	@Test
	public void testGetId() {
		Long id = 15l;
		ingredient.setId(id);

		assertEquals(id, ingredient.getId());
	}

}
