package com.seleniumeasy.progressbars;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.seleniumeasy.BasePage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class DragAndDropSlidersPage extends BasePage {
    private final SelenideElement graySlider = $("#slider1 input"),
            darkBlueSlider = $("#slider2 input"),
            greenSlider = $("#slider3 input"),
            lightBlueSlider = $("#slider4 input"),
            orangeSlider = $("#slider5 input"),
            redSlider = $("#slider6 input"),
            outputGray = $("#range"),
            outputDarkBlue = $("#rangePrimary"),
            outputGreen = $("#rangeSuccess"),
            outputLightBlue = $("#rangeInfo"),
            outputOrange = $("#rangeWarning"),
            outputRed = $("#rangeDanger");

    public DragAndDropSlidersPage dragAndDropGraySlider(int x, int y) {
        dragAndDropSlider(graySlider, x, y);
        return this;
    }

    public DragAndDropSlidersPage dragAndDropDarkBlueSlider(int x, int y) {
        dragAndDropSlider(darkBlueSlider, x, y);
        return this;
    }

    public DragAndDropSlidersPage dragAndDropGreenSlider(int x, int y) {
        dragAndDropSlider(greenSlider, x, y);
        return this;
    }

    public DragAndDropSlidersPage dragAndDropLightBlueSlider(int x, int y) {
        dragAndDropSlider(lightBlueSlider, x, y);
        return this;
    }

    public DragAndDropSlidersPage dragAndDropOrangeSlider(int x, int y) {
        dragAndDropSlider(orangeSlider, x, y);
        return this;
    }

    public DragAndDropSlidersPage dragAndDropRedSlider(int x, int y) {
        dragAndDropSlider(redSlider, x, y);
        return this;
    }

    public void validateGraySlider(Condition c) {
        outputGray.should(c);
    }

    public void validateDarkBlueSlider(Condition c) {
        outputDarkBlue.should(c);
    }

    public void validateGreenSlider(Condition c) {
        outputGreen.should(c);
    }

    public void validateLightBlueSlider(Condition c) {
        outputLightBlue.should(c);
    }

    public void validateOrangeSlider(Condition c) {
        outputOrange.should(c);
    }

    public void validateRedSlider(Condition c) {
        outputRed.should(c);
    }

    private void dragAndDropSlider(SelenideElement slider, int x, int y) {
        actions().dragAndDropBy(slider, x, y).perform();
    }

    private void getCoordinates(SelenideElement slider) {
        int x = slider.getLocation().getX();
        int y = slider.getLocation().getY();
        System.out.println("X: " + x + "\n" + "Y: " + y + "\n");
    }
}