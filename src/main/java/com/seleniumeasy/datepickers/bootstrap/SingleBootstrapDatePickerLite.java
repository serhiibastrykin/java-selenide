package com.seleniumeasy.datepickers.bootstrap;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.seleniumeasy.BasePage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SingleBootstrapDatePickerLite extends BasePage {
    LocalDate currentDate = LocalDate.now();
    private final SelenideElement inputDatePicker = $("input[placeholder='dd/mm/yyyy']"),
            daysTable = $("div[class=datepicker-days] table");
    private final ElementsCollection buttonsPrevious = $$("th[class=prev]"),
            buttonsNext = $$("th[class=next]"),
            buttonsClear = $$("th[class=clear]"),
            buttonsToday = $$("th[class=today]"),
            clickableDays = $$("td[class='day'], td[class='today day']"),
            unclickableSundays = $$("td[class='disabled disabled-date day']");

    private void openDatePicker() {
        inputDatePicker.click();
    }

    public SingleBootstrapDatePickerLite enterDate(String date) {
        String formattedDate = setDateFormat(date, "dd/MM/yyyy");
        inputDatePicker.setValue(formattedDate).pressEnter();
        return this;
    }

    public void clickPreviousMonth() {
        buttonsPrevious.get(0).click();
    }

    public void clickNextMonth() {
        buttonsNext.get(0).click();
    }

    public SingleBootstrapDatePickerLite clickToday() {
        buttonsToday.get(0).click();
        return this;
    }

    public SingleBootstrapDatePickerLite clickClear() {
        buttonsClear.get(0).click();
        return this;
    }

    public void validateDisplayedDate(String date) {
        String formattedDate = setDateFormat(date, "dd/MM/yyyy");
        inputDatePicker.shouldHave(value(formattedDate));
    }

    public void verifyDateIsNotDisplayed() {
        inputDatePicker.shouldBe(empty);
    }

    public SingleBootstrapDatePickerLite clickDate(String date) {
        openDatePicker();
        LocalDate enteredDate = LocalDate.parse(date);

        if (enteredDate.isAfter(currentDate)) {
            System.out.println("Future dates cannot be selected!");
            return this;
        } else {
            moveToEnteredDate(enteredDate);
        }

        String enteredDay = String.valueOf(enteredDate.getDayOfMonth());
        SelenideElement clickableDay = findDay(clickableDays, enteredDay);
        if (clickableDay != null) {
            clickableDay.click();
            return this;
        }

        SelenideElement unclickableDay = findDay(unclickableSundays, enteredDay);
        if (unclickableDay != null) {
            System.out.println("Day " + unclickableDay.getText() + " can't be selected because it's Sunday");
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

    private SelenideElement findDay(ElementsCollection days, String enteredDay) {
        for (SelenideElement day : days) {
            String dayText = day.getText();
            if (dayText.equals(enteredDay)) {
                return day;
            }
        }
        return null;
    }

    private String setDateFormat(String date, String pattern) {
        LocalDate displayedDate = LocalDate.parse(date);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(pattern);
        return dateFormat.format(displayedDate);
    }
}