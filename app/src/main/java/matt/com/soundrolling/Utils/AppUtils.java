package matt.com.soundrolling.Utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by deepaksingh on 20/07/15.
 */
public class AppUtils {

    public static void setPaintFlag(EditText editText) {
        editText.setPaintFlags(editText.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
    }

    public static void setPaintFlag(TextView textView) {
        textView.setPaintFlags(textView.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
    }

    public static boolean isEmailValid(String email) {
        boolean isValid = false;

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

    public static boolean isPasswordValid(String password) {
        Boolean isPasswordValid = true;
        if (!TextUtils.isEmpty(password)) {
            if (TextUtils.getTrimmedLength(password) <= 7) {
                isPasswordValid = false;
            }
        } else {
            isPasswordValid = false;
        }
        return isPasswordValid;
    }

    public static boolean isUsernameValid(String username) {
        Boolean isUsernameValid = true;
        if (!AppUtils.isEmailValid(username)) {
            if (!AppUtils.isPhoneNumber(username)) {
                isUsernameValid = false;
            }
        }

        return isUsernameValid;
    }


    public static boolean isPhoneNumber(String phoneNumber) {
        boolean isValid = false;

        String expression = "^[7-9][0-9]{9}$";
        CharSequence inputStr = phoneNumber;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

    public static void addHeightToListView(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }
        int totalHeight = listView.getPaddingTop() + listView.getPaddingBottom();
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            if (listItem instanceof ViewGroup)
                listItem.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
    }


    public static String convertTimeToSmallFormat(int hour, int minute) {
        String time = "";
        try {
            String _24HourTime = String.valueOf(hour) + ":" + String.valueOf(minute);
            SimpleDateFormat _24HourSDF = new SimpleDateFormat("HH:mm");
            SimpleDateFormat _12HourSDF = new SimpleDateFormat("hh:mm a");
            Date _24HourDt = _24HourSDF.parse(_24HourTime);
            time = _12HourSDF.format(_24HourDt);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }


    public static void showKeyboard(Context context, View v) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }

    public static void hideKeyboard(Context context, View v) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

    public static void setEditTextHintWithAstrix(String text, EditText view) {
        String colored = "<font color=red>*</font>";
        SpannableStringBuilder builder = new SpannableStringBuilder();
        builder.append(text);
        int start = builder.length();
        builder.append(colored);
        int end = builder.length();
        builder.setSpan(new ForegroundColorSpan(Color.parseColor("#989ca5")), start, end,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        view.setHint(Html.fromHtml(builder.toString()));
    }

    public static void setAutoEditTextHintWithAstrix(String text, AutoCompleteTextView view) {
        String colored = "<font color=red>*</font>";
        SpannableStringBuilder builder = new SpannableStringBuilder();
        builder.append(text);
        int start = builder.length();
        builder.append(colored);
        int end = builder.length();
        builder.setSpan(new ForegroundColorSpan(Color.parseColor("#989ca5")), start, end,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        view.setHint(Html.fromHtml(builder.toString()));
    }

    public static String formatDate(Date date) {
        Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }

    public static String formatDateNoDay(Date date) {
        Format formatter = new SimpleDateFormat("yyyy-MM");
        return formatter.format(date);
    }


    public static int CheckDates(String startDate, String endDate) {
        SimpleDateFormat dfDate = new SimpleDateFormat("yyyy-MM-dd");

        int b = 0;

        try {
            if (dfDate.parse(startDate).before(dfDate.parse(endDate))) {
                b = 0;  // If start date is before end date.
            } else if (dfDate.parse(startDate).equals(dfDate.parse(endDate))) {
                b = 1;  // If two dates are equal.
            } else {
                b = 2; // If start date is after the end date.
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return b;
    }

    public static Date stringToDate(String date) throws ParseException {

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss", Locale.ENGLISH);
        Date _date = format.parse(date);
        return _date;

    }

    public static Date stringToDate2(String date) throws ParseException {

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date _date = format.parse(date);
        return _date;

    }

    public static Date stringToDate4(String date) throws ParseException {

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date _date = format.parse(date);
        return _date;

    }

    public static Date stringToDate3(String date) throws ParseException {

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.ENGLISH);
        Date _date = format.parse(date);
        return _date;

    }

    public static String changeDateFormat(String mdate) throws ParseException {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date d = df.parse(mdate);
        df = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(df.format(d));

        return df.format(d);
    }

    public static int dpToPx(Context context, int dp) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int px = Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
        return px;
    }

    public static void setPaintFlagToEditText(EditText[] editText) {
        for (int i = 0; i < editText.length; i++) {
            setPaintFlag(editText[i]);
        }
    }

    public static boolean AppUpdate(Context ctx, float updatedVersion) {
        try {
            PackageInfo info = ctx.getPackageManager().getPackageInfo(
                    ctx.getPackageName(), 0);
            String version = info.versionName;
            return (Float.valueOf(info.versionName) < updatedVersion) ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
