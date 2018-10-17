package com.hunter333.recipes.repositories;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hunter333.recipes.models.UnitOfMeasure;

/**
 * 
 * @author Hunter333
 * @date 17.10.2018 г.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {

	@Autowired
	UnitOfMeasureRepository unitOfMeasureRepository;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetUnitOfMeasureByName() {
		UnitOfMeasure unOptional = unitOfMeasureRepository.getUnitOfMeasureByName("Cup");

		assertEquals("Cup", unOptional.getName());
	}

	@Test
	public void testGetUnitOfMeasureByNameTeaspoon() {
		UnitOfMeasure unOptional = unitOfMeasureRepository.getUnitOfMeasureByName("Teaspoon");

		assertEquals("Teaspoon", unOptional.getName());
	}

}
