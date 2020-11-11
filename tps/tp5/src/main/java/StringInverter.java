public class StringInverter implements StringTransformer{
    public void execute(StringDrink drink){
        StringBuffer build = new StringBuffer();
        build.append(drink.getText());
        drink.setText(build.reverse().toString());
    }

    @Override
    public void undo(StringDrink drink) {
        execute(drink);
    }
}
