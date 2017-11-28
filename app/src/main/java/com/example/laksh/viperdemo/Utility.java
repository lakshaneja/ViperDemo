package com.example.laksh.viperdemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Abhishek Kumar on 11/4/2016.
 */

public class Utility
  {

	 private static final String TAG = "UTILITY";
	 private static boolean isVisibile;

	 public static void showToast(Activity activity, String mgs)
		{
		  Toast.makeText(activity, mgs, Toast.LENGTH_SHORT).show();
		}

	 public static void showToast_Contaxt(Context context, String mgs)
		{
		  Toast.makeText(context, mgs, Toast.LENGTH_SHORT).show();
		}

	 public static boolean isValidPhoneNumber(String phone)
		{
		  return Patterns.PHONE.matcher(phone).matches();
		}
	  public static void showToastMsg(Activity activity,String msg)
	  {
		  if (!TextUtils.isEmpty(msg)) {
			  Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show();
		  }
	  }


	 public static boolean isValidEmaillId(String email)
		{
		  return Patterns.EMAIL_ADDRESS.matcher(email).matches();
		}

	 public static boolean isEmailValid(String email)
		{
		  boolean isValid = false;
		  String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
		  CharSequence inputStr = email;
		  Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
		  Matcher matcher = pattern.matcher(inputStr);
		  if(matcher.matches())
		  {
			 isValid = true;
		  }
		  return isValid;
		}

	 public static boolean checkIfOnlyNumericValuePresent(String text)
		{
		  if(text.matches("[0-9]+") && text.length() > 2)
		  {
			 return true;
		  }
		  else
		  {
			 return false;
		  }
		}

	 public static int specialCharacterCount(String text)
		{
		  int splCount = 0;
		  Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		  Matcher m = p.matcher(text);
		  while(m.find())
		  {
			 splCount++;
		  }
		  return splCount;
		}

	 public static boolean checkIfEmojiPresent(String text)
		{

		  boolean isValid = false;

		  final String regex = "([\\u20a0-\\u32ff\\ud83c\\udc00-" + "\\ud83d\\udeff\\udbb9\\udce5-\\udbb9\\udcee])";

		  Matcher matchEmo = Pattern.compile(regex).matcher(text);
		  while(matchEmo.find())
		  {
			 isValid = true;
		  }

		  return isValid;
		}

	 public static boolean isValidPassword(String password)
		{
		  return password.length() >= 6;
		}


	 public static void hideKeyboard(Activity activity)
		{
		  View view = activity.getCurrentFocus();
		  if(view != null)
		  {
			 InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
			 imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
		  }
		}

	 public static void hideKeyboardOnOutSideTouch(View view, final Activity activity)
		{
		  if(!(view instanceof EditText))
		  {
			 view.setOnTouchListener(new View.OnTouchListener()
				{
				  public boolean onTouch(View v, MotionEvent event)
					 {
						Utility.hideKeyboard(activity);
						return false;
					 }
				});
		  }
		  if(view instanceof ViewGroup)
		  {
			 for(int i = 0; i < ((ViewGroup) view).getChildCount(); i++)
			 {
				View innerView = ((ViewGroup) view).getChildAt(i);
				hideKeyboardOnOutSideTouch(innerView, activity);
			 }
		  }
		}

	 public static boolean checkKeyboard(View view, final Activity activity)
		{
		  if(!(view instanceof EditText))
		  {
			 view.setOnTouchListener(new View.OnTouchListener()
				{
				  public boolean onTouch(View v, MotionEvent event)
					 {
						Utility.hideKeyboard(activity);
						isVisibile = true;
						return false;
					 }
				});
		  }
		  if(view instanceof ViewGroup)
		  {
			 for(int i = 0; i < ((ViewGroup) view).getChildCount(); i++)
			 {
				View innerView = ((ViewGroup) view).getChildAt(i);
				hideKeyboardOnOutSideTouch(innerView, activity);
			 }
		  }
		  return isVisibile;
		}

	 public static String firstCapitalize(String string)
		{
		  return string.substring(0, 1).toUpperCase() + string.substring(1);
		}

	 public static boolean isOnline(Activity activity)
		{
		  ConnectivityManager cm = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
		  NetworkInfo netInfo = cm.getActiveNetworkInfo();
		  return netInfo != null && netInfo.isConnectedOrConnecting();
		}

	 public static void displayAlert(final Context context)
		{
		  new AlertDialog.Builder(context, R.style.AlertDialogStyle).setMessage("Would you like to turn on data!").setTitle("Network Error").setCancelable(true).setPositiveButton("Yes", new
				 DialogInterface.OnClickListener()
			 {
				public void onClick(DialogInterface dialog, int whichButton)
				  {
					 Intent intent = new Intent(Settings.ACTION_SETTINGS);
					 context.startActivity(intent);
				  }
			 }).setNegativeButton("No", new DialogInterface.OnClickListener()
			 {
				public void onClick(DialogInterface dialog, int whichButton)
				  {
					 dialog.dismiss();
				  }
			 }).show();
		}

	 public static int getPixelValue(Context activity, int dp)
		{

		  final float scale = activity.getResources().getDisplayMetrics().density;
		  return (int) (dp * scale + 0.5f);
		}

	 public static String toTitleCase(String str)
		{

		  if(str == null)
		  {
			 return null;
		  }

		  boolean space = true;
		  StringBuilder builder = new StringBuilder(str);
		  final int len = builder.length();

		  for(int i = 0; i < len; ++i)
		  {
			 char c = builder.charAt(i);
			 if(space)
			 {
				if(!Character.isWhitespace(c))
				{
				  // Convert to title case and switch out of whitespace mode.
				  builder.setCharAt(i, Character.toTitleCase(c));
				  space = false;
				}
			 }
			 else if(Character.isWhitespace(c))
			 {
				space = true;
			 }
			 else
			 {
				builder.setCharAt(i, Character.toLowerCase(c));
			 }
		  }
		  return builder.toString();
		}

	 public static String getDeviceId(Context context)
		{
		  return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
		}

	 public static boolean isKeyboardVisibility(Activity activity)
		{
		  final View contentView = activity.findViewById(android.R.id.content);
		  contentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
			 {
				private int mPreviousHeight;

				@Override
				public void onGlobalLayout()
				  {
					 int newHeight = contentView.getHeight();
					 if(mPreviousHeight != 0)
					 {
						if(mPreviousHeight > newHeight)
						{
						  // Height decreased: keyboard was shown
						  isVisibile = true;
						}
						else if(mPreviousHeight < newHeight)
						{
						  // Height increased: keyboard was hidden
						  isVisibile = false;
						}
						else
						{
						  // No change
						}
					 }
					 mPreviousHeight = newHeight;
				  }
			 });
		  return isVisibile;
		}

	 public static int pxToDp(int px)
		{
		  return (int) (px / Resources.getSystem().getDisplayMetrics().density);
		}

	 public static int dpToPx(int dp)
		{
		  return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
		}

	 public static Bitmap scaleDown(Bitmap realImage, float maxImageSize, boolean filter)
		{
		  float ratio = Math.min((float) maxImageSize / realImage.getWidth(), (float) maxImageSize / realImage.getHeight());
		  int width = Math.round((float) ratio * realImage.getWidth());
		  int height = Math.round((float) ratio * realImage.getHeight());

		  Bitmap newBitmap = Bitmap.createScaledBitmap(realImage, width, height, filter);
		  return newBitmap;
		}

	 public static long getCurrentTime()
		{
		  try
		  {
			 return new Date().getTime();
		  }
		  catch(Exception e)
		  {
			 e.printStackTrace();
			 return 0;
		  }
		}

	 public static String parseDateddMMyyyy(String time)
		{
		  String inputPattern = "yyyy-MM-dd";
		  String outputPattern = "dd-MMM-yyyy";
		  SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
		  SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

		  Date date = null;
		  String str = null;

		  try
		  {
			 date = inputFormat.parse(time);
			 str = outputFormat.format(date);
		  }
		  catch(ParseException e)
		  {
			 e.printStackTrace();
		  }
		  return str;
		}

	 //	 public static String parseDateTimeWithGMT(String dateTime)
	 //		{
	 //		  String inputPattern = "yyyy-MM-dd, hh:mm";
	 //		  String outputPatternDate = "dd MMM yyyy";
	 //		  String outputPatternTime = "hh:mm a";
	 //		  SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
	 //		  SimpleDateFormat outputFormatDate = new SimpleDateFormat(outputPatternDate);
	 //		  SimpleDateFormat outputFormatTime = new SimpleDateFormat(outputPatternTime);
	 //
	 //		  TimeZone gmtTime = TimeZone.getTimeZone("GMT");
	 //		  inputFormat.setTimeZone(gmtTime);
	 //
	 //		  Calendar cal = Calendar.getInstance();
	 //		  TimeZone tz = cal.getTimeZone();
	 //
	 //		  outputFormatDate.setTimeZone(tz);
	 //		  outputFormatTime.setTimeZone(tz);
	 //
	 //		  Date date = null;
	 //		  String fDate = "";
	 //		  String fTime = "";
	 //
	 //		  try
	 //		  {
	 //			 date = inputFormat.parse(dateTime);
	 //			 fDate = outputFormatDate.format(date);
	 //			 fTime = outputFormatTime.format(date);
	 //		  }
	 //		  catch(ParseException e)
	 //		  {
	 //			 e.printStackTrace();
	 //		  }
	 //		  return fDate + " at " + fTime;
	 //		}



	 public static String parseDateddMMyyyyNew(String time)
		{
		  String inputPattern = "yyyy-MM-dd";
		  String outputPattern = "dd MMM yyyy";
		  SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
		  SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

		  Date date = null;
		  String str = null;

		  try
		  {
			 date = inputFormat.parse(time);
			 str = outputFormat.format(date);
		  }
		  catch(ParseException e)
		  {
			 e.printStackTrace();
		  }
		  return str;
		}

	 public static String parseDateToddMMyyyy(String time)
		{
		  String inputPattern = "yyyy-MM-dd HH:mm:ss";
		  String outputPattern = "dd-MMM-yyyy h:mm a";

		  SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
		  SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

		  Date date = null;
		  String str = null;

		  try
		  {
			 date = inputFormat.parse(time);
			 str = outputFormat.format(date);
		  }
		  catch(ParseException e)
		  {
			 e.printStackTrace();
		  }
		  return str;
		}

	 public static String parseDateToddMM(String time)
		{
		  String inputPattern = "yyyy-MM-dd HH:mm:ss";
		  String outputPattern = "dd MMM";
		  SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
		  SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

		  Date date = null;
		  String str = null;

		  try
		  {
			 date = inputFormat.parse(time);
			 str = outputFormat.format(date);
		  }
		  catch(ParseException e)
		  {
			 e.printStackTrace();
		  }
		  return str;
		}

	 public static String parseDateForrating(String time)
		{
		  String inputPattern = "yyyy-MM-dd HH:mm:ss";
		  String outputPattern = "dd MMM yy";
		  SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
		  SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

		  Date date = null;
		  String str = null;

		  try
		  {
			 date = inputFormat.parse(time);
			 str = outputFormat.format(date);
		  }
		  catch(ParseException e)
		  {
			 e.printStackTrace();
		  }
		  return str;
		}

	 public static String roundTo2Decimal(String number)
		{
		  if(!TextUtils.isEmpty(number))
		  {
			 Double value = Double.parseDouble(number);
			 //			 double value2 = Math.round(value * 100) / 100.00d;
			 //			 return String.valueOf(value2);
			 return String.format("%.2f", value);
		  }
		  else
		  {
			 return "0.00";
		  }
		}

	 public static String getcurrentDate()
		{
		  Calendar calandar = Calendar.getInstance();
		  int cDay = calandar.get(Calendar.DAY_OF_MONTH);
		  int cMonth = calandar.get(Calendar.MONTH);
		  int cYear = calandar.get(Calendar.YEAR);
		  int cday = calandar.get(Calendar.DAY_OF_WEEK);

		  String month = "";
		  String day = "";

		  if(cday == 1)
		  {
			 day = "Sunday";
		  }
		  else if(cday == 2)
		  {
			 day = "Monday";
		  }
		  else if(cday == 3)
		  {
			 day = "Tuesday";
		  }
		  else if(cday == 4)
		  {
			 day = "Wednesday";
		  }
		  else if(cday == 5)
		  {
			 day = "Thursday";
		  }
		  else if(cday == 6)
		  {
			 day = "Friday";
		  }
		  else if(cday == 7)
		  {
			 day = "Saturday";
		  }

		  if(cMonth == 0)
		  {
			 month = "Jan";
		  }
		  else if(cMonth == 1)
		  {
			 month = "Feb";
		  }
		  else if(cMonth == 2)
		  {
			 month = "March";
		  }
		  else if(cMonth == 3)
		  {
			 month = "April";
		  }
		  else if(cMonth == 4)
		  {
			 month = "May";
		  }
		  else if(cMonth == 5)
		  {
			 month = "June";
		  }
		  else if(cMonth == 6)
		  {
			 month = "July";
		  }
		  else if(cMonth == 7)
		  {
			 month = "Aug";
		  }
		  else if(cMonth == 8)
		  {
			 month = "Sep";
		  }
		  else if(cMonth == 9)
		  {
			 month = "Oct";
		  }
		  else if(cMonth == 10)
		  {
			 month = "Nov";
		  }
		  else if(cMonth == 11)
		  {
			 month = "Dec";
		  }

		  String currentDateAndTime = cDay + " " + month + " " + cYear + ", " + day;

		  return currentDateAndTime;
		}

	 /**
	  * Converts Date object into string format as for e.g. <b>April 25th, 2012</b>
	  * @param date date object
	  * @return string format of provided date object
	  */
	 public static String getCustomDateString(Date date){
		SimpleDateFormat tmp = new SimpleDateFormat("MMMM d");

		String str = tmp.format(date);
		str = str.substring(0, 1).toUpperCase() + str.substring(1);

		if(date.getDate()>10 && date.getDate()<14)
		  str = str + "<sup>th</sup>, ";
		else{
		  if(str.endsWith("1")) str = str + "<sup>st</sup>, ";
		  else if(str.endsWith("2")) str = str + "<sup>nd</sup>, ";
		  else if(str.endsWith("3")) str = str + "<sup>rd</sup>, ";
		  else str = str + "<sup>th</sup>, ";
		}

		tmp = new SimpleDateFormat("yyyy");
		str = str + tmp.format(date);

		return str;
	 }
  }
