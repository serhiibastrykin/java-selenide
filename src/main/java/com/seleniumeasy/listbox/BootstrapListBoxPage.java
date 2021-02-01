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
        rightInputSearch.setValue(searchText);
        return this;
    }

    public BootstrapListBoxPage searchInsideLeftBox(String searchText) {
        leftInputSearch.setValue(searchText);
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

    public BootstrapListBoxPage selectRightItemsByIndex(int... indexes) {
        for (int index : indexes) {
            rightList.get(index).click();
        }
        return this;
    }

    public BootstrapListBoxPage selectLeftItemsByIndex(int... indexes) {
        for (int index : indexes) {
            leftList.get(index).click();
        }
        return this;
    }

    public BootstrapListBoxPage selectRightItemsByName(String... names) {
        for (String name : names) {
            rightList.find(text(name)).click();
        }
        return this;
    }

    public BootstrapListBoxPage selectLeftItemsByName(String... names) {
        for (String name : names) {
            leftList.find(text(name)).click();
        }
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

    public void validateItemsDisplayedRight(String... names) {
        for (String name : names) {
            rightList.find(exactText(name)).shouldBe(visible);
        }
    }

    public void validateItemsDisplayedLeft(String... names) {
        for (String name : names) {
            leftList.find(exactText(name)).shouldBe(visible);
        }
    }
}