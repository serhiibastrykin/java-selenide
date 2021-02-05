package jqueryui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.actions;

public class DragAndDropPage {
    private final ElementsCollection leftList = $$("ul#sortable1 li");
    private final ElementsCollection rightList = $$("ul#sortable2 li");

    public DragAndDropPage performDragAndDropRight(int source, int target) {
        dragAndDropToTarget(leftList, source, rightList, target);
        return this;
    }

    public DragAndDropPage performDragAndDropRight(int item, int x, int y) {
        dragAndDropByCoordinates(leftList, item, x, y);
        return this;
    }

    public DragAndDropPage performDragAndDropLeft(int source, int target) {
        dragAndDropToTarget(rightList, source, leftList, target);
        return this;
    }

    public DragAndDropPage performDragAndDropLeft(int item, int x, int y) {
        dragAndDropByCoordinates(rightList, item, x, y);
        return this;
    }

    public DragAndDropPage verifyRightListSize(int s) {
        rightList.shouldHave(size(s));
        return this;
    }

    public DragAndDropPage verifyLeftListSize(int s) {
        leftList.shouldHave(size(s));
        return this;
    }

    public DragAndDropPage verifyRightListWhiteItems(Condition c, String... items) {
        verifyItems(rightList, "ui-state-default ui-sortable-handle", c, items);
        return this;
    }

    public DragAndDropPage verifyRightListYellowItems(Condition c, String... items) {
        verifyItems(rightList, "ui-state-highlight ui-sortable-handle", c, items);
        return this;
    }

    public DragAndDropPage verifyLeftListWhiteItems(Condition c, String... items) {
        verifyItems(leftList, "ui-state-default ui-sortable-handle", c, items);
        return this;
    }

    public DragAndDropPage verifyLeftListYellowItems(Condition c, String... items) {
        verifyItems(leftList, "ui-state-highlight ui-sortable-handle", c, items);
        return this;
    }

    private void verifyItems(ElementsCollection collection, String className, Condition c, String... items) {
        for (String item : items) {
            collection.filter(attribute("class", className)).find(exactText(item)).should(c);
        }
    }

    private void dragAndDropToTarget(ElementsCollection collection1, int source, ElementsCollection collection2, int target) {
        collection1.get(source).dragAndDropTo(collection2.get(target));
    }

    private void dragAndDropByCoordinates(ElementsCollection collection, int item, int x, int y) {
        actions().dragAndDropBy(collection.get(item), x, y).perform();
    }
}