package ru.netology.javaqa.domain;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String playerName) {
        super("Игрок с именем" + playerName + "не найден");
    }
}
