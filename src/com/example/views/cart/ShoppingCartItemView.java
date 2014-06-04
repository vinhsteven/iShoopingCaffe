package com.example.views.cart;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ishoopingcaffe.R;
import com.example.utils.Utils;

public class ShoppingCartItemView extends LinearLayout implements OnClickListener{
	public TextView txtTitle, txtPrice, txtTotal;
	public TextView edtQuantity;
	public Button btnDelete;
	public ImageView imageItem;
	int w;
	ShoppingCartItem item;
	
	public ShoppingCartItemView(Context context, ShoppingCartItem item) 
	{
		super(context);
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.shopping_cart_item, this, true);
		
		this.item = item;
		
		txtTitle 		= (TextView)findViewById(R.id.shoppingCartItemTitle1);		
		txtPrice 		= (TextView)findViewById(R.id.shoppingCartItemPrice);
		txtTotal 		= (TextView)findViewById(R.id.shoppingCartItemTotal);
		edtQuantity 	= (TextView)findViewById(R.id.edtShoppingCartItemQuantity);
		imageItem 		= (ImageView)findViewById(R.id.shoppingCartItemImage);
		
		Activity a = (Activity)context;
		DisplayMetrics metric = new DisplayMetrics();
		a.getWindowManager().getDefaultDisplay().getMetrics(metric);
		w = metric.widthPixels;
		
		if(w < 480){
			imageItem.getLayoutParams().height = 70;//(int)(w /(1.6));
			imageItem.getLayoutParams().width = 70;
		}
		else{
			imageItem.getLayoutParams().width =100;
			imageItem.getLayoutParams().height = 100;
		}
		
		try
		{
			this.txtTitle.setText(item.title);
			this.edtQuantity.setText("x"+String.valueOf(item.count));
			if(item.image!=null)
				this.imageItem.setImageDrawable(item.image);//setBackgroundDrawable(image);
			else
			{
//				BusinessProcess classLoadImage = new BusinessProcess(context);
//				classLoadImage.asycLoadImage(this.imageItem, item.url, null);
			}
			try {

				double totalPrice = item.count * parseDouble(item.price);
				this.txtPrice.setText(item.currency
						+ Utils.roundNumber(totalPrice, 2));
				Log.e("totalPrice", "" + totalPrice);
				this.txtTotal.setText(item.currency
						+ Utils.roundNumber(totalPrice, 2));
				item.totalItem = Utils.roundNumber(totalPrice, 2);
				Log.e("totalItem", item.totalItem);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			double totalPrice = item.count*parseDouble(item.price);
			this.txtPrice.setText(item.currency+String.valueOf(parseDouble(item.price)));
			Log.e("totalPrice", ""+totalPrice);
			this.txtTotal.setText(item.currency+String.valueOf(totalPrice));
			item.totalItem = String.valueOf(totalPrice);
			Log.e("totalItem", item.totalItem);
			
		}
		catch (Exception e) {
			e.printStackTrace();
			double totalPrice = item.count*parseDouble(item.price);
			this.txtPrice.setText(item.currency+String.valueOf(parseDouble(item.price)));
			this.txtTotal.setText(item.currency+String.valueOf(totalPrice));
			item.totalItem = String.valueOf(totalPrice);
			
		}
		
		this.btnDelete = (Button) findViewById(R.id.shoppingCartItemDelete);
		this.setOnClickListener(this);
		this.btnDelete.setOnClickListener(this);
	}
	
