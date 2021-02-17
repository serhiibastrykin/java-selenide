package com.seleniumeasy.tests.datepickers.jquery;

import com.seleniumeasy.datepickers.jquery.JQueryDatePickerLite;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.time.LocalDate;

import static com.seleniumeasy.enums.DatePickers.JQUERY_DATE_PICKER;

public class JQueryDatePickerLiteTest extends BaseTest {

    JQueryDatePickerLite jQueryDatePickerLite = new JQueryDatePickerLite();

    @Test
    public void test_From_To_ClickableDate() {
        jQueryDatePickerLite
                .openDatePickers(JQUERY_DATE_PICKER, JQueryDatePickerLite.class)
                .clickInputFrom()
                .clickDate(LocalDate.of(2018, 3, 31))
                .clickInputTo()
                .clickDate(LocalDate.of(2019, 5, 31))
                .validateDisplayedDateInputFrom(LocalDate.of(2018, 3, 31))
                .validateDisplayedDateInputTo(LocalDate.of(2019, 5, 31));
    }

    @Test
    public void test_To_From_ClickableDate() {
        jQueryDatePickerLite
                .openDatePickers(JQUERY_DATE_PICKER, JQueryDatePickerLite.class)
                .clickInputTo()
                .clickDate(LocalDate.of(2022, 8, 19))
                .clickInputFrom()
                .clickDate(LocalDate.of(2020, 12, 25))
                .validateDisplayedDateInputFrom(LocalDate.of(2020, 12, 25))
                .validateDisplayedDateInputTo(LocalDate.of(2022, 8, 19));
    }

    @Test
    public void test_From_To_DisabledDate() {
        jQueryDatePickerLite
                .openDatePickers(JQUERY_DATE_PICKER, JQueryDatePickerLite.class)
                .clickInputFrom()
                .clickDate(LocalDate.of(2019, 8, 20))
                .clickInputTo()
                .clickDate(LocalDate.of(2019, 8, 19))
                .validateDisplayedDateInputFrom(LocalDate.of(2019, 8, 20))
                .verifyInputToIsEmpty();
    }

    @Test
    public void test_To_From_DisabledDate() {
        jQueryDatePickerLite
                .openDatePickers(JQUERY_DATE_PICKER, JQueryDatePickerLite.class)
                .clickInputTo()
                .clickDate(LocalDate.of(2019, 8, 19))
                .clickInputFrom()
                .clickDate(LocalDate.of(2019, 8, 20))
                .validateDisplayedDateInputTo(LocalDate.of(2019, 8, 19))
                .verifyInputFromIsEmpty();
    }
}