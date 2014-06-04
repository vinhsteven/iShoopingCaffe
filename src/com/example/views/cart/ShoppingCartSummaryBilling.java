package com.example.views.cart;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.AppcConfig.Common;
import com.example.ishoopingcaffe.R;
import com.example.listener.ActionEventConstantShoppingCart;
import com.example.listener.OnEventControlListener;
import com.example.utils.QMessage;
import com.example.utils.Utils;

public class ShoppingCartSummaryBilling extends LinearLayout implements OnClickListener{
	
	Context mContext;
	Button btnCheckout;
	Button btnBack;
	Button btnEdit,btnChoosePaymentGetway;
	TextView txtCurrency, txtEstimatePrice, txtTextTotal, textDescriptionPaymentGetway;
	ViewGroup cartList;
	ScrollView contentShoppingCard;
	LinearLayout emptyShoppingCard;
	LinearLayout viewMain,viewEditItemCart;
	
	TextView txt_title,txt_yourItem;
	TextView shoppingCartEstimateTotalSummaryPrice,shoppingCartSummaryPriceCurrency;
	//isDone = true --- show done
	//isDone = false --- show edit
	public static boolean isDone = false;
	private final static String tag = "ShoppingCartView"; 
	OnEventControlListener mlistener;
	
	PopupWindow popupWindowPayment;
	String popUpContents[];
	public ShoppingCartSummaryBilling(Context context, OnEventControlListener listener) {
		super(context);
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.shopping_cart_summary_billing_layout, this, true);
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
		btnChoosePaymentGetway = (Button)findViewById(R.id.btnChoosePaymentGetway);
		btnChoosePaymentGetway.setOnClickListener(this);
		btnBack = (Button)findViewById(R.id.btnBack);
		txt_title = (TextView)findViewById(R.id.txt_title);
		txt_yourItem =(TextView)findViewById(R.id.txt_yourItem);
		textDescriptionPaymentGetway = (TextView)findViewById(R.id.textDescriptionPaymentGetway);
		
		shoppingCartEstimateTotalSummaryPrice = (TextView)findViewById(R.id.shoppingCartEstimateTotalSummaryPrice);
		shoppingCartSummaryPriceCurrency = (TextView)findViewById(R.id.shoppingCartSummaryPriceCurrency);
		
		// init currency
		txtCurrency.setText("đ");
		shoppingCartSummaryPriceCurrency.setText("đ");
		btnCheckout = (Button) findViewById(R.id.shoppingCartCheckOut);
		btnEdit = (Button)findViewById(R.id.shoppingCartEdit);
		btnCheckout.setOnClickListener(this);
		loadShoppingCart("đ");
		
		List<String> dogsList = new ArrayList<String>();
        dogsList.add("Chuyển khoản");
        dogsList.add("Tiền mặt");
        // convert to simple array
        popUpContents = new String[dogsList.size()];
        dogsList.toArray(popUpContents);
        
        popupWindowPayment = popupWindowDogs();
	}
	public PopupWindow popupWindowDogs() {
		 
        // initialize a pop up window type
        PopupWindow popupWindow = new PopupWindow(mContext);
 
        // the drop down list is a list view
        ListView listViewDogs = new ListView(mContext);
         
        // set our adapter and pass our pop up window contents
        listViewDogs.setAdapter(dogsAdapter(popUpContents));
         
        // set the item click listener
        listViewDogs.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// add some animation when a list item was clicked
		        Animation fadeInAnimation = AnimationUtils.loadAnimation(mContext, android.R.anim.fade_in);
		        fadeInAnimation.setDuration(10);
		        view.startAnimation(fadeInAnimation);
		         
		        // dismiss the pop up
		        popupWindowPayment.dismiss();
		         
		         
		        // get the id
		        String selectedItemTag = ((TextView) view).getTag().toString();
		        
		        if(selectedItemTag.equals("0"))
		        {
		        	textDescriptionPaymentGetway.setText("Hiện chúng tôi chưa hỗ trợ phương thức thanh toán này.");
		        }
		        else
		        {
		        	textDescriptionPaymentGetway.setText(mContext.getString(R.string.payment_when_receive_product));
		        }
		        
		        
		        btnChoosePaymentGetway.setText(popUpContents[Integer.parseInt(selectedItemTag)]);
		        textDescriptionPaymentGetway.setVisibility(View.VISIBLE);
			}
		});
 
        // some other visual settings
        popupWindow.setFocusable(true);
       
        popupWindow.setWidth(300);
//        popupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        popupWindow.setHeight(250);
        // set the list view as pop up window content
        popupWindow.setContentView(listViewDogs);
 
        return popupWindow;
    }
	/*
     * adapter where the list values will be set
     */
    private ArrayAdapter<String> dogsAdapter(String dogsArray[]) {
 
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, dogsArray) {
 
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
 
                // setting the ID and text for every items in the list
                String item = getItem(position);
//                String[] itemArr = item.split("::");
//                String text = itemArr[0];
//                String id = itemArr[1];
 
                // visual settings for the list item
                TextView listItem = new TextView(mContext);
 
                listItem.setText(item);
                listItem.setTag(position);
                listItem.setTextSize(18);
                listItem.setPadding(10, 10, 10, 10);
                listItem.setTextColor(Color.WHITE);
                 
                return listItem;
            }
        };
         
        return adapter;
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
			shoppingCartEstimateTotalSummaryPrice.setText(Utils.roundNumber(estimatePrice, 2));
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
			shoppingCartEstimateTotalSummaryPrice.setText(Utils.roundNumber(estimatePrice, 2));
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
//			mlistener.onEvent(ActionEventConstantShoppingCart.ACTION_CHANGE_VIEW_BILLING, null, null);
			QMessage.showMessage(mContext, "Thông báo", "Bạn đã đặt hàng thành công! Chúng tôi sẽ liên lạc với bạn trong thời gian sớm nhất.", "OK");
		}
		else if(v==btnChoosePaymentGetway)
		{
			 popupWindowPayment.showAsDropDown(v);
		}
	}
	
	
}
