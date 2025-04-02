package dev.cheercode.connectfour;

import dev.cheercode.connectfour.game.Game;
import dev.cheercode.connectfour.game.ResultAnalyzer;
import dev.cheercode.connectfour.models.Disk;
import dev.cheercode.connectfour.models.players.Player;
import dev.cheercode.connectfour.models.players.RandomBot;
import dev.cheercode.connectfour.renders.ConsoleRender;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class MainWithRandomBot {
    public static void main(String[] args) {
        Player firstBot = new RandomBot("Blue_Bot", Disk.BLUE);
        Player secondBot = new RandomBot("Red_Bot", Disk.RED);
        Queue<Player> players = new ArrayDeque<>(List.of(firstBot, secondBot));
        int connectCountToVictory = 4;
        Game game = new Game(players, new ConsoleRender(), new ResultAnalyzer(), connectCountToVictory);
        game.start();
    }
}
