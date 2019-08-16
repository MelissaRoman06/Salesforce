/*
 * @(#) AccountStep.java Copyright (c) 2019 Jala Foundation.
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

import com.foundation.salesforce.core.AccountApi;
import com.foundation.salesforce.core.RestClient.RestClientApi;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * AccountStep class
 *
 * @author Cristian Lujan
 * @version 1.0
 */
public class AccountStep {

    private RestClientApi restClientApi;
    private AccountApi accountApi;

    @Given("^I log in with Authorization token$")
    public void ILogInWithAuthorizationToken() {
        restClientApi.getInstance().requestAuthenticate();
    }

    @Given("^I set up a GET request to Account endpoint$")
    public void iSetUpAGETRequestToAccountEndpoint() {
        accountApi.getInstance().getAccount();
    }

    @When("^I send the request$")
    public void iSendTheRequest() {

    }

    @Given("^I fill the request$")
    public void iFillTheRequest() {
        restClientApi.getInstance().requestAuthenticate();

    }

    @When("^I send the requestt$")
    public void iSendTheRequestt() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Name","Accnnt");
        accountApi.getInstance().createAccount(jsonObject);
    }

    @Given("^I fill the delete request$")
    public void iFillTheDeleteRequest() {
        restClientApi.getInstance().requestAuthenticate();
    }

    @When("^I send the delete$")
    public void iSendTheDelete() {
        accountApi.getInstance()
                .deleteAccount("https://na112.salesforce.com/services/data/v39.0/sobjects/Account");
    }
}
