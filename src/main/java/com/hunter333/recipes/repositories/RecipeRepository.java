package com.hunter333.recipes.repositories;

import org.springframework.data.repository.CrudRepository;

import com.hunter333.recipes.models.Recipe;

/**
 * 
 * @author Hunter333
 * @date 2.10.2018 г.
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
