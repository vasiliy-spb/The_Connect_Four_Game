package dev.cheercode.connectfour;

public class Player {
    private final String name;
    private final Disk disk;

    public Player(String name, Disk disk) {
        this.name = name;
        this.disk = disk;
    }

    public String getName() {
        return name;
    }

    public Disk getDisk() {
        return disk;
    }
}
