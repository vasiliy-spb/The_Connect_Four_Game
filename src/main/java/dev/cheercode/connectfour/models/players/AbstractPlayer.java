package dev.cheercode.connectfour.models.players;

import dev.cheercode.connectfour.models.Disk;

public abstract class AbstractPlayer implements Player {
    protected final String name;
    private final Disk disk;

    public AbstractPlayer(String name, Disk disk) {
        this.name = name;
        this.disk = disk;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Disk getDisk() {
        return disk;
    }
}
