package com.hunter333.recipes.bootstrap;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.hunter333.recipes.enumerations.Difficulty;
import com.hunter333.recipes.enumerations.TimeMeasure;
import com.hunter333.recipes.models.Category;
import com.hunter333.recipes.models.Ingredient;
import com.hunter333.recipes.models.Notes;
import com.hunter333.recipes.models.Recipe;
import com.hunter333.recipes.models.Time;
import com.hunter333.recipes.repositories.CategoryRepository;
import com.hunter333.recipes.repositories.RecipeRepository;
import com.hunter333.recipes.repositories.UnitOfMeasureRepository;

/**
 * 
 * @author Hunter333
 * @date 6.10.2018 г.
 */
@Component
public class DevInitDataBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private CategoryRepository categoryRepository;
	private RecipeRepository recipeRepository;
	private UnitOfMeasureRepository unitOfMeasureRepository;

	public DevInitDataBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository,
			UnitOfMeasureRepository unitOfMeasureRepository) {
		super();
		this.categoryRepository = categoryRepository;
		this.recipeRepository = recipeRepository;
		this.unitOfMeasureRepository = unitOfMeasureRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();
	}

	private void initData() {

		Recipe guacamole = createGuacamole();
		Recipe taco = createChickenTaco();

		recipeRepository.save(guacamole);
		recipeRepository.save(taco);
	}

	private Recipe createGuacamole() {
		Recipe guacamole = new Recipe();

		Set<Ingredient> ingredients = new HashSet<Ingredient>();
		ingredients.add(new Ingredient().setDescriptionBuilder("ripe avocados").setAmountBuilder(2d)
				.setUnitsOfMeasureBuilder(unitOfMeasureRepository.getUnitOfMeasureByName("Quantity"))
				.setRecipeBuilder(guacamole));
		ingredients.add(new Ingredient().setDescriptionBuilder("Kosher salt").setAmountBuilder(0.5d)
				.setUnitsOfMeasureBuilder(unitOfMeasureRepository.getUnitOfMeasureByName("Teaspoon"))
				.setRecipeBuilder(guacamole));
		ingredients.add(new Ingredient().setDescriptionBuilder("fresh lime juice or lemon juice").setAmountBuilder(1d)
				.setUnitsOfMeasureBuilder(unitOfMeasureRepository.getUnitOfMeasureByName("Tablespoon"))
				.setRecipeBuilder(guacamole));
		ingredients.add(new Ingredient().setDescriptionBuilder("minced red onion or thinly sliced green onion")
				.setAmountBuilder(0.25d).setUnitsOfMeasureBuilder(unitOfMeasureRepository.getUnitOfMeasureByName("Cup"))
				.setRecipeBuilder(guacamole));
		ingredients.add(new Ingredient().setDescriptionBuilder("serrano chiles, stems and seeds removed, minced")
				.setAmountBuilder(2d)
				.setUnitsOfMeasureBuilder(unitOfMeasureRepository.getUnitOfMeasureByName("Quantity"))
				.setRecipeBuilder(guacamole));
		ingredients.add(new Ingredient().setDescriptionBuilder("cilantro (leaves and tender stems), finely chopped")
				.setAmountBuilder(2d)
				.setUnitsOfMeasureBuilder(unitOfMeasureRepository.getUnitOfMeasureByName("Tablespoon"))
				.setRecipeBuilder(guacamole));
		ingredients.add(new Ingredient().setDescriptionBuilder("A dash of freshly grated black pepper")
				.setAmountBuilder(1d).setUnitsOfMeasureBuilder(unitOfMeasureRepository.getUnitOfMeasureByName("Pinch"))
				.setRecipeBuilder(guacamole));
		ingredients.add(new Ingredient().setDescriptionBuilder("ripe tomato, seeds and pulp removed, chopped")
				.setAmountBuilder(0.5d)
				.setUnitsOfMeasureBuilder(unitOfMeasureRepository.getUnitOfMeasureByName("Quantity"))
				.setRecipeBuilder(guacamole));

		Set<Category> guacamoleCategories = new HashSet<Category>();
		guacamoleCategories.add(categoryRepository.findByDescription("Mexican"));

		Notes note = new Notes();

		String direction = "1. Cut avocado, remove flesh: Cut the avocados in half. "
				+ "Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. "
				+ "Place in a bowl. \r\n" + "2. Mash with a fork: Using a fork, roughly mash the avocado. "
				+ "(Don't overdo it! The guacamole should be a little chunky.)\r\n"
				+ "3. Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. "
				+ "The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\r\n"
				+ "\r\n" + "Add the chopped onion, cilantro, black pepper, and chiles. "
				+ "Chili peppers vary individually in their hotness. "
				+ "So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\r\n"
				+ "\r\n"
				+ "Remember that much of this is done to taste because of the variability in the fresh ingredients. "
				+ "Start with this recipe and adjust to your taste.\r\n"
				+ "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. "
				+ "(The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\r\n"
				+ "\r\n"
				+ "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\r\n"
				+ "\r\n" + "Variations\r\n" + "\r\n"
				+ "For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\r\n"
				+ "\r\n"
				+ "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). "
				+ "Try guacamole with added pineapple, mango, or strawberries (see our Strawberry Guacamole).\r\n"
				+ "\r\n"
				+ "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\r\n"
				+ "\r\n"
				+ "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.";
		note.setNotes(direction);
		note.setRecipe(guacamole);

		guacamole = fillRecipeData(guacamole, "Perfect Guacamole",
				"The BEST guacamole! So easy to make with ripe avocados, salt, serrano chiles, cilantro and lime."
						+ " Garnish with red radishes or jicama. Serve with tortilla chips."
						+ " Watch how to make guacamole - it's easy!",
				new Time().setTimeAmountBuilder(10d).setTimeMeasureBuilder(TimeMeasure.MINUTES), null, 4, "",
				"https://www.simplyrecipes.com/recipes/perfect_guacamole/", "directions", Difficulty.EASY, note,
				ingredients, guacamoleCategories);
		return guacamole;
	}

	private Recipe createChickenTaco() {
		Recipe chickenTaco = new Recipe();

		Set<Ingredient> ingredients = new HashSet<Ingredient>();
		ingredients.add(new Ingredient().setDescriptionBuilder("ancho chili powder").setAmountBuilder(2d)
				.setUnitsOfMeasureBuilder(unitOfMeasureRepository.getUnitOfMeasureByName("Tablespoon"))
				.setRecipeBuilder(chickenTaco));

		ingredients.add(new Ingredient().setDescriptionBuilder("dried oregano").setAmountBuilder(1d)
				.setUnitsOfMeasureBuilder(unitOfMeasureRepository.getUnitOfMeasureByName("Teaspoon"))
				.setRecipeBuilder(chickenTaco));

		ingredients.add(new Ingredient().setDescriptionBuilder("dried cumin").setAmountBuilder(1d)
				.setUnitsOfMeasureBuilder(unitOfMeasureRepository.getUnitOfMeasureByName("Teaspoon"))
				.setRecipeBuilder(chickenTaco));

		ingredients.add(new Ingredient().setDescriptionBuilder("sugar").setAmountBuilder(1d)
				.setUnitsOfMeasureBuilder(unitOfMeasureRepository.getUnitOfMeasureByName("Teaspoon"))
				.setRecipeBuilder(chickenTaco));

		ingredients.add(new Ingredient().setDescriptionBuilder("salt").setAmountBuilder(0.5d)
				.setUnitsOfMeasureBuilder(unitOfMeasureRepository.getUnitOfMeasureByName("Teaspoon"))
				.setRecipeBuilder(chickenTaco));

		ingredients.add(new Ingredient().setDescriptionBuilder("garlic, finely chopped").setAmountBuilder(1d)
				.setUnitsOfMeasureBuilder(unitOfMeasureRepository.getUnitOfMeasureByName("Clove"))
				.setRecipeBuilder(chickenTaco));

		ingredients.add(new Ingredient().setDescriptionBuilder("finely grated orange zest").setAmountBuilder(1d)
				.setUnitsOfMeasureBuilder(unitOfMeasureRepository.getUnitOfMeasureByName("Tablespoon"))
				.setRecipeBuilder(chickenTaco));

		ingredients.add(new Ingredient().setDescriptionBuilder("resh-squeezed orange juice").setAmountBuilder(3d)
				.setUnitsOfMeasureBuilder(unitOfMeasureRepository.getUnitOfMeasureByName("Tablespoon"))
				.setRecipeBuilder(chickenTaco));

		ingredients.add(new Ingredient().setDescriptionBuilder("olive oil").setAmountBuilder(2d)
				.setUnitsOfMeasureBuilder(unitOfMeasureRepository.getUnitOfMeasureByName("Tablespoon"))
				.setRecipeBuilder(chickenTaco));

		ingredients.add(new Ingredient().setDescriptionBuilder("skinless, boneless chicken thighs").setAmountBuilder(5d)
				.setUnitsOfMeasureBuilder(unitOfMeasureRepository.getUnitOfMeasureByName("Quantity"))
				.setRecipeBuilder(chickenTaco));

		ingredients.add(new Ingredient().setDescriptionBuilder("small corn tortillas").setAmountBuilder(8d)
				.setUnitsOfMeasureBuilder(unitOfMeasureRepository.getUnitOfMeasureByName("Quantity"))
				.setRecipeBuilder(chickenTaco));

		ingredients.add(new Ingredient().setDescriptionBuilder("packed baby arugula").setAmountBuilder(3d)
				.setUnitsOfMeasureBuilder(unitOfMeasureRepository.getUnitOfMeasureByName("Cup"))
				.setRecipeBuilder(chickenTaco));

		ingredients.add(new Ingredient().setDescriptionBuilder("medium ripe avocados, sliced").setAmountBuilder(2d)
				.setUnitsOfMeasureBuilder(unitOfMeasureRepository.getUnitOfMeasureByName("Quantity"))
				.setRecipeBuilder(chickenTaco));

		ingredients.add(new Ingredient().setDescriptionBuilder("radishes, thinly sliced").setAmountBuilder(4d)
				.setUnitsOfMeasureBuilder(unitOfMeasureRepository.getUnitOfMeasureByName("Quantity"))
				.setRecipeBuilder(chickenTaco));

		ingredients.add(new Ingredient().setDescriptionBuilder("cherry tomatoes, halved").setAmountBuilder(0.5d)
				.setUnitsOfMeasureBuilder(unitOfMeasureRepository.getUnitOfMeasureByName("Pint"))
				.setRecipeBuilder(chickenTaco));

		ingredients.add(new Ingredient().setDescriptionBuilder("red onion, thinly sliced").setAmountBuilder(0.25d)
				.setUnitsOfMeasureBuilder(unitOfMeasureRepository.getUnitOfMeasureByName("Quantity"))
				.setRecipeBuilder(chickenTaco));

		ingredients.add(new Ingredient().setDescriptionBuilder("Roughly chopped cilantro").setAmountBuilder(1d)
				.setUnitsOfMeasureBuilder(unitOfMeasureRepository.getUnitOfMeasureByName("Quantity"))
				.setRecipeBuilder(chickenTaco));

		ingredients.add(new Ingredient().setDescriptionBuilder("sour cream").setAmountBuilder(0.5d)
				.setUnitsOfMeasureBuilder(unitOfMeasureRepository.getUnitOfMeasureByName("Cup"))
				.setRecipeBuilder(chickenTaco));

		ingredients.add(new Ingredient().setDescriptionBuilder("milk").setAmountBuilder(0.25d)
				.setUnitsOfMeasureBuilder(unitOfMeasureRepository.getUnitOfMeasureByName("Cup"))
				.setRecipeBuilder(chickenTaco));

		ingredients.add(new Ingredient().setDescriptionBuilder("lime, cut into wedges").setAmountBuilder(1d)
				.setUnitsOfMeasureBuilder(unitOfMeasureRepository.getUnitOfMeasureByName("Quantity"))
				.setRecipeBuilder(chickenTaco));

		Set<Category> tacoCategories = new HashSet<Category>();
		tacoCategories.add(categoryRepository.findByDescription("Mexican"));

		Notes note = new Notes();

		String direction = "1 Prepare a gas or charcoal grill for medium-high, direct heat.\r\n" + "\r\n"
				+ "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. "
				+ "Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\r\n"
				+ "\r\n" + "Set aside to marinate while the grill heats and you prepare the rest of the toppings."
				+ "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. "
				+ "Transfer to a plate and rest for 5 minutes.\r\n" + "\r\n"
				+ "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. "
				+ "As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\r\n"
				+ "\r\n" + "Wrap warmed tortillas in a tea towel to keep them warm until serving.\r\n" + "\r\n"
				+ "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. "
				+ "Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.\r\n"
				+ "\r\n";
		note.setNotes(direction);
		note.setRecipe(chickenTaco);

		fillRecipeData(chickenTaco, "Spicy Grilled Chicken Tacos",
				"Spicy grilled chicken tacos! Quick marinade, then grill. "
						+ "Ready in about 30 minutes. Great for a quick weeknight dinner, backyard cookouts, and tailgate parties.",
				new Time().setTimeAmountBuilder(20d).setTimeMeasureBuilder(TimeMeasure.MINUTES),
				new Time().setTimeAmountBuilder(15d).setTimeMeasureBuilder(TimeMeasure.MINUTES), 5, "",
				"https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/", "directions", Difficulty.EASY,
				note, ingredients, tacoCategories);
		return chickenTaco;
	}

	private Recipe fillRecipeData(Recipe recipe, String recipeName, String description, Time prepTime, Time cookTime,
			Integer servings, String source, String url, String directions, Difficulty difficulty, Notes notes,
			Set<Ingredient> ingredients, Set<Category> categories) {

		recipe.setName(recipeName);
		recipe.setDescription(description);
		recipe.setPrepTime(prepTime);
		recipe.setCookTime(cookTime);
		recipe.setServings(servings);
		recipe.setSource(source);
		recipe.setUrl(url);
		recipe.setDirections(directions);
		recipe.setDifficulty(difficulty);
		recipe.setNotes(notes);
		recipe.setIngredients(ingredients);
		recipe.setCategories(categories);

		return recipe;

	}

}
