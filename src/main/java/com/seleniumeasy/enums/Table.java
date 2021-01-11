package com.seleniumeasy.enums;

public enum Table {
    TABLE_PAGINATION("Table Pagination"),
    TABLE_DATA_SEARCH("Table Data Search"),
    TABLE_FILTER("Table Filter"),
    TABLE_SORT_AND_SEARCH("Table Sort & Search");

    private final String val;

    Table(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }
}
