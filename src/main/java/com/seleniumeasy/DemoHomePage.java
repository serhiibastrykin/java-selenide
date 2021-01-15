package com.seleniumeasy;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.seleniumeasy.alertsandmodals.FileDownloadPage;
import com.seleniumeasy.enums.InputForms;
import com.seleniumeasy.inputforms.*;
import com.seleniumeasy.others.DragAndDropPage;
import com.seleniumeasy.enums.Table;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class DemoHomePage {
    public static final SelenideElement BUTTON_CLOSE_POPUP = $("#at-cv-lightbox-close");
    private final SelenideElement openedMenu = $(".open .dropdown-menu"),
            dropdownInputFormsMain = $x("//li[@class='dropdown']/a[contains(text(), 'Input Forms')]"),
            dropdownInputForms = $x("//li[@class='tree-branch']/a[contains(text(), 'Input Forms')]"),
            itemAjaxFormSubmit = $x("//li[@class='tree-branch']/ul/li/a[contains(text(), 'Ajax Form Submit')]"),
            buttonStartPractising = $("#btn_basic_example"),
            itemSimpleFormDemo = $x("//div[@class='list-group']/a[contains(text(), 'Simple Form Demo')]"),
            dropdownTable = $x("//li[@class='dropdown']/a[contains(text(), 'Table')]"),
            dropdownAlertAndModals = $(byText("Alerts & Modals")),
            itemFileDownload = $(byText("File Download")),
            dropdownOthers = $(byText("Others")),
            itemDragAndDrop = $(byText("Drag and Drop"));

    private void clickInputFormsDropdownMain() {
        dropdownInputFormsMain.click();
    }

    public <PageObjectClass> PageObjectClass openInputForms
            (InputForms inputForms, Class<PageObjectClass> pageObjectClass) {
        clickInputFormsDropdownMain();
        openedMenu.$$("li").find(exactText(inputForms.getVal())).click();
        return Selenide.page(pageObjectClass);
    }

    public DemoHomePage clickInputFormsDropdown() {
        dropdownInputForms.click();
        return this;
    }

    public AjaxFormSubmitPage openAjaxFormSubmit() {
        itemAjaxFormSubmit.click();
        return new AjaxFormSubmitPage();
    }

    public DemoHomePage clickStartPractisingButton() {
        buttonStartPractising.click();
        return this;
    }

    public SimpleFormDemoPage openSimpleFormDemo() {
        itemSimpleFormDemo.click();
        return new SimpleFormDemoPage();
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

    public DemoHomePage clickAlertAndModals() {
        dropdownAlertAndModals.click();
        return this;
    }

    public FileDownloadPage openFileDownload() {
        itemFileDownload.click();
        return new FileDownloadPage();
    }

    public DemoHomePage clickOthersDropdown() {
        dropdownOthers.click();
        return this;
    }

    public DragAndDropPage openDragAndDrop() {
        itemDragAndDrop.click();
        return new DragAndDropPage();
    }
}