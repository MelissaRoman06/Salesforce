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
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;

/**
 * AccountStep class
 *
 * @author Cristian Lujan
 * @version 0.0.1
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

}