package com.tlabs.ecomdemo.ui.activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.tlabs.ecomdemo.R;
import com.tlabs.ecomdemo.models.CartOrder;
import com.tlabs.ecomdemo.models.UserAccount;
import com.tlabs.ecomdemo.ui.common.BaseActivity;
import com.tlabs.ecomdemo.utils.ActivityManager;
import com.tlabs.ecomdemo.utils.Constants;

public class AddressActivity extends BaseActivity {

    private Toolbar mToolbar;
    private EditText mEtName, mEtEmail, mEtAddress, mEtMobile;
    private Button mBtnChangeAddress, mBtnContinue;
    private String mEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mToolbar.setTitle("Delivery Option");
        mToolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        mEtName = (EditText) findViewById(R.id.etName);
        mEtEmail = (EditText) findViewById(R.id.etEmail);
        mEtAddress = (EditText) findViewById(R.id.etAddress);
        mEtMobile = (EditText) findViewById(R.id.etMobileNo);

        mEmail = mPreferenceManager.getUserEmail();
        UserAccount account = mDataManager.getUserAccountByEmail(mEmail);

        mEtName.setText(account.name);
        mEtEmail.setText(account.email);
        mEtMobile.setText(account.mobile);
        mEtAddress.setText(account.address);

        mBtnChangeAddress = (Button) findViewById(R.id.btnChangeAddress);
        mBtnChangeAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mEtAddress.getText().toString().trim().isEmpty() || !mEtMobile.getText().toString().trim().isEmpty()) {
                    showAlert();
                }
            }
        });

        mBtnContinue = (Button) findViewById(R.id.btnContinue);
        mBtnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateFields()) {
                    ActivityManager.showPaymentActivity(AddressActivity.this);
                }
            }
        });
    }

    private void showAlert() {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this)
                    .setMessage("Are you sure, Do you want to clear address and mobile fields?")
                    .setPositiveButton(Constants.KEY_YES,
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface arg0, int arg1) {
                                    clearFields();
                                }
                            })
                    .setNegativeButton(Constants.KEY_NO, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
    }

    private boolean validateFields() {

        if (mEtAddress.getText().toString().trim().isEmpty()) {
            mEtAddress.setError(getString(R.string.msg_address_validation));
            mEtAddress.requestFocus();
            return false;
        } else if (mEtMobile.getText().toString().trim().isEmpty()) {
            mEtMobile.setError(getString(R.string.msg_mobile_validation));
            mEtMobile.requestFocus();
            return false;
        }

        return true;
    }

    private void clearFields() {
        mEtAddress.setText("");
        mEtMobile.setText("");
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
