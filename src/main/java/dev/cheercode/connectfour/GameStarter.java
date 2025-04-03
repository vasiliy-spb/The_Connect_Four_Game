package dev.cheercode.connectfour;

import dev.cheercode.connectfour.factories.MenuFactory;
import dev.cheercode.connectfour.factories.StartMenuFactory;
import dev.cheercode.connectfour.menu.Menu;

public class GameStarter {
    public void start() {
        MenuFactory menuFactory = new StartMenuFactory();
        Menu menu = menuFactory.create();
        menu.display();
        menu.select();
    }
}
