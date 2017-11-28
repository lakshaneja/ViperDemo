package com.example.laksh.viperdemo;


import android.app.Activity;

import com.example.laksh.viperdemo.model.request.LoginRequest;

/**
 * Created by laksh on 9/11/17.
 */

public class LoginPresenterImpl implements LoginContract.LoginPresenter, LoginContract.LoginInteractor.OnLoginListener {
    LoginContract.ILoginView mILoginView;
    LoginContract.LoginInteractor mLoginInteractor;
    LoginContract.LoginInteractor.LoginRouter mLoginRouter;

    public LoginPresenterImpl(LoginContract.ILoginView mILoginView) {
        this.mILoginView = mILoginView;
        mLoginInteractor = new LoginInteractorImpl();
        mLoginRouter = new LoginRouterImpl((Activity) mILoginView);
    }

    @Override
    public void onSubmitClick(LoginRequest mLoginRequest) {
        mILoginView.showProgress();
        mLoginInteractor.login(mLoginRequest, LoginPresenterImpl.this);
    }

    @Override
    public void onStop() {
    }

    @Override
    public void onDestroy() {
        mILoginView = null;
    }

    @Override
    public void onLoginSuccessfull() {
        mILoginView.hideProgress();
        mLoginRouter.naviagateToHomeScreen();
    }

    @Override
    public void onLoginUnSuccessfull(String msg) {
        mILoginView.hideProgress();
        mILoginView.showToastMsg(msg);
    }
}
