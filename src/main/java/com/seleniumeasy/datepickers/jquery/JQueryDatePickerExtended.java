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

public class JQueryDatePickerExtended extends BasePage {
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

    public JQueryDatePickerExtended clickInputFrom() {
        inputFrom.click();
        return this;
    }

    public JQueryDatePickerExtended clickInputTo() {
        inputTo.click();
        return this;
    }

    public JQueryDatePickerExtended clickButtonPrevious() {
        buttonPrev.click();
        return this;
    }

    public JQueryDatePickerExtended clickButtonNext() {
        buttonNext.click();
        return this;
    }

    public JQueryDatePickerExtended enterDateInputFrom(LocalDate date) {
        String formattedDate = setDateFormat(date, "dd/MM/yyyy");
        inputFrom.setValue(formattedDate).pressEnter();
        return this;
    }

    public JQueryDatePickerExtended enterDateInputTo(LocalDate date) {
        String formattedDate = setDateFormat(date, "dd/MM/yyyy");
        inputTo.setValue(formattedDate).pressEnter();
        return this;
    }

    public JQueryDatePickerExtended validateDisplayedDateInputFrom(LocalDate date) {
        String formattedDate = setDateFormat(date, "MM/dd/yyyy");
        inputFrom.shouldHave(value(formattedDate));
        return this;
    }

    public JQueryDatePickerExtended validateDisplayedDateInputTo(LocalDate date) {
        String formattedDate = setDateFormat(date, "MM/dd/yyyy");
        inputTo.shouldHave(value(formattedDate));
        return this;
    }

    public JQueryDatePickerExtended verifyInputFromIsEmpty() {
        inputFrom.shouldBe(empty);
        return this;
    }

    public JQueryDatePickerExtended verifyInputToIsEmpty() {
        inputTo.shouldBe(empty);
        return this;
    }

    public JQueryDatePickerExtended selectMonth(String month) {
        dropdownMonths.find(exactText(month)).setSelected(true);
        return this;
    }

    public JQueryDatePickerExtended selectMonth(int month) {
        String enteredMonth = String.valueOf(month - 1);
        dropdownMonths.find(value(enteredMonth)).setSelected(true);
        return this;
    }

    public JQueryDatePickerExtended clearInputFrom() {
        inputFrom.clear();
        return this;
    }

    public JQueryDatePickerExtended clearInputTo() {
        inputTo.clear();
        return this;
    }

    public JQueryDatePickerExtended clickDate(String year, String month, String day) {
        moveToEnteredYear(year);
        selectMonth(month);
        clickDay(day);
        return this;
    }

    public JQueryDatePickerExtended clickDate(int year, int month, int day) {
        moveToEnteredYear(year);
        selectMonth(month);
        clickDay(day);
        return this;
    }

    public JQueryDatePickerExtended clickDay(int day) {
        SelenideElement clickableDay = findDateElements(activeDays, day);
        if (clickableDay != null) {
            clickableDay.click();
            return this;
        }

        SelenideElement disabledDay = findDateElements(disabledDays, day);
        if (disabledDay != null) {
            disabledDay.click();
            System.out.println("Day " + disabledDay.getText() + " cannot be selected because it is disabled!");
            return this;
        }
        return this;
    }

    public JQueryDatePickerExtended clickDay(String day) {
        SelenideElement clickableDay = findDateElements(activeDays, day);
        if (clickableDay != null) {
            clickableDay.click();
            return this;
        }

        SelenideElement disabledDay = findDateElements(disabledDays, day);
        if (disabledDay != null) {
            disabledDay.click();
            System.out.println("Day " + disabledDay.getText() + " cannot be selected because it is disabled!");
            return this;
        }
        return this;
    }

    public JQueryDatePickerExtended moveToEnteredYear(int year) {
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
        return this;
    }

    public JQueryDatePickerExtended moveToEnteredYear(String year) {
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
        return this;
    }

    public JQueryDatePickerExtended clickDate(LocalDate enteredDate) {
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