package steps;
/*
 * @(#) GetsSteps.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.  depende injections hooks before scenarios
 */

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import org.json.JSONException;
import org.json.JSONObject;

import static io.restassured.RestAssured.*;

public class PostSteps {
    private Response response;
    private ValidatableResponse json;
    private RequestSpecification request;
    private String ENDPOINT_GET_LEAD_BY_ID = "https://na112.salesforce.com/services/data/v39.0/sobjects/Lead";
    private String TOKEN_TYPE = "Bearer";
    private String ACCESS_TOKEN = "00D3i000000rfF0!ARUAQOjI70WgjOmdv9Scodrzs2n2rMkx2TzrYyGavZUrONRjbKp0FPDjVqf8onzhY7WHDOtfpSXKTGfk1NbGdMPfbZ4iNcLi";

    @Given("I build body for post operation")
    public void iPerformPostOperationForWithBody() throws JSONException {
        String authenticator = "Bearer 00D3i000000rfF0!ARUAQD6GRMf8qbz9Ckv_GoiD1LArXxZ3TriU9g4xuEokaIcQ2cBaebfOyopphZX3oVY5frxhTH3sAJc0nOmy0n_QT_dAb3nN";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Name","account444");
        request = given().headers("Authorization", authenticator,"Content-Type","application/json").body(jsonObject.toString());
    }

    @When("I send the body and post the account")
    public void iShouldTheBodyHasNameAs() throws JSONException {
        response = given().spec(request).post("https://na112.salesforce.com/services/data/v46.0/sobjects/Account");
    }
}
