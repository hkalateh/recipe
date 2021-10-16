package ir.kalateh.recipe.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "category")
@Entity
public class Category implements Serializable {
    
    @Id
    @GeneratedValue
    private Long id;
    
    private String description;
    
    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes;
    
    
}
