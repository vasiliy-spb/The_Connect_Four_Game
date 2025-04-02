package dev.cheercode.connectfour;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Player yellowPlayer = new Player("yellowPlayer", Disk.BLUE);
        Player redPlayer = new Player("redPlayer", Disk.RED);
        Queue<Player> players = new ArrayDeque<>(List.of(yellowPlayer, redPlayer));
        Game game = new Game(players, new ConsoleRender(), new ResultAnalyzer());
        game.start();
    }
}