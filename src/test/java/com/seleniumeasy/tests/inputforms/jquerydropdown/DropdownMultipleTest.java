package com.seleniumeasy.tests.inputforms.jquerydropdown;

import com.seleniumeasy.inputforms.DropdownMultiple;
import org.testng.annotations.Test;
import utils.SettingsSeleniumEasy;

import static com.seleniumeasy.enums.InputForms.JQUERY_SELECT_DROPDOWN;

public class DropdownMultipleTest extends SettingsSeleniumEasy {
    private final String[] states = {"California", "New York", "Illinois", "Texas", "Arizona"};

    DropdownMultiple dropdownMultiple = new DropdownMultiple();

    @Test
    public void testSelectStatesByName() {

        dropdownMultiple
                .openInputForms(JQUERY_SELECT_DROPDOWN, DropdownMultiple.class)
                .selectStatesByNames(states)
                .validateDisplayedStates(states);
    }

    @Test
    public void testSelectStatesByIndex() throws Exception {
        String[] states = {"Alaska", "Connecticut", "Florida"};
        dropdownMultiple
                .openInputForms(JQUERY_SELECT_DROPDOWN, DropdownMultiple.class)
                .selectStatesByIndexes(6, 1, 9)
                .verifyDisplayedStatesSize(3)
                .validateDisplayedStates(states);
    }

    @Test
    public void testDeselectStates() throws Exception {
        dropdownMultiple
                .openInputForms(JQUERY_SELECT_DROPDOWN, DropdownMultiple.class)
                .selectStatesByNames(states)
                .verifyDisplayedStatesSize(5)
                .deselectStates("New York", "Texas")
                .verifyDisplayedStatesSize(3)
                .validateDisplayedStates("Illinois", "California", "Arizona");
    }
}