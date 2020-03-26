public class StringReplacer implements StringTransformer{
    private char actual;
    private char change;

    public StringReplacer(char actual, char change){
        this.actual = actual;
        this.change = change;
    }

    public void execute(StringDrink drink){
        String ret = "";
        String text = drink.getText();
        for (int i = 0; i < text.length(); i++){
            if (actual == text.charAt(i)) ret += change;
            else ret += text.charAt(i);
        }
        drink.setText(ret);
    }
}
