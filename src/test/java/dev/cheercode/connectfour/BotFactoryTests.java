package dev.cheercode.connectfour;

import dev.cheercode.connectfour.factories.players.BotFactory;
import dev.cheercode.connectfour.models.Color;
import dev.cheercode.connectfour.models.players.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BotFactoryTests {
    private BotFactory botFactory;

    @BeforeEach
    public void init() {
        this.botFactory = new BotFactory();
    }

    @Test
    public void checkTestcase01() {
        Player bot1 = botFactory.create();
        Player bot2 = botFactory.create();
        assertTrue(bot1.getColor() != bot2.getColor() && bot1.getColor() != Color.WHITE);
    }

    @Test
    public void checkTestcase02() {
        try {
            int count = Color.values().length - 1;
            while (count-- > 0) {
                botFactory.create();
            }
            assertTrue(true);
        } catch (RuntimeException e) {
            assertTrue(false);
        }
    }

    @Test
    public void checkTestcase03() {
        try {
            int count = Color.values().length;
            while (count-- > 0) {
                botFactory.create();
            }
            assertTrue(false);
        } catch (RuntimeException e) {
            assertTrue(true);

        }
    }

    @Test
    public void checkTestcase04() {
        try {
            Set<Player> players = new HashSet<>();
            Set<Color> colors = new HashSet<>();
            int count = Color.values().length - 1;
            while (count-- > 0) {
                Player bot = botFactory.create();
                players.add(bot);
                colors.add(bot.getColor());
            }
            assertTrue(players.size() == colors.size());
        } catch (RuntimeException e) {
            assertTrue(false);
        }
    }
}
