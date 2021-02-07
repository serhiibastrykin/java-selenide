package jqueryui.test;

import jqueryui.DragAndDropPage;
import org.testng.annotations.Test;
import utils.SettingsJQueryUI;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;

public class DragAndDropTest extends SettingsJQueryUI {

    DragAndDropPage dragAndDropDemo = new DragAndDropPage();

    @Test
    public void testDragAndDropRightByTarget() {
        dragAndDropDemo
                .performDragAndDropRight(0, 4)
                .performDragAndDropRight(3, 5)
                .verifyLeftListSize(3)
                .verifyRightListSize(7)
                .verifyLeftListWhiteItems(hidden, "Item 1", "Item 5")
                .verifyRightListWhiteItems(visible, "Item 1", "Item 5");
    }

    @Test
    public void testDragAndDropRightByCoordinates() {
        dragAndDropDemo
                .performDragAndDropRight(2, 100, -50)
                .verifyLeftListSize(4)
                .verifyRightListSize(6)
                .verifyLeftListWhiteItems(hidden, "Item 3")
                .verifyRightListWhiteItems(visible, "Item 3");
    }

    @Test
    public void testDragAndDropLeftByTarget() {
        dragAndDropDemo
                .performDragAndDropLeft(4, 0)
                .verifyRightListSize(4)
                .verifyLeftListSize(6)
                .verifyRightListYellowItems(hidden, "Item 5")
                .verifyLeftListYellowItems(visible, "Item 5");
    }

    @Test
    public void testDragAndDropLeftByCoordinates() {
        String[] items = {"Item 3", "Item 4", "Item 1"};
        dragAndDropDemo
                .performDragAndDropLeft(2, -100, 100)
                .performDragAndDropLeft(2, -100, -100)
                .performDragAndDropLeft(0, -100, -20)
                .verifyRightListSize(2)
                .verifyLeftListSize(8)
                .verifyRightListYellowItems(hidden, items)
                .verifyLeftListYellowItems(visible, items);
    }
}