/*
 * Copyright © 2016, Craftsvilla.com
 *  Written under contract by Robosoft Technologies Pvt. Ltd.
 */

package spandroid.dev.network.volley;

import android.content.Context;
import android.content.SharedPreferences;

import org.json.JSONObject;

import java.util.ArrayList;


/**
 * Created by Mahesh Nayak on 19-02-2016.
 */
public class VolleyPreferenceManager {

    private static final String FILE_NAME = "pref";
    private static VolleyPreferenceManager instance;
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;

    private VolleyPreferenceManager(Context ctx) {
        initFields(ctx);
    }

    private static void initFields(Context ctx) {
        sharedPreferences = ctx.getApplicationContext().getSharedPreferences(ctx.getPackageName(), Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public static VolleyPreferenceManager getInstance(Context ctx) {
        if (instance == null) {
            instance = new VolleyPreferenceManager(ctx);
        }
        return instance;
    }

    public static void storePrefBoolean(Context context, String key, boolean value) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public static boolean getPrefBoolean(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        return sp.getBoolean(key, false);
    }

    public static int getIntPref(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        return sp.getInt(key, 0);
    }

    public static void storePrefInt(Context context, String key, int value) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public String getToken() {
        return sharedPreferences.getString(Keys.TOKEN, VolleyConstants
                .EMPTY_TEXT);
    }

    public void setToken(String token) {
        editor.putString(Keys.TOKEN, token).commit();
    }

    public String getCustomerId() {
        return sharedPreferences.getString(Keys.CUSTOMER_ID, VolleyConstants
                .EMPTY_TEXT);
    }

    public void setCustomerId(String token) {
        editor.putString(Keys.CUSTOMER_ID, token).commit();
    }

    public String getGuestId() {
        return sharedPreferences.getString(Keys.GUEST_SESSION_ID, VolleyConstants
                .EMPTY_TEXT);
    }

    public void setGuestId(String token) {
        editor.putString(Keys.GUEST_SESSION_ID, token).commit();
    }

    public String getGcmToken() {
        return sharedPreferences.getString(Keys.GCM_TOKEN, VolleyConstants
                .EMPTY_TEXT);
    }

    public void setGcmToken(String token) {
        editor.putString(Keys.GCM_TOKEN, token).commit();
    }

    public String getCustomerPin() {
        return sharedPreferences.getString(Keys.CUSTOMER_PIN, VolleyConstants
                .EMPTY_TEXT);
    }

    public void setCustomerPin(String pin) {
        editor.putString(Keys.CUSTOMER_PIN, pin).commit();
    }

    public int getCustomerCartCount() {
        return sharedPreferences.getInt(Keys.CUSTOMER_CART_COUNT, 0);
    }

    public void setCustomerCartCount(int count) {
        editor.putInt(Keys.CUSTOMER_CART_COUNT, count).apply();
    }

    public String getAddressId() {
        return sharedPreferences.getString(Keys.ADDRESS_ID, VolleyConstants
                .EMPTY_TEXT);
    }

    public void setAddressId(String addressId) {
        editor.putString(Keys.ADDRESS_ID, addressId).commit();
    }

    public String getLoginType() {
        return sharedPreferences.getString(Keys.LOGIN_TYPE, VolleyConstants
                .EMPTY_TEXT);
    }

    public void setLoginType(String name) {
        editor.putString(Keys.LOGIN_TYPE, name).apply();
    }

    public String getRecentSearch() {
        return sharedPreferences.getString(Keys.RECENT_SEARCH, VolleyConstants
                .EMPTY_TEXT);
    }

    public void setRecentSearch(String name) {
        editor.putString(Keys.RECENT_SEARCH, name).apply();
    }

    public String getTrendSearch() {
        return sharedPreferences.getString(Keys.TREND_SEARCH, VolleyConstants
                .EMPTY_TEXT);
    }

    public void setTrendSearch(String trendString) {
        editor.putString(Keys.TREND_SEARCH, trendString).apply();
    }

    public void insertInt(int pageId) {
        editor.putInt("perPageProduct", pageId).commit();
    }

    public int getInt() {
        return sharedPreferences.getInt("perPageProduct", 0);
    }

    public String getColorData() {
        return sharedPreferences.getString(Keys.COLOR_APP, VolleyConstants
                .EMPTY_TEXT);
    }

    public void setColorData(String value) {
        editor.putString(Keys.COLOR_APP, value).commit();
    }

    public int getMinPrice() {
        return sharedPreferences.getInt(Keys.MINPRICE, 0);
    }

    public void setMinPrice(int minprice) {
        editor.putInt(Keys.MINPRICE, minprice).commit();
    }

    public int getMaxPrice() {
        return sharedPreferences.getInt(Keys.MAXPRICE, 0);
    }

    public void setMaxPrice(int maxPrice) {
        editor.putInt(Keys.MAXPRICE, maxPrice).commit();
    }

    public void setFilterjson(JSONObject filterjson) {
        editor.putString(Keys.FILTERJSON, filterjson.toString()).commit();

    }

    public String getFilterJson() {
        return sharedPreferences.getString(Keys.FILTERJSON, "");
    }

    public String getRecentlyViewdProduct() {
        return sharedPreferences.getString(Keys.RECENTLY_VIEWED_PRODUCT, "");
    }

    public void setRecentlyViewdProduct(String recentlyViewedProduct) {
        editor.putString(Keys.RECENTLY_VIEWED_PRODUCT, recentlyViewedProduct).commit();
    }

    public String getSortJson() {
        return sharedPreferences.getString(Keys.SORTJSON, "");
    }

    public void setSortJson(JSONObject filterjson) {
        editor.putString(Keys.SORTJSON, filterjson.toString()).commit();

    }

    public int getCartProductSize() {
        return sharedPreferences.getInt(Keys.CART_PRODUCT_SIZE, -1);
    }

    public void setCartProductSize(int size) {

        editor.putInt(Keys.CART_PRODUCT_SIZE, size).commit();
    }

    public String getUrlHandlerJson() {

        return sharedPreferences.getString(Keys.HandlerJson, "");
    }

    public void setUrlHandlerJson(JSONObject jsonObject) {

        editor.putString(Keys.HandlerJson, jsonObject.toString()).commit();
    }

    public String getAdvertId() {
        return sharedPreferences.getString(Keys.GCM_TOKEN, "");
    }

    public void setAdvertId(String id) {
        editor.putString(Keys.ADVERTISINGID, id).commit();
    }

    public String getLoginUserWishList() {
        return sharedPreferences.getString(Keys.LoginUser, "");
    }

    public void setLoginUserWishList(ArrayList<Integer> mList) {
        editor.putString(Keys.LoginUser, mList.toString()).commit();
    }

    public void setGuestUserWishList(ArrayList<String> mList) {
        editor.putString(Keys.GuestUser, mList.toString()).commit();
    }

    public String getGuestUserList() {
        return sharedPreferences.getString(Keys.GuestUser, "");
    }

    public String getGuestWishListDetail() {
        return sharedPreferences.getString(Keys.GetUserDetails, "");
    }

    public void setGuestWishListDetail(String mList) {
        editor.putString(Keys.GetUserDetails, mList).commit();
    }

    public String getPincode() {
        return sharedPreferences.getString(Keys.PINCODE, VolleyConstants
                .DEFAULT_PINCODE);
    }

    public void setPincode(String pincode) {
        editor.putString(Keys.PINCODE, pincode).commit();
    }

    public boolean isHomePageViewedFirstTime() {
        return sharedPreferences.getBoolean(Keys.HOME_PAGE_VIEWED_FIRSTTIME, false);
    }

    public void setHomePageViewedFirstTime(boolean value) {
        editor.putBoolean(Keys.HOME_PAGE_VIEWED_FIRSTTIME, value).commit();
    }

    public String getFirstTimeUser() {
        return sharedPreferences.getString(Keys.LOGIN_FIRSTTIME, "");
    }

    public void setFirstTimeUser(String first) {
        editor.putString(Keys.LOGIN_FIRSTTIME, first).commit();
    }

    public String getTrackConfirmation() {
        return sharedPreferences.getString(Keys.TRACK_CONFIRM, "");
    }

    public void setTrackConfirmation(String yes) {
        editor.putString(Keys.TRACK_CONFIRM, yes).commit();
    }

    public int getAppliedMin() {
        return sharedPreferences.getInt(Keys.AppliedMin, 0);
    }

    public void setAppliedMin(int min) {
        editor.putInt(Keys.AppliedMin, min).commit();
    }

    public int getAppliedMax() {
        return sharedPreferences.getInt(Keys.AppliedMax, 0);
    }

    public void setAppliedMax(int max) {
        editor.putInt(Keys.AppliedMax, max).commit();
    }


    public int getSavedAppVersion() {
        return sharedPreferences.getInt(Keys.APP_VERSION, Integer.MIN_VALUE);
    }

    public void setSavedAppVersion(int value) {
        editor.putInt(Keys.APP_VERSION, value).commit();
    }

    public String getUserEmail() {
        return sharedPreferences.getString(VolleyConstants
                .LoginSourceType.SocialoLoginEmail, VolleyConstants
                .EMPTY_TEXT);
    }

    public void setUserEmail(String name) {
        editor.putString(VolleyConstants
                .LoginSourceType.SocialoLoginEmail, name).apply();
    }

    public String getBaseCheckoutUrl() {
        return sharedPreferences.getString(Keys.BASE_CHECKOUT_URL, null);
    }

    public void setBaseCheckoutUrl(String value) {
        editor.putString(Keys.BASE_CHECKOUT_URL, value).commit();
    }

    public String getBaseUrl() {
        return sharedPreferences.getString(Keys.BASE_URL, null);
    }

    public void setBaseUrl(String value) {
        editor.putString(Keys.BASE_URL, value).commit();
    }

    public void setSingleViewArrangeInCategory(boolean isSingleView) {
        editor.putBoolean(Keys.IS_SINGLE_VIEW_TYPE, isSingleView).apply();
    }

    public boolean getProductListArrangeType() {
        return sharedPreferences.getBoolean(Keys.IS_SINGLE_VIEW_TYPE, false);
    }

    public String getTrackOrderWidgetCustomerIdDetails() {
        return sharedPreferences.getString(Keys.TRACK_ORDER_WIDGET, VolleyConstants
                .EMPTY_TEXT);
    }

    public void setTrackOrderWidgetCustomerIdDetails(String customerId) {
        editor.putString(Keys.TRACK_ORDER_WIDGET, customerId).commit();
    }

    public String getTrackOrderWidgetDateDetails() {
        return sharedPreferences.getString(Keys.TRACK_ORDER_WIDGET_DATE, VolleyConstants
                .EMPTY_TEXT);
    }

    public void setTrackOrderWidgetDateDetails(String date) {
        editor.putString(Keys.TRACK_ORDER_WIDGET_DATE, date).commit();
    }

    public boolean isInstallTracked() {
        return sharedPreferences.getBoolean(Keys.APP_INSTALLS, false);
    }

    public void setFirstInstall(boolean token) {
        editor.putBoolean(Keys.APP_INSTALLS, token).commit();
    }

    public boolean hasPlacedOrder() {
        return sharedPreferences.getBoolean(Keys.ORDER_PLACED, false);
    }

    public void setHasPlacedOrder() {
        editor.putBoolean(Keys.ORDER_PLACED, true).commit();
    }

    public boolean isRatingPopUpShown() {
        return sharedPreferences.getBoolean(Keys.RATING_SHOWN, false);
    }

    public void setRatingPopupShown(boolean value) {
        editor.putBoolean(Keys.RATING_SHOWN, value).commit();
    }

    public int getLaunchCount() {
        return sharedPreferences.getInt(Keys.LAUNCH_COUNT, 0);
    }

    public void setLaunchCount(int value) {
        editor.putInt(Keys.LAUNCH_COUNT, value).commit();
    }

    public String getUtmData() {
        return sharedPreferences.getString(Keys.UTM_PARAMETERS, VolleyConstants
                .EMPTY_TEXT);
    }

    public void setUtmData(String data) {
        editor.putString(Keys.UTM_PARAMETERS, data);
        editor.commit();
    }


    public String getUserGender() {
        return sharedPreferences.getString(Keys.USER_GENDER, VolleyConstants
                .EMPTY_TEXT);
    }

    public void setUserGender(String data) {
        editor.putString(Keys.USER_GENDER, data);
        editor.commit();
    }

    public String getAutoSuggestionString() {
        return sharedPreferences.getString(Keys.SEARCH_AUTOSUGGESTION, VolleyConstants
                .EMPTY_TEXT);
    }

    public void setAutoSuggestionString(String data) {
        editor.putString(Keys.SEARCH_AUTOSUGGESTION, data);
        editor.commit();
    }

    public boolean getUserPhoneDetails() {
        return sharedPreferences.getBoolean(Keys.USER_PHONE_DETAILS, false);
    }

    public void setUserPhoneDetails(boolean isUserDetailsPresent) {
        editor.putBoolean(Keys.USER_PHONE_DETAILS, isUserDetailsPresent);
        editor.commit();
    }


    public String getFirstTimeLaunchedDate() {
        return sharedPreferences.getString(Keys.FIRST_LAUNCHED_DATE, VolleyConstants
                .EMPTY_TEXT);
    }

    public void setFirstTimeLaunchedDate(String firstLaunchDate) {
        editor.putString(Keys.FIRST_LAUNCHED_DATE, firstLaunchDate);
        editor.commit();
    }


    public interface Keys {
        String TOKEN = "token";
        String CUSTOMER_ID = "customer_id";
        String GUEST_SESSION_ID = "guest_id";
        String CUSTOMER_PIN = "customer_pin";
        String CUSTOMER_CART_COUNT = "customer_cart_count";

        String ADDRESS_ID = "ADDRESSID";

        String LOGIN_TYPE = "type";
        String RECENT_SEARCH = "recent_search";
        String TREND_SEARCH = "trend_search";

        String LOGIN_Email = "email";

        String COLOR_APP = "color";

        String MINPRICE = "min";
        String MAXPRICE = "max";
        String FILTERJSON = "filter";

        String SORTJSON = "sort";

        String CART_PRODUCTS = "cart_products";
        String CART_PRODUCT_SIZE = "cart_product_size";

        String HandlerJson = "handler";

        String RECENTLY_VIEWED_PRODUCT = "recently_viewed";

        String LoginUser = "login";

        String GuestUser = "guest";

        String GetUserDetails = "guestdetails";
        String PINCODE = "pincode";
        String HOME_PAGE_VIEWED_FIRSTTIME = "homepage_viewed_firsttime";
        String LOGIN_FIRSTTIME = "login_firsttime";
        String GCM_TOKEN = "gcm";
        String ADVERTISINGID = "advertId";
        String TRACK_CONFIRM = "orderConfirm";
        String AppliedMin = "MIni";
        String AppliedMax = "Maxi";
        String BASE_URL = "base_url_v2";
        String COACHMARKS = "coachmark_data";
        String APP_VERSION = "app_version";
        String IS_SINGLE_VIEW_TYPE = "isSingleView";
        String APP_INSTALLS = "app_installs";
        String UTM_PARAMETERS = "utm_parameters";
        String TRACK_ORDER_WIDGET = "trackOrderWidget";
        String TRACK_ORDER_WIDGET_DATE = "trackOrderWidgetDate";
        String USER_GENDER = "gender";
        String SEARCH_AUTOSUGGESTION = "SearchAuto";
        String USER_PHONE_DETAILS = "phone";

        String ORDER_PLACED = "order_placed";
        String RATING_SHOWN = "rating_popup_shown";
        String LAUNCH_COUNT = "launch_count";
        String INSTALL_DATE = "install_date";
        String BASE_CHECKOUT_URL = "checkout_url";
        String FIRST_LAUNCHED_DATE = "date";

        String CART_DATA = "cart_data";

    }


}

