package com.seleniumeasy.datepickers;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.seleniumeasy.BasePage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SingleBootstrapDatepickerExtended extends BasePage {
    LocalDate currentDate = LocalDate.now();
    private final SelenideElement inputDatepicker = $("input[placeholder='dd/mm/yyyy']"),
            daysTable = $("div[class=datepicker-days] table"),
            monthsTable = $("div[class=datepicker-months] table"),
            yearsTable = $("div[class=datepicker-years] table");
    private final ElementsCollection datepickerHeaders = $$("th[class=datepicker-switch]"),
            buttonsPrevious = $$("th[class=prev]"),
            buttonsNext = $$("th[class=next]"),
            buttonsClear = $$("th[class=clear]"),
            buttonsToday = $$("th[class=today]"),
            clickableDays = $$("td[class='day'], td[class='today day']"),
            clickableMonths = $$("span[class='month'], span[class='month focused']"),
            clickableYears = $$("span[class='year'], span[class='year focused']"),
            unclickableSundays = $$("td[class='disabled disabled-date day']");

    public SingleBootstrapDatepickerExtended openDatepicker() {
        inputDatepicker.click();
        return this;
    }

    public SingleBootstrapDatepickerExtended enterDate(LocalDate date) {
        String formattedDate = setDateFormat(date, "dd/MM/yyyy");
        inputDatepicker.setValue(formattedDate).pressEnter();
        return this;
    }

    public SingleBootstrapDatepickerExtended clickPreviousMonth() {
        buttonsPrevious.get(0).click();
        return this;
    }

    public SingleBootstrapDatepickerExtended clickPreviousYear() {
        buttonsPrevious.get(1).click();
        return this;
    }

    public SingleBootstrapDatepickerExtended clickPreviousDecade() {
        buttonsPrevious.get(2).click();
        return this;
    }

    public SingleBootstrapDatepickerExtended clickNextMonth() {
        buttonsNext.get(0).click();
        return this;
    }

    public SingleBootstrapDatepickerExtended clickNextYear() {
        buttonsNext.get(1).click();
        return this;
    }

    public SingleBootstrapDatepickerExtended clickNextDecade() {
        buttonsNext.get(2).click();
        return this;
    }

    public SingleBootstrapDatepickerExtended clickHeaderWithMonthAndYear() {
        datepickerHeaders.get(0).click();
        return this;
    }

    public SingleBootstrapDatepickerExtended clickHeaderWithYear() {
        datepickerHeaders.get(1).click();
        return this;
    }

    public SingleBootstrapDatepickerExtended clickTodayDays() {
        buttonsToday.get(0).click();
        return this;
    }

    public SingleBootstrapDatepickerExtended clickTodayMonths() {
        buttonsToday.get(1).click();
        return this;
    }

    public SingleBootstrapDatepickerExtended clickTodayYears() {
        buttonsToday.get(2).click();
        return this;
    }

    public SingleBootstrapDatepickerExtended clickClearDays() {
        buttonsClear.get(0).click();
        return this;
    }

    public SingleBootstrapDatepickerExtended clickClearMonths() {
        buttonsClear.get(1).click();
        return this;
    }

    public SingleBootstrapDatepickerExtended clickClearYears() {
        buttonsClear.get(2).click();
        return this;
    }

    public void validateDisplayedDate(LocalDate date) {
        String formattedDate = setDateFormat(date, "dd/MM/yyyy");
        inputDatepicker.shouldHave(value(formattedDate));
    }

    public void verifyDateIsNotDisplayed() {
        inputDatepicker.shouldBe(empty);
    }

    public SingleBootstrapDatepickerExtended clickDesiredDate(LocalDate enteredDate) {
        openDatepicker();
        clickHeaderWithMonthAndYear();
        clickHeaderWithYear();

        clickYear(enteredDate);
        clickMonth(enteredDate);
        clickDay(enteredDate);
        return this;
    }

    public SingleBootstrapDatepickerExtended clickDay(LocalDate enteredDate) {
        if (enteredDate.isAfter(currentDate)) {
            System.out.println("Future dates cannot be selected!");
            return this;
        } else {
            moveToEnteredDate(enteredDate);
        }

        String enteredDay = String.valueOf(enteredDate.getDayOfMonth());
        SelenideElement clickableDay = findDateElements(clickableDays, enteredDay);
        if (clickableDay != null) {
            clickableDay.click();
            return this;
        }

        SelenideElement unclickableDay = findDateElements(unclickableSundays, enteredDay);
        if (unclickableDay != null) {
            System.out.println("Day " + unclickableDay.getText() + " can't be selected because it's Sunday");
            return this;
        }
        return this;
    }

    public SingleBootstrapDatepickerExtended clickMonth(LocalDate enteredDate) {
        if (enteredDate.isAfter(currentDate)) {
            System.out.println("Future dates cannot be selected!");
            return this;
        } else {
            moveToEnteredMonth(enteredDate);
        }

        String enteredMonth = setDateFormat(enteredDate, "dd/MMM/yyyy").split("/")[1];
        SelenideElement clickableMonth = findDateElements(clickableMonths, enteredMonth);
        if (clickableMonth != null) {
            clickableMonth.click();
            return this;
        }
        return this;
    }

    public SingleBootstrapDatepickerExtended clickYear(LocalDate enteredDate) {
        if (enteredDate.isAfter(currentDate)) {
            System.out.println("Future dates cannot be selected!");
            return this;
        } else {
            moveToEnteredYear(enteredDate);
        }

        String enteredYear = String.valueOf(enteredDate.getYear());
        SelenideElement clickableYear = findDateElements(clickableYears, enteredYear);
        if (clickableYear != null) {
            clickableYear.click();
            return this;
        }
        return this;
    }

    private void moveToEnteredDate(LocalDate enteredDate) {
        SelenideElement currentMonthAndYear = daysTable.$("thead th[class='datepicker-switch']");
        String[] displayedMonthAndYear = currentMonthAndYear.getText().split(" ");
        String enteredMonth = enteredDate.getMonth().toString();
        String enteredYear = String.valueOf(enteredDate.getYear());

        if (enteredDate.isBefore(currentDate) || enteredDate.isEqual(currentDate)) {
            while (!displayedMonthAndYear[0].equalsIgnoreCase(enteredMonth)
                    || (!displayedMonthAndYear[1].equals(enteredYear))) {
                clickPreviousMonth();
                displayedMonthAndYear = currentMonthAndYear.getText().split(" ");
            }
        }
    }

    private void moveToEnteredMonth(LocalDate enteredDate) {
        SelenideElement currentYear = monthsTable.$("thead th[class='datepicker-switch']");
        String displayedYear = currentYear.getText();
        String enteredYear = String.valueOf(enteredDate.getYear());

        if (enteredDate.isBefore(currentDate) || enteredDate.isEqual(currentDate)) {
            while (!displayedYear.equals(enteredYear)) {
                clickPreviousYear();
                displayedYear = currentYear.getText();
            }
        }
    }

    private void moveToEnteredYear(LocalDate enteredDate) {
        int enteredYear = enteredDate.getYear();
        List<Integer> yearsFromDecade = getAllYearsFromDecade();

        while (!yearsFromDecade.contains(enteredYear)) {
            clickPreviousDecade();
            yearsFromDecade = getAllYearsFromDecade();
        }
    }

    private List<Integer> getAllYearsFromDecade() {
        SelenideElement currentDecade = yearsTable.$("thead th[class='datepicker-switch']");
        String displayedDecade = currentDecade.getText();
        String[] decade = displayedDecade.split("-");
        int initialYear = Integer.parseInt(decade[0]);
        int finalYear = Integer.parseInt(decade[1]);
        List<Integer> result = new ArrayList<>();
        for (int year = initialYear; year <= finalYear; year++) {
            result.add(year);
        }
        return result;
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