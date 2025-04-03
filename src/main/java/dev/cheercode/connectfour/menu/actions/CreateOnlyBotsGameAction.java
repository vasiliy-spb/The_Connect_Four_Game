package dev.cheercode.connectfour.menu.actions;

import dev.cheercode.connectfour.game.Game;
import dev.cheercode.connectfour.game.ResultAnalyzer;
import dev.cheercode.connectfour.factories.players.BotFactory;
import dev.cheercode.connectfour.factories.players.PlayerFactory;
import dev.cheercode.connectfour.models.players.Player;
import dev.cheercode.connectfour.renders.ConsoleRender;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class CreateOnlyBotsGameAction implements Action {
    @Override
    public void perform() {
        PlayerFactory playerFactory = new BotFactory();
        Player firstBot = playerFactory.create();
        Player secondBot = playerFactory.create();
        Queue<Player> players = new ArrayDeque<>(List.of(firstBot, secondBot));
        int connectCountToVictory = 4;
        Game game = new Game(players, new ConsoleRender(), new ResultAnalyzer(), connectCountToVictory);
        game.start();
    }
}
