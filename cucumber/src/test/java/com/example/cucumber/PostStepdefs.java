package com.example.cucumber;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class PostStepdefs {

    private String request;
    GraphQLGetResponse graphResponse;

    @Before
    public void setup() {
        RestAssured.baseURI = "http://localhost:8081";
        RestAssured.basePath = "graphql";
    }

    @When("I send get request")
    public void iSendGetRequest() {

        RequestSpecBuilder reqSpecBuilder = new RequestSpecBuilder();
        reqSpecBuilder.setContentType("application/json; charset=UTF-8");
        reqSpecBuilder.setBody(request);
        RequestSpecification requestSpecification = RestAssured.given(reqSpecBuilder.build());

        graphResponse = requestSpecification
                                            .expect()
                                            .when().post().as(GraphQLGetResponse.class);
    }

    @Then("I verify response")
    public void iVerifyResponse() {
        System.out.println("Status code: "+graphResponse);
    }

    @Given("I have request")
    public void iHaveRequest() {


        request = "{\"query\":\"{\\n "+
                " getRecentPosts (id: \"23\") {\\n " +
                " id\\n  " +
                " authorId\\n }" +
                "\\n}\",\"variables\":{}}";


    }
}

