package com.tlabs.ecomdemo.ui.activities;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tlabs.ecomdemo.R;
import com.tlabs.ecomdemo.ui.common.BaseActivity;
import com.tlabs.ecomdemo.utils.ActivityManager;
import com.tlabs.ecomdemo.utils.Utils;

import java.util.regex.Pattern;

public class LoginActivity extends BaseActivity {

    private EditText mEtEmail, mEtPassword;
    private TextView mTxtForgotPassword, mTxtSignUp, mTxtTerms;
    private Button mBtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEtEmail = (EditText) findViewById(R.id.etEmail);
        mEtPassword = (EditText) findViewById(R.id.etPassword);
        mTxtForgotPassword = (TextView) findViewById(R.id.txtForgotPassword);
        mTxtSignUp = (TextView) findViewById(R.id.txtSignUp);
        mTxtTerms = (TextView) findViewById(R.id.txtTerms);
        mBtnLogin = (Button) findViewById(R.id.btnLogin);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateFields()) {
                    String email = mEtEmail.getText().toString().trim();
                    String password = mEtPassword.getText().toString().trim();

                    if (mDataManager.checkUserLogin(email, password)) {
                        Utils.loadStaticData();
                        mPreferenceManager.setIsLoggedIn(true);
                        showHomeScreen();
                    } else {
                        Toast.makeText(LoginActivity.this, R.string.str_invalid_login, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        mTxtForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showForgotPassword(mEtEmail.getText().toString());
            }
        });

        mTxtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityManager.showSignupActivity(LoginActivity.this);
            }
        });

        mTxtTerms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        checkLogInStatus();
    }

    private void checkLogInStatus() {
        if (mPreferenceManager.isLoggedIn()) {
            showHomeScreen();
        }
    }

    private void showHomeScreen() {
        ActivityManager.showHomeActivity(LoginActivity.this);
        finish();
    }

    private void showForgotPassword(String email) {

    }

    private boolean validateFields() {
        Pattern emailPattern = Patterns.EMAIL_ADDRESS;

        if (mEtEmail.getText().toString().equals("")) {
            mEtEmail.setError(getString(R.string.msg_email_validation));
            mEtEmail.requestFocus();
            return false;
        } else if (!emailPattern.matcher(mEtEmail.getText().toString()).matches()) {
            mEtEmail.setError(getString(R.string.msg_invalid_email_validation));
            mEtEmail.requestFocus();
            return false;
        } else if (mEtPassword.getText().toString().trim().isEmpty()) {
            mEtPassword.setError(getString(R.string.msg_password_validation));
            mEtPassword.requestFocus();
            return false;
        }

        return true;
    }
}
