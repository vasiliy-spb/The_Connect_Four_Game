package dev.cheercode.connectfour.game;

import dev.cheercode.connectfour.factories.StandardBoardFactory;
import dev.cheercode.connectfour.models.Board;
import dev.cheercode.connectfour.models.Disk;
import dev.cheercode.connectfour.models.players.Player;
import dev.cheercode.connectfour.renders.Render;

import java.util.Queue;

public class Game {
    private static final String WELCOME_MESSAGE_TEMPLATE = """
            ====================================================================================
                                                ИГРА %s В РЯД
            ====================================================================================
            """;
    private final int connectCountToVictory;
    private final String welcomeMessage;
    private final Board board;
    private final Queue<Player> players;
    private final Render render;
    private final ResultAnalyzer resultAnalyzer;

    public Game(Queue<Player> players, Render render, ResultAnalyzer resultAnalyzer, int connectCountToVictory) {
        this.board = StandardBoardFactory.create();
        this.players = players;
        this.render = render;
        this.resultAnalyzer = resultAnalyzer;
        this.connectCountToVictory = connectCountToVictory;
        this.welcomeMessage = WELCOME_MESSAGE_TEMPLATE.formatted(connectCountToVictory);
    }

    public void start() {
        System.out.println(welcomeMessage);
        render.display(board.getGrid());
        Player player = players.peek();
        while (!isGameOver()) {
            player = players.poll();
            nextTurn(player);
            render.display(board.getGrid());
            players.offer(player);
        }
        showGameResult(player);
    }

    private void showGameResult(Player player) {
        System.out.println("——— Игра окончена ———");
        if (resultAnalyzer.hasWinner(board.getGrid(), connectCountToVictory)) {
            System.out.printf("Победил игрок: %s\n", player.getName());
        } else {
            System.out.println("— Ничья —");
        }
    }

    private void nextTurn(Player player) {
        int columnNumber = player.select(board);
        while (isFilled(columnNumber)) {
            System.out.println("Эта колонка заполнена.");
            columnNumber = player.select(board);
        }
        int columnIndex = columnNumber - 1;

        Disk playersDisk = player.getDisk();
        board.put(playersDisk, columnIndex);
    }

    private boolean isFilled(int columnNumber) {
        int columnIndex = columnNumber - 1;
        return board.isFilled(columnIndex);
    }

    private boolean isGameOver() {
        return resultAnalyzer.hasWinner(board.getGrid(), connectCountToVictory) || board.isFull();
    }
}
