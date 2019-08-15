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
 * with Jala Foundation.
 */

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;


import com.sun.xml.internal.ws.wsdl.writer.document.soap.Body;
import com.sun.xml.internal.ws.wsdl.writer.document.soap.BodyType;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gherkin.ast.DataTable;
import gherkin.ast.TableRow;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import javax.xml.crypto.Data;
import java.net.Authenticator;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.*;

public class PostSteps {
    private Response response;
    private ValidatableResponse json;
    private RequestSpecification request;
    private String ENDPOINT_GET_LEAD_BY_ID = "https://na112.salesforce.com/services/data/v39.0/sobjects/Lead";
    private String TOKEN_TYPE = "Bearer";
    private String ACCESS_TOKEN = "00D3i000000rfF0!ARUAQOjI70WgjOmdv9Scodrzs2n2rMkx2TzrYyGavZUrONRjbKp0FPDjVqf8onzhY7WHDOtfpSXKTGfk1NbGdMPfbZ4iNcLi";

//    @Given("^post on the account$")
//    public void aLeadExistsWithId() {
//        request = new RequestSpecBuilder()
//                .setBaseUri("https://na112.salesforce.com/services/data/")
//                .addHeader("Authorization", TOKEN_TYPE.concat(" ").concat(ACCESS_TOKEN))
//                .build();
//    }




    @Given("I perform post operation for  with body")
    public void iPerformPostOperationForWithBody() {
        String authenticator = "Bearer 00D3i000000rfF0!ARUAQNFhjMwRMqR4orFsAvSIuBch3KbXE8wbNEZO_JHkRKRb6LfSdDsvRSum.GMRnHSy_A6YgyNdeE8FBbAKdUsRRmPk2e6v";
        request = given().header("Authorization", authenticator);
    }

    @When("I should the body has name as")
    public void iShouldTheBodyHasNameAs() {
          HashMap<String, String> body = new HashMap<>();
        body.put("Name", "account233");
        response = given().spec(request).post("https://na112.salesforce.com/001/e?retURL=%2F001%2Fo", body);
    }
}
