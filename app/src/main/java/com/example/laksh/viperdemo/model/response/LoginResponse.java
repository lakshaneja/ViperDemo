package com.example.laksh.viperdemo.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abhishek Kumar on 11/7/2016.
 */

public class LoginResponse {

    @Expose
    @SerializedName("code")
    String code;

    @Expose
    @SerializedName("message")
    String message;

    @Expose
    @SerializedName("data")
    List<LoginResponseData> datas = new ArrayList<>();

    @Expose
    @SerializedName("userimgurl")
    String userimgurl;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<LoginResponseData> getDatas() {
        return datas;
    }

    public void setDatas(List<LoginResponseData> datas) {
        this.datas = datas;
    }

    public String getUserimgurl() {
        return userimgurl;
    }

    public void setUserimgurl(String userimgurl) {
        this.userimgurl = userimgurl;
    }
}
