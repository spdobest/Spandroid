package spandroid.dev.network.volley;

import java.util.ArrayList;

/**
 * Created by surajbokankar on 11/08/16.
 */
public class VolleyConstants {

    public static final String ACTIVITY = "Activity";
    public static final String FROM_WHICH_SCREEN = "FROM_WHICH_SCREEN";
    public static final String IS_NEW_ADDRESS = "IS_NEW_ADDRESS";
    public static final String SPACE = " ";
    public static final String EMPTY_TEXT = "";
    public static final String COMMA = ", ";
    public static final String BRACKET_OPEN = "(";
    public static final String BRACKET_CLOSE = ")";
    public static final String PLUS = " + ";
    public static final String HYPHEN = " - ";
    public static final String SLASH = "/-";
    public static final String VERTICAL_SCORE = " || ";
    public static final String PERCENTAGE = "%";
    public static final String COLON = " : ";
    public static final String SELECT_ALL = "Select All";
    public static final String IS_FROM_HELP_AND_SUPPORT = "isFromHelpAndSupport";
    public static final String FINALJSON = "final";
    public static final Integer STOCK_UNAVAILABLE = 1;
    ///CleverTap Events
    public static final String ButtonTapped = "Tapped Button";
    public static final String Checkout = "CheckedOut";
    public static final String HomeScreen = "HomeScreenViewed";
    public static final String RemovefromCart = "RemoveItemFromCart";
    public static final String NavigatioItem = "NavigationItemAccessed";
    public static final String WentToCart = "WentToCart";
    public static final String AddToCartEvent = "AddedToCart";
    public static final String PoliciesViewed = "PoliciesViewed";
    public static final String BannerTapped = "Tapped Banner";
    public static final String ProductDetails = "ProductDetailsViewed";
    public static final String FilterSorted = "ResultsFilteredOrSorted";
    public static final String SearchPerform = "SearchPerformed";
    public static final String ImageViewed = "ImagesViewed";
    public static final String ProductExpantion = "ProductDetailsExpaned";
    public static final String PreCharged = "PreChargedEvent";
    public static final String UserLogin = "UserLogsIn";
    public static final String WISHLIST = "AddToWishList";
    public static final String UsrerSignUp = "UserSignsUp";
    public static final String MOREDETAILS = "MoreDetails";
    public static final String SimialrProductsEvent = "RecommendationClicked";
    public static final String WishListProductEvent = "ProductBookmarked";
    public static final String GuestUserEvent = "GuestCheckout";
    public static final String CARTPAGEVIEW = "cartviewed";
    public static final String PayamentSuccess = "paymentSucces";
    //CleverTap Changes
    public static final String Category_Name = "category";
    public static final String SUB_CATEGORY_NAME = "subcate";
    public static final String Position_On_page = "position";
    public static final String filterApplied = "AppliedFilter";
    public static final String sortApplied = "AppliedSort";
    //CleverTap GCM PayLoad
    public static final String CleverTap_GCM_Body = "nm";
    public static final String CleverTap_GCM_MSG = "nt";
    public static final String Is_CleverTap = "wzrk_pn";
    public static final String CleverTap_GCM_pivot = "wzrk_pivot";
    public static final String CleverTap_GCM_sound = "wzrk_sound";
    public static final String CleverTap_GCM_rts = "wzrk_rts";
    public static final String CleverTap_GCM_id = "wzrk_id";
    public static final String CleverTap_GCM_collapse = "collapse_key";


