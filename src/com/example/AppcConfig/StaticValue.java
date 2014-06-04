package com.example.AppcConfig;

public class StaticValue {
	
	public static int tabHome;
	public static int tabPromotion;
	public static int tabMyCart;
	public static int tabWallet;
	public static int tabSetting;
	public static int tabGift;
	
	//define variable for shopping
	public static int PROMOTION_YOURSELF 	= 1;
	public static int GIFT_YOURSELF 		= 2;
	public static int PRODUCT				= 3;
	public static int GIFT_FRIEND 			= 4;
	public static int PROMOTION_FRIEND 		= 5;
	//public static int GIFT_FACEBOOK_FRIEND 	= 6;
	public static int GIFT_FACEBOOK_FRIEND 	= 4;
	
	public static int BUY_FOR_YOURSELF 		= 1;
	public static int BUY_FOR_FRIEND 		= 2;
	
	//define for deal follow
	public static int DEAL_FROM_HOME 		= 1;
	public static int DEAL_FROM_DEAl 		= DEAL_FROM_HOME + 1;
	public static int DEAL_FROM_SETTING		= DEAL_FROM_DEAl + 1;
	public static int DEAL_FROM_MYPROMOTION = DEAL_FROM_SETTING + 1;
	
}
