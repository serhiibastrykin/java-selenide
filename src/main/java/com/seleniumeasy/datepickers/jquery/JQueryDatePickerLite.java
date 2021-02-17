package com.seleniumeasy.datepickers.jquery;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.seleniumeasy.BasePage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;

public class JQueryDatePickerLite extends BasePage {
    LocalDate currentDate = LocalDate.now();
    private final SelenideElement inputFrom = $("#from"),
            inputTo = $("#to"),
            buttonPrev = $x("//span[contains(text(), 'Prev')]"),
            buttonNext = $x("//span[contains(text(), 'Next')]"),
            displayedYear = $("span[class=ui-datepicker-year]");
    private final ElementsCollection dropdownMonths = $$("select[class=ui-datepicker-month] option"),
            activeDays = $$("td[data-handler=selectDay]"),
            disabledDays = $$("td[class=' ui-datepicker-unselectable ui-state-disabled ']," +
                    "td[class=' ui-datepicker-week-end ui-datepicker-unselectable ui-state-disabled ']");

    public JQueryDatePickerLite clickInputFrom() {
        inputFrom.click();
        return this;
    }

    public JQueryDatePickerLite clickInputTo() {
        inputTo.click();
        return this;
    }

    private void clickButtonPrevious() {
        buttonPrev.click();
    }

    private void clickButtonNext() {
        buttonNext.click();
    }

    public JQueryDatePickerLite validateDisplayedDateInputFrom(LocalDate date) {
        String formattedDate = setDateFormat(date, "MM/dd/yyyy");
        inputFrom.shouldHave(value(formattedDate));
        return this;
    }

    public JQueryDatePickerLite validateDisplayedDateInputTo(LocalDate date) {
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

    public JQueryDatePickerLite clickDate(LocalDate enteredDate) {
        moveToEnteredDate(enteredDate);
        String enteredDay = String.valueOf(enteredDate.getDayOfMonth());

        SelenideElement clickableDay = findDateElements(activeDays, enteredDay);
        if (clickableDay != null) {
            clickableDay.click();
            return this;
        }

        SelenideElement disabledDay = findDateElements(disabledDays, enteredDay);
        if (disabledDay != null) {
            disabledDay.click();
            System.out.println("Day " + disabledDay.getText() + " cannot be selected because it is disabled!");
            return this;
        }
        return this;
    }

    private void moveToEnteredDate(LocalDate enteredDate) {
        String formattedDate = setDateFormat(enteredDate, "dd/MMM/yyyy");
        String[] enteredMonthAndYear = formattedDate.split("/");
        String enteredMonth = enteredMonthAndYear[1];
        String enteredYear = enteredMonthAndYear[2];
        String displayedMonthText = dropdownMonths.find(attribute("selected")).getText();
        String displayedYearText = displayedYear.getText();

        if (enteredDate.isBefore(currentDate) || enteredDate.isEqual(currentDate)) {
            while (!displayedMonthText.equals(enteredMonth)
                    || (!displayedYearText.equals(enteredYear))) {
                clickButtonPrevious();
                displayedMonthText = dropdownMonths.find(attribute("selected")).getText();
                displayedYearText = displayedYear.getText();
            }
        } else if (enteredDate.isAfter(currentDate)) {
            while (!displayedMonthText.equals(enteredMonth)
                    || (!displayedYearText.equals(enteredYear))) {
                clickButtonNext();
                displayedMonthText = dropdownMonths.find(attribute("selected")).getText();
                displayedYearText = displayedYear.getText();
            }
        }
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