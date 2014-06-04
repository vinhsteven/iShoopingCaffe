package com.example.views.cart;

import android.graphics.drawable.Drawable;

public class ShoppingCartItem{
	public int count = 0;
	public String totalItem;// total price of item
	public String itemId, price, currency;//id, price item, currency item
	public int typePush;// type is: promotion, gift, product, gift friend, promotion friend
	public int typeBuy;// type is: buy your self, buy friend
	public boolean priceIsZero = false;// if price not input
	public String nameSend, nameReceid, emailReceid, messageSend, layoutGiftUrl;//id, price item, currency item
	public String maxOrder = "0";
	public String title;
	public Drawable image;
	public String url;
	public String dateSend = "2012-12-31";
	public String giftLayoutId = "0";
	
	
	public ShoppingCartItem(String title, String price, String currency, int count, String itemId, int typePush, Drawable image, String url,
			int typeBuy, String nameSend, String nameReceid, String emailReceid, String messageSend, String layoutGiftUrl) 
	{
		this.title = title;
		this.typePush 		= typePush;//type = 1: promotion , type = 2: gift, type = 3: product , type = 4: gift friend, type = 5: promotion friend
		this.itemId 		= itemId;
		this.price 			= price;
		this.currency 		= currency;
		this.count 			+= count;
		this.typeBuy 		= typeBuy;
		this.nameSend 		= nameSend;
		this.nameReceid 	= nameReceid;
		this.emailReceid 	= emailReceid;
		this.messageSend 	= messageSend;
		this.layoutGiftUrl 	= layoutGiftUrl;
		this.image = image;
		this.url = url;
		this.totalItem = price;
	}
	/**Truong.le
	 * */
	// constructor new for buy gift
	public ShoppingCartItem(String title, String price, String currency, int count, String itemId, int typePush, Drawable image, String url,
			int typeBuy, String nameSend, String nameReceid, String emailReceid, String messageSend, String layoutGiftUrl, String dateSend) 
	{
		this.title 			= title;
		this.typePush 		= typePush;//type = 1: promotion , type = 2: gift, type = 3: product , type = 4: gift friend, type = 5: promotion friend
		this.itemId 		= itemId;
		this.price 			= price;
		this.currency 		= currency;
		this.count 			+= count;
		this.typeBuy 		= typeBuy;
		this.nameSend 		= nameSend;
		this.nameReceid 	= nameReceid;
		this.emailReceid 	= emailReceid;
		this.messageSend 	= messageSend;
		this.layoutGiftUrl 	= layoutGiftUrl;
		this.image 			= image;
		this.url 			= url;
		this.totalItem 		= price;
		this.dateSend 		= dateSend;
	}
	public String getItemString()
	{
		String chuoiURL = "";
		chuoiURL = itemId + "," + typePush + "," + count + "," + price + "," + nameSend + "," + nameReceid + "," 
					+ emailReceid + "," + messageSend + "," + layoutGiftUrl + "," + giftLayoutId + "," + dateSend;
		return chuoiURL;
	}
	public int mQuantity;  
	public ShoppingCartItem(String itemId, String title, String price, String currency, int quantity) 
	{
		this.itemId = itemId;
		this.title = title;
		this.price = price;
		this.currency = currency;
		this.totalItem = price;
		this.count 			+= quantity;
	}
}
