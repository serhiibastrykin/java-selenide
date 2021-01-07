package com.seleniumeasy;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.seleniumeasy.alertsandmodals.FileDownloadPage;
import com.seleniumeasy.inputforms.*;
import com.seleniumeasy.others.DragAndDropPage;
import com.seleniumeasy.enums.Table;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class DemoHomePage {
    private final SelenideElement dropdownInputForms1 = $x("//li[@class='dropdown']/a[contains(text(), 'Input Forms')]"),
            itemSimpleFormDemo1 = $x("//ul[@class='dropdown-menu']/li/a[contains(text(), 'Simple Form Demo')]"),
            buttonStartPractising = $("#btn_basic_example"),
            itemSimpleFormDemo2 = $x("//div[@class='list-group']/a[contains(text(), 'Simple Form Demo')]"),
            dropdownOthers = $(byText("Others")),
            itemDragAndDrop = $(byText("Drag and Drop")),
            dropdownAlertAndModals = $(byText("Alerts & Modals")),
            itemFileDownload = $(byText("File Download")),
            itemCheckboxDemo = $(byText("Checkbox Demo")),
            dropdownTable = $x("//li[@class='dropdown']/a[contains(text(), 'Table')]"),
            openedMenu = $(".open .dropdown-menu"),
            itemRadioButtons = $(byText("Radio Buttons Demo")),
            itemSelectDropdownList = $(byText("Select Dropdown List")),
            dropdownInputForms2 = $x("//li[@class='tree-branch']/a[contains(text(), 'Input Forms')]"),
            itemAjaxFormSubmit = $x("//li[@class='tree-branch']/ul/li/a[contains(text(), 'Ajax Form Submit')]");
    public static SelenideElement buttonClosePopup = $("#at-cv-lightbox-close");

    public DemoHomePage clickInputFormsDropdown1() {
        dropdownInputForms1.click();
        return this;
    }

    public SimpleFormDemoPage openSimpleFormDemo1() {
        itemSimpleFormDemo1.click();
        return new SimpleFormDemoPage();
    }

    public SimpleFormDemoPage openSimpleFormDemo2() {
        itemSimpleFormDemo2.click();
        return new SimpleFormDemoPage();
    }

    public DemoHomePage clickStartPractisingButton() {
        buttonStartPractising.click();
        return this;
    }

    public DemoHomePage clickOthersDropdown() {
        dropdownOthers.click();
        return this;
    }

    public DragAndDropPage openDragAndDrop() {
        itemDragAndDrop.click();
        return new DragAndDropPage();
    }

    public DemoHomePage clickAlertAndModals() {
        dropdownAlertAndModals.click();
        return this;
    }

    public FileDownloadPage openFileDownload() {
        itemFileDownload.click();
        return new FileDownloadPage();
    }

    public CheckboxDemoPage openCheckboxDemo() {
        itemCheckboxDemo.click();
        return new CheckboxDemoPage();
    }

    private void clickTableDropdown() {
        dropdownTable.click();
    }

    public <PageObjectClass> PageObjectClass openTable(Table table, Class<PageObjectClass> pageObjectClass) {
        clickTableDropdown();
        openedMenu.$$("li").find(exactText(table.getVal())).click();
        return Selenide.page(pageObjectClass);
    }

    public RadioButtonsDemoPage openRadioButtons() {
        itemRadioButtons.click();
        return new RadioButtonsDemoPage();
    }

    public SelectDropdownListPage openSelectDropdownList() {
        itemSelectDropdownList.click();
        return new SelectDropdownListPage();
    }

    public DemoHomePage clickInputFormsDropdown2() {
        dropdownInputForms2.click();
        return this;
    }

    public AjaxFormSubmitPage openAjaxFormSubmit() {
        itemAjaxFormSubmit.click();
        return new AjaxFormSubmitPage();
    }
}
