package com.seleniumeasy.enums;

public enum DatePickers {
    BOOTSTRAP_DATE_PICKER("Bootstrap Date Picker"),
    JQUERY_DATE_PICKER("JQuery Date Picker");

    private final String val;

    DatePickers(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }
}