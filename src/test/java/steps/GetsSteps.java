/*
 * @(#) GetsSteps.java Copyright (c) 2019 Jala Foundation.
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

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

/**
 * GetsSteps class contains steps for Gets.feature
 *
 * @author MelissaRoman
 * @version 1.0
 **/
public class GetsSteps {
    private Response response;
    private ValidatableResponse json;
    private RequestSpecification request;
    private String ENDPOINT_GET_LEAD_BY_ID = "https://na112.salesforce.com/services/data/v39.0/sobjects/Lead";
    private String TOKEN_TYPE = "Bearer";
    private String ACCESS_TOKEN = "00D3i000000rqLx!AQwAQJG7NFGTQnBWzPsPG7uh54eyY4OH335GBNcha2EqPOwvmWGlcY18QDrThsw0YBMjh7ceMO5WdF9g0y_xG.qGiWCYJuUw";

    @Given("A lead exists with Id (.*)")
    public void aLeadExistsWithId(String idLead) {
        request = new RequestSpecBuilder()
                .setBaseUri("https://na112.salesforce.com/services/data/")
                .addHeader("Authorization",TOKEN_TYPE.concat(" ").concat(ACCESS_TOKEN))
                .build();
    }

    @When("a user retrieves the lead by Id")
    public void aUserRetrievesTheLeadById() {
        response = given().spec(request).get("https://na112.salesforce.com/services/data/v39.0/sobjects/Lead/?Id=00Q3i000002AwJKEA0");
        System.out.println("response: " + response.prettyPrint());
    }

    @Then("the status code is {int}")
    public void theStatusCodeIs(int statusCode) {
        json = response.then().statusCode(statusCode);
    }
}
