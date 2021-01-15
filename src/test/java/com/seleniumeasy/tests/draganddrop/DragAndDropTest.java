package com.seleniumeasy.tests.draganddrop;

import com.seleniumeasy.others.DragAndDropPage;
import org.junit.Test;
import utils.SettingsSeleniumEasy;

import static org.assertj.core.api.Assertions.assertThat;

public class DragAndDropTest extends SettingsSeleniumEasy {

    DragAndDropPage dragAndDropPage = new DragAndDropPage();

    @Test
    public void dragAndDropTest() {
        dragAndDropPage
                .clickOthersDropdown()
                .openDragAndDrop()
                .performDragAndDrop();
        assertThat(true).isEqualTo(dragAndDropPage.validateDroppableElements());
    }
}