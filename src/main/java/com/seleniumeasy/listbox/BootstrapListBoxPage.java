package com.seleniumeasy.listbox;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.seleniumeasy.DemoHomePage;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BootstrapListBoxPage extends DemoHomePage {
    private final SelenideElement rightInputSearch = $("div[class='well'] input[name='SearchDualList']"),
            leftInputSearch = $(".text-right input[name='SearchDualList']"),
            rightButtonSelectAll = $("div[class='well'] .selector"),
            leftButtonSelectAll = $(".text-right .selector"),
            buttonMoveLeft = $(".move-left"),
            buttonMoveRight = $(".move-right");
    private final ElementsCollection leftList = $$(".text-right li"),
            rightList = $$("div[class='well'] li");

    public BootstrapListBoxPage searchInsideRightBox(String searchText) {
        rightInputSearch.sendKeys(searchText);
        return this;
    }

    public BootstrapListBoxPage searchInsideLeftBox(String searchText) {
        leftInputSearch.sendKeys(searchText);
        return this;
    }

    public BootstrapListBoxPage clickRightSelectAll() {
        rightButtonSelectAll.click();
        return this;
    }

    public BootstrapListBoxPage clickLeftSelectAll() {
        leftButtonSelectAll.click();
        return this;
    }

    public BootstrapListBoxPage moveLeft() {
        buttonMoveLeft.click();
        return this;
    }

    public BootstrapListBoxPage moveRight() {
        buttonMoveRight.click();
        return this;
    }

    public BootstrapListBoxPage selectRightItemByIndex(int i) {
        rightList.get(i).click();
        return this;
    }

    public BootstrapListBoxPage selectLeftItemByIndex(int i) {
        leftList.get(i).click();
        return this;
    }

    public BootstrapListBoxPage selectRightItemByName(String name) {
        rightList.find(text(name)).click();
        return this;
    }

    public BootstrapListBoxPage selectLeftItemByName(String name) {
        leftList.find(text(name)).click();
        return this;
    }

    public void validateItemsFoundRight(Condition c) {
        int counter = 0;
        for (SelenideElement selenideElement : rightList) {
            if (selenideElement.isDisplayed()) {
                selenideElement.should(c);
                counter++;
            }
        }
        System.out.println("Found " + counter + " items");
    }

    public void validateItemsFoundLeft(Condition c) {
        int counter = 0;
        for (SelenideElement selenideElement : leftList) {
            if (selenideElement.isDisplayed()) {
                selenideElement.should(c);
                counter++;
            }
        }
        System.out.println("Found " + counter + " items");
    }

    public void validateRightBoxSize(int s) {
        rightList.shouldHave(size(s));
    }

    public void validateLeftBoxSize(int s) {
        leftList.shouldHave(size(s));
    }

    public void validateItemIsDisplayedRight(String name) {
        rightList.last().shouldHave(text(name), attribute("class",
                "list-group-item active"));
    }

    public void validateItemIsDisplayedLeft(String name) {
        leftList.last().shouldHave(text(name), attribute("class",
                "list-group-item active"));
    }
}