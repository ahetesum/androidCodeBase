package com.connect.rh.utils;

import java.util.regex.Pattern;

import android.widget.EditText;

public class ValidationHelper {

    public static boolean isEmpty(EditText editText, String errorMsg) {
        if (editText.getText().toString().trim().length() > 0) {
            editText.setError(null);
            return true;
        }
        editText.setError(errorMsg);
        return false;
    }

    public static boolean isNumber(EditText editText, String errorMsg) {
        Pattern pattern = Pattern.compile(".*[^0-9].*");
        if (pattern.matcher(editText.getText().toString()).matches()) {
            editText.setError(null);
            return true;
        }
        editText.setError(errorMsg);
        return false;
    }

    public static boolean isEqual(EditText editText, String text, String errorMsg) {
        if (editText.getText().toString().equals(text)) {
            editText.setError(null);
            return true;
        }
        editText.setError(errorMsg);
        return false;
    }

    public static boolean isEqual(EditText editText1, EditText editText2, String errorMsg) {
        if (editText1.getText().toString().equals(editText2.getText().toString())) {
            editText2.setError(null);
            return true;
        }
        editText2.setError(errorMsg);
        return false;
    }


    public static boolean isPhoneNumber(EditText editText, String errorMsg) {
        String phoneNo = editText.getText().toString();
        // validate phone numbers of format "1234567890"
        if (phoneNo.matches("\\d{10}")) {
            editText.setError(null);
            return true;
        }
        // validating phone number with -, . or spaces
        else if (phoneNo.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) {
            editText.setError(null);
            return true;
        }
        // validating phone number with extension length from 3 to 5
        else if (phoneNo.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}")) {
            editText.setError(null);
            return true;
        }
        // validating phone number where area code is in braces ()
        else if (phoneNo.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) {
            editText.setError(null);
            return true;
        }
        // return false if nothing matches the input
        else {
            editText.setError(errorMsg);
            return false;
        }
    }

    public static boolean isEmail(EditText editText, String errorMsg) {

        Pattern pattern = Pattern.compile(".+@.+\\.[a-z]+");
        if (pattern.matcher(editText.getText().toString()).matches()) {
            editText.setError(null);
            return true;
        }
        editText.setError(errorMsg);
        return false;
    }

    public static boolean isPinNumber(EditText editText, String errorMsg) {
        Pattern pattern = Pattern.compile("\\d{6}");
        String var = editText.getText().toString();
        if (pattern.matcher(editText.getText().toString()).matches()) {
            editText.setError(null);
            return true;
        }
        editText.setError(errorMsg);
        return false;
    }

    public static boolean isCartVaid(EditText editText, int availableQty, String errorMsg) {
        if (Integer.parseInt((editText.getText().toString())) < availableQty) {
            editText.setError(null);
            return true;
        }
        editText.setError(errorMsg);
        return false;
    }


}