    //Dynamic Url Handler public
    public static final String type = "Type";
    //CleverTap SignUp/Login
    public static final String emailType = "email";
    public static final String facebookType = "Facebook";
    public static final String googleType = "Google+";
    public static final String ItemListCount = "cartValue";
    public static final String CustomerNumberCount = "count";
    public static final String CustomerNumber = "number";
    public static final String CustomerCareEmail = "customercareEmail";
    public static final String DeepLink = "DeepLink";
    public static final String DeepLinkUri = "path";
    public static final String SearchString = "search";
    public static final String FacebookUri = "facebook";
    public static final String SearchQueryFromNotification = "search_notify";
    public static final String Type = "NotificationType";
    public static final String CATEGORY_ID = "CATEGORY_ID";
    public static final String PRODUCT_ID = "PRODUCT_ID";
    public static final String UserEmail = " userEmailAddress";
    public static final String ApiIndexTitle = "Title";
    public static final String mTitle = "Title";
    public static final String AppIndexBaseUri = "android-app://com.craftsvilla.app/craftsvilla/com.craftsvilla.android";
    //Color Filter
    public static final String ColorFilter = "Color";
    //Color Filter
    public static final String COLOR_FILTER_NEW = "Color_filter";
    public static final String ColorCode = "code";
    public static final String colorcode = "hascode";
    public static final String minValue = "min";
    public static final String maxValue = "max";
    public static final String Section = "Section";
    public static final String Category = "Category";
    public static final String subCategory = "subCategory";
    public static final String ProductId = "productId";
    public static final String Source = "source";
    public static final String ProductName = "productname";
    public static final String GuestCheckout = "guest";
    public static final String GuestUser = "isCvUser";
    public static final String ShareEventFired = "share";
    public static final String SortByradiopref = "sortbyrange";
    public static final String Discountradiopref = "discountrange";
    public static final String Cashondeliverypref = "cashondelivery";
    public static final String Rangepref = "rangearray";
    public static final String Firstname = "name";
    public static final String Lastname = "lastname";

    /*public String WentToCart="WentToCart";
    public String WentToCart="WentToCart";
    public String WentToCart="WentToCart";*/
    public static final String EmailId = "emailId";
    public static final String phoneNumber = "phone";
    public static final String IS_VISIBLE = "isVisible";
    public static final String IS_APP_COUPON_VISIBLE = "isAppCouponVisible";
    public static final String IS_CHAT_VISIBLE = "isChatVisible";
    public static final String IS_WEBVIEW_VISIBLE = "isWebViewVisible";
    public static final String GoogleAdvertisingId = "AdvertId";
    public static final String PRODUCT_REMOVED_FROM_CART = "product_removed_from_cart";
    public static final String PRODUCT_MOVED_TO_WISHLIST = "product_moved_to_wishlist";
    public static final String IsCategorySend = "category";
    public static final String IsFromDeepLinkingAndNotification = "deepNotify";
    public static final String WishListDeepLink = "wishlis";
    public static final String PDP_URL = "pdp_url";
    public final static String PAYMENT_SUCCESSFUL_STRING = "https://secure2.craftsvilla.com/#!/buy/payment-success/app";
    public final static String SURVEYGIZMO = "http://www.surveygizmo.com/s3/3218748/Android-Application-Rating?render=internal";
    public final static String PLAYSTORELINK = "http://play.google.com/store/apps/details?id=";
    public static final String PRODUCT_VIEWED_BROADCAST = "product_viewed_broadcast";

    public final static String DEFAULT_PINCODE = "000000";
    public static final String SHOULD_CLEAR_HOME_CACHE = "should_clear_home_cache";
    public static final String SOCIAL_PRESSURE_CONFIG1 = "config1";
    public static final String SOCIAL_PRESSURE_CONFIG2 = "config2";
    public static final String SOCIAL_PRESSURE_CONFIG3 = "config3";
    public static final String PAYMENT_MODE_DISPLAY = "payment_mode_display";
    public static final String PAYMENT_MODE_TYPE = "payment_mode_type";
    public static final String INR = "INR";

