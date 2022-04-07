package ir.kalateh.recipe.repository;

import ir.kalateh.recipe.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
