package com.tlabs.ecomdemo.ui.activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.tlabs.ecomdemo.R;
import com.tlabs.ecomdemo.models.CartOrder;
import com.tlabs.ecomdemo.ui.common.BaseActivity;
import com.tlabs.ecomdemo.utils.ActivityManager;
import com.tlabs.ecomdemo.utils.Constants;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PaymentActivity extends BaseActivity {

    String mCardTypeArray[] = {"VISA", "Master Card", "Maestro"};
    String mMonthArray[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    String mYearArray[] = new String[20];
    String mSelectedCard = "";
    int mSelectedMonthPosition = 0;
    String mSelectedMonth = "";
    String mSelectedYear = "";
    ArrayAdapter<String> mCardsAdapter;
    ArrayAdapter<String> mMonthsAdapter;
    ArrayAdapter<String> mYearsAdapter;
    private Toolbar mToolbar;
    private EditText mEtCardNumber, mEtName, mEtCVV;
    private Button mBtnPay;
    private Spinner mSpinnerCardType, mSpinnerMonth, mSpinnerYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);


        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("Payment Option");
        mToolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        mEtCardNumber = (EditText) findViewById(R.id.etCardNumber);
        mEtName = (EditText) findViewById(R.id.etName);
        mEtCVV = (EditText) findViewById(R.id.etCVV);
        mSpinnerCardType = (Spinner) findViewById(R.id.spinnerCardType);
        mSpinnerMonth = (Spinner) findViewById(R.id.spinnerMonth);
        mSpinnerYear = (Spinner) findViewById(R.id.spinnerYear);

        for (int i = 0; i < mYearArray.length; i++) {
            mYearArray[i] = String.valueOf(2016 + i);
        }

        mCardsAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, mCardTypeArray);
        mMonthsAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, mMonthArray);
        mYearsAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, mYearArray);

        mCardsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerCardType.setAdapter(mCardsAdapter);

        mSpinnerCardType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                mSelectedCard = adapter.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
                mSelectedCard = "";
            }
        });

        mMonthsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerMonth.setAdapter(mMonthsAdapter);

        mSpinnerMonth.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                mSelectedMonth = adapter.getItemAtPosition(position).toString();
                mSelectedMonthPosition = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
                mSelectedMonth = "";
                mSelectedMonthPosition = 0;
            }
        });

        mYearsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerYear.setAdapter(mYearsAdapter);

        mSpinnerYear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                mSelectedYear = adapter.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
                mSelectedYear = "";
            }
        });

        mBtnPay = (Button) findViewById(R.id.btnPay);
        mBtnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateFields()) {
                    showPaymentSuccessfulDialog();
                }
            }
        });

    }

    private boolean validateFields() {
        SimpleDateFormat currentDate = new SimpleDateFormat("dd/MM/yyyy");
        Date todayDate = new Date();
        String thisDate = currentDate.format(todayDate);
        String[] dateArray = thisDate.split("/");

        if (mSelectedCard.isEmpty()) {
            Toast.makeText(this, "Please select your card type", Toast.LENGTH_SHORT).show();
            return false;
        } else if (mEtCardNumber.getText().toString().trim().isEmpty()) {
            mEtCardNumber.setError(getString(R.string.msg_address_validation));
            mEtCardNumber.requestFocus();
            return false;
        } else if (mEtName.getText().toString().trim().isEmpty()) {
            mEtName.setError(getString(R.string.msg_mobile_validation));
            mEtName.requestFocus();
            return false;
        } else if (mSelectedYear.isEmpty() || mSelectedMonth.isEmpty()) {
            Toast.makeText(this, "Please select your card expiry details", Toast.LENGTH_SHORT).show();
            return false;
        } else if (mSelectedYear.equals(dateArray[2]) && mSelectedMonthPosition < (Integer.valueOf(dateArray[1]) - 1)) {
            Toast.makeText(this, "Please give your valid card expiry details", Toast.LENGTH_SHORT).show();
            return false;
        } else if (mEtCVV.getText().toString().trim().isEmpty()) {
            mEtCVV.setError(getString(R.string.msg_cvv_validation));
            mEtCVV.requestFocus();
            return false;
        } else if (mEtCVV.getText().toString().trim().length() > 3) {
            mEtCVV.setError(getString(R.string.msg_cvv_error));
            mEtCVV.requestFocus();
            return false;
        }

        return true;
    }

    private void showPaymentSuccessfulDialog() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this)
                .setMessage("Do you want to continue this payment?")
                .setPositiveButton(Constants.KEY_YES,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                ActivityManager.showHomeActivity(PaymentActivity.this);
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
