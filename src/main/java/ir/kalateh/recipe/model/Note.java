package ir.kalateh.recipe.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "notes")
@Entity
public class Note implements Serializable {
    
    @Id
    @Column(name = "recipe_id")
    private Long id;
    
    @OneToOne
    @MapsId
    @JoinColumn(name = "recipe_id", referencedColumnName = "id")
    private Recipe recipe;
    
    @Lob
    @Column(name = "recipe_note")
    private String recipeNote;

}
