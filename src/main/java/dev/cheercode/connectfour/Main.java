package dev.cheercode.connectfour;

import dev.cheercode.connectfour.game.Game;
import dev.cheercode.connectfour.game.ResultAnalyzer;
import dev.cheercode.connectfour.models.Disk;
import dev.cheercode.connectfour.models.players.Player;
import dev.cheercode.connectfour.models.players.RealPlayer;
import dev.cheercode.connectfour.renders.ConsoleRender;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Player firstPlayer = new RealPlayer("FirstPlayer", Disk.BLUE);
        Player secondPlayer = new RealPlayer("SecondPlayer", Disk.RED);
        Queue<Player> players = new ArrayDeque<>(List.of(firstPlayer, secondPlayer));
        int connectCountToVictory = 4;
        Game game = new Game(players, new ConsoleRender(), new ResultAnalyzer(), connectCountToVictory);
        game.start();
    }
}