package com.seleniumeasy.enums;

public enum ProgressBars {
    JQUERY_DOWNLOAD_PROGRESS_BARS("JQuery Download Progress bars"),
    BOOTSTRAP_PROGRESS_BAR("Bootstrap Progress bar"),
    DRAG_AND_DROP_SLIDERS("Drag & Drop Sliders");

    private final String val;

    ProgressBars(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }
}