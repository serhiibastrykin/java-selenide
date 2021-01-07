package com.seleniumeasy.others;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.seleniumeasy.DemoHomePage;

import static com.codeborne.selenide.Selenide.*;

public class DragAndDropPage extends DemoHomePage {
    private final ElementsCollection DRAGGABLE_ELEMENTS = $$("#todrag span"),
            DROPPED_ITEMS = $$("#droppedlist span");
    private final SelenideElement DROP_HERE = $("#mydropzone");

    public DragAndDropPage performDragAndDrop() {
        for (int i = 0; i < DRAGGABLE_ELEMENTS.size(); i++) {
            DRAGGABLE_ELEMENTS.get(i).dragAndDropTo(DROP_HERE);
        }
        return this;
    }

    public boolean verifyPresenceOfAllDraggableElements() {
        return DROPPED_ITEMS.size() == DRAGGABLE_ELEMENTS.size() ? true : false;
    }
}