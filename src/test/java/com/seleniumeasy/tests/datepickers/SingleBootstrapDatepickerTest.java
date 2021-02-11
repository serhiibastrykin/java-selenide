package com.seleniumeasy.tests.datepickers;

import com.seleniumeasy.datepickers.SingleBootstrapDatepickerLite;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.time.LocalDate;

import static com.seleniumeasy.enums.DatePickers.BOOTSTRAP_DATE_PICKER;

public class SingleBootstrapDatepickerTest extends BaseTest {
    LocalDate currentDate = LocalDate.now();
    String futureDate = currentDate.plusMonths(3).plusDays(15).toString();
    String pastDate = LocalDate.of(2018, 7, 4).toString();
    String sundayDate = LocalDate.of(2020, 11, 15).toString();

    SingleBootstrapDatepickerLite singleBootstrapDatepickerLite = new SingleBootstrapDatepickerLite();

    @Test
    public void testClickingFutureDate() {
        singleBootstrapDatepickerLite
                .openDatePickers(BOOTSTRAP_DATE_PICKER, SingleBootstrapDatepickerLite.class)
                .clickDate(futureDate)
                .verifyDateIsNotDisplayed();
    }

    @Test
    public void testEnteringFutureDate() {
        singleBootstrapDatepickerLite
                .openDatePickers(BOOTSTRAP_DATE_PICKER, SingleBootstrapDatepickerLite.class)
                .enterDate(futureDate)
                .validateDisplayedDate(currentDate.toString());
    }

    @Test
    public void testClickingCurrentDate() {
        singleBootstrapDatepickerLite
                .openDatePickers(BOOTSTRAP_DATE_PICKER, SingleBootstrapDatepickerLite.class)
                .clickDate(currentDate.toString())
                .validateDisplayedDate(currentDate.toString());
    }

    @Test
    public void testEnteringCurrentDate() {
        singleBootstrapDatepickerLite
                .openDatePickers(BOOTSTRAP_DATE_PICKER, SingleBootstrapDatepickerLite.class)
                .enterDate(currentDate.toString())
                .validateDisplayedDate(currentDate.toString());
    }

    @Test
    public void testClickingPastDate() {
        singleBootstrapDatepickerLite
                .openDatePickers(BOOTSTRAP_DATE_PICKER, SingleBootstrapDatepickerLite.class)
                .clickDate(pastDate)
                .validateDisplayedDate(pastDate);
    }

    @Test
    public void testEnteringPastDate() {
        singleBootstrapDatepickerLite
                .openDatePickers(BOOTSTRAP_DATE_PICKER, SingleBootstrapDatepickerLite.class)
                .enterDate(pastDate)
                .validateDisplayedDate(pastDate);
    }

    @Test
    public void testClickingSunday() {
        singleBootstrapDatepickerLite
                .openDatePickers(BOOTSTRAP_DATE_PICKER, SingleBootstrapDatepickerLite.class)
                .clickDate(sundayDate)
                .verifyDateIsNotDisplayed();
    }

    @Test
    public void testEnteringSunday() {
        singleBootstrapDatepickerLite
                .openDatePickers(BOOTSTRAP_DATE_PICKER, SingleBootstrapDatepickerLite.class)
                .enterDate(sundayDate)
                .verifyDateIsNotDisplayed();  /* the date is displayed in the input though, but it's definitely a bug because
                                               the outcome should the same as for the testClickingSunday() test */
    }
}