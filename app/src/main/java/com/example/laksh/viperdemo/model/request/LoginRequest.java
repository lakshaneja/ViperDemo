package com.example.laksh.viperdemo.model.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Abhishek Kumar on 11/7/2016.
 */

public class LoginRequest
  {

	 @Expose
	 @SerializedName("token")
	 String token;

	 @Expose
	 @SerializedName("methodname")
	 String methodname;

	 @Expose
	 @SerializedName("mode")
	 String mode;

	 @Expose
	 @SerializedName("google_user_id")
	 String googleUserId;

	 @Expose
	 @SerializedName("facebook_user_id")
	 String facebookUserId;

	 @Expose
	 @SerializedName("vendorEmail")
	 String vendorEmail;

	 @Expose
	 @SerializedName("password")
	 String password;

	 @Expose
	 @SerializedName("vendorImage")
	 String vendorImage;

	 @Expose
	 @SerializedName("fname")
	 String fname;

	 @Expose
	 @SerializedName("lname")
	 String lname;

	 @Expose
	 @SerializedName("device_type")
	 String deviceType;

	 @Expose
	 @SerializedName("device_token")
	 String deviceToken;

	 public LoginRequest()
		{

		}

	 public LoginRequest(String token, String methodname, String mode, String googleUserId, String facebookUserId, String vendorEmail, String password, String vendorImage, String fname, String lname,
                         String deviceType, String deviceToken)
		{
		  this.token = token;
		  this.methodname = methodname;
		  this.mode = mode;
		  this.googleUserId = googleUserId;
		  this.facebookUserId = facebookUserId;
		  this.vendorEmail = vendorEmail;
		  this.password = password;
		  this.vendorImage = vendorImage;
		  this.fname = fname;
		  this.lname = lname;
		  this.deviceType = deviceType;
		  this.deviceToken = deviceToken;
		}
  }
