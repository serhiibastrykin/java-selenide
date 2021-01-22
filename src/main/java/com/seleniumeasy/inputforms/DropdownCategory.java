package com.seleniumeasy.inputforms;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.seleniumeasy.DemoHomePage;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;
import static java.util.Objects.requireNonNull;

public class DropdownCategory extends DemoHomePage {
    private final ElementsCollection categories = $$("#files optgroup"),
            files = $$("#files option");

    public DropdownCategory selectFileByName(String filename) throws Exception {
        if (!files.find(exactText(filename)).isDisplayed()) {
            throw new Exception("File \"" + filename + "\" doesn't exist!");
        }
        files.find(exactText(filename)).setSelected(true);
        return this;
    }

    public DropdownCategory selectFileByIndex(int category, int fileIndex) throws Exception {
        String part1 = "//select[@id='files']/optgroup[",
                part2 = "]/option[",
                part3 = "]";
        SelenideElement file = $x(part1 + category + part2 + fileIndex + part3);
        if (!file.exists()) {
            throw new Exception("File with index " + fileIndex + " doesn't exist in the current category!");
        }
        file.setSelected(true);
        return this;
    }

    public DropdownCategory selectFileFromCategory(String category, String filename) throws Exception {
        boolean isElementFound = false;
        for (SelenideElement currentCategory : categories) {
            String labelText = currentCategory.getAttribute("label");
            if (requireNonNull(labelText).contains(category)) {
                isElementFound = true;
                selectFile(filename, currentCategory);
            }
        }
        if (!isElementFound) {
            throw new Exception("Category \"" + category + "\" doesn't exist!");
        }
        return this;
    }

    private void selectFile(String filename, SelenideElement currentCategory) throws Exception {
        ElementsCollection options = currentCategory.$$("option");
        SelenideElement file = options.find(exactText(filename));
        if (!file.exists()) {
            throw new Exception("File \"" + filename + "\" doesn't exist!");
        }
        file.setSelected(true);
    }

    public void validateDisplayedFile(String filename) {
        files.find(exactText(filename)).shouldBe(selected);
    }
}