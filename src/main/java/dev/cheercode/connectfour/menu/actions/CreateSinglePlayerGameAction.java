package dev.cheercode.connectfour.menu.actions;

import dev.cheercode.connectfour.factories.players.BotFactory;
import dev.cheercode.connectfour.factories.players.PlayerFactory;
import dev.cheercode.connectfour.factories.players.RealPlayerFactory;
import dev.cheercode.connectfour.user_input_readers.ConsoleUserInputReader;
import dev.cheercode.connectfour.game.Game;
import dev.cheercode.connectfour.game.ResultAnalyzer;
import dev.cheercode.connectfour.models.players.Player;
import dev.cheercode.connectfour.renders.ConsoleRender;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class CreateSinglePlayerGameAction implements Action {
    @Override
    public void perform() {
        PlayerFactory playerFactory = new RealPlayerFactory(ConsoleUserInputReader.getInstance());
        Player player = playerFactory.create();
        PlayerFactory botFactory = new BotFactory();
        if (player.getColor().ordinal() == 0) {
            botFactory.create();
        }
        Player bot = botFactory.create();

        Queue<Player> players = new ArrayDeque<>(List.of(player, bot));
        int connectCountToVictory = 4;
        Game game = new Game(players, new ConsoleRender(), new ResultAnalyzer(), connectCountToVictory);
        game.start();
    }
}
