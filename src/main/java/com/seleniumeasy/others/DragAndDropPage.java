package com.seleniumeasy.others;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.seleniumeasy.DemoHomePage;

import static com.codeborne.selenide.Selenide.*;

public class DragAndDropPage extends DemoHomePage {
    private final ElementsCollection draggableElements = $$("#todrag span"),
            droppedItems = $$("#droppedlist span");
    private final SelenideElement dropHere = $("#mydropzone");

    public DragAndDropPage performDragAndDrop() {
        for (int i = 0; i < draggableElements.size(); i++) {
            draggableElements.get(i).dragAndDropTo(dropHere);
        }
        return this;
    }

    public boolean verifyPresenceOfAllDraggableElements() {
        return droppedItems.size() == draggableElements.size() ? true : false;
    }
}