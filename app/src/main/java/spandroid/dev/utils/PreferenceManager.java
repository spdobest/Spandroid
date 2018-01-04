/*
 * Copyright © 2016, Craftsvilla.com
 *  Written under contract by Robosoft Technologies Pvt. Ltd.
 */

package spandroid.dev.utils;

import android.content.Context;
import android.content.SharedPreferences;



import org.json.JSONObject;

import java.util.ArrayList;

import spandroid.dev.common.Constants;


/**
 * Created by Mahesh Nayak on 19-02-2016.
 */
public class PreferenceManager {

    private static final String FILE_NAME = "pref";



    public interface Keys {

	    String IS_USER_LOGGEDIN ="isuser_loggedin" ;

        String TOKEN = "token";
        String CUSTOMER_ID = "customer_id";
        String GUEST_SESSION_ID = "guest_id";
      //  String GCM_TOKEN = "gcm_token";
        String CUSTOMER_PIN = "customer_pin";
        String CUSTOMER_CART_COUNT = "customer_cart_count";

        String ADDRESS_ID = "ADDRESSID";

        String LOGIN_TYPE = "type";
        String RECENT_SEARCH = "recent_search";
        String TREND_SEARCH = "trend_search";

        String COLOR_APP = "color";

        String MINPRICE="min";
        String MAXPRICE="max";
        String FILTERJSON="filter";

        String SORTJSON="sort";

        String CART_PRODUCTS= "cart_products";
        String CART_PRODUCT_SIZE = "cart_product_size";

        String HandlerJson = "handler";

        String RECENTLY_VIEWED_PRODUCT = "recently_viewed";

        String LoginUser = "login";

        String GuestUser = "guest";

        String GetUserDetails = "guestdetails";
        String PINCODE="pincode";
        String HOME_PAGE_VIEWED_FIRSTTIME="homepage_viewed_firsttime";
        String LOGIN_FIRSTTIME="login_firsttime";
        String GCM_TOKEN="gcm";
        String ADVERTISINGID="advertId";
        String TRACK_CONFIRM ="orderConfirm" ;
        String AppliedMin="MIni";
        String AppliedMax ="Maxi" ;
    }

    private static PreferenceManager sInstance;
    private SharedPreferences mPrefs;
    private SharedPreferences.Editor mEditor;

    private PreferenceManager( Context ctx) {
        mPrefs = ctx.getApplicationContext().getSharedPreferences(ctx.getPackageName(), Context.MODE_PRIVATE);
        mEditor = mPrefs.edit();
    }

    public static PreferenceManager getInstance(Context ctx) {
        if (sInstance == null) {
            sInstance = new PreferenceManager(ctx);
        }
        return sInstance;
    }