    public static int mSelectedPosition = -1;
    public static String AddressId = "ADDRESSID";
    public static int BuyNow = 1;
    public static int AddToCart = 2;
    public static String FILTER_PRICE = "Price";
    public static String FILTER_OTHER = "OTHER";
    public static String FILTER_COLOR = "Color";
    public static String FILTER_DISCOUNT = "Discount";
    public static String SINGLE_SELECT = "Single Select";
    public static String MULTI_SELECT = "Multi Select";
    public static String CATEGORYIDLIST = "catList";
    public static String PAGEID = "pageId";
    public static String PERPAGE = "perpage";
    public static String FIRSTLOAD = "firstload";
    public static String SORTNAME = "name";
    public static String SORTFILTERVALUE = "value";
    public static String PRODUCTCOUNT = "count";
    public static String SORTPOSITION = "sortpos";
    public static String MIN = "minimum";
    public static String MAX = "maximum";
    public static ArrayList<Integer> mWishIdList = new ArrayList<>();
    public static String SECTION_TYPE = "TYPE";
    public static String FILTER_VALUES = "filter";
    public static String HOMEPAGE = "home";
    public static String CATEGORYLISTACTIVITY = "category";
    public static String PRODUCTDETAILACTIVITY = "PDP";
    public static String SEARCHACTIVITY = "search";
    public static String FEED = "feed";
    public static String CATEGORYID = "id";
    public static String CATEGORYNAME = "name";
    public static String Price = "price";
    public static String FilterType = "filters";
    public static String SortType = "sort";
    public static String Meta = "meta";
    public static String Marketing = "marketing";
    // public static String SORT_VALUE="sort";    
    public static boolean WebViewInstance = false;
    public static ArrayList<String> mGuestUserWishList = new ArrayList<>();
    //SECTION Name  public
    /*    public static String MYCARTACTIVITY="mycart";
      public static String ADDRESS="address";  
    public static String CALLWEBVIEW="webview";
      public static String ADDRESSACTIVITY="address";*/
    //CleverTap Event Tracking
    public static String CleverTap_AddedtoCart = "AddedtoCart";
    public static String CleverTap_AddToWishList = "AddToWishList";
    public static String CleverTap_Charged = "Charged";
    public static String CleverTap_CheckedOut = "CheckedOut";
    // testing
    public static String CleverTap_HomeScreenViewed = "HomeScreenViewed";
    public static String CleverTap_ProductDetailsViewed = "ProductDetailsViewed";
    public static String CleverTap_PageViews = "PageViews";
    public static String CleverTap_RemoveItemFromCart = "RemoveItemFromCart";
    public static String CleverTap_SearchPerformed = "SearchPerformed";
    public static String CleverTap_UserLogsIn = "UserLogsIn";
    public static String CleverTap_UserSignsUp = "UserSignsUp";
    public static String CleverTap_WentToCart = "WentToCart";
    public static String CleverTap_OrderStatus = "OrderStatus";
    public static String STOREFRONTS = "store_front";
    //CleverTap Common Parameters
    public static String CSF = "csf";
    public static String DEALS = "deals";
    public static String homepagedummyjson4 = "";
    public static String homepagedummyjson5 = "";
    public static ArrayList<String> wishListProductIDs = new ArrayList<>();
    public static String KEY_GCM_TOKEN;
    //Marketing Tracking Details
    public static String Utm_Source = "utm_source";
    public static String Utm_Medium = "utm_medium";
    public static String Utm_Campaign = "utm_campaign";
    //Firebase Events
    public static String BEGIN_CHECKOUT = "Begin_Checkout";
    public static String COMPLETE_ORDER = "Order_Complete";
    public static String PREVIOUSFILTER = "prevState";
    public static String HOME_SCREEN_VIEWED = "Home Screen";
    public static String APP_INSTALL = "app_install";
    public static String APP_OPEN = "app_open";
    public static String SCREEN_VIEWED = "screen_viewed";
    public static String SCREEN_NAME = "screen_name";
    //User Profile
    public static String HOME_TAB = "Home Tab";
    public static String CATEGORY_SCREEN = "Category Tab";
    public static String DEALS_SCREEN = "Deals Tab";
    public static String WISHLIST_SCREEN = "Wishlist Tab";
    public static String ACCOUNT_SCREEN = "Account Tab";
    public static String CSF_PAGE = "CSF Screen";
    public static String SEARCH_PAGE = "Search Page";
    public static String PDP_SCREEN = "Product Detail Page";
    public static String CART_SCREEN = "Cart Screen";
    public static String SHIPPING_SCREEN = "Shipping Page";
    public static String QUOTE_ID = "quoteId";
    public static String ANDROID = "android";
    public static String JUSPAY = "juspay";
    public static String NETBANKING = "netbanking";
    public static String WALLET = "wallet";
    public static String DEBIT_CARD = "dc";
    public static String CREDIT_CARD = "cc";
    public static String CONFIG_BASE_URL = null;
    public static String TOTAL_PAYABLE = "totalpayable";
    public static String COUPON_CODE = "couponCode";


