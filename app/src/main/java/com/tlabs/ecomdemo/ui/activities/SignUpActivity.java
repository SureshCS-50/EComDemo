package com.tlabs.ecomdemo.ui.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tlabs.ecomdemo.R;
import com.tlabs.ecomdemo.models.UserAccount;
import com.tlabs.ecomdemo.ui.common.BaseActivity;
import com.tlabs.ecomdemo.utils.ActivityManager;
import com.tlabs.ecomdemo.utils.Utils;

import java.util.regex.Pattern;

public class SignUpActivity extends BaseActivity {

    private EditText mEtName, mEtEmail, mEtPassword, mEtConfirmPassword;
    private Button mBtnSignUp;
    private UserAccount mUserAccount;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("Create Account");
        mToolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        mUserAccount = new UserAccount();

        mEtName = (EditText) findViewById(R.id.etName);
        mEtEmail = (EditText) findViewById(R.id.etEmail);
        mEtPassword = (EditText) findViewById(R.id.etPassword);
        mEtConfirmPassword = (EditText) findViewById(R.id.etConfirmPassword);
        mBtnSignUp = (Button) findViewById(R.id.btnSignup);


        mBtnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateFields()) {

                    mUserAccount.name = mEtName.getText().toString().trim();
                    mUserAccount.email = mEtEmail.getText().toString().trim();
                    mUserAccount.password = mEtPassword.getText().toString().trim();
                    mUserAccount.save();

                    mPreferenceManager.setIsLoggedIn(true);
                    mPreferenceManager.saveUserEmail(mUserAccount.email);

                    Utils.loadStaticData();

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

        if (name.isEmpty()) {
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
        } else if (!password.equals(confirmPassword)) {
            Toast.makeText(this, getString(R.string.str_password_confirm_password_mismatch), Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
