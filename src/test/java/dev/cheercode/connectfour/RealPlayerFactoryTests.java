package dev.cheercode.connectfour;

import dev.cheercode.connectfour.user_input_readers.UserInputReader;
import dev.cheercode.connectfour.factories.players.PlayerFactory;
import dev.cheercode.connectfour.factories.players.RealPlayerFactory;
import dev.cheercode.connectfour.models.Color;
import dev.cheercode.connectfour.models.players.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class RealPlayerFactoryTests {

    @Test
    @DisplayName("Create player with correct name 1")
    public void checkTestcase01() {
        String name = "Igrok Moshchny";
        String color = "r";
        List<String> lines = List.of(name, color);
        UserInputReader reader = new FakeUserInputReader(lines);
        PlayerFactory factory = new RealPlayerFactory(reader);
        Player player = factory.create();

        assertEquals(name.trim(), player.getName());
    }

    @Test
    @DisplayName("Create player with correct name 2")
    public void checkTestcase02() {
        String name = "  Igrok Moshchny";
        String color = "r";
        List<String> lines = List.of(name, color);
        UserInputReader reader = new FakeUserInputReader(lines);
        PlayerFactory factory = new RealPlayerFactory(reader);
        Player player = factory.create();

        assertEquals(name.trim(), player.getName());
    }

    @Test
    @DisplayName("Create player with correct name 3")
    public void checkTestcase03() {
        String name = "Igrok Moshchny  ";
        String color = "r";
        List<String> lines = List.of(name, color);
        UserInputReader reader = new FakeUserInputReader(lines);
        PlayerFactory factory = new RealPlayerFactory(reader);
        Player player = factory.create();

        assertEquals(name.trim(), player.getName());
    }

    @Test
    @DisplayName("Create player with correct name 4")
    public void checkTestcase04() {
        String name = "  Igrok Moshchny  ";
        String color = "r";
        List<String> lines = List.of(name, color);
        UserInputReader reader = new FakeUserInputReader(lines);
        PlayerFactory factory = new RealPlayerFactory(reader);
        Player player = factory.create();

        assertEquals(name.trim(), player.getName());
    }

    @Test
    @DisplayName("Create player with correct color 1")
    public void checkTestcase05() {
        String name = "Igrok Moshchny";
        String color = "r";
        List<String> lines = List.of(name, color);
        UserInputReader reader = new FakeUserInputReader(lines);
        PlayerFactory factory = new RealPlayerFactory(reader);
        Player player = factory.create();

        assertEquals(Color.RED, player.getColor());
    }

    @Test
    @DisplayName("Create player with correct color 2")
    public void checkTestcase06() {
        String name = "Igrok Moshchny";
        String color = "b";
        List<String> lines = List.of(name, color);
        UserInputReader reader = new FakeUserInputReader(lines);
        PlayerFactory factory = new RealPlayerFactory(reader);
        Player player = factory.create();

        assertEquals(Color.BLUE, player.getColor());
    }

    @Test
    @DisplayName("Create player with correct color 3")
    public void checkTestcase07() {
        String name = "Igrok Moshchny";
        String color = "R";
        List<String> lines = List.of(name, color);
        UserInputReader reader = new FakeUserInputReader(lines);
        PlayerFactory factory = new RealPlayerFactory(reader);
        Player player = factory.create();

        assertEquals(Color.RED, player.getColor());
    }

    @Test
    @DisplayName("Create player with correct color 4")
    public void checkTestcase08() {
        String name = "Igrok Moshchny";
        String color = "B";
        List<String> lines = List.of(name, color);
        UserInputReader reader = new FakeUserInputReader(lines);
        PlayerFactory factory = new RealPlayerFactory(reader);
        Player player = factory.create();

        assertEquals(Color.BLUE, player.getColor());
    }

    @Test
    @DisplayName("Don't create two players with same name 1")
    public void checkTestcase09() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        String firstPlayerName = "Igrok Moshchny";
        String secondPlayerName = "Gamer Light";
        String color = "R";
        String input = "%s\n%s\n".formatted(firstPlayerName, color)
                + "%s\n%s\nb\n".formatted(firstPlayerName, secondPlayerName);
        String[] lineArray = input.split("\n");
        UserInputReader reader = new FakeUserInputReader(lineArray);
        PlayerFactory factory = new RealPlayerFactory(reader);

        factory.create();
        factory.create();

        String output = outputStream.toString();
        System.setOut(originalOut);

        assertTrue(output.contains("Уже есть игрок с таким именем."));
    }

    @Test
    @DisplayName("Don't create two players with same name 2")
    public void checkTestcase10() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        String firstPlayerName = "Igrok Moshchny";
        String secondPlayerName = "Gamer Light";
        String color = "R";
        String input = "%s\n%s\n".formatted(firstPlayerName, color)
                + "  %s\n%s\nb\n".formatted(firstPlayerName, secondPlayerName);
        String[] lineArray = input.split("\n");
        UserInputReader reader = new FakeUserInputReader(lineArray);
        PlayerFactory factory = new RealPlayerFactory(reader);

        factory.create();
        factory.create();

        String output = outputStream.toString();
        System.setOut(originalOut);

        assertTrue(output.contains("Уже есть игрок с таким именем."));
    }

    @Test
    @DisplayName("Don't create two players with same name 3")
    public void checkTestcase11() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        String firstPlayerName = "Igrok Moshchny";
        String secondPlayerName = "Gamer Light";
        String color = "R";
        String input = "%s\n%s\n".formatted(firstPlayerName, color)
                + "%s  \n%s\nb\n".formatted(firstPlayerName, secondPlayerName);
        String[] lineArray = input.split("\n");
        UserInputReader reader = new FakeUserInputReader(lineArray);
        PlayerFactory factory = new RealPlayerFactory(reader);

        factory.create();
        factory.create();

        String output = outputStream.toString();
        System.setOut(originalOut);

        assertTrue(output.contains("Уже есть игрок с таким именем."));
    }

    @Test
    @DisplayName("Don't create two players with same name 4")
    public void checkTestcase12() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        String firstPlayerName = "Igrok Moshchny";
        String secondPlayerName = "Gamer Light";
        String color = "R";
        String input = "%s\n%s\n".formatted(firstPlayerName, color)
                + "  %s   \n%s\nb\n".formatted(firstPlayerName, secondPlayerName);
        String[] lineArray = input.split("\n");
        UserInputReader reader = new FakeUserInputReader(lineArray);
        PlayerFactory factory = new RealPlayerFactory(reader);

        factory.create();
        factory.create();

        String output = outputStream.toString();
        System.setOut(originalOut);

        assertTrue(output.contains("Уже есть игрок с таким именем."));
    }

    @Test
    @DisplayName("Number of created players equals number of available colors")
    public void checkTestcase13() {
        final int count = Color.values().length - 1;
        String name = "Igrok Moshchny ";
        String[] colorKeys = {"r", "B"};

        assertEquals(count, colorKeys.length);

        StringBuilder inputBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            inputBuilder.append(name);
            inputBuilder.append(i + 1);
            inputBuilder.append("\n");
            inputBuilder.append(colorKeys[i]);
            inputBuilder.append("\n");
        }

        String[] lineArray = inputBuilder.toString().split("\n");
        UserInputReader reader = new FakeUserInputReader(lineArray);
        PlayerFactory factory = new RealPlayerFactory(reader);

        Set<Player> players = new HashSet<>();
        Set<Color> colors = new HashSet<>();

        try {
            for (int i = 0; i < count; i++) {
                Player player = factory.create();
                players.add(player);
                colors.add(player.getColor());
            }
            assertEquals(players.size(), colors.size());
            assertEquals(players.size(), count);
        } catch (RuntimeException e) {
            fail();
        }
    }

    @Test
    @DisplayName("Don't create more players then has available colors")
    public void checkTestcase14() {
        int count = Color.values().length - 1;
        String name = "Igrok Moshchny ";
        String[] colorKeys = {"r", "B"};

        StringBuilder inputBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            inputBuilder.append(name);
            inputBuilder.append(i + 1);
            inputBuilder.append("\n");
            inputBuilder.append(colorKeys[i]);
            inputBuilder.append("\n");
        }

        String[] lineArray = inputBuilder.toString().split("\n");
        UserInputReader reader = new FakeUserInputReader(lineArray);
        PlayerFactory factory = new RealPlayerFactory(reader);

        Set<Player> players = new HashSet<>();
        Set<Color> colors = new HashSet<>();

        try {
            while (count-- > 0) {
                Player player = factory.create();
                players.add(player);
                colors.add(player.getColor());
            }
            assertEquals(players.size(), colors.size());
        } catch (RuntimeException e) {
            fail();
        }
    }
}
