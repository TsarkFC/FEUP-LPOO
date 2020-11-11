import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private Screen screen;

    Arena arena = new Arena(50, 15);

    TextGraphics graphics;

    public Game() {
        try {
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            screen = new TerminalScreen(terminal);

            graphics = screen.newTextGraphics();

            screen.setCursorPosition(null);   // we don't need a cursor
            screen.startScreen();             // screens must be started
            screen.doResizeIfNecessary();     // resize screen if necessary


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void draw() throws IOException {
        screen.clear();
        arena.draw(screen.newTextGraphics());
        screen.refresh();
    }

    public void run() throws IOException {
        while(true) {
            draw();

            KeyStroke key = null;

            try {
                key = screen.readInput();
                processKey(key);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (arena.verifyMonsterCollisions()) screen.close();

            if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') {
                try {
                    screen.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (arena.verifyMonsterCollisions()) screen.close();
            if (key.getKeyType() == KeyType.EOF) break;
        }
    }

    private void processKey(KeyStroke key) {
        arena.processKey(key);
    }
}
