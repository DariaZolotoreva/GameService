package ru.netology.javaqa.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Player petja = new Player(1, "Piter", 250);
    Player oleg = new Player(2, "Oleg", 100);
    Player viktor = new Player(3, "Viktor", 100);

    @Test
    public void ShouldWinFirstPlayer() {
        Game game = new Game();
        game.register(petja);
        game.register(oleg);

        int expected = game.round("Piter", "Oleg");
        int actual = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldWinSecondPlayer() {
        Game game = new Game();
        game.register(petja);
        game.register(oleg);

        int expected = game.round("Oleg", "Piter");
        int actual = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldBeTieGame() {
        Game game = new Game();
        game.register(oleg);
        game.register(viktor);

        int expected = game.round("Oleg", "Viktor");
        int actual = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldThrowExceptionIfPlayer1NonRegistered() {
        Game game = new Game();
        game.register(oleg);
        game.register(viktor);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Gena", "Viktor"));
    }

    @Test
    public void ShouldThrowExceptionIfPlayer2NonRegistered() {
        Game game = new Game();
        game.register(oleg);
        game.register(viktor);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Oleg", "Gena"));
    }
}

