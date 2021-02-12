package com.seleniumeasy.tests.datepickers;

import com.seleniumeasy.datepickers.SingleBootstrapDatepickerPro;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.time.LocalDate;

import static com.seleniumeasy.enums.DatePickers.BOOTSTRAP_DATE_PICKER;

public class SingleBootstrapDatepickerProTest extends BaseTest {
    LocalDate currentDate = LocalDate.now();

    SingleBootstrapDatepickerPro singleBootstrapDatepickerPro = new SingleBootstrapDatepickerPro();

    @Test
    public void testClickPastDate() {
        singleBootstrapDatepickerPro
                .openDatePickers(BOOTSTRAP_DATE_PICKER, SingleBootstrapDatepickerPro.class)
                .clickDesiredDate(LocalDate.of(1976, 5, 12))
                .validateDisplayedDate(LocalDate.of(1976, 5, 12));
    }

    @Test
    public void testClickCurrentDate() {
        singleBootstrapDatepickerPro
                .openDatePickers(BOOTSTRAP_DATE_PICKER, SingleBootstrapDatepickerPro.class)
                .clickDesiredDate(LocalDate.now())
                .validateDisplayedDate(LocalDate.now());
    }

    @Test
    public void testClickFutureDate() {
        singleBootstrapDatepickerPro
                .openDatePickers(BOOTSTRAP_DATE_PICKER, SingleBootstrapDatepickerPro.class)
                .clickDesiredDate(currentDate.plusMonths(3).plusDays(15))
                .verifyDateIsNotDisplayed();
    }

    @Test
    public void testTryClickSunday() {
        singleBootstrapDatepickerPro
                .openDatePickers(BOOTSTRAP_DATE_PICKER, SingleBootstrapDatepickerPro.class)
                .clickDesiredDate(LocalDate.of(1997, 4, 27))
                .verifyDateIsNotDisplayed();
    }
}