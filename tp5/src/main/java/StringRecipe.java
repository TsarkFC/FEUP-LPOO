import java.util.List;

public class StringRecipe {
    private List<StringTransformer> trans;

    public List<StringTransformer> getTrans() {
        return trans;
    }

    public void setTrans(List<StringTransformer> trans) {
        this.trans = trans;
    }

    public StringRecipe(List<StringTransformer> trans){
        this.trans = trans;
    }

    public void mix(StringDrink drink){
        for (StringTransformer st : trans){
            st.execute(drink);
        }
    }
}
