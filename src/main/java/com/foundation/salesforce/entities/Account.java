/*
 * @(#) AccountApi.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.foundation.salesforce.entities;

/**
 * Account class
 *
 * @author Cristian Lujan
 * @version 0.0.1
 */
public class Account {

    /**
     * Variable for the name Account.
     */
    private String nameAccount;

    /**
     * Variable for the id of Account.
     */
    private int id;

    /**
     *
     * @return
     */
    public String getNameAccount() {
        return nameAccount;
    }

    public void setNameAccount(String nameAccount) {
        this.nameAccount = nameAccount;
    }

    /**
     * Gets the id of the Account.
     *
     * @return the id as string.
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}