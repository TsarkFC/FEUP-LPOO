public class StringCaseChanger implements StringTransformer{
    public void execute(StringDrink drink){
        String ret = "";
        String text = drink.getText();
        for (int i = 0; i < text.length(); i++){
            if (Character.isLowerCase(text.charAt(i))){
                ret += Character.toUpperCase(text.charAt(i));
            }
            else{
                ret += Character.toLowerCase(text.charAt(i));
            }
        }
        drink.setText(ret);
    }

    @Override
    public void undo(StringDrink drink) {
        execute(drink);
    }
}
