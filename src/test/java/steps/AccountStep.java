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

import com.foundation.salesforce.core.Account_API;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

/**
 * AccountStep class
 *
 * @author Cristian Lujan
 * @version 0.0.1
 */
public class AccountStep {

    private Account_API account_api = new Account_API();

        @Given("I set up a GET request")
        public void iSetUpAGETRequest() {
            account_api.authenticateAccounts();
        }

        @When("I send the request to (.*) endpoint")
        public void iSendTheRequestToAccountEndpoint(String endPoint) {
            account_api.requestAccounts(endPoint);
        }
}