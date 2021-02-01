package com.seleniumeasy.tests.others;

import com.seleniumeasy.others.DragAndDropPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.SettingsSeleniumEasy;

import static com.seleniumeasy.enums.Others.DRAG_AND_DROP;

public class DragAndDropTest extends SettingsSeleniumEasy {

    DragAndDropPage dragAndDropPage = new DragAndDropPage();

    @Test (enabled = false)
    public void dragAndDropTest() {
        dragAndDropPage
                .openOthers(DRAG_AND_DROP, DragAndDropPage.class)
                .performDragAndDrop();
        Assert.assertTrue(dragAndDropPage.isDroppedSizeEquals(4));
    }
}