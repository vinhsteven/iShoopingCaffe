package com.example.AppcConfig;

import java.util.Locale;

public class ApplicationConfig {
	
	public static String AUTHORIZE_STRING = "";
	
	public static String companyId = "";// = "10132";
	public static String categoryChoose = "NAILS";
	public static String STATUS_SALON_ACTIVATE = "ACTIVATE";
	// user information
	// change when log out
	public static boolean CheckLogin = false;
	public static String userIdOfMerchantCDB = "";
	public static String IdMerchantCDB = "";
	public static String userId = "";
	public static String userName = "";
	public static String groupId = "";
	public static String userRole = "";
	public static String userRoleName = "";
	public static String userEmail = "";
	public static String firstName = "";
	public static String lastName = "";
	public static String contactId = "";
	public static String portraitId = "";
	public static String deviceId;
	public static String portName = "TCP:192.168.2.67";
	public static String portSetting = "9100";
	public static int	 SCAN_QR_CODE_REQUEST = 1;
	public static int	 SCAN_QR_CODE_REQUEST_CARD = 2;
	public static int	 RECEIPT_STATUS_REQUEST = 0;
	public static int	 SCAN_CARD_NUMBER_MEMBERSHIP = 101;
	public static String  SCAN_RESULT ="";
	public static int DELTA_NUMBER_ROUND = 2;
	public static int	 REQUEST_SELECT_AMOUNT_DEPOSIT = 1123;
	//use for location
	public static double myLatitue;//location of my location
	public static double myLongitue;//location of my location
	public static double currentLatitue;//location of city choose
	public static double currentLongitue;//location of city choose
	public static String currentNameCity;
	public static String currentNameState;
	public static String currentNameCountry;
	public static String currentShortNameCountry;
	public static String myAddressLocation;
	public static String idCountry;
	public static String idCity;
	public static boolean isChangedListSpa;
	public static int screenWidth;
	public static int screenHeight;

	public static double MileToKm = 1.609344;
	public static double KmToMile = 0.621504;
	public static int RadiusShoose = 3;
	public static int RadiusShooseForDeal = 3;
	public static int RadiusShooseForLocation = 3;
	
	//use for tab
	public static int tab =-1;
	public static int tabHome=0;
	public static int tabDeal=1;
	public static int tabGift=1;
	public static int tabMyCart=1;
	public static int tabMore=1;
	
	public static String classNameService = "com.qgs.portal.setting.model.Services";
	public static String classNameProduct = "com.qgs.portal.setting.model.Product";
	
	public static String colorWaiting="";
	public static String colorConfirm="";
	public static String colorChecked="";
	public static int heightMenu = 0;
	//mutli language
	public static Locale locale = Locale.getDefault();
	public static int REQUEST_LAYOUT_DETAILMEMBERSHIP = 15;
	public static int RESULT_LAYOUT_DETAILMEMBERSHIP = -1;
	public static int REQUEST_LAYOUT_DETAILCREADIT = 16;
	public static int RESULT_LAYOUT_DETAILCREADITCARD = -1;
	public static int REQUEST_LAYOUT_DETAILGIFTCARD = 16;
	public static int RESULT_LAYOUT_DETAILGIFTCARD = -1;
	public static boolean readyGetFriendFacebook = false;
	public static boolean changeServer = false;
	public static int valueClickMapDeal = 1;
	public static int valueClickMapGift = 1;
	
	//
	public static int SCAN_CHOPPING_MEMBERSHIP_QGS = 68;
	//public static int VALUE_CHOPPING_MEMBERSHIP_QGS = 0;
	public static int SCAN_CHOPPING_MEMBERSHIP = 77;
	//public static int VALUE_CHOPPING_MEMBERSHIP = 0;
	public static boolean IS_CHANGE_VIEW_BOOKING = false;
	public static boolean valueOfUserLoginnedGooleYet = false;
	public static String twitter_id="";
	public static String twitter_name="";
	public static String twitter_email="";
	public static boolean IS_FIRST_LOAD = true;
	public static boolean IS_CLEAR_CACHE = false;
	public static int REQUEST_CODE_SCAN_CREDITCARD= 99;
	public static boolean isSelectNextMonth = false;// to show message nailstech don't have time when next month
	public static boolean reloadlistGiftWhenBack = false;
	//status reload of my booking.
	public static int StatusReloadMyBooking = 0; //0:-view List  1:-view day 2:- View month
	public static int statusChangeMapMemberShip = 1;
}
