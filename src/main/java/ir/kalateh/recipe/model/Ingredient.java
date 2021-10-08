package ir.kalateh.recipe.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Table(name = "Ingredient")
@Entity
public class Ingredient implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String description;
    private BigDecimal amount;
    @ManyToOne
    private Recipe recipe;
}
