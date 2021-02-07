package com.seleniumeasy.inputforms;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.seleniumeasy.BasePage;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

public class DropdownDisabled extends BasePage {
    private final SelenideElement selectedTerritory = $x("//span[@style='width: 50%;']" +
            "//span[@class='select2-selection__rendered']");
    private final ElementsCollection dropdownSelectTerritories = $$(".js-example-disabled-results option");

    public DropdownDisabled selectTerritoryByName(String name) throws Exception {
        if (dropdownSelectTerritories.find(exactText(name)).isEnabled()) {
            dropdownSelectTerritories.find(exactText(name)).setSelected(true);
        } else {
            throw new Exception("Option \"" + name + "\" is disabled!");
        }
        return this;
    }

    public DropdownDisabled selectTerritoryByIndex(int i) throws Exception {
        if (dropdownSelectTerritories.get(i).isEnabled()) {
            dropdownSelectTerritories.get(i).setSelected(true);
        } else {
            throw new Exception("Option \"" + i + "\" is disabled!");
        }
        return this;
    }

    public void validateDisplayedTerritory(Condition c) {
        selectedTerritory.should(c);
    }

    public void validateDisplayedTerritory(int i) {
        String territory = dropdownSelectTerritories.get(i).text();
        selectedTerritory.shouldHave(attribute("title", territory));
    }
}