package com.seleniumeasy.inputforms;

import com.codeborne.selenide.ElementsCollection;
import com.seleniumeasy.BasePage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;

public class DropdownMultiple extends BasePage {
    private final ElementsCollection states = $$(".js-example-basic-multiple option"),
            selectedStates = $$(".select2-selection--multiple li[class=select2-selection__choice]");

    public DropdownMultiple selectStatesByNames(String... names) {
        for (String name : names) {
            states.find(exactText(name)).setSelected(true);
        }
        return this;
    }

    public DropdownMultiple selectStatesByIndexes(int... indexes) {
        for (int i : indexes) {
            states.get(i).setSelected(true);
        }
        return this;
    }

    public DropdownMultiple deselectStates(String... names) throws Exception {
        for (String name : names) {
            if (!states.find(exactText(name)).isSelected()) {
                throw new Exception("State " + name + " is not selected!");
            }
            states.find(exactText(name)).setSelected(false);
        }
        return this;
    }

    public DropdownMultiple verifyDisplayedStatesSize(int s) throws Exception {
        if (selectedStates.size() != s) {
            throw new Exception("Expected size: " + s + "\nActual size: " + selectedStates.size());
        }
        return this;
    }

    public void validateDisplayedStates(String... states) {
        for (String state : states)
            selectedStates.find(attribute("title", state)).shouldBe(visible);
    }
}