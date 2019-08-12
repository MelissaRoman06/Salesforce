/*
 * @(#) Account_API.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.foundation.salesforce.core;

import com.foundation.salesforce.entities.Account;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * Account_API class
 *
 * @author Cristian Lujan
 * @version 1.0
 */
public class Account_API {

    /**
     * Header name for the Url Api.
     */
    final String URL_API = "urlAPI";

    /**
     * Header name for the token type
     */
    final String TOKEN_TYPE = "token_type";

    /**
     * Header name for de access token
     */
    final String ACCESS_TOKEN = "access_token";

    private  Response response;
    private RequestSpecification request;

    /**
     * Retrieve Accounts
     */
    public void authenticateAccounts() {
        request = given().headers("Authorization",TOKEN_TYPE.concat(" ").concat(ACCESS_TOKEN),
                "Content-Type", "content_type");

    }

    /**
     * Request Account
     * @param endPoint
     */
    public void requestAccounts(String endPoint) {
        response = request.when().request("GET", URL_API.concat(endPoint));
        response.prettyPrint();
    }

    /**
     * Create Account
     * @param account
     */
    public void createAnAccount(Account account) {

        Map<String,String> newAccount = new HashMap<>();
        newAccount.put("name", account.getNameAccount());
        Response response = given().headers("Authorization","access_token",
                "Content-Type", "content_type").
                body(newAccount).
                when().
                request("POST", URL_API);
    }
}