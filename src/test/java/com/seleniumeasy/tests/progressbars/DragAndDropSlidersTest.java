package com.seleniumeasy.tests.progressbars;

import com.seleniumeasy.progressbars.DragAndDropSlidersPage;
import org.testng.annotations.Test;
import utils.BaseTest;

import static com.codeborne.selenide.Condition.value;
import static com.seleniumeasy.enums.ProgressBars.DRAG_AND_DROP_SLIDERS;

public class DragAndDropSlidersTest extends BaseTest {

    DragAndDropSlidersPage dragAndDropSlidersPage = new DragAndDropSlidersPage();

    @Test
    public void testGraySlider() {
        dragAndDropSlidersPage
                .openProgressBars(DRAG_AND_DROP_SLIDERS, DragAndDropSlidersPage.class)
                .dragAndDropGraySlider(-10, 0)
                .validateGraySlider(value("47"));
    }

    @Test
    public void testDarkBlueSlider() {
        dragAndDropSlidersPage
                .openProgressBars(DRAG_AND_DROP_SLIDERS, DragAndDropSlidersPage.class)
                .dragAndDropDarkBlueSlider(-150, 0)
                .validateDarkBlueSlider(value("1"));
    }

    @Test
    public void testGreenSlider() {
        dragAndDropSlidersPage
                .openProgressBars(DRAG_AND_DROP_SLIDERS, DragAndDropSlidersPage.class)
                .dragAndDropGreenSlider(0, 0)
                .validateGreenSlider(value("50"));
    }

    @Test
    public void testLightBlueSlider() {
        dragAndDropSlidersPage
                .openProgressBars(DRAG_AND_DROP_SLIDERS, DragAndDropSlidersPage.class)
                .dragAndDropLightBlueSlider(150, 0)
                .validateLightBlueSlider(value("100"));
    }

    @Test
    public void testOrangeSlider() {
        dragAndDropSlidersPage
                .openProgressBars(DRAG_AND_DROP_SLIDERS, DragAndDropSlidersPage.class)
                .dragAndDropOrangeSlider(146, 0)
                .validateOrangeSlider(value("99"));
    }

    @Test
    public void testRedSlider() {
        dragAndDropSlidersPage
                .openProgressBars(DRAG_AND_DROP_SLIDERS, DragAndDropSlidersPage.class)
                .dragAndDropRedSlider(1, 0)
                .validateRedSlider(value("51"));
    }
}