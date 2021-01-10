package com.seleniumeasy.table;

import com.codeborne.selenide.SelenideElement;
import com.seleniumeasy.DemoHomePage;

import static com.codeborne.selenide.Selenide.$;

public class TablePaginationPage extends DemoHomePage {
    private final SelenideElement table = $(".table-hover");

}
