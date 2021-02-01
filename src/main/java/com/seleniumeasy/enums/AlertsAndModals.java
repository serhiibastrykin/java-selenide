package com.seleniumeasy.enums;

public enum AlertsAndModals {
    BOOTSTRAP_ALERTS("Bootstrap Alerts"),
    BOOTSTRAP_MODALS("Bootstrap Modals"),
    WINDOW_POPUP_MODAL("Window Popup Modal"),
    PROGRESS_BAR_MODAL("Progress Bar Modal"),
    JAVASCRIPT_ALERTS("Javascript Alerts"),
    FILE_DOWNLOAD("File Download");

    private final String val;

    AlertsAndModals(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }
}