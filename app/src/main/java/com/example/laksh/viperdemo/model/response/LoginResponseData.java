package com.example.laksh.viperdemo.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Abhishek Kumar on 11/7/2016.
 */

public class LoginResponseData
  {

	 @Expose
	 @SerializedName("id")
	 String id;

	 @Expose
	 @SerializedName("vendorEmail")
	 String vendorEmail;

	 @Expose
	 @SerializedName("fname")
	 String fname;

	 @Expose
	 @SerializedName("lname")
	 String lname;

	 @Expose
	 @SerializedName("vendor_image")
	 String vendorImage;

	 @Expose
	 @SerializedName("vendor_mobile_no")
	 String vendorMobileNo;

	 @Expose
	 @SerializedName("vendor_status")
	 String vendorStatus;

	 @Expose
	 @SerializedName("email_verified")
	 String emailVerified;

	 @Expose
	 @SerializedName("mobile_no_verified")
	 String mobileNoVerified;

	 @Expose
	 @SerializedName("vendor_verified")
	 String vendorVerified;

	 @Expose
	 @SerializedName("notification_status")
	 String notificationStatus;

	 @Expose
	 @SerializedName("Refrence_code")
	 String referenceCode;

	 public String getReferenceCode()
		{
		  return referenceCode;
		}

	 public void setReferenceCode(String referenceCode)
		{
		  this.referenceCode = referenceCode;
		}

	 public String getNotificationStatus()
		{
		  return notificationStatus;
		}

	 public void setNotificationStatus(String notificationStatus)
		{
		  this.notificationStatus = notificationStatus;
		}

	 public String getId()
		{
		  return id;
		}

	 public void setId(String id)
		{
		  this.id = id;
		}

	 public String getVendorEmail()
		{
		  return vendorEmail;
		}

	 public void setVendorEmail(String vendorEmail)
		{
		  this.vendorEmail = vendorEmail;
		}

	 public String getFname()
		{
		  return fname;
		}

	 public void setFname(String fname)
		{
		  this.fname = fname;
		}

	 public String getLname()
		{
		  return lname;
		}

	 public void setLname(String lname)
		{
		  this.lname = lname;
		}

	 public String getVendorImage()
		{
		  return vendorImage;
		}

	 public void setVendorImage(String vendorImage)
		{
		  this.vendorImage = vendorImage;
		}

	 public String getVendorMobileNo()
		{
		  return vendorMobileNo;
		}

	 public void setVendorMobileNo(String vendorMobileNo)
		{
		  this.vendorMobileNo = vendorMobileNo;
		}

	 public String getVendorStatus()
		{
		  return vendorStatus;
		}

	 public void setVendorStatus(String vendorStatus)
		{
		  this.vendorStatus = vendorStatus;
		}

	 public String getEmailVerified()
		{
		  return emailVerified;
		}

	 public void setEmailVerified(String emailVerified)
		{
		  this.emailVerified = emailVerified;
		}

	 public String getMobileNoVerified()
		{
		  return mobileNoVerified;
		}

	 public void setMobileNoVerified(String mobileNoVerified)
		{
		  this.mobileNoVerified = mobileNoVerified;
		}

	 public String getVendorVerified()
		{
		  return vendorVerified;
		}

	 public void setVendorVerified(String vendorVerified)
		{
		  this.vendorVerified = vendorVerified;
		}
  }
