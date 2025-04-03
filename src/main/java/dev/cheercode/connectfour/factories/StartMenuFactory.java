package dev.cheercode.connectfour.factories;

import dev.cheercode.connectfour.menu.Menu;
import dev.cheercode.connectfour.menu.StartMenu;
import dev.cheercode.connectfour.menu.actions.CreateOnlyBotsGameAction;
import dev.cheercode.connectfour.menu.actions.CreateSinglePlayerGameAction;
import dev.cheercode.connectfour.menu.actions.CreateTwoPlayersGameAction;
import dev.cheercode.connectfour.menu.items.ItemsKey;
import dev.cheercode.connectfour.menu.items.MenuItem;

import java.util.List;

public class StartMenuFactory implements MenuFactory {
    @Override
    public Menu create() {
        String title = "=== СТАРТОВОЕ МЕНЮ ===";
        List<MenuItem> items = List.of(
                new MenuItem("Один игрок", ItemsKey.SINGLE_PLAYER, new CreateSinglePlayerGameAction()),
                new MenuItem("Два игрока", ItemsKey.TWO_PLAYERS, new CreateTwoPlayersGameAction()),
                new MenuItem("Игра ботов", ItemsKey.ONLY_BOTS, new CreateOnlyBotsGameAction())
        );
        Menu menu = new StartMenu(title, items);
        return menu;
    }
}
