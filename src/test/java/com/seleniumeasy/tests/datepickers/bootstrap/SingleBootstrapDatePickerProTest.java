package com.seleniumeasy.tests.datepickers.bootstrap;

import com.seleniumeasy.datepickers.bootstrap.SingleBootstrapDatePickerPro;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.time.LocalDate;

import static com.seleniumeasy.enums.DatePickers.BOOTSTRAP_DATE_PICKER;

public class SingleBootstrapDatePickerProTest extends BaseTest {
    LocalDate currentDate = LocalDate.now();

    SingleBootstrapDatePickerPro singleBootstrapDatePickerPro = new SingleBootstrapDatePickerPro();

    @Test
    public void testClickPastDate() {
        singleBootstrapDatePickerPro
                .openDatePickers(BOOTSTRAP_DATE_PICKER, SingleBootstrapDatePickerPro.class)
                .clickDesiredDate(LocalDate.of(1976, 5, 12))
                .validateDisplayedDate(LocalDate.of(1976, 5, 12));
    }

    @Test
    public void testClickCurrentDate() {
        singleBootstrapDatePickerPro
                .openDatePickers(BOOTSTRAP_DATE_PICKER, SingleBootstrapDatePickerPro.class)
                .clickDesiredDate(LocalDate.now())
                .validateDisplayedDate(LocalDate.now());
    }

    @Test
    public void testClickFutureDate() {
        singleBootstrapDatePickerPro
                .openDatePickers(BOOTSTRAP_DATE_PICKER, SingleBootstrapDatePickerPro.class)
                .clickDesiredDate(currentDate.plusMonths(3).plusDays(15))
                .verifyDateIsNotDisplayed();
    }

    @Test
    public void testTryClickSunday() {
        singleBootstrapDatePickerPro
                .openDatePickers(BOOTSTRAP_DATE_PICKER, SingleBootstrapDatePickerPro.class)
                .clickDesiredDate(LocalDate.of(1997, 4, 27))
                .verifyDateIsNotDisplayed();
    }
}