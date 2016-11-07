package com.tlabs.ecomdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class SignUpActivity extends AppCompatActivity {

    private EditText mEtName, mEtEmail, mEtPassword, mEtConfirmPassword;
    private Button mBtnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mEtName = (EditText) findViewById(R.id.etName);
        mEtEmail = (EditText) findViewById(R.id.etEmail);
        mEtPassword = (EditText) findViewById(R.id.etPassword);
        mEtConfirmPassword = (EditText) findViewById(R.id.etConfirmPassword);
        mBtnSignUp = (Button) findViewById(R.id.btnSignup);

        mBtnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateFields()){
                    ActivityManager.showHomeActivity(SignUpActivity.this);
                    finish();
                }
            }
        });
    }

    private boolean validateFields() {
        Pattern emailPattern = Patterns.EMAIL_ADDRESS;

        String name = mEtName.getText().toString().trim();
        String email = mEtEmail.getText().toString().trim();
        String password = mEtPassword.getText().toString().trim();
        String confirmPassword = mEtConfirmPassword.getText().toString().trim();

        if(name.isEmpty()){
            mEtName.setError(getString(R.string.msg_name_validation));
            mEtName.requestFocus();
            return false;
        } else if (email.isEmpty()) {
            mEtEmail.setError(getString(R.string.msg_email_validation));
            mEtEmail.requestFocus();
            return false;
        } else if (!emailPattern.matcher(email).matches()) {
            mEtEmail.setError(getString(R.string.msg_invalid_email_validation));
            mEtEmail.requestFocus();
            return false;
        } else if (password.isEmpty()) {
            mEtPassword.setError(getString(R.string.msg_password_validation));
            mEtPassword.requestFocus();
            return false;
        } else if (confirmPassword.isEmpty()) {
            mEtConfirmPassword.setError(getString(R.string.msg_confirm_password_validation));
            mEtConfirmPassword.requestFocus();
            return false;
        } else if(!password.equals(confirmPassword)) {
            Toast.makeText(this, getString(R.string.str_password_confirm_password_mismatch), Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}
