package com.seleniumeasy.tests.listbox;

import com.seleniumeasy.listbox.BootstrapListBoxPage;
import org.testng.annotations.Test;
import utils.SettingsSeleniumEasy;

import static com.codeborne.selenide.Condition.exactText;
import static com.seleniumeasy.enums.ListBox.BOOTSTRAP_LIST_BOX;

public class BootstrapListBoxTest extends SettingsSeleniumEasy {

    BootstrapListBoxPage bootstrapListBoxPage = new BootstrapListBoxPage();

    @Test
    public void testMoveElementRightByIndex() {
        String[] items = {"bootstrap-duallist", "Morbi leo risus"};
        bootstrapListBoxPage
                .openListBox(BOOTSTRAP_LIST_BOX, BootstrapListBoxPage.class)
                .selectLeftItemsByIndex(0, 2)
                .moveRight()
                .validateItemsDisplayedRight(items);
    }

    @Test
    public void testMoveElementLeftByIndex() {
        String[] items = {"Cras justo odio", "Dapibus ac facilisis in"};
        bootstrapListBoxPage
                .openListBox(BOOTSTRAP_LIST_BOX, BootstrapListBoxPage.class)
                .selectRightItemsByIndex(1, 0)
                .moveLeft()
                .validateItemsDisplayedLeft(items);
    }

    @Test
    public void testMoveElementRightByName() {
        String[] items = {"Morbi leo risus", "Vestibulum at eros", "Porta ac consectetur ac"};
        bootstrapListBoxPage
                .openListBox(BOOTSTRAP_LIST_BOX, BootstrapListBoxPage.class)
                .selectLeftItemsByName("eros", "Morbi", "Porta")
                .moveRight()
                .validateItemsDisplayedRight(items);
    }

    @Test
    public void testMoveElementLeftByName() {
        String[] items = {"Cras justo odio", "Porta ac consectetur ac"};
        bootstrapListBoxPage
                .openListBox(BOOTSTRAP_LIST_BOX, BootstrapListBoxPage.class)
                .selectRightItemsByName("as", "ac conse")
                .moveLeft()
                .validateItemsDisplayedLeft(items);
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
                .searchInsideRightBox("in")
                .validateItemsFoundRight(exactText("Dapibus ac facilisis in"));
    }

    @Test
    public void testValidateItemsFoundLeft() {
        bootstrapListBoxPage
                .openListBox(BOOTSTRAP_LIST_BOX, BootstrapListBoxPage.class)
                .searchInsideLeftBox("at")
                .validateItemsFoundLeft(exactText("Vestibulum at eros"));
    }
}