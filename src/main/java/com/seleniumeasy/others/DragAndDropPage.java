package com.seleniumeasy.others;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.seleniumeasy.DemoHomePage;

import static com.codeborne.selenide.Selenide.*;

public class DragAndDropPage extends DemoHomePage {
    private final ElementsCollection draggableElements = $$("#todrag span"),
            droppedItems = $$("#droppedlist span");
    private final SelenideElement dropHere = $("#mydropzone");

    public void performDragAndDrop() {
        for (SelenideElement draggableElement : draggableElements) {
            draggableElement.dragAndDropTo(dropHere);
        }
    }

    public boolean isDroppedSizeEquals(int s) {
        if (droppedItems.size() != s) {
            System.out.println("Expected size: " + s + "\nActual size: " + droppedItems.size());
            return false;
        }
        return true;
    }
}