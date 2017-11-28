package com.example.laksh.viperdemo.api;

import com.example.laksh.viperdemo.model.request.LoginRequest;
import com.example.laksh.viperdemo.model.response.LoginResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by laksh on 9/11/17.
 */

public interface WebServiceApi {
    @POST("vendorjsonapi/")
    Observable<LoginResponse> login(@Body LoginRequest request);
}