    public enum RequestMode {
        CACHE,
        API
    }

    public interface Screen {
        int NO_AUTH = -1;
        int CART = 1;
        int NONE = 0;
    }

    public interface HeaderKeys {
        String API_VERSION_CODE = "X-VERSION-CODE";
        String X_CLIENT = "X-Client";
        String CONTENT_TYPE = "Content-Type";
        String CACHE_CONTROL = "Cache-Control";
        String AUTHORIZATION = "Authorization";
        String X_SESSION = "X-Session";
    }


    public interface RequestBodyKeys {
        int NETWORK_WIFI = 1;
        int NETWORK_MOBILE = 0;
        String TAG_NETWORK_TYPE = "networkType";
        String TAG_NETWORK_SPEED = "networkSpeed";
        String CUSTOMER_ID = "customerId";
        String COUPON_CODE = "couponCode";
        String PRODUCT_ID = "productId";
        String PRODUCT_IDS = "productIds";
        String QTY = "qty";
        String PRODUCTS = "products";

        String PINCODE = "pincode";
        String CITY = "city";
        String STATE = "state";
        String FIRST_NAME = "firstName";
        String LAST_NAME = "lastName";
        String ADDRESS = "address";
        String PHONE_NO = "phoneNo";
        String COUNTRY_PHONE_CODE = "countryPhoneCode";
        String COUNTRY_ID = "countryId";
        String ADDRESS_ID = "addressId";
        String CATEGORY_ID = "categoryId";

        String SOURCE = "source";
        String DEVICE_ID = "deviceId";
        String PLATFORM = "platform";
        String APP_VERSION = "appVersion";
        String EMAIL_ID = "emailId";
        String PAYMENT_GATEWAY = "paymentGateway";
        String BANK_CODE = "bankCode";
        String CUSTOMER_EMAIL = "customerEmail";
        String CUSTOMER_PHONE = "customerPhone";
        String IMEI = "imei";
        String PAYMENT_METHOD = "paymentMethod";
        String ORDER_ID = "orderId";

    }

    public interface GetQueryKeys {
        String PRODUCT_ID = "?productId=";
        String PRODUCT_IDS = "?productIds=";
        String EMAIL_ID = "?emailId=";
        String CHECK_PINCODE_PINCODE = "?customerPincode=";
        String CHECK_PINCODE_VENDOR_PINCODE = "&vendorPincode=";
        String CHECK_PINCODE_VENDOR_COD = "&vendorCod=";
        String TERM = "?term=";
        String EMAILID_GUEST = "emailId";

        String HOME = "?";
        String RECENT_SEARCH = "?params=";
        String DEVICCE_ID = "?deviceId=";
        String PLATFORM = "&platform=";
        String APP_VERSION = "&appVersion=";
        String PARAMS = "?params=";
        String PINCODE = "&customerPincode=";
    }

    public interface AppConstants {
        String PLATFORM = "Android";
        String CONTENT_FORMAT = "application/json";
        String NO_CACHE = "no-cache";
    }

    public interface ErrorStatusCodes {
        int NO_RESPONSE = -1;
        int SUCCESS_ZERO = 0;
        int NO_INTERNET = 1;
    }

    public interface TrackingConstants {
        String LOGINSCREEN = "loginscreen";
        String FACEBOOK = "facebook";
        String GOOGLE = "google";
        String LOGIN = "normal_login";

    }

