package com.seleniumeasy.tests.others;

import com.seleniumeasy.others.DragAndDropPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.SettingsSeleniumEasy;

public class DragAndDropTest extends SettingsSeleniumEasy {

    DragAndDropPage dragAndDropPage = new DragAndDropPage();

    @Test
    public void dragAndDropTest() {
        dragAndDropPage
                .clickOthersDropdown()
                .openDragAndDrop()
                .performDragAndDrop();
        Assert.assertTrue(dragAndDropPage.validateDroppedItemsSize(4));
    }
}