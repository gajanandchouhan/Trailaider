package com.trailaider.app.utils;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.trailaider.app.GlideApp;
import com.trailaider.app.R;
import com.trailaider.app.ui.adapter.ListItemAdapter;
import com.trailaider.app.ui.pickers.MyDatePicker;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.text.format.DateUtils.getRelativeTimeSpanString;

/**
 * Created by gajanand on 4/1/18.
 */

public class CommonUtils {
    public static void startActivity(Context activity, Class<?> clazz) {
        Intent intent = new Intent(activity, clazz);
        activity.startActivity(intent);
    }

    public static void showSnakeBar(Context mContext, String message) {
        Snackbar.make(((AppCompatActivity) mContext).findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG).show();
    }

    public static void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    public static void showLog(String tag, String value) {
        Log.v(tag, value);
    }

    public static void printHashKey(Context pContext) {
        try {
            PackageInfo info = pContext.getPackageManager().getPackageInfo(pContext.getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String hashKey = new String(Base64.encode(md.digest(), 0));
                Log.i("FACEBOOK", "printHashKey() Hash Key: " + hashKey);
            }
        } catch (NoSuchAlgorithmException e) {
            Log.e("FACEBOOK", "printHashKey()", e);
        } catch (Exception e) {
            Log.e("FACEBOOK", "printHashKey()", e);
        }
    }

    public static boolean hasPermissions(Context context, String... permissions) {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void startActivity(Context activity, Class c, Bundle bundle, boolean clearTop) {
        Intent intent = new Intent(activity, c);
        if (bundle != null)
            intent.putExtra(ConstantLib.KEY_BUNDLE_EXTRA, bundle);
        if (clearTop) {
            ActivityCompat.finishAffinity((Activity) activity);
        }
        activity.startActivity(intent);
    }

    public static void startActivityForResult(Context activity, Class c, Bundle bundle, boolean clearTop) {
        Intent intent = new Intent(activity, c);
        if (bundle != null)
            intent.putExtra(ConstantLib.KEY_BUNDLE_EXTRA, bundle);
        if (clearTop) {
            ActivityCompat.finishAffinity((Activity) activity);
        }
        ((Activity) activity).startActivityForResult(intent, 103);
    }

    private static final Pattern[] passwordRegexes = new Pattern[4];

    {
        passwordRegexes[0] = Pattern.compile(".*[A-Z].*");
        passwordRegexes[1] = Pattern.compile(".*[a-z].*");
        passwordRegexes[2] = Pattern.compile(".*\\d.*");
        passwordRegexes[3] = Pattern.compile(".*[~!].*");
    }

    public static boolean isLegalPassword(String pass) {

        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(pass);

        return matcher.matches();
    }

    public final static boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }


