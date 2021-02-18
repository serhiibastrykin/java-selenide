package com.seleniumeasy.tests.datepickers.bootstrap;

import com.seleniumeasy.datepickers.bootstrap.SingleBootstrapDatePickerLite;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.time.LocalDate;

import static com.seleniumeasy.enums.DatePickers.BOOTSTRAP_DATE_PICKER;

public class SingleBootstrapDatePickerLiteTest extends BaseTest {
    LocalDate currentDate = LocalDate.now();
    String futureDate = currentDate.plusMonths(3).plusDays(15).toString();
    String pastDate = LocalDate.of(2018, 7, 4).toString();
    String sundayDate = LocalDate.of(2020, 11, 15).toString();

    SingleBootstrapDatePickerLite singleBootstrapDatePickerLite = new SingleBootstrapDatePickerLite();

    @Test
    public void testClickFutureDate() {
        singleBootstrapDatePickerLite
                .openDatePickers(BOOTSTRAP_DATE_PICKER, SingleBootstrapDatePickerLite.class)
                .clickDate(futureDate)
                .verifyDateIsNotDisplayed();
    }

    @Test
    public void testEnterFutureDate() {
        singleBootstrapDatePickerLite
                .openDatePickers(BOOTSTRAP_DATE_PICKER, SingleBootstrapDatePickerLite.class)
                .enterDate(futureDate)
                .validateDisplayedDate(currentDate.toString());
    }

    @Test
    public void testClickCurrentDate() {
        singleBootstrapDatePickerLite
                .openDatePickers(BOOTSTRAP_DATE_PICKER, SingleBootstrapDatePickerLite.class)
                .clickDate(currentDate.toString())
                .validateDisplayedDate(currentDate.toString());
    }

    @Test
    public void testEnterCurrentDate() {
        singleBootstrapDatePickerLite
                .openDatePickers(BOOTSTRAP_DATE_PICKER, SingleBootstrapDatePickerLite.class)
                .enterDate(currentDate.toString())
                .validateDisplayedDate(currentDate.toString());
    }

    @Test
    public void testClickPastDate() {
        singleBootstrapDatePickerLite
                .openDatePickers(BOOTSTRAP_DATE_PICKER, SingleBootstrapDatePickerLite.class)
                .clickDate(pastDate)
                .validateDisplayedDate(pastDate);
    }

    @Test
    public void testEnterPastDate() {
        singleBootstrapDatePickerLite
                .openDatePickers(BOOTSTRAP_DATE_PICKER, SingleBootstrapDatePickerLite.class)
                .enterDate(pastDate)
                .validateDisplayedDate(pastDate);
    }

    @Test
    public void testClickSunday() {
        singleBootstrapDatePickerLite
                .openDatePickers(BOOTSTRAP_DATE_PICKER, SingleBootstrapDatePickerLite.class)
                .clickDate(sundayDate)
                .verifyDateIsNotDisplayed();
    }

    @Test
    public void testEnterSunday() {
        singleBootstrapDatePickerLite
                .openDatePickers(BOOTSTRAP_DATE_PICKER, SingleBootstrapDatePickerLite.class)
                .enterDate(sundayDate)
                .verifyDateIsNotDisplayed();  /* the date is displayed in the input though, but it's definitely a bug because
                                               the outcome should the same as for the testClickingSunday() test */
    }
}