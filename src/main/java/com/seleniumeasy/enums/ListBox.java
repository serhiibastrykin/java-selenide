package com.seleniumeasy.enums;

public enum ListBox {
    BOOTSTRAP_LIST_BOX("Bootstrap List Box"),
    JQUERY_LIST_BOX("JQuery List Box"),
    DATA_LIST_FILTER("Data List Filter");

    private final String val;

    ListBox(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }
}