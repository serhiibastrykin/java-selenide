package com.seleniumeasy.tests.datepickers.bootstrap;

import com.seleniumeasy.datepickers.bootstrap.DoubleBootstrapDatePickerPage;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.time.LocalDate;

import static com.seleniumeasy.enums.DatePickers.BOOTSTRAP_DATE_PICKER;

public class DoubleBootstrapDatePickerTest extends BaseTest {

    DoubleBootstrapDatePickerPage doubleBootstrapDatePickerPage = new DoubleBootstrapDatePickerPage();

    @Test
    public void testDateFrom_To() {
        doubleBootstrapDatePickerPage
                .openDatePickers(BOOTSTRAP_DATE_PICKER, DoubleBootstrapDatePickerPage.class)
                .clickInputStartDate()
                .clickEnteredDate(LocalDate.of(1929, 3, 12))
                .clickInputEndDate()
                .clickEnteredDate(LocalDate.of(2073, 11, 4))
                .validateDisplayedStartDate(LocalDate.of(1929, 3, 12))
                .validateDisplayedEndDate(LocalDate.of(2073, 11, 4));
    }
}