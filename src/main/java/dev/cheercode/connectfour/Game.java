package dev.cheercode.connectfour;

import java.util.Queue;

public class Game {
    private static final String WELCOME_MESSAGE = """
            ====================================================================================
                                                ИГРА 4 В РЯД
            ====================================================================================
            """;
    private final Board board;
    private final Queue<Player> players;
    private final Render render;
    private final ResultAnalyzer resultAnalyzer;

    public Game(Queue<Player> players, Render render, ResultAnalyzer resultAnalyzer) {
        this.board = StandardBoardFactory.create();
        this.players = players;
        this.render = render;
        this.resultAnalyzer = resultAnalyzer;
    }

    public void start() {
        System.out.println(WELCOME_MESSAGE);
        render.display(board.getGrid());
        while (!isGameOver()) {
            Player player = players.poll();
            nextTurn(player);
            players.offer(player);
            if (resultAnalyzer.hasWinner(board.getGrid())) {
                System.out.printf("Победил игрок: %s\n", player.getName());
            }
        }
        if (!resultAnalyzer.hasWinner(board.getGrid())) {
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

        render.display(board.getGrid());

        if (resultAnalyzer.hasWinner(board.getGrid())) {
            System.out.printf("Победил игрок: %s\n", player.getName());
        }
    }

    private boolean isFilled(int columnNumber) {
        int columnIndex = columnNumber - 1;
        return board.isFilled(columnIndex);
    }

    private boolean isGameOver() {
        return resultAnalyzer.hasWinner(board.getGrid()) || board.isFull();
    }
}
