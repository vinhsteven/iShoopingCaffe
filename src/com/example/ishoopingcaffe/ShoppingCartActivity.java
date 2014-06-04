package com.example.ishoopingcaffe;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import com.example.listener.ActionEventConstantShoppingCart;
import com.example.listener.OnEventControlListener;
import com.example.views.cart.ShoppingCartBilling;
import com.example.views.cart.ShoppingCartShipping;
import com.example.views.cart.ShoppingCartSummaryBilling;
import com.example.views.cart.ShoppingCartView;

public class ShoppingCartActivity extends Activity implements
		OnEventControlListener {
	LinearLayout layoutContainer;
	Animation animation;

	Context mContext;
	ShoppingCartView shoppingCart;
	ShoppingCartBilling shoppingCartBilling;
	ShoppingCartShipping shoppingCartShipping;
	ShoppingCartSummaryBilling shoppingCartSummaryBilling;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shoppingcart);
		mContext = this;
		layoutContainer = (LinearLayout) findViewById(R.id.container_cart);
		shoppingCart = new ShoppingCartView(mContext, this);
		shoppingCart.setLayoutParams(new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		layoutContainer.addView(shoppingCart);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	public void onEvent(int eventType, View control, Object data) {
		switch (eventType) {
		case ActionEventConstantShoppingCart.ACTION_CHANGE_VIEW_MAIN_SHOPPING_CART: {
			layoutContainer.removeAllViews();
			shoppingCart = new ShoppingCartView(mContext, this);
			shoppingCart.setLayoutParams(new LinearLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
			animation = AnimationUtils.loadAnimation(mContext,
					R.anim.rail_from_right_to_left);
			layoutContainer.addView(shoppingCart);
			shoppingCart.startAnimation(animation);
			break;
		}
		case ActionEventConstantShoppingCart.ACTION_CHANGE_VIEW_BILLING: {
			layoutContainer.removeAllViews();
			shoppingCartBilling = new ShoppingCartBilling(this, this);
			shoppingCartBilling.setLayoutParams(new LinearLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
			animation = AnimationUtils.loadAnimation(mContext,
					R.anim.rail_from_right_to_left);
			layoutContainer.addView(shoppingCartBilling);
			shoppingCartBilling.startAnimation(animation);
			break;
		}
		case ActionEventConstantShoppingCart.ACTION_CHANGE_VIEW_SHIPPING: {
			layoutContainer.removeAllViews();
			shoppingCartShipping = new ShoppingCartShipping(this, this);
			shoppingCartShipping.setLayoutParams(new LinearLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
			animation = AnimationUtils.loadAnimation(mContext,
					R.anim.rail_from_right_to_left);
			layoutContainer.addView(shoppingCartShipping);
			shoppingCartShipping.startAnimation(animation);
			break;
		}
		case ActionEventConstantShoppingCart.ACTION_CHANGE_VIEW_SUMMARY_BILLING_SHOPPINGCART: {
			layoutContainer.removeAllViews();
			shoppingCartSummaryBilling = new ShoppingCartSummaryBilling(this, this);
			shoppingCartSummaryBilling.setLayoutParams(new LinearLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
			animation = AnimationUtils.loadAnimation(mContext,
					R.anim.rail_from_right_to_left);
			layoutContainer.addView(shoppingCartSummaryBilling);
			shoppingCartSummaryBilling.startAnimation(animation);
			break;
		}
		default: {

			break;
		}
		}

	}

}
