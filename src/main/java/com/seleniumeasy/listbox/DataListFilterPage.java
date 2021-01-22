package com.seleniumeasy.listbox;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.seleniumeasy.DemoHomePage;

import static com.codeborne.selenide.Selenide.*;

public class DataListFilterPage extends DemoHomePage {
    private final SelenideElement inputSearchAttendees = $("#input-search");
    private final ElementsCollection companies = $$(".info-block h5"),
            names = $$(".info-block h4"),
            titles = $$(".info-block p"),
            phones = $$x("//span[contains(text(), 'Phone')]"),
            emails = $$x("//span[contains(text(), 'Email')]");

    public DataListFilterPage enterSearchText(String searchText) {
        inputSearchAttendees.sendKeys(searchText);
        return this;
    }

    public void validateFoundUsers(String searchText) {
        int counter = 0;
        for (int i = 0; i < companies.size(); i++) {
            if (companies.get(i).text().contains(searchText)
                    || names.get(i).text().contains(searchText)
                    || titles.get(i).text().contains(searchText)
                    || phones.get(i).text().contains(searchText)
                    || emails.get(i).text().contains(searchText)) {
                counter++;
            }
        }
        System.out.printf("Found %d users", counter);
    }
}