package com.hunter333.recipes.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.hunter333.recipes.enumerations.Difficulty;

import lombok.Data;

/**
 * 
 * @author Hunter333
 * @date 1.10.2018 г.
 */
@Data
@Entity
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String description;
	@OneToOne(cascade = CascadeType.ALL)
	private Time prepTime;
	@OneToOne(cascade = CascadeType.ALL)
	private Time cookTime;
	private Integer servings;
	private String source;
	private String url;
	private String directions;

	@Enumerated(value = EnumType.STRING)
	private Difficulty difficulty;

	@Lob
	private Byte[] image;

	@OneToOne(cascade = CascadeType.ALL)
	private Notes notes;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
	private Set<Ingredient> ingredients;

	@ManyToMany
	@JoinTable(name = "recipe_category", joinColumns = @JoinColumn(name = "recipe_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Set<Category> categories;

	public void setNotes(Notes notes) {
		notes.setRecipe(this);
		this.notes = notes;
	}

}
