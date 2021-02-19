package com.seleniumeasy.datepickers.bootstrap;

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

public class SingleBootstrapDatePickerPro extends BasePage {
    LocalDate currentDate = LocalDate.now();
    private final SelenideElement inputDatepicker = $("input[placeholder='dd/mm/yyyy']"),
            yearsTable = $("div[class=datepicker-years] table");
    private final ElementsCollection datepickerHeaders = $$("th[class=datepicker-switch]"),
            buttonsPrevious = $$("th[class=prev]"),
            clickableDays = $$("td[class='day'], td[class='today day']"),
            clickableMonths = $$("span[class='month'], span[class='month focused']"),
            clickableYears = $$("span[class='year'], span[class='year focused']"),
            unclickableSundays = $$("td[class='disabled disabled-date day']");

    private void openDatepicker() {
        inputDatepicker.click();
    }

    private void clickPreviousDecade() {
        buttonsPrevious.get(2).click();
    }

    private void clickHeaderWithMonthAndYear() {
        datepickerHeaders.get(0).click();
    }

    private void clickHeaderWithYear() {
        datepickerHeaders.get(1).click();
    }

    public void validateDisplayedDate(LocalDate date) {
        String formattedDate = setDateFormat(date, "dd/MM/yyyy");
        inputDatepicker.shouldHave(value(formattedDate));
    }

    public void verifyDateIsNotDisplayed() {
        inputDatepicker.shouldBe(empty);
    }

    public SingleBootstrapDatePickerPro clickDesiredDate(LocalDate enteredDate) {
        openDatepicker();
        clickHeaderWithMonthAndYear();
        clickHeaderWithYear();

        clickYear(enteredDate);
        clickMonth(enteredDate);
        clickDay(enteredDate);
        return this;
    }

    private void clickDay(LocalDate enteredDate) {
        String enteredDay = String.valueOf(enteredDate.getDayOfMonth());
        SelenideElement clickableDay = findDateElements(clickableDays, enteredDay);
        if (clickableDay != null) {
            clickableDay.click();
            return;
        }

        SelenideElement unclickableDay = findDateElements(unclickableSundays, enteredDay);
        if (unclickableDay != null) {
            System.out.println("Day " + unclickableDay.getText() + " can't be selected because it's Sunday");
        }
    }

    private void clickMonth(LocalDate enteredDate) {
        String enteredMonth = setDateFormat(enteredDate, "dd/MMM/yyyy").split("/")[1];
        SelenideElement clickableMonth = findDateElements(clickableMonths, enteredMonth);
        if (clickableMonth != null) {
            clickableMonth.click();
        }
    }

    private void clickYear(LocalDate enteredDate) {
        if (enteredDate.isAfter(currentDate)) {
            System.out.println("Future dates cannot be selected!");
            return;
        } else {
            moveToEnteredYear(enteredDate);
        }

        String enteredYear = String.valueOf(enteredDate.getYear());
        SelenideElement clickableYear = findDateElements(clickableYears, enteredYear);
        if (clickableYear != null) {
            clickableYear.click();
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