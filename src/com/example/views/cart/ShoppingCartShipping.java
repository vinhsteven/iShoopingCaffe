package com.example.views.cart;
import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ishoopingcaffe.R;
import com.example.listener.ActionEventConstantDiscovery;
import com.example.listener.ActionEventConstantShoppingCart;
import com.example.listener.OnEventControlListener;
import com.example.utils.EmailValidator;



public class ShoppingCartShipping extends LinearLayout implements OnClickListener, OnEventControlListener{
	Button btnBack, btnNext;
	TextView txtTitleHeader;
	Context mContext;
	public EditText contactEmail;
	OnEventControlListener mlistener;
	public ShoppingCartShipping(Context context, OnEventControlListener listener) {
		super(context);
		mContext = context;
		mlistener = listener;
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.shopping_cart_shipping, this, true);
		btnBack = (Button)findViewById(R.id.btnBack);
		btnNext = (Button)findViewById(R.id.btnOption);
		btnBack.setOnClickListener(this);
		btnNext.setOnClickListener(this);
		
		txtTitleHeader = (TextView)findViewById(R.id.txtTitle);
		txtTitleHeader.setText(mContext.getString(R.string.shipping));
	}

	// show or hide layout change billing address

	@Override
	public void onClick(View view) {
		if(view == btnBack){
			mlistener.onEvent(ActionEventConstantShoppingCart.ACTION_CHANGE_VIEW_MAIN_SHOPPING_CART, null, null);
		}
		else if(view == btnNext)
		{
			mlistener.onEvent(ActionEventConstantShoppingCart.ACTION_CHANGE_VIEW_SUMMARY_BILLING_SHOPPINGCART, null, null);
		}
	}
	
	
	
	// validate cart before purchase 
	public boolean validatePaymentInfor()
	{
		boolean isOk = true;
		
		// check if email is validated
		String email = contactEmail.getText().toString().trim();
		EmailValidator eValidate = new  EmailValidator();
		if(email.equals(""))
		{
			showMessageFalse(getResources().getString(R.string.textWarning), getResources().getString(R.string.error_not_enter_email));
			return false;
		}
		else if(!eValidate.validate(email))
		{		
			showMessageFalse(getResources().getString(R.string.textWarning), getResources().getString(R.string.error_email_invalid));
			return false;
		}
		TextView txtBillingAdd = (TextView)findViewById(R.id.edtAddress_PaymentInfor);
		TextView txtFirstName = (TextView)findViewById(R.id.edtFirstName_PaymentInfor);
		TextView txtLastName = (TextView)findViewById(R.id.edtLastName_PaymentInfor);
		TextView txtCity = (TextView)findViewById(R.id.edtCity_PaymentInfor);
		TextView txtState = (TextView)findViewById(R.id.edtState_PaymentInfor);
		TextView txtZipcode = (TextView)findViewById(R.id.edtZipcode_PaymentInfor);
		TextView txtPhone = (TextView)findViewById(R.id.edtPhone_PaymentInfor);
		return false;
	}
	private void showMessageFalse(String title, String message)
	{
		final AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
       builder.setMessage(message)
       			.setTitle(title)
              .setCancelable(false)
              .setIcon(R.drawable.check_false)
              .setPositiveButton(getResources().getString(R.string.btnOk), null);
       builder.show();
	}

	@Override
	public void onEvent(int eventType, View control, Object data) {
		
		
	}
}
