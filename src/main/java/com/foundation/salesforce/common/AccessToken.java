/*
 * @(#) accessToken.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.foundation.salesforce.common;

import org.json.JSONException;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class AccessToken {
    private static AccessToken accessToken;
    private static AppClient appClient=new AppClient();
    private  AccessToken(){
        initAccessToken();
    }
    public static AccessToken getInstance(){
        if (accessToken == null) {
            accessToken = new AccessToken();
        }
        return accessToken;
    }

    private static void initAccessToken(){
        String clientID;
        String clientSecret;
        String redirectUri;
        String userName;
        String password;
        String token;

            clientID = Util.getInstance().getConfig().getClientID();
            clientSecret = Util.getInstance().getConfig().getClientSecret();
            redirectUri = Util.getInstance().getConfig().getRedirectUri();
            userName = Util.getInstance().getConfig().getUserName();
            password = Util.getInstance().getConfig().getPassword();
            token = Util.getInstance().getConfig().getToken();

        String urlAuth = "https://login.salesforce.com/services/oauth2/token";
        String response = given()
                .param("grant_type", "password")
                .param("client_id", clientID)
                .param("client_secret", clientSecret)
                .param("redirect_uri", redirectUri)
                .param("username", userName)
                .param("password", password+token)
                .when()
                .post(urlAuth).body().prettyPrint();
        token=response;
        JSONObject json = null;

        String access_token="";
        String instance_url="";
        String id="";
        String token_type="";
        String issued_at="";
        String signature="";


        try {
            json = new JSONObject(response);
            access_token = json.getString("access_token");
            instance_url = json.getString("instance_url");
            id = json.getString("id");
            token_type = json.getString("token_type");
            issued_at = json.getString("issued_at");
            signature = json.getString("signature");

            /** Use this to validate session
             * instead of expiring on browser close.
             */
        } catch (JSONException e) {
            e.printStackTrace();
        }
        appClient.setAccess_token(access_token);
        appClient.setInstance_url(instance_url);
        appClient.setId(id);
        appClient.setToken_type(token_type);
        appClient.setIssued_at(issued_at);
        appClient.setSignature(signature);
    }
    public AppClient appClient(){
        return appClient;
    }
}