    public interface BundleKeys {
        String CURRENT_SCREEN = "current_screen";
        String TABS = "tabs";
        String BANNER_IMAGE = "banner_image_url";
        String BANNER_ID = "baner_id";
        String TAB_ID = "tab_id";
        String CATEGORY_ID = "categoryId";
        String ACTION_TITLE = "action_title";
        String IS_SEARCH = "is_search";
        String SEARCH_QUERY = "query";
        String PRODUCT_ID = "product_id";
        String PRODUCT_NAME = "productName";
        String IS_SIMILAR_PRODUCT = "is_similar_product";
        String ORDER_STATUS = "order_status";
        String ADDRESS_ITEM = "address_item";
        String FILTER_ITEM_POSITION = "filter_item_position";
        String FILTER_TITLE = "filter_title";
        String SUB_CATEGORIES = "sub_categories";
        String VENDOR_ID = "vendor_id";
        String WEB_URL = "web_url";
        String FEED_ID = "feed_ID";
        String BANNER_TYPE = "banner_type";
        String BANNER_NAME = "bannner_name";
        String IS_CHECKOUT = "is_checkout";
        String DELIVERY_ADDRESS = "deliveryAddress";
        String TAG_ID = "tag_id";
        String CUSTOMER_ID = "customer_id";
        String ADDRESS_ID = "address_id";
        String FRAGMENT_NAME = "fragment_name";
        String PRODUCT_IMAGE_POSITION = "ïmage_pos";
        String IS_PAGER = "is_pager";
        String PRODUCT_DESCRIPTION = "description";
        String PRODUCT = "product";
        String GALLERY_LIST = "mGalleryList";
        String POSITION = "position";
        String FROM_WHICH_SCREEN = "from_whichscreen";
        String EMAIL_ID = "emailid";
        String IS_GUEST_USER = "isGuestUser";
        String PAGEID = "pageId";
        String PERPAGE = "perPage";
        String FEEDID = "feedId";
        String BUNDLE = "bundle";
        String HOME_SCREEN = "homeScreen";

        // home screen navigation ids
        int HOME_FRAGMENT = 1;
        int CATEGORIES_FRAGMENT = 2;
        int WISHLIST_FRAGMENT = 4;
        int PROFILE_FRAGMENT = 5;
        int DEALS_FRAGMENT = 3;

        String USER_TYPE = "userType";
        String PAGE_TYPE = "pageType";
        String IS_CATEGORY_ACTIVE = "is_category_active";
        String TOOLBARTITLE = "ToolBarTitle";
        String IS_FROM_SEARCH = "isFromSearch";
        String PARENT = "parent";

        int FILTER_FRAGMENT = 1;
        int SORT_FRAGMENT = 2;
    }

    public interface OrderStatus {
        String CURRENT = "CURRENT";
        String COMPLETED = "COMPLETED";
        String CANCELED = "CANCELLED";
        String ORDER_ID = "ORDER_ID";
    }

    public interface HomeContent {
        String SLIDER = "slider";
        String CATEGORY = "categoryBox";
        String PRODUCT_GRID = "productGrid";
        String VENDOR_GRID = "vendorShopGrid";
        String PAGE = "staticPage";
        String COLOR_GRID = "colorBox";
        String FEED_BOX = "feedBox";
    }

    public interface LoginSourceType {
        String FACEBOOK = "facebook";
        String GOOGLE = "google";
        String SocialoLoginEmail = "email";
    }

    public interface ActivityRequestCodes {
        int RC_SIGN_IN = 555;
        int LOGIN_NAVIGATION = 1000;
        int LOGIN_COMPULSORY = 1001;
        int FILTER = 1002;
        int OAUTH_MANAGER = 1003;
        int FROM_CART_PAGE = 1004;
        int FROM_CART_PAGE_LOGIN = 1005;
        int PRODUCT_DETAIL_ACTIVITY = 1006;
    }

    public interface RequestTags {
        String AUTO_SUGGESTION = "auto_suggestion";
    }

    public interface FilterViewType {
        String COLOR = "colorGridView";
        String NESTED_LISTVIEW = "nestedMultiSelectListView";
        String MULTI_SELECT_VIEW = "multiSelectListView";
        String RADIO_VIEW = "radioListView";
    }

    public interface FilterType {
        String ATTRIBUTE_FILTER = "attributeFilter";
        String SUB_CAT_FILTER = "subCatFilter";

    }

    public interface Dialogs {
        String SPLASH = "splash";
        String SEARCH = "Search";
    }

    public interface BannerType {
        String FEED = "feed";
        String CATEGORY = "category";
        String PRODUCT = "product";
        String TAG = "tag";
    }

    public interface CodHeaderType {
        int NO_HEADER = 0;
        int COD_AVAILABLE = 1;
        int COD_NOT_AVAILABLE = 2;
    }

    public interface BroadCastReceiverType {
        String LOGOUT = "logout";
        String LOGOUT_SUCCESS = "logout_success";
    }