	public static void storePrefBoolean(Context context, String key, boolean value) {
		SharedPreferences sp = context.getSharedPreferences(FILE_NAME, context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sp.edit();
		editor.putBoolean(key, value);
		editor.commit();
	}

	public static boolean getPrefBoolean(Context context, String key) {
		SharedPreferences sp = context.getSharedPreferences(FILE_NAME, context.MODE_PRIVATE);
		return sp.getBoolean(key, false);
	}

	public static int getIntPref(Context context, String key) {
		SharedPreferences sp = context.getSharedPreferences(FILE_NAME, context.MODE_PRIVATE);
		return sp.getInt(key, 0);
	}

	public static void storePrefInt(Context context, String key, int value) {
		SharedPreferences sp = context.getSharedPreferences(FILE_NAME, context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sp.edit();
		editor.putInt(key, value);
		editor.commit();
	}

	public boolean isUserLoggedIn(){
		return mPrefs.getBoolean( Keys.IS_USER_LOGGEDIN, false);
	}

	public void setUserLoggedIN(boolean isUserLoggedIn){
		mEditor.putBoolean( Keys.IS_USER_LOGGEDIN, isUserLoggedIn).commit();
	}


	public void setToken(String token) {
        mEditor.putString( Keys.TOKEN, token).commit();
    }

    public String getToken() {
        return mPrefs.getString( Keys.TOKEN, Constants.EMPTY_TEXT);
    }

    public void setCustomerId(String token) {
        mEditor.putString( Keys.CUSTOMER_ID, token).commit();
    }

    public String getCustomerId() {
        return mPrefs.getString( Keys.CUSTOMER_ID, Constants.EMPTY_TEXT);
    }

    public void setGuestId(String token) {
        mEditor.putString( Keys.GUEST_SESSION_ID, token).commit();
    }

    public String getGuestId() {
        return mPrefs.getString( Keys.GUEST_SESSION_ID, Constants.EMPTY_TEXT);
    }

    public void setGcmToken(String token) {
        mEditor.putString( Keys.GCM_TOKEN, token).commit();
    }

    public String getGcmToken() {
        return mPrefs.getString( Keys.GCM_TOKEN, Constants.EMPTY_TEXT);
    }

    public void setCustomerPin(String pin) {
        mEditor.putString( Keys.CUSTOMER_PIN, pin).commit();
    }

    public String getCustomerPin() {
        return mPrefs.getString( Keys.CUSTOMER_PIN, Constants.EMPTY_TEXT);
    }

    public void setCustomerCartCount(int count) {
        mEditor.putInt( Keys.CUSTOMER_CART_COUNT, count).apply();
    }

    public int getCustomerCartCount() {
        return mPrefs.getInt( Keys.CUSTOMER_CART_COUNT, 0);
    }


    public void setAddressId(String addressId) {
        mEditor.putString( Keys.ADDRESS_ID, addressId).commit();
    }

    public String getAddressId() {
        return mPrefs.getString( Keys.ADDRESS_ID, Constants.EMPTY_TEXT);
    }

    public void setLoginType(String name) {
        mEditor.putString( Keys.LOGIN_TYPE, name).apply();
    }

    public String getLoginType() {
        return mPrefs.getString( Keys.LOGIN_TYPE, Constants.EMPTY_TEXT);
    }

    public void setRecentSearch(String name){
        mEditor.putString( Keys.RECENT_SEARCH, name).apply();
    }

    public String getRecentSearch(){
        return mPrefs.getString( Keys.RECENT_SEARCH, Constants.EMPTY_TEXT);
    }

    public void setTrendSearch(String trendString) {
        mEditor.putString( Keys.TREND_SEARCH, trendString).apply();
    }
    public String getTrendSearch(){
        return mPrefs.getString( Keys.TREND_SEARCH, Constants.EMPTY_TEXT);
    }

    public void insertInt(int pageId){
        mEditor.putInt("perPageProduct", pageId).commit();
    }

    public int getInt() {
        return mPrefs.getInt("perPageProduct", 0);
    }

    public String getColorData() {
        return mPrefs.getString( Keys.COLOR_APP, Constants.EMPTY_TEXT);
    }

    public void setColorData(String value) {
        mEditor.putString( Keys.COLOR_APP, value).commit();
       // mEditor.putStringSet()
    }




    public void setMinPrice(int minprice){
        mEditor.putInt( Keys.MINPRICE, minprice).commit();
    }

    public int getMinPrice() {
        return mPrefs.getInt( Keys.MINPRICE, 0);
    }


    public void setMaxPrice(int maxPrice){
        mEditor.putInt( Keys.MAXPRICE, maxPrice).commit();
    }

    public int getMaxPrice() {
        return mPrefs.getInt( Keys.MAXPRICE, 0);
    }

    public void setFilterjson(JSONObject filterjson)
    {
        mEditor.putString( Keys.FILTERJSON, filterjson.toString()).commit();

    }

    public  String getFilterJson()
    {
         return mPrefs.getString( Keys.FILTERJSON, "");
    }


    public void setRecentlyViewdProduct(String recentlyViewedProduct)
    {
        mEditor.putString( Keys.RECENTLY_VIEWED_PRODUCT, recentlyViewedProduct).commit();
    }
    public  String getRecentlyViewdProduct()
    {
        return mPrefs.getString( Keys.RECENTLY_VIEWED_PRODUCT, "");
    }

    public void setSortJson(JSONObject filterjson)
    {
        mEditor.putString( Keys.SORTJSON, filterjson.toString()).commit();

    }

    public  String getSortJson()
    {
        return mPrefs.getString( Keys.SORTJSON, "");
    }

    public void setCartProductSize(int size) {

        mEditor.putInt( Keys.CART_PRODUCT_SIZE, size).commit();
    }
    public int getCartProductSize(){
        return mPrefs.getInt( Keys.CART_PRODUCT_SIZE, -1);
    }

    public void setUrlHandlerJson(JSONObject jsonObject) {

        mEditor.putString( Keys.HandlerJson, jsonObject.toString()).commit();
    }
    public String getUrlHandlerJson(){

        return mPrefs.getString( Keys.HandlerJson, "");
    }






	public String getAdvertId(){
        return mPrefs.getString( Keys.GCM_TOKEN, "");
    }

    public void setAdvertId(String id){
        mEditor.putString( Keys.ADVERTISINGID, id).commit();
    }


    public  void setLoginUserWishList(ArrayList<Integer> mList)
    {
        mEditor.putString( Keys.LoginUser, mList.toString()).commit();
    }

    public  String getLoginUserWishList()
    {
        return mPrefs.getString( Keys.LoginUser, "");
    }

    public  void setGuestUserWishList(ArrayList<String> mList)
    {
        mEditor.putString( Keys.GuestUser, mList.toString()).commit();
    }

    public  String getGuestUserList()
    {
        return mPrefs.getString( Keys.GuestUser, "");
    }

    public  void setGuestWishListDetail(String mList)
    {
        mEditor.putString( Keys.GetUserDetails, mList).commit();
    }

    public  String getGuestWishListDetail()
    {
        return mPrefs.getString( Keys.GetUserDetails, "");
    }

    public String getPincode(){
        return mPrefs.getString( Keys.PINCODE, "");
    }

    public void setPincode(String pincode){
        mEditor.putString( Keys.PINCODE, pincode).commit();
    }


    public boolean isHomePageViewedFirstTime(){
        return mPrefs.getBoolean( Keys.HOME_PAGE_VIEWED_FIRSTTIME, false);
    }

    public void setHomePageViewedFirstTime(){
        mEditor.putBoolean( Keys.HOME_PAGE_VIEWED_FIRSTTIME, true).commit();
    }

    public String getFirstTimeUser(){
        return mPrefs.getString( Keys.LOGIN_FIRSTTIME, "");
    }

    public void setFirstTimeUser(String first){
        mEditor.putString( Keys.LOGIN_FIRSTTIME, first).commit();
    }


    public String getGCMToken(){
        return mPrefs.getString( Keys.GCM_TOKEN, "");
    }

    public void setGCMID(String token){
        mEditor.putString( Keys.GCM_TOKEN, token).commit();
    }


    public void setTrackConfirmation(String yes) {
        mEditor.putString( Keys.TRACK_CONFIRM, yes).commit();
    }
    public String getTrackConfirmation() {
        return mPrefs.getString( Keys.TRACK_CONFIRM, "");
    }



    public void setAppliedMin(int min) {
        mEditor.putInt( Keys.AppliedMin, min).commit();
    }
    public int getAppliedMin() {
        return mPrefs.getInt( Keys.AppliedMin, 0);
    }




    public void setAppliedMax(int max) {
        mEditor.putInt( Keys.AppliedMax, max).commit();
    }
    public int getAppliedMax() {
        return mPrefs.getInt( Keys.AppliedMax, 0);
    }
}
