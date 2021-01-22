package com.seleniumeasy.tests.listbox;

import com.seleniumeasy.listbox.BootstrapListBoxPage;
import org.testng.annotations.Test;
import utils.SettingsSeleniumEasy;

import static com.codeborne.selenide.Condition.text;
import static com.seleniumeasy.enums.ListBox.BOOTSTRAP_LIST_BOX;

public class BootstrapListBoxTest extends SettingsSeleniumEasy {

    BootstrapListBoxPage bootstrapListBoxPage = new BootstrapListBoxPage();

    @Test
    public void testMoveElementRightByIndex() {
        bootstrapListBoxPage
                .openListBox(BOOTSTRAP_LIST_BOX, BootstrapListBoxPage.class)
                .selectLeftItemByIndex(0)
                .moveRight()
                .validateItemIsDisplayedRight("list");
    }

    @Test
    public void testMoveElementLeftByIndex() {
        bootstrapListBoxPage
                .openListBox(BOOTSTRAP_LIST_BOX, BootstrapListBoxPage.class)
                .selectRightItemByIndex(2)
                .moveLeft()
                .validateItemIsDisplayedLeft("risus");
    }

    @Test
    public void testMoveElementRightByName() {
        bootstrapListBoxPage
                .openListBox(BOOTSTRAP_LIST_BOX, BootstrapListBoxPage.class)
                .selectLeftItemByName("facilisis")
                .moveRight()
                .validateItemIsDisplayedRight("Dapibus ac facilisis in");
    }

    @Test
    public void testMoveElementLeftByName() {
        bootstrapListBoxPage
                .openListBox(BOOTSTRAP_LIST_BOX, BootstrapListBoxPage.class)
                .selectRightItemByName("Porta ac consectetur ac")
                .moveLeft()
                .validateItemIsDisplayedLeft("Porta");
    }

    @Test
    public void testMoveAllElementsRight() {
        bootstrapListBoxPage
                .openListBox(BOOTSTRAP_LIST_BOX, BootstrapListBoxPage.class)
                .clickLeftSelectAll()
                .moveRight()
                .validateRightBoxSize(10);
    }

    @Test
    public void testMoveAllElementsLeft() {
        bootstrapListBoxPage
                .openListBox(BOOTSTRAP_LIST_BOX, BootstrapListBoxPage.class)
                .clickRightSelectAll()
                .moveLeft()
                .validateLeftBoxSize(10);
    }

    @Test
    public void testValidateItemsFoundRight() {
        bootstrapListBoxPage
                .openListBox(BOOTSTRAP_LIST_BOX, BootstrapListBoxPage.class)
                .searchInsideRightBox("leo")
                .validateItemsFoundRight(text("leo"));
    }

    @Test
    public void testValidateItemsFoundLeft() {
        bootstrapListBoxPage
                .openListBox(BOOTSTRAP_LIST_BOX, BootstrapListBoxPage.class)
                .searchInsideLeftBox("ac")
                .validateItemsFoundLeft(text("ac"));
    }
}