    public interface CheckPinState {
        int NONE = 0;
        int PIN_CAPTURED = 1;
        int COD_DETAILS_FETCHED = 2;
    }

    public interface FragmentNames {
        String PRODUCT_DETAIL = "productDetailsPage";
        String HOME_SCREEN = "homeScreen";
        String CATEGORY_PAGE = "categoryPage";
        String SEARCH_PAGE = "searchPage";
        String CART_PAGE = "cartPage";
        String ORDER_PAGE = "orderPage";
        String FILTER_DATA = "filterData";

    }

    public interface pushDeepLinkKeys {
        String FacebookUri = "facebook";
        String REGISTRATION_COMPLETE = "registrationComplete";
    }

    public interface SwitchScreenFromLoginDialog {
        int FROM_HOME_SCREEN = 1;
        int FROM_ONBOARDING_SCREEN = 2;
        int FROM_MYACCOUNT_SCREEN = 3;
        int FROM_CART_SCREEN = 4;
        int FROM_WISHLIST_SCREEN = 5;
        int FROM_CHECKOUT_SCREEN = 6;
    }

    public interface ForGcm {
        String SENT_TOKEN_TO_SERVER = "sentTokenToServer";
        String NOTIFICATION_ID = "NOTIFICATION_ID";
    }

    public interface UrlHandlerKey {
        String MID = "MID";
        String FILTER = "filter";
        String SORT = "sort";

    }


    public interface MyAccount {
        String MY_ACCOUNT = "MY_ACCOUNT";
        String MY_ORDER = "myOrder";
        String ADDRESS = "address";
        String BANK_DETAILS = "bankDetails";
        String ACCOUNT = "account";

    }

    public interface Gcm {
        String GCM_TITLE = "title";
        String GCM_DISPLAY = "disp";
        String GCM_ACTION = "action";
        String GCM_CONTENT = "content";

    }

    public interface Payment {
        String VISA = "VISA";
        String MASTERCARD = "MASTERCARD";
        String AMEX = "AMEX";
        String MAESTRO = "MAESTRO";
        String DINERS = "DINERS";
        String RUPAY = "RUPAY";
        String JCB = "JCB";
        int[] FORMAT_14_15 = {4, 10};
        int[] FORMAT_16 = {4, 8, 12};
        String DELIMITER = "-";
        String COD = "cod";
        String JUSPAY_ERROR_INVALID_CARD = "invalid_card_number";
        String JUSPAY_ERROR_INVALID_CVV = "invalid_card_cvv";
        String JUSPAY_ERROR_INVALID_YEAR = "invalid_expiry_year";
        String JUSPAY_ERROR_INVALID_MONTH = "invalid_expiry_month";
        String RETRY = "Retry";
    }

    public interface PaymentOptions {
        String COD = "cod";
        String NETBANKING = "net_banking";
        String WALLET = "wallet";
        String DEBIT_CARD = "debit_card";
        String CREDIT_CARD = "credit_card";
        String CARD = "card";

    }

    public interface PaymentType {
        String COD = "cod";
        String CARD = "card";
        String NETBANKING = "netbanking";
        String WALLET = "wallet";
    }

    public interface PaymentDisplayName {
        String COD = "Cash On Delivery";
        String CARD = "card";
        String NETBANKING = "NetBanking";
        String WALLET = "Wallet";
    }

    public static final class HomeAdapterRowViewType {

        public static final int COROUSAL = 1;
        public static final int FIXED_SINGLE = 2;
        public static final int SLIDER = 3;
        public static final int TRACK = 4;
        //SLIDER ALWAYS
        public static final int RECENTLY_VIEWED = 5;
        public static final int FIXED_GRID = 6;
        public static final int SLIDER_PRODUCT = 7;
        public static final int FIXED_GRID_SINGLE = 8;
        public static final int FIXED_SINGLE_BANNER = 9;
        public static final int SLIDER_PRODUCT_API = 10;
        public static final int FIRST_TIME_LOGIN_WELCOME = 11;
        public static final int FIXED_GRID_SCROLL_VERTICAL = 12;
        public static final int DEFAULT = 13;
        public static final int SECURITY_POLICY = 100;
        public static final int SPANNED_GRID = 14;
        public static final int CLUBBED_API = 15;
    }
}
