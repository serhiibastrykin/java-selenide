package com.seleniumeasy.datepickers.bootstrap;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.seleniumeasy.BasePage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DoubleBootstrapDatePickerPage extends BasePage {
    LocalDate currentDate = LocalDate.now();
    private final SelenideElement inputStartDate = $("input[placeholder='Start date']"),
            inputEndDate = $("input[placeholder='End date']"),
            daysTable = $("div[class=datepicker-days] table"),
            monthsTable = $("div[class=datepicker-months] table"),
            yearsTable = $("div[class=datepicker-years] table");
    private final ElementsCollection datePickerHeaders = $$("th[class=datepicker-switch]"),
            buttonsPrevious = $$("th[class=prev]"),
            buttonsNext = $$("th[class=next]"),
            clickableDays = $$("td[class='day'], td[class='today day']"),
            clickableMonths = $$("span[class='month'], span[class='month focused']"),
            clickableYears = $$("span[class='year'], span[class='year focused']"),
            unclickableSundays = $$("td[class='disabled disabled-date day']");

    public DoubleBootstrapDatePickerPage clickInputStartDate() {
        inputStartDate.click();
        return this;
    }

    public DoubleBootstrapDatePickerPage clickInputEndDate() {
        inputEndDate.click();
        return this;
    }

    public DoubleBootstrapDatePickerPage enterStartDate(LocalDate date) {
        String formattedDate = setDateFormat(date, "dd/MM/yyyy");
        inputStartDate.setValue(formattedDate).pressEnter();
        return this;
    }

    public DoubleBootstrapDatePickerPage enterEndDate(LocalDate date) {
        String formattedDate = setDateFormat(date, "dd/MM/yyyy");
        inputEndDate.setValue(formattedDate).pressEnter();
        return this;
    }

    private void clickPreviousMonth() {
        buttonsPrevious.get(0).click();
    }

    private void clickPreviousYear() {
        buttonsPrevious.get(1).click();
    }

    private void clickPreviousDecade() {
        buttonsPrevious.get(2).click();
    }

    private void clickNextMonth() {
        buttonsNext.get(0).click();
    }

    private void clickNextYear() {
        buttonsNext.get(1).click();
    }

    private void clickNextDecade() {
        buttonsNext.get(2).click();
    }

    private void clickHeaderWithMonthAndYear() {
        datePickerHeaders.get(0).click();
    }

    private void clickHeaderWithYear() {
        datePickerHeaders.get(1).click();
    }

    public DoubleBootstrapDatePickerPage validateDisplayedStartDate(LocalDate date) {
        String formattedDate = setDateFormat(date, "dd/MM/yyyy");
        inputStartDate.shouldHave(value(formattedDate));
        return this;
    }

    public DoubleBootstrapDatePickerPage validateDisplayedEndDate(LocalDate date) {
        String formattedDate = setDateFormat(date, "dd/MM/yyyy");
        inputEndDate.shouldHave(value(formattedDate));
        return this;
    }

    public DoubleBootstrapDatePickerPage verifyStartDateIsNotDisplayed() {
        inputStartDate.shouldBe(empty);
        return this;
    }

    public DoubleBootstrapDatePickerPage verifyEndDateIsNotDisplayed() {
        inputEndDate.shouldBe(empty);
        return this;
    }

    public DoubleBootstrapDatePickerPage clickEnteredDate(LocalDate enteredDate) {
        clickHeaderWithMonthAndYear();
        clickHeaderWithYear();

        clickYear(enteredDate);
        clickMonth(enteredDate);
        clickDay(enteredDate);
        return this;
    }

    private void clickDay(LocalDate enteredDate) {
        moveToEnteredDay(enteredDate);

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
        moveToEnteredMonth(enteredDate);

        String enteredMonth = setDateFormat(enteredDate, "dd/MMM/yyyy").split("/")[1];
        SelenideElement clickableMonth = findDateElements(clickableMonths, enteredMonth);
        if (clickableMonth != null) {
            clickableMonth.click();
        }
    }

    private void clickYear(LocalDate enteredDate) {
        moveToEnteredYear(enteredDate);

        String enteredYear = String.valueOf(enteredDate.getYear());
        SelenideElement clickableYear = findDateElements(clickableYears, enteredYear);
        if (clickableYear != null) {
            clickableYear.click();
        }
    }

    private void moveToEnteredDay(LocalDate enteredDate) {
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
        } else if (enteredDate.isAfter(currentDate)) {
            while (!displayedMonthAndYear[0].equalsIgnoreCase(enteredMonth)
                    || (!displayedMonthAndYear[1].equals(enteredYear))) {
                clickNextMonth();
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
        } else if (enteredDate.isAfter(currentDate)) {
            while (!displayedYear.equals(enteredYear)) {
                clickNextYear();
                displayedYear = currentYear.getText();
            }
        }
    }

    private void moveToEnteredYear(LocalDate enteredDate) {
        int enteredYear = enteredDate.getYear();
        int firstYearOfDecade = getAllYearsFromDecade().get(0);
        int lastYearOfDecade = getAllYearsFromDecade().size() - 1;
        List<Integer> yearsFromDecade = getAllYearsFromDecade();

        if (enteredYear < firstYearOfDecade) {
            while (!yearsFromDecade.contains(enteredYear)) {
                clickPreviousDecade();
                yearsFromDecade = getAllYearsFromDecade();
            }
        } else if (enteredYear > lastYearOfDecade) {
            while (!yearsFromDecade.contains(enteredYear)) {
                clickNextDecade();
                yearsFromDecade = getAllYearsFromDecade();
            }
        }
    }

    private List<Integer> getAllYearsFromDecade() {
        SelenideElement currentDecade = yearsTable.$("thead th[class='datepicker-switch']");
        String displayedDecade = currentDecade.getText();
        String[] decade = displayedDecade.split("-");
        int initialYear = Integer.parseInt(decade[0]);
        int finalYear = Integer.parseInt(decade[1]);
        List<Integer> decadeYears = new ArrayList<>();
        for (int year = initialYear; year <= finalYear; year++) {
            decadeYears.add(year);
        }
        return decadeYears;
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