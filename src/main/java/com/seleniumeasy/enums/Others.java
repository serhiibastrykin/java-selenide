package com.seleniumeasy.enums;

public enum Others {
    DRAG_AND_DROP("Drag and Drop"),
    DYNAMIC_DATA_LOADING("Dynamic Data Loading");

    private final String val;

    Others(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }
}