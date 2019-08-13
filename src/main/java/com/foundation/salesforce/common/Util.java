/*
 * @(#) Util.java Copyright (c) 2019 Jala Foundation.
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

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import static org.apache.commons.lang3.SystemUtils.USER_DIR;

/**
 * Util class implements the singleton which allows to read
 *
 * @author Jesus Menacho
 * @version 1.0
 */

public class Util {
    private static Util Utilcreation;
    private static Config config=new Config();

    /**
     * This constructor let me initializer the initUnit.
     */
    private Util() {
        initUtil();
    }

    /**
     * Method let me return the instance Util class
     * @return Util util calss
     */
    public static Util getInstance() {
        if (Utilcreation == null) {
            Utilcreation = new Util();
        }
        return Utilcreation;
    }

    /**
     * Method init the class util.
     */
    private static void initUtil() {
        String clientID;
        String clientSecret;
        String redirectUri;
        String userName;
        String password;
        String token;

        try (InputStream input = new FileInputStream(System.getProperty("user.dir") + "/application.properties")) {
            Properties properties = new Properties();
            properties.load(input);

            clientID = properties.getProperty("app.client_id");
            clientSecret = properties.getProperty("app.client_secret");
            redirectUri = properties.getProperty("app.redirect_uri");
            userName = properties.getProperty("app.user_name");
            password = properties.getProperty("app.password");
            token=properties.getProperty("app.token");

            config.setClientID(clientID);
            config.setClientSecret(clientSecret);
            config.setRedirectUri(redirectUri);
            config.setUserName(userName);
            config.setPassword(password);
            config.setToken(token);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Method let me obtain the class Config for access to variables.
     * @return Config the class, constains all variable required in DB connections.
     */
    public Config getConfig() {
        return config;
    }
}
