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
    public void iSendTheRequestt() {
        final Map<String,String> map = new HashMap<>();
        map.put("Name","asdf");
        accountApi.getInstance().createAccount(map);
    }
}
