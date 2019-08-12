/*
 * @(#) Authentication.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.foundation.salesforce;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

/**
 * @author Alejandro Sánchez Luizaga
 * @version 1.0
 */
public class Authentication {
    private String username;
    private String password;
    private String token;
    private String key;
    private String secret;
    private String auth_endpoint;
    private String proxyHost;
    private String proxyPort;

    private Logger logger = Logger.getLogger("Authentication.class");

    public String retrieveAccessToken(String username){
        readUserCredentials(username);
        readConnectionSettings();
        logger.info("Getting Access Token from authentication server...");
        Response response = given().queryParam("grant_type", "password").queryParam("client_id", key).queryParam("password", password + token).when().post(auth_endpoint);
        response.prettyPrint();
        return null; //response.body().jsonPath().getString("access_token");
    }

    private void readUserCredentials(String username){
        //try (InputStream input = getClass().getClassLoader().getResourceAsStream("user.properties")) {
        try (InputStream input = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/user.properties")) {
            Properties properties = new Properties();
            properties.load(input);
            this.username = username;
            this.password = properties.getProperty(username+".password");
            this.token = properties.getProperty(username+".token");
            this.key = properties.getProperty(username+".key");
            this.secret = properties.getProperty(username+".secret");
        }
        catch (IOException ioex) {
            logger.warning("Unable to find user.properties");
            ioex.printStackTrace();
        }
    }

    private void readConnectionSettings(){
        //try (InputStream input = getClass().getClassLoader().getResourceAsStream("connection.properties")) {
        try (InputStream input = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/connection.properties")) {
            Properties properties = new Properties();
            properties.load(input);
            auth_endpoint = properties.getProperty("salesforce_uri") + properties.getProperty("auth_endpoint");
            proxyHost = properties.getProperty("proxy.host");
            proxyPort = properties.getProperty("proxy.port");
        }
        catch (IOException ioex) {
            logger.warning("Unable to find connection.properties");
            ioex.printStackTrace();
        }
    }
}