	public void refreshItem()
	{
		this.edtQuantity.setText("X"+String.valueOf(item.count));
	}
	
//	public void refreshChange()
//	{
//		try
//		{
//			String total, quantity;
//			if(item.typeBuy == StaticValue.BUY_FOR_YOURSELF)
//			{
//				int count = item.count;
//				String text = edtQuantity.getText().toString().trim();
////				int maxPerson = Common.maxBought;
//				
//				if(text.compareTo("") != 0)
//				{
//					count = Integer.parseInt(text);
//					if(count>0)
//					{
//						if(item.typePush == StaticValue.PROMOTION_YOURSELF)//is promotion
//						{
//							if(count > maxPerson)
//							{
//								item.count = maxPerson;
//								double totalPrice = (double)(item.count * Double.parseDouble(item.price));
//								item.totalItem =  totalPrice+"";
//								total = item.currency + String.valueOf(totalPrice);
//								ShoppingCartItemView.this.txtTotal.setText(total);
//								item.priceIsZero = false;
//								quantity = String.valueOf(maxPerson);
//								ShoppingCartItemView.this.edtQuantity.setText(quantity);
//								Toast.makeText(getContext(),getResources().getString(R.string.the_max_order_is)+" "+ quantity +" !", Toast.LENGTH_SHORT).show();	
//							}
//							else
//							{
//								item.count = count;
//								double totalPrice = (double)(item.count * Double.parseDouble(item.price));
//								item.totalItem =  totalPrice+"";
//								total = item.currency + String.valueOf(totalPrice);
//								ShoppingCartItemView.this.txtTotal.setText(total);
//								item.priceIsZero = false;
//							}
//						}
//						else if(item.typePush == StaticValue.GIFT_YOURSELF)//is gift for yourself
//						{
//							if(count > Integer.parseInt(item.maxOrder))
//							{
//								item.count = Integer.parseInt(item.maxOrder);
//								double totalPrice = (double)(item.count * Double.parseDouble(item.price));
//								item.totalItem =  totalPrice+"";
//								total = item.currency + String.valueOf(totalPrice);
//								ShoppingCartItemView.this.txtTotal.setText(total);
//								item.priceIsZero = false;
//								quantity = item.maxOrder;
//								ShoppingCartItemView.this.edtQuantity.setText(quantity);
//								Toast.makeText(getContext(),getResources().getString(R.string.the_max_order_is)+" "+ quantity +" !", Toast.LENGTH_SHORT).show();	
//							}
//							else
//							{
//								item.count = count;
//								double totalPrice = (double)(item.count * Double.parseDouble(item.price));
//								item.totalItem =  totalPrice+"";
//								total = item.currency + String.valueOf(totalPrice);
//								ShoppingCartItemView.this.txtTotal.setText(total);
//								item.priceIsZero = false;
//							}
//						}
//						else//is gift
//						{
//							item.count = count;
//							double totalPrice = (double)(item.count * Double.parseDouble(item.price));
//							item.totalItem =  totalPrice+"";
//							total = item.currency + String.valueOf(totalPrice);
//							ShoppingCartItemView.this.txtTotal.setText(total);
//							item.priceIsZero = false;
//						}
//					}
//					else
//					{
//						item.count = 0;
//						item.totalItem =  "0.00";
//						total = item.currency + item.totalItem;
//						ShoppingCartItemView.this.txtTotal.setText(total);
//						item.priceIsZero = true;
//					}
//				}
//				else
//				{
//					item.count = 0;
//					item.totalItem =  "0.00";
//					total = item.currency + item.totalItem;
//					ShoppingCartItemView.this.txtTotal.setText(total);
//					item.priceIsZero = true;
//				}
//			}
//			ShoppingCartView.refresh(item.itemId);
//
//			ShoppingCartItemView.this.edtQuantity.findFocus();
//			ShoppingCartItemView.this.edtQuantity.requestFocus();
//		}
//		catch(Exception ex)
//		{
//			Log.d(tag, "Error");
//			ex.printStackTrace();
//		}
//	}

	private double parseDouble(String num)
	{
		double ret = 0.0;
		try
		{
			ret = Double.parseDouble(num);
		}
		catch(Exception ex)
		{
			num = num.substring(1);
			ret = Double.parseDouble(num);
		}
		return ret;
	}
	@Override
	public void onClick(View v) 
	{
		if(v == this.btnDelete)
		{
			
//			Common.deleteCart(item);
//			Common.isDeleteShoppingcart = true;
//			ShoppingCartView.refresh(item.itemId);
//			
//			if(Common.shoppingCart == null || Common.shoppingCart.size() == 0)
//			{
//				this.btnDelete.setVisibility(View.INVISIBLE);
//				ShoppingCartView.btnEdit.setBackgroundResource(R.drawable.button_edit);
//				Common.isDeleteShoppingcart = false;
//			}
		}
		
	}
	private static final String tag = "ShoppingCartItem";
}
