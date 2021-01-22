package com.seleniumeasy.tests.listbox;

import com.seleniumeasy.listbox.JQueryListBoxPage;
import org.testng.annotations.Test;
import utils.SettingsSeleniumEasy;

import static com.seleniumeasy.enums.ListBox.JQUERY_LIST_BOX;

public class JQueryListBoxTest extends SettingsSeleniumEasy {

    JQueryListBoxPage jQueryListBoxPage = new JQueryListBoxPage();

    @Test
    public void testAddItem() {
        String name = "Helena";
        jQueryListBoxPage
                .openListBox(JQUERY_LIST_BOX, JQueryListBoxPage.class)
                .addItemToResultList(name)
                .validateItemIsNotDisplayedInPickList(name)
                .validateItemIsDisplayedInResultList(name);
    }

    @Test
    public void testRemoveItem() {
        String name = "Alice";
        jQueryListBoxPage
                .openListBox(JQUERY_LIST_BOX, JQueryListBoxPage.class)
                .addItemToResultList(name)
                .validateItemIsDisplayedInResultList(name)
                .removeItemFromResultList(name)
                .validateItemIsNotDisplayedInResultList(name)
                .validateItemIsDisplayedInPickList(name);
    }

    @Test
    public void testAddItems() {
        String[] names = new String[] {"Luiza", "Laura", "Isis"};
        jQueryListBoxPage
                .openListBox(JQUERY_LIST_BOX, JQueryListBoxPage.class)
                .addItemsToResultList(names)
                .validateItemsAreNotDisplayedInPickList(names)
                .validateItemsAreDisplayedInResultList(names);
    }

    @Test
    public void testRemoveItems() {
        String[] names = new String[] {"Beatriz", "Giovanna", "Lara", "Julia"};
        jQueryListBoxPage
                .openListBox(JQUERY_LIST_BOX, JQueryListBoxPage.class)
                .addItemsToResultList(names)
                .validateItemsAreDisplayedInResultList(names)
                .removeItemsFromResultList(names)
                .validateItemsAreNotDisplayedInResultList(names)
                .validateItemsAreDisplayedInPickList(names);
    }

    @Test
    public void testAddAllItems() {
        jQueryListBoxPage
                .openListBox(JQUERY_LIST_BOX, JQueryListBoxPage.class)
                .addAllItemsToResultList()
                .validatePickListSize(0)
                .validateResultListSize(15);
    }

    @Test
    public void testRemoveAllItems() {
        jQueryListBoxPage
                .openListBox(JQUERY_LIST_BOX, JQueryListBoxPage.class)
                .addAllItemsToResultList()
                .validatePickListSize(0)
                .validateResultListSize(15)
                .removeAllItemsFromResultList()
                .validateResultListSize(0)
                .validatePickListSize(15);
    }
}