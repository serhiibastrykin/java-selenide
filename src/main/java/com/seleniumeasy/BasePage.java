package com.seleniumeasy;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.seleniumeasy.enums.*;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class BasePage {
    public static final SelenideElement BUTTON_CLOSE_POPUP = $("#at-cv-lightbox-close");
    private final SelenideElement openedMenu = $(".open .dropdown-menu"),
            dropdownInputForms = $(byText("Input Forms")),
            dropdownDatePickers = $(byText("Date pickers")),
            dropdownTable = $(byText("Table")),
            dropdownProgressBars = $(byText("Progress Bars")),
            dropdownAlertAndModals = $(byText("Alerts & Modals")),
            dropdownListBox = $(byText("List Box")),
            dropdownOthers = $(byText("Others"));

    private void clickInputFormsDropdownMain() {
        dropdownInputForms.click();
    }

    public <PageObjectClass> PageObjectClass openInputForms
            (InputForms inputForms, Class<PageObjectClass> pageObjectClass) {
        clickInputFormsDropdownMain();
        openedMenu.$$("li").find(exactText(inputForms.getVal())).click();
        return Selenide.page(pageObjectClass);
    }

    private void clickDatePickers() {
        dropdownDatePickers.click();
    }

    public <PageObjectClass> PageObjectClass openDatePickers
            (DatePickers datePickers, Class<PageObjectClass> pageObjectClass) {
        clickDatePickers();
        openedMenu.$$("li").find(exactText(datePickers.getVal())).click();
        return Selenide.page(pageObjectClass);
    }

    private void clickTableDropdown() {
        dropdownTable.click();
    }

    public <PageObjectClass> PageObjectClass openTable
            (Table table, Class<PageObjectClass> pageObjectClass) {
        clickTableDropdown();
        openedMenu.$$("li").find(exactText(table.getVal())).click();
        return Selenide.page(pageObjectClass);
    }

    private void clickProgressBars() {
        dropdownProgressBars.click();
    }

    public <PageObjectClass> PageObjectClass openProgressBars
            (ProgressBars progressBars, Class<PageObjectClass> pageObjectClass) {
        clickProgressBars();
        openedMenu.$$("li").find(exactText(progressBars.getVal())).click();
        return Selenide.page(pageObjectClass);
    }

    private void clickAlertAndModals() {
        dropdownAlertAndModals.click();
    }

    public <PageObjectClass> PageObjectClass openAlertsAndModals
            (AlertsAndModals alertsAndModals, Class<PageObjectClass> pageObjectClass) {
        clickAlertAndModals();
        openedMenu.$$("li").find(exactText(alertsAndModals.getVal())).click();
        return Selenide.page(pageObjectClass);
    }

    private void clickListBox() {
        dropdownListBox.click();
    }

    public <PageObjectClass> PageObjectClass openListBox
            (ListBox listBox, Class<PageObjectClass> pageObjectClass) {
        clickListBox();
        openedMenu.$$("li").find(exactText(listBox.getVal())).click();
        return Selenide.page(pageObjectClass);
    }

    private void clickOthersDropdown() {
        dropdownOthers.click();
    }

    public <PageObjectClass> PageObjectClass openOthers
            (Others others, Class<PageObjectClass> pageObjectClass) {
        clickOthersDropdown();
        openedMenu.$$("li").find(exactText(others.getVal())).click();
        return Selenide.page(pageObjectClass);
    }
}