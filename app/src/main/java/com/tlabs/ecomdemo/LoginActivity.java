package com.tlabs.ecomdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

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
        mBtnLogin = (Button) findViewById(R.id.btnLogin);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateFields()){
                    if(mEtEmail.getText().toString().equals("admin@admin.com") && mEtPassword.getText().toString().equals("admin")){
                        ActivityManager.showHomeActivity(LoginActivity.this);
                        finish();
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
