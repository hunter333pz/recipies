package com.hunter333.recipes.repositories;

import org.springframework.data.repository.CrudRepository;

import com.hunter333.recipes.models.Category;

/**
 * 
 * @author Hunter333
 * @date 2.10.2018 г.
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
