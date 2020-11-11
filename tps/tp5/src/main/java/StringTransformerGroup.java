import java.util.List;

public class StringTransformerGroup implements StringTransformer{
    private List<StringTransformer> trans;

    public StringTransformerGroup(List<StringTransformer> trans){
        this.trans = trans;
    }

    public void execute(StringDrink drink){
        for (StringTransformer t : trans) t.execute(drink);
    }

    public void undo(StringDrink drink) { for (StringTransformer t : trans) t.undo(drink); }
}
