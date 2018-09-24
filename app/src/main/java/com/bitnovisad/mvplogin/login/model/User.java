package com.bitnovisad.mvplogin.login.model;

import android.text.TextUtils;
import android.util.Patterns;

/**
 * Model klasa
 * */

public class User implements IntUser {

    private String username, password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isValidData() {
        //CHECK is username empty + username matches data + password length > 8
        boolean res = !TextUtils.isEmpty(getUsername()) && !TextUtils.isEmpty(getPassword())
                && Patterns.EMAIL_ADDRESS.matcher(getUsername()).matches()
                && getPassword().length() > 8;
        return res;
    }
}
