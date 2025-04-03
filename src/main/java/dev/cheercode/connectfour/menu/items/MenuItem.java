package dev.cheercode.connectfour.menu.items;

import dev.cheercode.connectfour.menu.actions.Action;

public class MenuItem {
    private final String title;
    private final ItemsKey key;
    private final Action action;

    public MenuItem(String title, ItemsKey key, Action action) {
        this.title = title;
        this.key = key;
        this.action = action;
    }

    public String getTitle() {
        return title;
    }

    public ItemsKey getKey() {
        return key;
    }

    public void execute() {
        action.perform();
    }
}
