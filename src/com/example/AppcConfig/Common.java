package com.example.AppcConfig;

import java.util.ArrayList;

import android.view.ViewGroup;

import com.example.views.cart.ShoppingCartItem;

public class Common {
	
	public static String serviceTypeChoose = "NAILS";
	public static String SUB_DOMAIN = "wallet.";
	public static String AppCategoryId = "";
	public static int statusButonChangeCatalog=0;
	public static int loadFirst = 0; // (0): load lan dau, (1): load nhung lan sau
	public static String remoteUser = "";//"admin@myqgs.com";
	public static String password = "";//"binl@d3n";
	/*public static String serverName ="http://qgsdemo.com";
	public static String virtualHost= "qgsdemo.com";*/
	public static String serverName ="http://myqgs.com";
	public static String virtualHost= "myqgs.com";
	/*public static String serverName ="http://beta.qgs.vn";
	public static String virtualHost= "beta.qgs.vn";*/
	/*public static String serverName ="http://qa.qgs.vn";
	public static String virtualHost= "qa.qgs.vn";*/
	public static ViewGroup cartList;
	// use for shopping cart, save it per session
	public static boolean isDeleteShoppingcart = false;
	public static int tab;	
	public static String user;
	public static String username_signup;
	public static String pass_signup;
	public static String name_signup;
	public static String email_signup;
	public static String email_guest;
	public static String department_choose;
	public static int idFloorChoose;
	public static int saleMin;
	public static int saleMax;
	public static String timeChoose;
	public static int badgeNum = 0;
	public static String hourChooseMin;
	public static String hourChooseMax;
	public static String idStore;
	public static String userId;
	public static String userFirstname;
	public static String userLastname;
	public static boolean isLogin;
	public static ArrayList<String> arrIdCard;
	public static String timeChooseMin;
	public static String timeChooseMax;
	public static Boolean CheckLogin=false;
	public static String IdOrderChoose;
	public static String currencyChoose;
	public static ArrayList<ShoppingCartItem> shoppingCart = new ArrayList<ShoppingCartItem>();
	
	public String getIdOrderChoose() {
		return IdOrderChoose;
	}

	public void setIdOrderChoose(String idOrderChoose) {
		IdOrderChoose = idOrderChoose;
	}
	
	public Boolean getCheckLogin() {
		return CheckLogin;
	}

	public void setCheckLogin(Boolean checkLogin) {
		CheckLogin = checkLogin;
	}

	public String getTimeChooseMin() {
		return timeChooseMin;
	}

	public void setTimeChooseMin(String timeChooseMin) {
		Common.timeChooseMin = timeChooseMin;
	}

	public String getTimeChooseMax() {
		return timeChooseMax;
	}

	public void setTimeChooseMax(String timeChooseMax) {
		Common.timeChooseMax = timeChooseMax;
	}


	
	public String getHourChooseMin() {
		return hourChooseMin;
	}

	public void setHourChooseMin(String hourChooseMin) {
		Common.hourChooseMin = hourChooseMin;
	}

	public String getHourChooseMax() {
		return hourChooseMax;
	}

	public void setHourChooseMax(String hourChooseMax) {
		Common.hourChooseMax = hourChooseMax;
	}

	
	public int getTab() {
		return tab;
	}

	public void setTab(int tab) {
		Common.tab = tab;
	}

	public ArrayList<String> getArrIdCard() {
		return arrIdCard;
	}

	public void setArrIdCard(ArrayList<String> arrIdCard) {
		Common.arrIdCard = arrIdCard;
	}

	public boolean isLogin() {
		return isLogin;
	}

	public void setLogin(boolean isLogin) {
		Common.isLogin = isLogin;
	}

	public String getUserFirstname() {
		return userFirstname;
	}

	public void setUserFirstname(String userFirstname) {
		Common.userFirstname = userFirstname;
	}

	public String getUserLastname() {
		return userLastname;
	}

	public void setUserLastname(String userLastname) {
		Common.userLastname = userLastname;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		Common.userId = userId;
	}

	public String getIdStore() {
		return idStore;
	}

	public void setIdStore(String idStore) {
		Common.idStore = idStore;
	}

	public String getTimeChoose() {
		return timeChoose;
	}

	public void setTimeChoose(String timeChoose) {
		Common.timeChoose = timeChoose;
	}

	public int getSaleMin() {
		return saleMin;
	}

	public void setSaleMin(int saleMin) {
		Common.saleMin = saleMin;
	}
	
	public int getSaleMax() {
		return saleMax;
	}

	public void setSaleMax(int saleMax) {
		Common.saleMax = saleMax;
	}

	public int getIdFloorChoose() {
		return idFloorChoose;
	}

	public void setIdFloorChoose(int idFloorChoose) {
		Common.idFloorChoose = idFloorChoose;
	}

	public String getDepartment_choose() {
		return department_choose;
	}

	public void setDepartment_choose(String department_choose) {
		Common.department_choose = department_choose;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		Common.user = user;
	}


	public String getEmail_signup() {
		return email_signup;
	}

	public void setEmail_signup(String email_signup) {
		Common.email_signup = email_signup;
	}

	public String getName_signup() {
		return name_signup;
	}

	public void setName_signup(String name_signup) {
		Common.name_signup = name_signup;
	}

	public String getPass_signup() {
		return pass_signup;
	}

	public void setPass_signup(String pass_signup) {
		Common.pass_signup = pass_signup;
	}

	public String getUsername_signup() {
		return username_signup;
	}

	public void setUsername_signup(String username_signup) {
		Common.username_signup = username_signup;
	}
	public static void deleteCart(ShoppingCartItem item){
		shoppingCart.remove(item);
	}
	
	public static void deleteItemCart(int index){
		shoppingCart.remove(index);
	}
	public static void editItemCart(ShoppingCartItem item){
		int index=0;
		for (int i = 0; i < shoppingCart.size(); i++) {
			if(shoppingCart.get(i).itemId.equals(item.itemId))
			{
				index= i;
				break;
			}
		}
		System.out.println("index update-"+ index);
		shoppingCart.set(index, item);
	}
}
