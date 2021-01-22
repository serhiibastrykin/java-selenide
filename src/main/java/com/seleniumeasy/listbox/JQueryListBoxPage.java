package com.seleniumeasy.listbox;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.seleniumeasy.DemoHomePage;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class JQueryListBoxPage extends DemoHomePage {
    private final SelenideElement buttonAdd = $(".pAdd"),
            buttonAddAll = $(".pAddAll"),
            buttonRemove = $(".pRemove"),
            buttonRemoveAll = $(".pRemoveAll");
    private final ElementsCollection pickList = $$(".pickData option"),
            resultList = $$(".pickListResult option");

    public JQueryListBoxPage addItemToResultList(String name) {
        pickList.find(exactText(name)).click();
        buttonAdd.click();
        return this;
    }

    public JQueryListBoxPage addItemsToResultList(String[] names) {
        for (String name : names) {
            pickList.find(exactText(name)).click();
        }
        buttonAdd.click();
        return this;
    }

    public JQueryListBoxPage removeItemFromResultList(String name) {
        resultList.find(exactText(name)).click();
        buttonRemove.click();
        return this;
    }

    public JQueryListBoxPage removeItemsFromResultList(String[] names) {
        for (String name : names) {
            resultList.find(exactText(name)).click();
        }
        buttonRemove.click();
        return this;
    }

    public JQueryListBoxPage addAllItemsToResultList() {
        buttonAddAll.click();
        return this;
    }

    public JQueryListBoxPage removeAllItemsFromResultList() {
        buttonRemoveAll.click();
        return this;
    }

    public JQueryListBoxPage validatePickListSize(int s) {
        pickList.shouldHave(size(s));
        return this;
    }

    public JQueryListBoxPage validateResultListSize(int s) {
        resultList.shouldHave(size(s));
        return this;
    }

    public void validateItemIsDisplayedInPickList(String name) {
        pickList.find(exactText(name)).should(exist);
    }

    public JQueryListBoxPage validateItemIsNotDisplayedInPickList(String name) {
        pickList.find(exactText(name)).shouldNot(exist);
        return this;
    }

    public JQueryListBoxPage validateItemIsDisplayedInResultList(String name) {
        resultList.find(exactText(name)).should(exist);
        return this;
    }

    public JQueryListBoxPage validateItemIsNotDisplayedInResultList(String name) {
        resultList.find(exactText(name)).shouldNot(exist);
        return this;
    }

    public void validateItemsAreDisplayedInPickList(String[] names) {
        for (String name : names) {
            pickList.find(exactText(name)).should(exist);
        }
    }

    public JQueryListBoxPage validateItemsAreNotDisplayedInPickList(String[] names) {
        for (String name : names) {
            pickList.find(exactText(name)).shouldNot(exist);
        }
        return this;
    }

    public JQueryListBoxPage validateItemsAreDisplayedInResultList(String[] names) {
        for (String name : names) {
            resultList.find(exactText(name)).should(exist);
        }
        return this;
    }

    public JQueryListBoxPage validateItemsAreNotDisplayedInResultList(String[] names) {
        for (String name : names) {
            resultList.find(exactText(name)).shouldNot(exist);
        }
        return this;
    }
}