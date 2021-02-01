package com.seleniumeasy.inputforms;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.seleniumeasy.DemoHomePage;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class InputFormSubmitPage extends DemoHomePage {
    private final SelenideElement inputFirstName = $("input[name=first_name]"),
            inputLastName = $("input[name=last_name]"),
            inputEmail = $("input[name=email]"),
            inputPhone = $("input[name=phone]"),
            inputAddress = $("input[name=address]"),
            inputCity = $("input[name=city]"),
            inputZipCode = $("input[name=zip]"),
            inputWebsite = $("input[name=website]"),
            inputProjectDescription = $("textarea[name=comment]"),
            buttonSend = $(".btn-default");
    private final ElementsCollection states = $$(".selectpicker option"),
            errors = $$("small[data-bv-result=INVALID]");

    public InputFormSubmitPage enterFirstName(String firstName) {
        inputFirstName.setValue(firstName);
        return this;
    }

    public InputFormSubmitPage enterLastName(String lastName) {
        inputLastName.setValue(lastName);
        return this;
    }

    public InputFormSubmitPage enterEmail(String email) {
        inputEmail.setValue(email);
        return this;
    }

    public InputFormSubmitPage enterPhone(String phoneNumber) {
        inputPhone.setValue(phoneNumber);
        return this;
    }

    public InputFormSubmitPage enterAddress(String address) {
        inputAddress.setValue(address);
        return this;
    }

    public InputFormSubmitPage enterCity(String city) {
        inputCity.setValue(city);
        return this;
    }

    public InputFormSubmitPage selectState(int state) {
        states.get(state).setSelected(true);
        return this;
    }

    public InputFormSubmitPage selectState(String state) {
        states.find(exactText(state)).setSelected(true);
        return this;
    }

    public InputFormSubmitPage enterZipCode(String zipCode) {
        inputZipCode.setValue(zipCode);
        return this;
    }

    public InputFormSubmitPage enterWebsiteOrDomainName(String website) {
        inputWebsite.setValue(website);
        return this;
    }

    public InputFormSubmitPage doYouHaveHosting(String answer) {
        String radiobutton = String.format("input[value=%s]", answer);
        $(radiobutton).setSelected(true);
        return this;
    }

    public InputFormSubmitPage enterProjectDescription(String description) {
        inputProjectDescription.setValue(description);
        return this;
    }

    public InputFormSubmitPage clickSend() {
        buttonSend.click();
        return this;
    }

    public void verifyFormIsSubmitted() throws Exception {
        int currentSize = errors.size();
        List<String> fields = new ArrayList<>();
        for (SelenideElement error : errors) {
            String field = error.getText();
            fields.add(field);
        }
        if (currentSize != 0) {
            System.out.print(fields);
            throw new Exception(String.format("Validation failed in %d field(s)!", currentSize));
        }
    }
}