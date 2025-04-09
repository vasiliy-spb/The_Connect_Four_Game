package dev.cheercode.connectfour;

import dev.cheercode.connectfour.factories.StandardBoardFactory;
import dev.cheercode.connectfour.models.Board;
import dev.cheercode.connectfour.models.Color;
import dev.cheercode.connectfour.renders.ConsoleRender;
import dev.cheercode.connectfour.renders.Render;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardTests {
    private Board board;
    private static Render render;

    @BeforeAll
    public static void initRender() {
        render = new ConsoleRender();
    }

    @BeforeEach
    public void init() {
        this.board = StandardBoardFactory.create();
    }

    @Test
    @DisplayName("All columns are available on empty board")
    public void checkTestcase01() {
        int width = board.getWidth();
        boolean allColumnsAreAvailable = true;
        for (int column = 0; column < width; column++) {
            allColumnsAreAvailable &= !board.isFilled(column);
        }
        render.display(board.getGrid());
        assertTrue(allColumnsAreAvailable);
    }

    @Test
    @DisplayName("isFilled(int column) method throws exception for negative column index")
    public void checkTestcase02() {
        int negativeColumnIndex = -1;
        try {
            board.isFilled(negativeColumnIndex);
            assertTrue(false);
        } catch (IndexOutOfBoundsException e) {
            assertTrue(true);
        }
    }

    @Test
    @DisplayName("isFilled(int column) method throws exception for out of bound column index")
    public void checkTestcase03() {
        int outOfBoundColumnIndex = board.getWidth();
        try {
            board.isFilled(outOfBoundColumnIndex);
            assertTrue(false);
        } catch (IndexOutOfBoundsException e) {
            assertTrue(true);
        }
    }

    @Test
    @DisplayName("isFilled(int column) method accept bottom bound column index")
    public void checkTestcase04() {
        int bottomBoundColumnIndex = 0;
        try {
            board.isFilled(bottomBoundColumnIndex);
            render.display(board.getGrid());
            assertTrue(true);
        } catch (IndexOutOfBoundsException e) {
            assertTrue(false);
        }
    }

    @Test
    @DisplayName("isFilled(int column) method accept upper bound column index")
    public void checkTestcase05() {
        int upperBoundColumnIndex = board.getWidth() - 1;
        try {
            board.isFilled(upperBoundColumnIndex);
            render.display(board.getGrid());
            assertTrue(true);
        } catch (IndexOutOfBoundsException e) {
            assertTrue(false);
        }
    }

    @Test
    @DisplayName("isFilled(int column) return correct answer for filled column")
    public void checkTestcase06() {
        Random random = new Random();
        int columnIndex = random.nextInt(board.getWidth());
        Color tempColor = Color.RED;
        for (int i = 0; i < board.getGrid().length; i++) {
            board.put(tempColor, columnIndex);
        }
        render.display(board.getGrid());
        try {
            assertTrue(board.isFilled(columnIndex));
        } catch (RuntimeException e) {
            assertTrue(false);
        }
    }

    @Test
    @DisplayName("isFilled(int column) return correct answer for almost filled column")
    public void checkTestcase07() {
        Random random = new Random();
        int columnIndex = random.nextInt(board.getWidth());
        Color tempColor = Color.RED;
        for (int i = 1; i < board.getGrid().length; i++) {
            board.put(tempColor, columnIndex);
        }
        render.display(board.getGrid());
        try {
            assertFalse(board.isFilled(columnIndex));
        } catch (RuntimeException e) {
            assertTrue(false);
        }
    }

    @Test
    @DisplayName("isFilled(int column) return correct answer for almost empty column")
    public void checkTestcase08() {
        Random random = new Random();
        int columnIndex = random.nextInt(board.getWidth());
        Color tempColor = Color.RED;
        board.put(tempColor, columnIndex);
        render.display(board.getGrid());
        try {
            assertFalse(board.isFilled(columnIndex));
        } catch (RuntimeException e) {
            assertTrue(false);
        }
    }

    @Test
    @DisplayName("isFull() return correct answer for not full grid")
    public void checkTestcase09() {
        Random random = new Random();
        int emptyIndex = random.nextInt(board.getWidth());
        Color tempColor = Color.RED;
        for (int row = 0; row < board.getGrid().length; row++) {
            for (int column = 0; column < board.getWidth(); column++) {
                if (row == 0 && column == emptyIndex) {
                    continue;
                }
                board.put(tempColor, column);
            }
        }
        render.display(board.getGrid());
        assertFalse(board.isFull());
    }

    @Test
    @DisplayName("isFull() return correct answer for full grid")
    public void checkTestcase10() {
        Color tempColor = Color.RED;
        for (int row = 0; row < board.getGrid().length; row++) {
            for (int column = 0; column < board.getWidth(); column++) {
                board.put(tempColor, column);
            }
        }
        render.display(board.getGrid());
        assertTrue(board.isFull());
    }

    @Test
    @DisplayName("isFull() throws exception when trying to put color into full grid")
    public void checkTestcase11() {
        Color tempColor = Color.RED;
        for (int row = 0; row < board.getGrid().length; row++) {
            for (int column = 0; column < board.getWidth(); column++) {
                board.put(tempColor, column);
            }
        }
        render.display(board.getGrid());
        Random random = new Random();
        int additionalIndex = random.nextInt(board.getWidth());
        try {
            board.put(tempColor, additionalIndex);
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }
}
