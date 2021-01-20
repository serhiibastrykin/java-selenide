package com.seleniumeasy.tests.listbox;

import com.seleniumeasy.listbox.BootstrapListBoxPage;
import org.junit.Test;
import utils.SettingsSeleniumEasy;

import static com.codeborne.selenide.Condition.text;

public class BootstrapListBoxTest extends SettingsSeleniumEasy {

    BootstrapListBoxPage bootstrapListBoxPage = new BootstrapListBoxPage();

    @Test
    public void testMoveElementRightByIndex() {
        bootstrapListBoxPage
                .clickListBox()
                .openBootstrapListBox()
                .selectLeftItemByIndex(0)
                .moveRight()
                .validateItemIsDisplayedRight("list");
    }

    @Test
    public void testMoveElementLeftByIndex() {
        bootstrapListBoxPage
                .clickListBox()
                .openBootstrapListBox()
                .selectRightItemByIndex(2)
                .moveLeft()
                .validateItemIsDisplayedLeft("risus");
    }

    @Test
    public void testMoveElementRightByName() {
        bootstrapListBoxPage
                .clickListBox()
                .openBootstrapListBox()
                .selectLeftItemByName("facilisis")
                .moveRight()
                .validateItemIsDisplayedRight("Dapibus ac facilisis in");
    }

    @Test
    public void testMoveElementLeftByName() {
        bootstrapListBoxPage
                .clickListBox()
                .openBootstrapListBox()
                .selectRightItemByName("Porta ac consectetur ac")
                .moveLeft()
                .validateItemIsDisplayedLeft("Porta");
    }

    @Test
    public void testMoveAllElementsRight() {
        bootstrapListBoxPage
                .clickListBox()
                .openBootstrapListBox()
                .clickLeftSelectAll()
                .moveRight()
                .validateRightBoxSize(10);
    }

    @Test
    public void testMoveAllElementsLeft() {
        bootstrapListBoxPage
                .clickListBox()
                .openBootstrapListBox()
                .clickRightSelectAll()
                .moveLeft()
                .validateLeftBoxSize(10);
    }

    @Test
    public void testValidateItemsFoundRight() {
        bootstrapListBoxPage
                .clickListBox()
                .openBootstrapListBox()
                .searchInsideRightBox("leo")
                .validateItemsFoundRight(text("leo"));
    }

    @Test
    public void testValidateItemsFoundLeft() {
        bootstrapListBoxPage
                .clickListBox()
                .openBootstrapListBox()
                .searchInsideLeftBox("ac")
                .validateItemsFoundLeft(text("ac"));
    }
}