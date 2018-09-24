package com.bitnovisad.mvplogin.login.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bitnovisad.mvplogin.R;
import com.bitnovisad.mvplogin.login.presenter.IntLoginPresenter;
import com.bitnovisad.mvplogin.login.presenter.LoginPresenter;

public class LoginFragment extends Fragment implements IntLoginView {

    EditText edtUsername, edtPassword;
    Button btnLogin;
    IntLoginPresenter loginPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.login_fragment, container, false);

        //initialize View
        edtUsername = (EditText) v.findViewById(R.id.userNameField);
        edtPassword = (EditText) v.findViewById(R.id.userPasswordField);
        btnLogin = (Button) v.findViewById(R.id.btnLogin);

        //initialize login Presenter
        loginPresenter = new LoginPresenter(this);

        //event for click on login button
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.onLogin(edtUsername.getText().toString(), edtPassword.getText().toString());
                //loginPresenter.handleLogin(edtUsername.getText().toString(), edtPassword.getText().toString());
            }
        });
        return v;
    }

    @Override
    public void onLoginSuccess(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginFail(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}
