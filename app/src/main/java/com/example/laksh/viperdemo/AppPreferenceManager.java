package com.example.laksh.viperdemo;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Abhishek Kumar on 11/4/2016.
 */

public class AppPreferenceManager {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context context;
    private static final String SHARED_PREF = "DOWNSWEEP PREFERENCES";
    private static final String USERID = "USERID";
    private static final String GCMTOKEN = "GCMTOKEN";
    private static final String VENDOR_EMAIL = "VENDOR_EMAIL";
    private static final String FNAME = "FNAME";
    private static final String LNAME = "LNAME";
    private static final String REFERRAL_CODE = "REFERRAL_CODE";
    private static final String VENDOR_IMAGE = "VENDOR_IMAGE";
    private static final String VENDOR_MOBILE_NO = "VENDOR_MOBILE_NO";
    private static final String NOTIFICATION_STATUS = "NOTIFICATION_STATUS";

    public AppPreferenceManager(Context context) {
        this.context=context;
        sharedPreferences = context.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void removeValues(Context context) {
        this.context=context;
        sharedPreferences = context.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        editor.clear();
        editor.commit();
    }

    public String getUserID() {
        return sharedPreferences.getString(USERID, "");
    }

    public void setUserID(String gcmToken) {
        editor.putString(USERID, gcmToken);
        editor.commit();
    }

    public String getReferralCode() {
        return sharedPreferences.getString(REFERRAL_CODE, "");
    }

    public void setReferralCode(String referralCode) {
        editor.putString(REFERRAL_CODE, referralCode);
        editor.commit();
    }

    public String getVendorMObileNO() {
        return sharedPreferences.getString(VENDOR_MOBILE_NO, "");
    }

    public void setVendorMObileNO(String vendorMobileNO) {
        editor.putString(VENDOR_MOBILE_NO, vendorMobileNO);
        editor.commit();
    }

    public String getVendorImage() {
        return sharedPreferences.getString(VENDOR_IMAGE, "");
    }

    public void setVendorImage(String vendorImage) {
        editor.putString(VENDOR_IMAGE, vendorImage);
        editor.commit();
    }

    public String getLname() {
        return sharedPreferences.getString(LNAME, "");
    }

    public void setLname(String lname) {
        editor.putString(LNAME, lname);
        editor.commit();
    }

    public String getFname() {
        return sharedPreferences.getString(FNAME, "");
    }

    public void setFname(String fname) {
        editor.putString(FNAME, fname);
        editor.commit();
    }

    public String getVendorEmail() {
        return sharedPreferences.getString(VENDOR_EMAIL, "");
    }

    public void setVendorEmail(String vendorEmail) {
        editor.putString(VENDOR_EMAIL, vendorEmail);
        editor.commit();
    }

    public String getGCToken() {
        return sharedPreferences.getString(GCMTOKEN, "");
    }

    public void setGCToken(String gcmToken) {
        editor.putString(GCMTOKEN, gcmToken);
        editor.commit();
    }

    public String getNotificationStatus() {
        return sharedPreferences.getString(NOTIFICATION_STATUS, "");
    }

    public void setNotificationStatus(String notificationStatus) {
        editor.putString(NOTIFICATION_STATUS, notificationStatus);
        editor.commit();
    }

}
