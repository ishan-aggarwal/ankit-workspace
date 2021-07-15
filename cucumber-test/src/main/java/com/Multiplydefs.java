package com;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Multiplydefs {
    int a;
    int b;
    int result;

    @Given("I have {int} and {int}")
    public void iHaveAnd(int arg0, int arg1) {
        a=arg0;
        b=arg1;
    }

    @Then("I verify result is {int}")
    public void iVerifyResultIs(int arg0) {
        if(result == arg0) {

        }
    }

    @When("I multiply")
    public void iMultiply() {
        result = a*b;
    }

    @When("I add")
    public void iAdd() {
        result = a+b;
    }
}
