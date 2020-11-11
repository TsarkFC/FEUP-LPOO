public class HumanClient implements Client{
    private OrderingStrategy strategy;

    public HumanClient(OrderingStrategy strategy){
        this.strategy = strategy;
    }

    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar){
        strategy.wants(drink, recipe, bar);
    }

    public void happyHourStarted(Bar bar){
        strategy.happyHourStarted((StringBar) bar);
    }

    public void happyHourEnded(Bar bar){
        strategy.happyHourEnded((StringBar) bar);
    }
}
