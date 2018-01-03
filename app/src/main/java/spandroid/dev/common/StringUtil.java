/*
 * Copyright © 2016, Craftsvilla.com
 *  Written under contract by Robosoft Technologies Pvt. Ltd.
 */

package spandroid.dev.common;

import android.graphics.Paint;
import android.text.TextUtils;
import android.widget.TextView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sibaprasad on 20/10/16.
 */
public class StringUtil {
    private static final String DEFAULT_PARAMS_ENCODING = "UTF-8";

    public static String getRequestBody(Object obj) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    public static String getEncodedText(String param) {
        try {
            if (!TextUtils.isEmpty(param))
                return URLEncoder.encode(param, DEFAULT_PARAMS_ENCODING);
        } catch (UnsupportedEncodingException e) {
            return Constants.EMPTY_TEXT;
        }
        return Constants.EMPTY_TEXT;
    }

    public static void setStrikeTextViewWithString(TextView view, String text) {
        view.setText(text);
        view.setPaintFlags(view.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
    }

    public static Map<String,Object> getCleverTapAnalyticsMap(String key, String value) {
        HashMap<String, Object> map = new HashMap<>();
        map.put(key, value);
        return map;
    }

    public static boolean isEmailIdValid(String emailId) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(emailId).matches();
    }
}
