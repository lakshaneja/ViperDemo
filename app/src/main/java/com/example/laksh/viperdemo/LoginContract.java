package com.example.laksh.viperdemo;


import com.example.laksh.viperdemo.model.request.LoginRequest;

import org.reactivestreams.Subscription;

/**
 * Created by laksh on 9/11/17.
 */

public interface LoginContract {

     interface ILoginView{
        void showProgress();
        void hideProgress();
        void showToastMsg(String msg);
    }

    interface LoginPresenter{
         void onSubmitClick(LoginRequest mLoginRequest);
         void onStop();
         void onDestroy();
    }

    interface LoginInteractor{
         void login(LoginRequest mLoginRequest, OnLoginListener mOnLoginListener);
         interface OnLoginListener{
             void onLoginSuccessfull();
             void onLoginUnSuccessfull(String msg);
         }

         interface LoginRouter{
             void naviagateToHomeScreen();
         }
    }


}
