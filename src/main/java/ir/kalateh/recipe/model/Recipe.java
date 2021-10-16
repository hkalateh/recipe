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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "recipes")
@Entity
public class Recipe implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "prep_time")
    private Integer prepTime;
    
    @Column(name = "cook_time")
    private Integer cookTime;
    
    @Column(name = "servings")
    private Integer servings;
    
    @Column(name = "source")
    private String source;
    
    @Column(name = "url")
    private String url;
    
    @Column(name = "directions")
    private String directions;
    
    @Column(name = "image")
    @Lob
    private Byte[] image;
    
    @Enumerated
    @Column(columnDefinition = "smallint")
    private Difficulty difficulty;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "recipe")
    @PrimaryKeyJoinColumn
    private Note notes;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients;
    
    @ManyToMany
    @JoinTable(name = "recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
    private Set<Category> categories;
}
