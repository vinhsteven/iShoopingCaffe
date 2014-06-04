package com.example.views.cart;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.AppcConfig.Common;
import com.example.ishoopingcaffe.R;
import com.example.listener.ActionEventConstantShoppingCart;
import com.example.listener.OnEventControlListener;
import com.example.utils.Utils;

public class ShoppingCartView extends LinearLayout implements OnClickListener{
	
	Context mContext;
	Button btnCheckout;
	Button btnBack;
	Button btnEdit;
	TextView txtCurrency, txtEstimatePrice, txtTextTotal;
	ViewGroup cartList;
	ScrollView contentShoppingCard;
	LinearLayout emptyShoppingCard;
	LinearLayout viewMain,viewEditItemCart;
	
	TextView txt_title,txt_yourItem;
	//isDone = true --- show done
	//isDone = false --- show edit
	public static boolean isDone = false;
	private final static String tag = "ShoppingCartView"; 
	OnEventControlListener mlistener;
	public ShoppingCartView(Context context, OnEventControlListener listener) {
		super(context);
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.shopping_cart_layout, this, true);
		mlistener = listener;
		mContext = context;
		viewMain = (LinearLayout)findViewById(R.id.viewMain);
		
		txtCurrency = (TextView) findViewById(R.id.shoppingCartEstimatePriceCurrency);
		txtEstimatePrice = (TextView) findViewById(R.id.shoppingCartEstimateTotalPrice);
		cartList = (ViewGroup)findViewById(R.id.shoppingCartList);
		contentShoppingCard = (ScrollView)findViewById(R.id.contentShoppingCart);
		emptyShoppingCard = (LinearLayout)findViewById(R.id.emptyShoppingCart);
		emptyShoppingCard.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		txtTextTotal = (TextView)findViewById(R.id.shoppingCartTextTotalPrice);
		
		btnBack = (Button)findViewById(R.id.btnBack);
		txt_title = (TextView)findViewById(R.id.txt_title);
		txt_yourItem =(TextView)findViewById(R.id.txt_yourItem);
		
		// init currency
		txtCurrency.setText("đ");		
		btnCheckout = (Button) findViewById(R.id.shoppingCartCheckOut);
		btnEdit = (Button)findViewById(R.id.shoppingCartEdit);
		btnCheckout.setOnClickListener(this);
		loadShoppingCart("đ");
	}
	public void setLanguage()
	{
		txt_title.setText(getResources().getString(R.string.titleShoppingCart));
		txt_yourItem.setText(getResources().getString(R.string.txtYouritems));
	}
	// reload shopping cart item (when delete or change infor).
	public void refresh(String itemId)
	{
		cartList.removeAllViews();
		Double estimatePrice = 0.0;
		int index=0;
		for (int i = 0; i < Common.shoppingCart.size(); i++) {
			try{
				ShoppingCartItem item = Common.shoppingCart.get(i);
				estimatePrice+= Double.parseDouble(item.totalItem);
				ShoppingCartItemView viewItem = new ShoppingCartItemView(mContext, item);
				cartList.addView(viewItem);
				if(item.itemId.equals(itemId))
				{
					index = i;
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}

		
		try {

			txtEstimatePrice.setText(Utils.roundNumber(estimatePrice, 2));
			
		} catch (Exception e) {
			e.printStackTrace();
			txtEstimatePrice.setText(String.valueOf(estimatePrice));
		}
		
		if(Common.shoppingCart == null || Common.shoppingCart.size()== 0)
		{
			emptyShoppingCard.setVisibility(View.VISIBLE);
			contentShoppingCard.setVisibility(View.GONE);
			btnCheckout.setVisibility(View.GONE);
			btnEdit.setVisibility(View.GONE);
			Common.isDeleteShoppingcart = false;
			isDone = false;
		}
		else
		{
			if(Common.isDeleteShoppingcart == true)
				for(int i = 0; i<Common.shoppingCart.size(); i++)
				{
					ShoppingCartItemView itemView = (ShoppingCartItemView) cartList.getChildAt(i);
					if(!itemView.btnDelete.isShown())
					{
						itemView.btnDelete.setVisibility(View.VISIBLE);
						//ShoppingCartView.btnEdit.setText(mContext.getResources().getString(R.string.btnDone));
						isDone = true;
						btnEdit.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.button_done));
						
					}
					else
					{
						//itemView.btnDelete.setVisibility(View.INVISIBLE);
						//ShoppingCartView.btnEdit.setText(mContext.getResources().getString(R.string.btnEdit));
						isDone = false;
						btnEdit.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.button_edit));
					}
					
				}
			ShoppingCartItemView itemView = (ShoppingCartItemView) cartList.getChildAt(index);
			itemView.edtQuantity.requestFocus();
			
			emptyShoppingCard.setVisibility(View.GONE);
			contentShoppingCard.setVisibility(View.VISIBLE);
			btnCheckout.setVisibility(View.VISIBLE);
			btnEdit.setVisibility(View.VISIBLE);
			
			txtTextTotal.setText(mContext.getResources().getString(R.string.lb_total_MyAppointment_details)+" " +((Common.shoppingCart.size()>1) ? "("+Common.shoppingCart.size() + " items)" : "("+Common.shoppingCart.size() + " item)"));
		}
	}
	// loading shopping cart item
	public void loadShoppingCart(String currency)
	{
		try
		{
			
			cartList.removeAllViews();
			NumberFormat formatter = new DecimalFormat(".00");
			//DecimalFormat formatter = new DecimalFormat("#.##");
			double estimatePrice = 0 ;
			Log.e("Common.shoppingCart.size()",""+Common.shoppingCart.size());
			
			for(ShoppingCartItem item : Common.shoppingCart)
			{
				try
				{
					Log.d("item.totalItem", ""+item.totalItem);
					double temp = Double.parseDouble(item.totalItem);
					estimatePrice = estimatePrice + temp;
					
					ShoppingCartItemView viewItem = new ShoppingCartItemView(mContext, item);
					cartList.addView(viewItem);
					
				}
				catch(Exception ex){
					Log.d(tag, "Error in parse double");
					ex.printStackTrace();
				}
				txtCurrency.setText(item.currency);
			}
			
			String estimatePrice1 = formatter.format(estimatePrice);
			
			try {

			txtEstimatePrice.setText(Utils.roundNumber(estimatePrice, 2));
			
		} catch (Exception e) {
			e.printStackTrace();
			txtEstimatePrice.setText(estimatePrice1);
		}
	
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void onClick(View v) {
		if(v==btnCheckout)
		{
			mlistener.onEvent(ActionEventConstantShoppingCart.ACTION_CHANGE_VIEW_BILLING, null, null);
		}
//		else if(v==btnCheckout){}
	}
	
	
}
