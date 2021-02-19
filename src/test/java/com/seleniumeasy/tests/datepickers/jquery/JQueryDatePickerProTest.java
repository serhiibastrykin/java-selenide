package com.seleniumeasy.tests.datepickers.jquery;

import com.seleniumeasy.datepickers.jquery.JQueryDatePickerPro;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.time.LocalDate;

import static com.seleniumeasy.enums.DatePickers.JQUERY_DATE_PICKER;

public class JQueryDatePickerProTest extends BaseTest {

    JQueryDatePickerPro jQueryDatePickerPro = new JQueryDatePickerPro();

    @Test
    public void test_From_To_ClickableDateByText() {
        jQueryDatePickerPro
                .openDatePickers(JQUERY_DATE_PICKER, JQueryDatePickerPro.class)
                .clickInputFrom()
                .clickDate("2021", "Apr", "24")
                .clickInputTo()
                .clickDate("2021", "Dec", "1")
                .validateDisplayedDateInputFrom(LocalDate.of(2021, 4, 24))
                .validateDisplayedDateInputTo(LocalDate.of(2021, 12, 1));
    }

    @Test
    public void test_To_From_DisabledDateByText() {
        jQueryDatePickerPro
                .openDatePickers(JQUERY_DATE_PICKER, JQueryDatePickerPro.class)
                .clickInputTo()
                .clickDate("2019", "Aug", "19")
                .clickInputFrom()
                .clickDate("2019", "Aug", "20")
                .validateDisplayedDateInputTo(LocalDate.of(2019, 8, 19))
                .verifyInputFromIsEmpty();
    }

    @Test
    public void test_To_From_ClickableDateByNumbers() {
        jQueryDatePickerPro
                .openDatePickers(JQUERY_DATE_PICKER, JQueryDatePickerPro.class)
                .clickInputTo()
                .clickDate(2022, 7, 10)
                .clickInputFrom()
                .clickDate(2020, 2, 27)
                .validateDisplayedDateInputTo(LocalDate.of(2022, 7, 10))
                .validateDisplayedDateInputFrom(LocalDate.of(2020, 2, 27));
    }

    @Test
    public void test_From_To_DisabledDateByNumbers() {
        jQueryDatePickerPro
                .openDatePickers(JQUERY_DATE_PICKER, JQueryDatePickerPro.class)
                .clickInputFrom()
                .clickDate(2019, 8, 20)
                .clickInputTo()
                .clickDate(2019, 8, 19)
                .validateDisplayedDateInputFrom(LocalDate.of(2019, 8, 20))
                .verifyInputToIsEmpty();
    }
}