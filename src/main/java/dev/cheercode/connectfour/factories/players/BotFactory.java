package dev.cheercode.connectfour.factories.players;

import dev.cheercode.connectfour.models.Disk;
import dev.cheercode.connectfour.models.players.Player;
import dev.cheercode.connectfour.models.players.RandomBot;

import java.util.HashSet;
import java.util.Set;

public class BotFactory implements PlayerFactory {
    private final Set<Disk> usedDisks = new HashSet<>();

    public BotFactory() {
        usedDisks.add(Disk.EMPTY);
    }

    @Override
    public Player create() {
        Disk[] disks = Disk.values();
        if (usedDisks.size() >= disks.length) {
            throw new RuntimeException("Cannot create new bot: not disks enough.");
        }
        Disk disk = disks[usedDisks.size() - 1];
        String name = disk.name() + "_Bot";
        usedDisks.add(disk);
        return new RandomBot(name, disk);
    }
}
