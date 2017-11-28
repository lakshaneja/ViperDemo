package com.example.laksh.viperdemo;

import com.example.laksh.viperdemo.api.WebApi;
import com.example.laksh.viperdemo.model.request.LoginRequest;
import com.example.laksh.viperdemo.model.response.LoginResponse;

import org.reactivestreams.Subscription;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DefaultObserver;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by laksh on 9/11/17.
 */

public class LoginInteractorImpl implements LoginContract.LoginInteractor {
    @Override
    public void login(LoginRequest mLoginRequest, final OnLoginListener mOnLoginListener) {
               WebApi.getService().login(mLoginRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                       .subscribe(new DisposableObserver<LoginResponse>() {
                           @Override
                           public void onNext(LoginResponse loginResponse) {
                               if (loginResponse!=null)
                               {
                                   if (loginResponse.getCode()!=null)
                                   {
                                       if (loginResponse.getCode().equalsIgnoreCase("200"))
                                       {
                                           mOnLoginListener.onLoginSuccessfull();
                                       }else {
                                           mOnLoginListener.onLoginUnSuccessfull(loginResponse.getMessage());
                                       }
                                   }else mOnLoginListener.onLoginUnSuccessfull("Server Error");
                               }else mOnLoginListener.onLoginUnSuccessfull("Server Error");

                           }

                           @Override
                           public void onError(Throwable e) {
                            mOnLoginListener.onLoginUnSuccessfull(e.getLocalizedMessage());
                           }

                           @Override
                           public void onComplete() {

                           }
                       });

    }
}
