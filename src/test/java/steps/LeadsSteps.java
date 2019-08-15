/*
 * @(#) LeadsSteps.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */
package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * LeadsSteps class contains steps for FindLeadById.feature
 *
 * @author Melissa Roman
 * @version 1.0
 **/
public class LeadsSteps {
    private Response response;
    private ValidatableResponse json;
    private RequestSpecification request;
    private String ENDPOINT_LEAD = "https://na112.salesforce.com/services/data/v39.0/sobjects/Lead";
    private String TOKEN_TYPE = "Bearer";
    private String ACCESS_TOKEN = "00D3i000000rqLx!AQwAQGFNqZ8DPvrzXwTL8jnHnFZZIiLVI1axYI_NUWFvghBnNZ01iz8SEraHNz9bU.cWlOfwUmFvJMnAkIMDnAhcwGNZgeVP";
    private JSONObject creationData;

    public void buildRequestSpecification() {
        request = new RequestSpecBuilder()
                .setBaseUri(ENDPOINT_LEAD)
                .addHeader("Authorization",TOKEN_TYPE.concat(" ").concat(ACCESS_TOKEN))
                .build();
    }

    @When("a user retrieves the lead by Id (.*)")
    public void aUserRetrievesTheLeadByIdQIAwJKEA(String leadId) {
        buildRequestSpecification();
        response = given().spec(request).get( "/" + leadId);
        response.prettyPrint();
    }

    @Then("the status code is {int}")
    public void theStatusCodeIs(int statusCode) {
        json = response.then().statusCode(statusCode);
    }

    @And("response includes the following")
    public void responseIncludesTheFollowing(Map<String,String> responseFields) {
        for (Map.Entry<String, String> field : responseFields.entrySet()) {
            json.body(field.getKey(), equalTo(field.getValue()));
        }
    }

    @When("a user retrieves the summary for lead")
    public void aUserRetrievesTheSummaryForLead() {
        buildRequestSpecification();
        response = given().spec(request).get();
        response.prettyPrint();
    }


    @When("a user deletes a lead by Id (.*)")
    public void aUserDeletesALeadByIdQIAwJKEA(String leadId) {
        buildRequestSpecification();
        response = given().spec(request).delete("/" + leadId);
        response.prettyPrint();
    }

    @Given("a user sets json object with required fields")
    public void aUserSetsJsonObjectWithRequiredFields(Map<String,String> inputFields) {
        creationData = new JSONObject();
        for (Map.Entry<String, String> field : inputFields.entrySet()) {
            creationData.put(field.getKey(), field.getValue());
        }
    }

    @When("the user creates the lead")
    public void theUserCreatesTheLead() {
        buildRequestSpecification();
        request.contentType("application/json").body(creationData.toString());
        response = given().spec(request).post();
        response.prettyPrint();
    }
}
