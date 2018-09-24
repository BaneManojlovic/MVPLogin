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
        boolean isLoginSuccess = user.isValidData();

        if(isLoginSuccess){
            loginView.onLoginResult("Login Successful!");
        }else {
            loginView.onLoginResult("Login Failed!");
        }
    }
}
