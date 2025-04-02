package dev.cheercode.connectfour;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Player firstPlayer = new Player("FirstPlayer", Disk.BLUE);
        Player secondPlayer = new Player("SecondPlayer", Disk.RED);
        Queue<Player> players = new ArrayDeque<>(List.of(firstPlayer, secondPlayer));
        Game game = new Game(players, new ConsoleRender(), new ResultAnalyzer());
        game.start();
    }
}