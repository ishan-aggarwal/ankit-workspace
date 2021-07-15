package com;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class APIStepdefs {
    int num;
    int result;
    
    @Given("I have {int}")
    public void iHave(int arg0) {
        num = arg0;
    }

    @When("I called method")
    public void iCalledMethod() {
        API api = new API();
        result = api.calculate(num);
    }

    @Then("I verify output")
    public void iVerifyOutput() {
        
    }

    @Then("I verify output is {string}")
    public void iVerifyOutputIs(String arg0) {

    }
}