    public static int getScreenWidth(Context mContext) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) mContext).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        return width;
    }

    public static int getScreenHeight(Context mContext) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) mContext).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        return height;
    }

    public static Uri getImageUri(Context applicationContext, Bitmap photo) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        photo.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(applicationContext.getContentResolver(), photo, "" + System.currentTimeMillis(), null);
        return Uri.parse(path);
    }

    public static void showDatePicker(Context mContext, String title, final int type, final DateSelectedListner listner) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        final int day = c.get(Calendar.DAY_OF_MONTH);
        MyDatePicker datePickerDialog = new MyDatePicker(
                mContext, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                // Do something with the date chosen by the user
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(String.format(Locale.getDefault(), "%02d", dayOfMonth));
                stringBuilder.append("/");
                stringBuilder.append(String.format(Locale.getDefault(), "%02d", month + 1));
                stringBuilder.append("/");
                stringBuilder.append(year);
                listner.onDateSelected(stringBuilder.toString(), type);
            }

        }, year, month, day);
        datePickerDialog.setPermanentTitle(title);
        c.set(year - 5, month, day);
        datePickerDialog.getDatePicker().setMaxDate(c.getTimeInMillis());
        datePickerDialog.show();
    }

    public static void hideKeyboard(Context ctx) {
        InputMethodManager inputManager = (InputMethodManager) ctx
                .getSystemService(Context.INPUT_METHOD_SERVICE);

        // check if no view has focus:
        View v = ((Activity) ctx).getCurrentFocus();
        if (v == null)
            return;

        if (inputManager != null) {
            inputManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
    }

    public static String centimeterToFeet(String centemeter) {
        int feetPart = 0;
        int inchesPart = 0;
        if (!TextUtils.isEmpty(centemeter)) {
            double dCentimeter = Double.valueOf(centemeter);
            feetPart = (int) Math.floor((dCentimeter / 2.54) / 12);
            System.out.println((dCentimeter / 2.54) - (feetPart * 12));
            inchesPart = (int) Math.ceil((dCentimeter / 2.54) - (feetPart * 12));
        }
        return String.format(Locale.getDefault(), "%d' %d\"", feetPart, inchesPart);
    }

    public static String kgsToLbs(String kgs) {
        int weightNew = (int) Math.round(Double.parseDouble(kgs) * 2.20462);
        return String.format(Locale.getDefault(), "%d lbs", weightNew);
    }

    public static String lbsToKgs(String lbs) {
        int weightNew = (int) Math.round(Double.parseDouble(lbs) * 0.454);
        return String.format(Locale.getDefault(), "%d kgs", weightNew);
    }

    public static String feetToCm(String feet) {
        double dCentimeter = 0d;
        if (!TextUtils.isEmpty(feet)) {
            if (feet.contains("'")) {
                String tempfeet = feet.substring(0, feet.indexOf("'"));
                if (!TextUtils.isEmpty(tempfeet)) {
                    dCentimeter += (Math.round(Double.valueOf(tempfeet)) * 30.48);
                }
            }
            if (feet.contains("\"")) {
                String tempinch = feet.substring(feet.indexOf("'") + 1, feet.indexOf("\""));
                if (!TextUtils.isEmpty(tempinch)) {
                    dCentimeter += (Math.round((Double.valueOf(tempinch)) * 2.54));
                }
            }
        }
        return String.format("%s cm", (int) dCentimeter);
        //Format to decimal digit as per your requirement
    }

    public static String getTimeLineDifference(String stringDate) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = null;
        try {
            date = df.parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long epoch = 0;
        if (date != null) {
            epoch = date.getTime();
        }

        return (String) getRelativeTimeSpanString(epoch, System.currentTimeMillis(), DateUtils.SECOND_IN_MILLIS);
    }

    public static String getCureretDateTime() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());//dd/MM/yyyy
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }


    public static String getMessageTime(String stringDate) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = null;
        try {
            date = df.parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long epoch = 0;
        if (date != null) {
            epoch = date.getTime();
        }
        long l = System.currentTimeMillis() - epoch;
        if (l > 1000 * 60 * 60 * 24) {
            SimpleDateFormat sdfDate = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());//dd/MM/yyyy
            String strDate = sdfDate.format(date);
            return strDate;
        } else {
            SimpleDateFormat sdfDate = new SimpleDateFormat("hh:mm a", Locale.getDefault());//dd/MM/yyyy
            String strDate = sdfDate.format(date);
            return strDate;
        }
    }

    public static void shareText(String shareText, Context mContext) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, shareText);
        sendIntent.setType("text/plain");
        mContext.startActivity(sendIntent);
    }


    /**
     * Returns the length of the given path, in meters, on Earth.
     */
    public static double computeLength(List<Location> path) {
        if (path.size() < 2) {
            return 0;
        }
        double length = 0;
        Location prev = path.get(0);
        for (Location location : path) {
            length += prev.distanceTo(location);
            prev = location;
        }

        return length;
    }

    public static int getAge(String date) {

        int age = 0;
        try {
            Date date1 = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).parse(date);
            Calendar now = Calendar.getInstance();
            Calendar dob = Calendar.getInstance();
            dob.setTime(date1);
            if (dob.after(now)) {
                throw new IllegalArgumentException("Can't be born in the future");
            }
            int year1 = now.get(Calendar.YEAR);
            int year2 = dob.get(Calendar.YEAR);
            age = year1 - year2;
            int month1 = now.get(Calendar.MONTH);
            int month2 = dob.get(Calendar.MONTH);
            if (month2 > month1) {
                age--;
            } else if (month1 == month2) {
                int day1 = now.get(Calendar.DAY_OF_MONTH);
                int day2 = dob.get(Calendar.DAY_OF_MONTH);
                if (day2 > day1) {
                    age--;
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return age;

    }

    public static void shareImageAndText(final Context mContext, final String text, String imagUrl) {
        if (imagUrl != null) {
            GlideApp.with(mContext).asBitmap().load(imagUrl).into(new SimpleTarget<Bitmap>() {
                @Override
                public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                    Uri localBitmapUri = getLocalBitmapUri(resource, mContext);
                    if (localBitmapUri != null) {
                        Intent shareIntent = new Intent();
                        shareIntent.setAction(Intent.ACTION_SEND);
                        shareIntent.putExtra(Intent.EXTRA_TEXT, text);
                        shareIntent.putExtra(Intent.EXTRA_STREAM, localBitmapUri);
                        shareIntent.setType("image/*");
                        mContext.startActivity(shareIntent);
                    }
                }
            });
        } else {
            shareText(text, mContext);
        }

    }

    private static Uri getLocalBitmapUri(Bitmap bmp, Context context) {
        Uri bmpUri = null;
        try {
            File file = new File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES), "share_image.png");
            FileOutputStream out = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.PNG, 90, out);
            out.close();
            bmpUri = Uri.fromFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bmpUri;
    }

    public static void showDropDownWindow(List list, Context mContext, View view) {
        try {
            //We need to get the instance of the LayoutInflater, use the context of this activity
            Dialog dialog = new Dialog(mContext);
            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //Inflate the view from a predefined XML layout
            View layout = inflater.inflate(R.layout.popup, null);
            RecyclerView recyclerView = (RecyclerView) layout;
            recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
            recyclerView.setAdapter(new ListItemAdapter(mContext, list));
            dialog.setContentView(layout);
            dialog.getWindow().setLayout(CommonUtils.getScreenWidth(mContext) * 60 / 100, CommonUtils.getScreenHeight(mContext) / 2);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
            dialog.getWindow().setGravity(Gravity.TOP | Gravity.END);
            WindowManager.LayoutParams attributes = dialog.getWindow().getAttributes();
            attributes.y = 50;
            attributes.x = 50;
            dialog.getWindow().setAttributes(attributes);
            dialog.show();
            /* LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //Inflate the view from a predefined XML layout
            View layout = inflater.inflate(R.layout.popup, null);
            // create a 300px width and 470px height PopupWindow
            PopupWindow pw = new PopupWindow(layout);
            // display the popup in the center
            pw.setWidth(CommonUtils.getScreenWidth(mContext) * 60 / 100);
            pw.setHeight(CommonUtils.getScreenHeight(mContext) / 2);
            pw.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            pw.setFocusable(true);
            pw.setOutsideTouchable(true);
            pw.showAsDropDown(view);*/

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String convertMeterToFeet(String trek_height) {
        try {
            double height = Double.parseDouble(trek_height);
            double heightInMeter = height / 3.28084;
            return String.format(Locale.getDefault(), "%.2f", heightInMeter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String conVertFeetToMeter(String trek_height) {
        try {
            double height = Double.parseDouble(trek_height);
            double heightInMeter = height * 0.3048;
            return String.format(Locale.getDefault(), "%.2f", heightInMeter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
