import java.util.ArrayList;
import java.util.List;

public class SmartStrategy  implements  OrderingStrategy{
    private List<StringDrink> drinks;
    private List<StringRecipe> recipes;

    public SmartStrategy(){
        drinks = new ArrayList<>();
        recipes = new ArrayList<>();
    }

    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar){
        if (bar.happyHour) {
            bar.order(drink, recipe);
        }
        else {
            drinks.add(drink);
            recipes.add(recipe);
        }
    }
    public void happyHourStarted(StringBar bar){
        if (drinks.size() != 0) {
            for (int i = 0; i < drinks.size(); i++) {
                bar.order(drinks.get(i), recipes.get(i));
            }
        }
    }
    public void happyHourEnded(StringBar bar){}
}
