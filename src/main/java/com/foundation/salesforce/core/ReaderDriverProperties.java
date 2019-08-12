/*
 * @(#) ReaderDriverProperties.java Copyright (c) 2019 Jala Foundation.
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

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * ReaderDriverProperties class
 *
 * @author Cristian Lujan
 * @version 1.0
 */
public class ReaderDriverProperties {

    private static final String URL_SALESFORCE_PROPERTIES = "gradle.properties";
    private Map<String, String> properties = new HashMap<>();

    protected ReaderDriverProperties() {
        addPropertiesSalesforce();
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void addPropertiesSalesforce() {
        Properties propertiesSalesforce = loadFile(URL_SALESFORCE_PROPERTIES);
        propertiesSalesforce.forEach((key, value) -> properties.put(key.toString(), value.toString()));
    }

    public static ReaderDriverProperties getInstance() {
        return new ReaderDriverProperties();
    }

    private Properties loadFile(String url) {
        Properties prop = new Properties();
        try {
            InputStream input = new FileInputStream(url);
            // load a properties file
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}