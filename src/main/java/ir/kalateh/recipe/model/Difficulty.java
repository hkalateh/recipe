package ir.kalateh.recipe.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Difficulty {
    
    EASY(0, "EASY", "آسان"),
    MODERATE(1, "MODERATE", "معمولی"),
    HARD(2, "HARD", "سخت");
    
    private final Integer index;
    private final String title;
    private final String persianTitle;
    
    public static Difficulty valueOfIndex(Integer index) {
        for (Difficulty difficulty : values()) {
            if (difficulty.getIndex().equals(index))
                return difficulty;
        }
        return null;
    }
}