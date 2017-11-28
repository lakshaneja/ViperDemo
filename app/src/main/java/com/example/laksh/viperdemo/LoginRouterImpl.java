package com.example.laksh.viperdemo;

import android.app.Activity;
import android.content.Intent;


/**
 * Created by laksh on 9/11/17.
 */

public class LoginRouterImpl implements LoginContract.LoginInteractor.LoginRouter {
    Activity mActivity;

    public LoginRouterImpl(Activity mActivity) {
        this.mActivity = mActivity;
    }

    @Override
    public void naviagateToHomeScreen() {
        Intent in=new Intent(mActivity, HomeActivity.class);
        mActivity.startActivity(in);
    }
}
