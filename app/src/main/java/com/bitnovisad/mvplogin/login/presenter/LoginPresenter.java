package com.bitnovisad.mvplogin.login.presenter;

import com.bitnovisad.mvplogin.login.model.User;
import com.bitnovisad.mvplogin.login.view.IntLoginView;

public class LoginPresenter implements IntLoginPresenter {

    IntLoginView loginView;

    public LoginPresenter(IntLoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void onLogin(String username, String password) {

        User user = new User(username, password);
        int loginCode = user.isValidData();

        if(loginCode == 0){
            loginView.onLoginFail("Login Failed! Fields can't be empty!");
        }else if(loginCode == 1){
            loginView.onLoginFail("Login Failed! User don't exist!");
        }else  if (loginCode == 2){
            loginView.onLoginFail("Login Failed! Passwort to short!");
        }else {
            loginView.onLoginSuccess("Login Success!");
        }
    }
}
