import java.util.ArrayList;
import java.util.List;

public class StringBar extends Bar{
    public void order(StringDrink drink, StringRecipe recipe){
        recipe.mix(drink);
    }
    public void happyHourStarted(Bar bar){

    }
}
