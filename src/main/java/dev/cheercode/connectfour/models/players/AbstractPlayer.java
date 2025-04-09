package dev.cheercode.connectfour.models.players;

import dev.cheercode.connectfour.models.Color;

public abstract class AbstractPlayer implements Player {
    protected final String name;
    private final Color color;

    public AbstractPlayer(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Color getColor() {
        return color;
    }
}
