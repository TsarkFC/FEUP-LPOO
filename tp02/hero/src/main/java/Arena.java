import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private int width, height;

    Hero hero = new Hero(10, 10);

    private List<Wall> walls;

    private List<Coin> coins;

    private List<Monster> monsters;

    public Arena(int width, int height){
        this.height = height;
        this.width = width;
        this.walls = createWalls();
        this.coins = createCoins();
        this.monsters = createMonsters();
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }

        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }

        return walls;
    }

    private List<Monster> createMonsters(){
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Position check = new Position(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1);

            while (!checkMonster(check, monsters)) {
                check = new Position(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1);
            }

            monsters.add(new Monster(check.getX(), check.getY()));
        }
        return monsters;
    }

    public int getWitdth() {
        return width;
    }

    public void setWitdth(int witdth) {
        this.width = witdth;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void processKey(KeyStroke key) {
        System.out.println(key);

        switch (key.getKeyType()) {
            case ArrowUp:
                moveHero(hero.moveUp());
                moveMonster();
                break;
            case ArrowDown:
                moveHero(hero.moveDown());
                moveMonster();
                break;
            case ArrowRight:
                moveHero(hero.moveRight());
                moveMonster();
                break;
            case ArrowLeft:
                moveHero(hero.moveLeft());
                moveMonster();
                break;
        }
    }

    public void draw(TextGraphics graphics) throws IOException {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        hero.draw(graphics);

        for (Wall wall : walls) wall.draw(graphics);
        for (Coin coin : coins) coin.draw(graphics);
        for (Monster monster : monsters) monster.draw(graphics);
    }

    public void moveHero(Position position) {
        if (canHeroMove(position)) {
            hero.setPosition(position);
        }
    }

    public boolean canHeroMove(Position position) {
        if (position.getX() >= this.getWitdth() || position.getY() >= this.getHeight()) return false;
        else if (position.getX() <= 0 || position.getY() <= 0) return false;
        else {
            for (Wall wall:walls) if (wall.getPosition().equals(position)) return false;
            retrieveCoins(position);
        }
        return true;
    }

    public void retrieveCoins(Position position){
        int index = 0;
        for (Coin coin:coins) {
            if (coin.getPosition().equals(position)) {
                coins.remove(index);
                return;
            }
            index++;
        }
    }

    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Position check = new Position(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1);

            while (!checkCoins(check, coins)) {
                check = new Position(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1);
            }

            coins.add(new Coin(check.getX(), check.getY()));
        }
        return coins;
    }

    private boolean checkCoins(Position position, List<Coin> coins){
        if (coins.size() == 0) return true;
        for (Coin coin : coins){
            if (coin.getPosition().equals(position)) return false;
        }
        if (hero.getPosition().equals(position)) return false;

        return true;
    }

    private boolean checkMonster(Position position, List<Monster> monsters){
        for (Monster monster : monsters){
            if (monster.getPosition().equals(position)) return false;
        }
        for (Coin coin:coins){
            if (coin.getPosition().equals(position)) return false;
        }
        if (hero.getPosition().equals(position)) return false;
        else if (position.getY() >= height || position.getX() >= width || position.getX() <= 0 || position.getY() <= 0) return false;
        else{
            for (Wall wall:walls) if (wall.getPosition().equals(position)) return false;
        }
        return true;
    }

    private void moveMonster(){
        for (Monster monster : monsters){
            Position pos = monster.move(monster.getPosition());
            if (checkMonster(pos, monsters)) monster.setPosition(pos);
        }
    }

    public boolean verifyMonsterCollisions(){
        for (Monster monster : monsters){
            if (monster.position.equals(hero.getPosition())){
                System.out.println("YOU LOST!");
                return true;
            }
        }
        return false;
    }
}
