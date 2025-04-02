package dev.cheercode.connectfour;

import dev.cheercode.connectfour.game.ResultAnalyzer;
import dev.cheercode.connectfour.models.Disk;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ResultAnalyzerTests {
    private ResultAnalyzer resultAnalyzer;
    private int countToVictory;

    @BeforeEach
    public void init() {
        this.resultAnalyzer = new ResultAnalyzer();
        this.countToVictory = 4;
    }

    @Test
    public void checkTestcase01() {
        String templateFilePath = "src/test/java/dev/cheercode/connectfour/grid_templates/template01.txt";
        Disk[][] grid = GridFactory.create(templateFilePath);
        assertTrue(resultAnalyzer.hasWinner(grid, countToVictory));
    }

    @Test
    public void checkTestcase02() {
        String templateFilePath = "src/test/java/dev/cheercode/connectfour/grid_templates/template02.txt";
        Disk[][] grid = GridFactory.create(templateFilePath);
        assertTrue(resultAnalyzer.hasWinner(grid, countToVictory));
    }

    @Test
    public void checkTestcase03() {
        String templateFilePath = "src/test/java/dev/cheercode/connectfour/grid_templates/template03.txt";
        Disk[][] grid = GridFactory.create(templateFilePath);
        assertTrue(resultAnalyzer.hasWinner(grid, countToVictory));
    }

    @Test
    public void checkTestcase04() {
        String templateFilePath = "src/test/java/dev/cheercode/connectfour/grid_templates/template04.txt";
        Disk[][] grid = GridFactory.create(templateFilePath);
        assertTrue(resultAnalyzer.hasWinner(grid, countToVictory));
    }

    @Test
    public void checkTestcase05() {
        String templateFilePath = "src/test/java/dev/cheercode/connectfour/grid_templates/template05.txt";
        Disk[][] grid = GridFactory.create(templateFilePath);
        assertTrue(resultAnalyzer.hasWinner(grid, countToVictory));
    }

    @Test
    public void checkTestcase06() {
        String templateFilePath = "src/test/java/dev/cheercode/connectfour/grid_templates/template06.txt";
        Disk[][] grid = GridFactory.create(templateFilePath);
        assertTrue(resultAnalyzer.hasWinner(grid, countToVictory));
    }

    @Test
    public void checkTestcase07() {
        String templateFilePath = "src/test/java/dev/cheercode/connectfour/grid_templates/template07.txt";
        Disk[][] grid = GridFactory.create(templateFilePath);
        assertTrue(resultAnalyzer.hasWinner(grid, countToVictory));
    }

    @Test
    public void checkTestcase08() {
        String templateFilePath = "src/test/java/dev/cheercode/connectfour/grid_templates/template08.txt";
        Disk[][] grid = GridFactory.create(templateFilePath);
        assertFalse(resultAnalyzer.hasWinner(grid, countToVictory));
    }

    @Test
    public void checkTestcase09() {
        String templateFilePath = "src/test/java/dev/cheercode/connectfour/grid_templates/template09.txt";
        Disk[][] grid = GridFactory.create(templateFilePath);
        assertTrue(resultAnalyzer.hasWinner(grid, countToVictory));
    }

    @Test
    public void checkTestcase10() {
        String templateFilePath = "src/test/java/dev/cheercode/connectfour/grid_templates/template10.txt";
        Disk[][] grid = GridFactory.create(templateFilePath);
        assertTrue(resultAnalyzer.hasWinner(grid, countToVictory));
    }

    @Test
    public void checkTestcase11() {
        String templateFilePath = "src/test/java/dev/cheercode/connectfour/grid_templates/template11.txt";
        Disk[][] grid = GridFactory.create(templateFilePath);
        assertTrue(resultAnalyzer.hasWinner(grid, countToVictory));
    }

    @Test
    public void checkTestcase12() {
        String templateFilePath = "src/test/java/dev/cheercode/connectfour/grid_templates/template12.txt";
        Disk[][] grid = GridFactory.create(templateFilePath);
        assertTrue(resultAnalyzer.hasWinner(grid, countToVictory));
    }

    @Test
    public void checkTestcase13() {
        String templateFilePath = "src/test/java/dev/cheercode/connectfour/grid_templates/template13.txt";
        Disk[][] grid = GridFactory.create(templateFilePath);
        assertTrue(resultAnalyzer.hasWinner(grid, countToVictory));
    }

    @Test
    public void checkTestcase14() {
        String templateFilePath = "src/test/java/dev/cheercode/connectfour/grid_templates/template14.txt";
        Disk[][] grid = GridFactory.create(templateFilePath);
        assertTrue(resultAnalyzer.hasWinner(grid, countToVictory));
    }

    @Test
    public void checkTestcase15() {
        String templateFilePath = "src/test/java/dev/cheercode/connectfour/grid_templates/template15.txt";
        Disk[][] grid = GridFactory.create(templateFilePath);
        assertFalse(resultAnalyzer.hasWinner(grid, countToVictory));
    }
}
