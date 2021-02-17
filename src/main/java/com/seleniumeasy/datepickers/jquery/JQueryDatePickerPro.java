package com.seleniumeasy.datepickers.jquery;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.seleniumeasy.BasePage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;

public class JQueryDatePickerPro extends BasePage {
    private final SelenideElement inputFrom = $("#from"),
            inputTo = $("#to"),
            buttonPrev = $x("//span[contains(text(), 'Prev')]"),
            buttonNext = $x("//span[contains(text(), 'Next')]"),
            displayedYear = $("span[class=ui-datepicker-year]");
    private final ElementsCollection dropdownMonths = $$("select[class=ui-datepicker-month] option"),
            activeDays = $$("td[data-handler=selectDay]"),
            disabledDays = $$("td[class=' ui-datepicker-unselectable ui-state-disabled ']," +
                    "td[class=' ui-datepicker-week-end ui-datepicker-unselectable ui-state-disabled ']");

    public JQueryDatePickerPro clickInputFrom() {
        inputFrom.click();
        return this;
    }

    public JQueryDatePickerPro clickInputTo() {
        inputTo.click();
        return this;
    }

    private void clickButtonPrevious() {
        buttonPrev.click();
    }

    private void clickButtonNext() {
        buttonNext.click();
    }

    public JQueryDatePickerPro validateDisplayedDateInputFrom(LocalDate date) {
        String formattedDate = setDateFormat(date, "MM/dd/yyyy");
        inputFrom.shouldHave(value(formattedDate));
        return this;
    }

    public JQueryDatePickerPro validateDisplayedDateInputTo(LocalDate date) {
        String formattedDate = setDateFormat(date, "MM/dd/yyyy");
        inputTo.shouldHave(value(formattedDate));
        return this;
    }

    public void verifyInputFromIsEmpty() {
        inputFrom.shouldBe(empty);
    }

    public void verifyInputToIsEmpty() {
        inputTo.shouldBe(empty);
    }

    public JQueryDatePickerPro clickDate(String year, String month, String day) {
        moveToEnteredYear(year);
        selectMonth(month);
        clickDay(day);
        return this;
    }

    public JQueryDatePickerPro clickDate(int year, int month, int day) {
        moveToEnteredYear(year);
        selectMonth(month);
        clickDay(day);
        return this;
    }

    private void clickDay(int day) {
        SelenideElement clickableDay = findDateElements(activeDays, day);
        if (clickableDay != null) {
            clickableDay.click();
            return;
        }

        SelenideElement disabledDay = findDateElements(disabledDays, day);
        if (disabledDay != null) {
            disabledDay.click();
            System.out.println("Day " + disabledDay.getText() + " cannot be selected because it is disabled!");
        }
    }

    private void clickDay(String day) {
        SelenideElement clickableDay = findDateElements(activeDays, day);
        if (clickableDay != null) {
            clickableDay.click();
            return;
        }

        SelenideElement disabledDay = findDateElements(disabledDays, day);
        if (disabledDay != null) {
            disabledDay.click();
            System.out.println("Day " + disabledDay.getText() + " cannot be selected because it is disabled!");
        }
    }

    private void selectMonth(String month) {
        dropdownMonths.find(exactText(month)).setSelected(true);
    }

    private void selectMonth(int month) {
        String enteredMonth = String.valueOf(month - 1);
        dropdownMonths.find(value(enteredMonth)).setSelected(true);
    }

    private void moveToEnteredYear(int year) {
        int displayedYearValue = Integer.parseInt(displayedYear.getText());

        if (year < displayedYearValue) {
            while (year != displayedYearValue) {
                clickButtonPrevious();
                displayedYearValue = Integer.parseInt(displayedYear.getText());
            }
        } else if (year > displayedYearValue) {
            while (year != displayedYearValue) {
                clickButtonNext();
                displayedYearValue = Integer.parseInt(displayedYear.getText());
            }
        }
    }

    private void moveToEnteredYear(String year) {
        int enteredYear = Integer.parseInt(year);
        int displayedYearValue = Integer.parseInt(displayedYear.getText());
        String displayedYearText = displayedYear.getText();

        if (enteredYear < displayedYearValue) {
            while (!year.equals(displayedYearText)) {
                clickButtonPrevious();
                displayedYearText = displayedYear.getText();
            }
        } else if (enteredYear > displayedYearValue) {
            while (!year.equals(displayedYearText)) {
                clickButtonNext();
                displayedYearText = displayedYear.getText();
            }
        }
    }

    private SelenideElement findDateElements(ElementsCollection dateElements, int enteredDateElement) {
        for (SelenideElement dateElement : dateElements) {
            int dateElementValue = Integer.parseInt(dateElement.getText());
            if (dateElementValue == enteredDateElement) {
                return dateElement;
            }
        }
        return null;
    }

    private SelenideElement findDateElements(ElementsCollection dateElements, String enteredDateElement) {
        for (SelenideElement dateElement : dateElements) {
            String dateElementText = dateElement.getText();
            if (dateElementText.equals(enteredDateElement)) {
                return dateElement;
            }
        }
        return null;
    }

    private String setDateFormat(LocalDate date, String pattern) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(pattern);
        return dateFormat.format(date);
    }
}