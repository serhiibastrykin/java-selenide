package com.seleniumeasy.enums.statics;

public enum Colors {
    TEXT_RESET("\u001B[0m"),
    TEXT_GREEN("\u001B[32m"),
    TEXT_RED("\u001B[31m"),
    TEXT_YELLOW("\u001B[33m"),
    TEXT_BLUE("\u001B[34m"),
    TEXT_PURPLE("\u001B[35m"),
    TEXT_CYAN("\u001B[36m"),
    TEXT_GRAY("\u001B[37m"),
    TEXT_WHITE("\033[0;97m"),
    TEXT_BLACK("\u001B[30m");

    private final String color;

    Colors(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}