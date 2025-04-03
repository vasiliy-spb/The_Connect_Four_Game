package dev.cheercode.connectfour;

import dev.cheercode.connectfour.factories.players.BotFactory;
import dev.cheercode.connectfour.models.Disk;
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
        assertTrue(bot1.getDisk() != bot2.getDisk() && bot1.getDisk() != Disk.EMPTY);
    }

    @Test
    public void checkTestcase02() {
        try {
            int count = Disk.values().length - 1;
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
            int count = Disk.values().length;
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
            Set<Disk> disks = new HashSet<>();
            int count = Disk.values().length - 1;
            while (count-- > 0) {
                Player bot = botFactory.create();
                players.add(bot);
                disks.add(bot.getDisk());
            }
            assertTrue(players.size() == disks.size());
        } catch (RuntimeException e) {
            assertTrue(false);
        }
    }
}
