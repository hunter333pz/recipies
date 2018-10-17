package com.hunter333.recipes.models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CategoryTest {

	Category category;

	@Before
	public void setUp() {
		category = new Category();
	}

	@Test
	public void testGetId() {
		Long id = 4l;
		category.setId(id);
		assertEquals(id, category.getId());
	}

	@Test
	public void testGetDescription() {
		String description = "Test description";

		category.setDescription(description);
		assertEquals(description, category.getDescription());
	}

}
