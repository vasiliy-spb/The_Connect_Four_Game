package dev.cheercode.connectfour.factories.players;

import dev.cheercode.connectfour.models.Color;
import dev.cheercode.connectfour.models.players.Player;
import dev.cheercode.connectfour.models.players.RandomBot;

import java.util.HashSet;
import java.util.Set;

public class BotFactory implements PlayerFactory {
    private final Set<Color> usedColors = new HashSet<>();

    public BotFactory() {
        usedColors.add(Color.NEUTRAL);
    }

    @Override
    public Player create() {
        Color[] colors = Color.values();
        if (usedColors.size() >= colors.length) {
            throw new RuntimeException("Cannot create new bot: not colors enough.");
        }
        Color color = colors[usedColors.size() - 1];
        String name = color.name() + "_Bot";
        usedColors.add(color);
        return new RandomBot(name, color);
    }
}
