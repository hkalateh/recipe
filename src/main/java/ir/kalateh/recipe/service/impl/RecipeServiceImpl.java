package ir.kalateh.recipe.service.impl;

import ir.kalateh.recipe.model.Recipe;
import ir.kalateh.recipe.repository.RecipeRepository;
import ir.kalateh.recipe.service.RecipeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<Recipe> getRecipes() {
        return recipeRepository.findAll();
    }
}
