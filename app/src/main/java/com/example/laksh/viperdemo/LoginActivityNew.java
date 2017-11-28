package com.example.laksh.viperdemo;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.laksh.viperdemo.model.request.LoginRequest;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.text.TextUtils.isEmpty;
import static android.util.Patterns.EMAIL_ADDRESS;
import static android.util.Patterns.PHONE;

/**
 * Created by laksh on 9/11/17.
 */

public class LoginActivityNew extends AppCompatActivity implements LoginContract.ILoginView {

    private static final String LOGTAG = LoginActivityNew.class.getCanonicalName();
    private static final int RC_SIGN_IN = 9001;
    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;

    @BindView(R.id.activity_login)
    LinearLayout loginContainer;
    @BindView(R.id.login_email)
    EditText loginEmail;
    @BindView(R.id.login_password)
    EditText loginPassword;
    @BindView(R.id.login_submit)
    Button loginSubmit;
    ImageView imageView;
    String email;
    String password;
    String userImageBase64 = "";
    Bitmap profileImageBitmap;

    private boolean isEmailValid;
    private boolean isPasswordValid;
    private ProgressDialog progressDialog;
    private String gcmToken;
    LoginContract.LoginPresenter mLoginPresenter;
    private AppPreferenceManager preferenceManager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mLoginPresenter = new LoginPresenterImpl(this);
        if (loginContainer != null)
        preferenceManager = new AppPreferenceManager(this);
        if (getApplicationContext() != null)
            progressDialog = new ProgressDialog(LoginActivityNew.this);
        progressDialog.setMessage("Please wait...");
    }


    @OnClick(R.id.login_submit)
    void onLoginSubmit() {
        String email = loginEmail.getText().toString().trim();
        String password = loginPassword.getText().toString().trim();
        if (!isEmpty(email)) {
            if (EMAIL_ADDRESS.matcher(email).matches() || PHONE.matcher(email).matches()) {
                loginEmail.setError(null);
                isEmailValid = true;
            } else {
                isEmailValid = false;
                loginEmail.setError(getString(R.string.invalid_email_login));
            }
        } else {
            isEmailValid = false;
            loginEmail.setError(getString(R.string.email_blank_login));
        }

        if (!isEmpty(password)) {
            if (password.length() >= 6 && password.length() <= 21) {
                loginPassword.setError(null);
                isPasswordValid = true;
            } else {
                isPasswordValid = false;
                loginPassword.setError(getString(R.string.password_length_alert));
            }
        } else {
            isPasswordValid = false;
            loginPassword.setError(getString(R.string.password_blank));
        }

        if (isEmailValid && isPasswordValid) {
            LoginRequest request = new LoginRequest(getString(R.string.token_key), "login", "1", "", "", loginEmail.getText().toString(), loginPassword.getText().toString(), "", "", "", "1", gcmToken);

            if (Utility.isOnline(this)) {
                mLoginPresenter.onSubmitClick(request);
                //loginCall(request);

            } else {
                Toast.makeText(this, R.string.internet_alert, Toast.LENGTH_SHORT).show();
            }
        } else {

            if (isEmpty(email) && isEmpty(password)) {
                Toast.makeText(this, "Email/Mobile Number field are blank.", Toast.LENGTH_SHORT).show();
            } else if (!isEmailValid && isPasswordValid) {
                Toast.makeText(this, "Email/Mobile Number field is incorrect.", Toast.LENGTH_SHORT).show();
            } else if (!isPasswordValid && isEmailValid) {
                Toast.makeText(this, "Password field is incorrect.", Toast.LENGTH_SHORT).show();
            } else if (!isEmailValid && !isPasswordValid) {
                Toast.makeText(this, "Required fields are incorrect.", Toast.LENGTH_SHORT).show();
            }
        }
    }


    @Override
    protected void onStop() {
        mLoginPresenter.onStop();
        super.onStop();
    }

    @Override
    public void showProgress() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (progressDialog != null)
                    progressDialog.show();
            }
        });

    }

    @Override
    public void hideProgress() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (progressDialog != null)
                    progressDialog.dismiss();
            }
        });
    }

    @Override
    public void showToastMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}
