package com.hunter333.recipes.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * 
 * @author Hunter333
 * @date 1.10.2018 г.
 */
@Entity
public class Ingredient {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String description;
	private Double amount;

	@OneToOne(fetch = FetchType.EAGER)
	private UnitOfMeasure unitOfMeasure;

	@ManyToOne
	private Recipe recipe;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public UnitOfMeasure getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	public Ingredient setDescriptionBuilder(String description) {
		this.description = description;
		return this;
	}

	public Ingredient setAmountBuilder(Double amount) {
		this.amount = amount;
		return this;
	}

	public Ingredient setUnitsOfMeasureBuilder(UnitOfMeasure unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
		return this;
	}

	public Ingredient setRecipeBuilder(Recipe recipe) {
		this.recipe = recipe;
		return this;
	}
}
