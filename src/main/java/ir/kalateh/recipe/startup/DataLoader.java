package ir.kalateh.recipe.startup;

import ir.kalateh.recipe.model.*;
import ir.kalateh.recipe.repository.CategoryRepository;
import ir.kalateh.recipe.repository.RecipeRepository;
import ir.kalateh.recipe.repository.UnitOfMeasureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class DataLoader implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public DataLoader(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void run(String... args) throws Exception {
       List<Recipe> recipes = getRecipe();
       recipeRepository.saveAll(recipes);
    }

    List<Recipe> getRecipe() throws Exception {
        Optional<Category> westAsianOptional = categoryRepository.findByDescription("west asian");
        Category westAsian = westAsianOptional.orElseThrow(()->new Exception("west asian isn't insert"));
        Optional<Category> americanOptional = categoryRepository.findByDescription("american");
        Category american = americanOptional.orElseThrow(()->new Exception("american isn't insert"));

        Optional<UnitOfMeasure> cupOptional = unitOfMeasureRepository.findByUom("cup");
        UnitOfMeasure cup = cupOptional.orElseThrow(()->new Exception("cup isn't insert"));
        Optional<UnitOfMeasure> teaSpoonOptional = unitOfMeasureRepository.findByUom("teaSpoon");
        UnitOfMeasure teaSpoon = teaSpoonOptional.orElseThrow(()->new Exception("teaspoon isn't insert"));
        Optional<UnitOfMeasure> tableSpoonOptional = unitOfMeasureRepository.findByUom("tableSpoon");
        UnitOfMeasure tableSpoon = tableSpoonOptional.orElseThrow(()->new Exception("tablespoon isn't insert"));
        Optional<UnitOfMeasure> ounceOptional = unitOfMeasureRepository.findByUom("Ounce");
        UnitOfMeasure ounce = ounceOptional.orElseThrow(()->new Exception("ounce isn't insert"));
        Optional<UnitOfMeasure> eachOptional = unitOfMeasureRepository.findByUom("each");
        UnitOfMeasure each = eachOptional.orElseThrow(()->new Exception("each isn't insert"));
        Optional<UnitOfMeasure> bunchOptional = unitOfMeasureRepository.findByUom("bunch");
        UnitOfMeasure bunch= bunchOptional.orElseThrow(()->new Exception("bunch isn't insert"));
        Optional<UnitOfMeasure> cloveOptional = unitOfMeasureRepository.findByUom("clove");
        UnitOfMeasure clove = cloveOptional.orElseThrow(()->new Exception("clove isn't insert"));
        Optional<UnitOfMeasure> largeOptional = unitOfMeasureRepository.findByUom("large");
        UnitOfMeasure large = largeOptional.orElseThrow(()->new Exception("large isn't insert"));
        Optional<UnitOfMeasure> stalkOptional = unitOfMeasureRepository.findByUom("stalk");
        UnitOfMeasure stalk = stalkOptional.orElseThrow(()->new Exception("stalk isn't insert"));

        List<Recipe> recipes = new ArrayList<>();
        Recipe lentilSoupRecipe = new Recipe();
        lentilSoupRecipe.getCategories().add(westAsian);
        lentilSoupRecipe.getCategories().add(american);
        lentilSoupRecipe.setDescription("Perfect soup for ramadan");
        lentilSoupRecipe.setPrepTime(15);
        lentilSoupRecipe.setCookTime(60);
        Note lentilSoupNote = new Note();
        lentilSoupNote.setRecipeNote("To achieve a creamy consistency, I like to puree a little of the soup in the blender and add it back to the pot. Like most lentil soups, this one thickens as it sits. So, be prepared to add more water when you reheat it, or simply enjoy it as a stew.");
        lentilSoupRecipe.setDirections("In a soup pot over medium heat, heat the olive oil. Once the oil shimmers, add the onions and cook, stirring occasionally for 10 minutes, or until deep, golden brown. " +
                "Push the onions to the side of the pot. And in the space you made, add the tomato paste. Stir for 2 to 3 minutes, or until the tomato paste darkens to a ruddy brown. Add the thyme, garlic, celery, and carrots. Cook and stir for 2 minutes. " +
                "Add the lentils, 8 cups water, soy sauce, salt and pepper to the pot. Adjust the heat to medium, so the soup is just at a gentle simmer. Simmer for 55 to 60 minutes, or until the lentils are soft. " +
                " Scoop out 2 cups of the soup and purée it in a blender until smooth, or use an immersion blender and purée just until the soup takes on a little body and thickens, but you still have texture. Return the blended soup to the pot and stir in the lemon juice. Add the sliced kale and simmer until the kale softens, about 1 to 2 minutes.\n" +
                "\n" +
                "Taste, and add more salt, pepper, and lemon juice, if you like. Serve with a nice slice of crusty bread or a side salad. ");
        lentilSoupRecipe.setDifficulty(Difficulty.MODERATE);
        lentilSoupRecipe.setNotes(lentilSoupNote);
        lentilSoupNote.setRecipe(lentilSoupRecipe);
        lentilSoupRecipe.addIngredients(new Ingredient("olive oil",new BigDecimal(2),tableSpoon));
        lentilSoupRecipe.addIngredients(new Ingredient("yellow onion, finely diced",new BigDecimal(1),large));
        lentilSoupRecipe.addIngredients(new Ingredient("tomato paste",new BigDecimal(2),tableSpoon));
        lentilSoupRecipe.addIngredients(new Ingredient("dried thyme",new BigDecimal(1),teaSpoon));
        lentilSoupRecipe.addIngredients(new Ingredient("garlic, finely diced",new BigDecimal(1),clove));
        lentilSoupRecipe.addIngredients(new Ingredient("celery, finely diced",new BigDecimal(1),stalk));
        lentilSoupRecipe.addIngredients(new Ingredient("carrots, peeled and finely diced",new BigDecimal(3),each));
        lentilSoupRecipe.addIngredients(new Ingredient("small green French lentils",new BigDecimal(12),ounce));
        lentilSoupRecipe.addIngredients(new Ingredient("water or vegetable stock",new BigDecimal(8),cup));
        lentilSoupRecipe.addIngredients(new Ingredient("low-sodium soy sauce",new BigDecimal(1),tableSpoon));
        lentilSoupRecipe.addIngredients(new Ingredient("salt, plus more to taste", BigDecimal.valueOf(1.5),teaSpoon));
        lentilSoupRecipe.addIngredients(new Ingredient("pepper, plus more to taste", BigDecimal.valueOf(.125),teaSpoon));
        lentilSoupRecipe.addIngredients(new Ingredient("lemon juice, plus more to taste",new BigDecimal(3),tableSpoon));
        lentilSoupRecipe.addIngredients(new Ingredient("kale, stemmed and thinly sliced crosswise", BigDecimal.valueOf(.5),bunch));

        recipes.add(lentilSoupRecipe);

        return recipes;

    }
}
