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
    private final SelenideElement OPENED_MENU = $(".open .dropdown-menu"),
            DROPDOWN_INPUT_FORMS_MAIN = $x("//li[@class='dropdown']/a[contains(text(), 'Input Forms')]"),
            DROPDOWN_INPUT_FORMS = $x("//li[@class='tree-branch']/a[contains(text(), 'Input Forms')]"),
            ITEM_AJAX_FORM_SUBMIT = $x("//li[@class='tree-branch']/ul/li/a[contains(text(), 'Ajax Form Submit')]"),
            BUTTON_START_PRACTISING = $("#btn_basic_example"),
            ITEM_SIMPLE_FORM_DEMO = $x("//div[@class='list-group']/a[contains(text(), 'Simple Form Demo')]"),
            DROPDOWN_TABLE = $x("//li[@class='dropdown']/a[contains(text(), 'Table')]"),
            DROPDOWN_ALERT_AND_MODALS = $(byText("Alerts & Modals")),
            ITEM_FILE_DOWNLOAD = $(byText("File Download")),
            DROPDOWN_OTHERS = $(byText("Others")),
            ITEM_DRAG_AND_DROP = $(byText("Drag and Drop"));
    public static SelenideElement BUTTON_CLOSE_POPUP = $("#at-cv-lightbox-close");

    private void clickInputFormsDropdownMain() {
        DROPDOWN_INPUT_FORMS_MAIN.click();
    }

    public <PageObjectClass> PageObjectClass openInputForms
            (InputForms inputForms, Class<PageObjectClass> pageObjectClass) {
        clickInputFormsDropdownMain();
        OPENED_MENU.$$("li").find(exactText(inputForms.getVal())).click();
        return Selenide.page(pageObjectClass);
    }

    public DemoHomePage clickInputFormsDropdown() {
        DROPDOWN_INPUT_FORMS.click();
        return this;
    }

    public AjaxFormSubmitPage openAjaxFormSubmit() {
        ITEM_AJAX_FORM_SUBMIT.click();
        return new AjaxFormSubmitPage();
    }

    public DemoHomePage clickStartPractisingButton() {
        BUTTON_START_PRACTISING.click();
        return this;
    }

    public SimpleFormDemoPage openSimpleFormDemo() {
        ITEM_SIMPLE_FORM_DEMO.click();
        return new SimpleFormDemoPage();
    }

    private void clickTableDropdown() {
        DROPDOWN_TABLE.click();
    }

    public <PageObjectClass> PageObjectClass openTable(Table table, Class<PageObjectClass> pageObjectClass) {
        clickTableDropdown();
        OPENED_MENU.$$("li").find(exactText(table.getVal())).click();
        return Selenide.page(pageObjectClass);
    }

    public DemoHomePage clickAlertAndModals() {
        DROPDOWN_ALERT_AND_MODALS.click();
        return this;
    }

    public FileDownloadPage openFileDownload() {
        ITEM_FILE_DOWNLOAD.click();
        return new FileDownloadPage();
    }

    public DemoHomePage clickOthersDropdown() {
        DROPDOWN_OTHERS.click();
        return this;
    }

    public DragAndDropPage openDragAndDrop() {
        ITEM_DRAG_AND_DROP.click();
        return new DragAndDropPage();
    }
}