import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Random;

public class Monster extends Element {
    public Monster(int x, int y){
        super(x, y);
    }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FF0000"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "M");
    }

    public Position move(Position position){
        Random random = new Random();
        Position pos = new Position(position.getX(), position.getY());
        int next = random.nextInt(5);

        switch (next){
            case 1:
                pos.setY(pos.getY()+1);
                break;
            case 2:
                pos.setY(pos.getY()-1);
                break;
            case 3:
                pos.setX(pos.getX()+1);
                break;
            case 4:
                pos.setX(pos.getX()-1);
                break;
        }
        return pos;
    }
}
