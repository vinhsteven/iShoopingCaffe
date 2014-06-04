package com.example.ishoopingcaffe;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.example.AppcConfig.Common;
import com.example.AppcConfig.StaticValue;
import com.example.listener.ActionEventConstantDiscovery;
import com.example.listener.OnEventControlListener;
import com.example.utils.QMessage;
import com.example.views.cart.ShoppingCartItem;
import com.example.views.discovery.DialogDetailCommentProducts;
import com.example.views.discovery.ViewDetailProducts;
import com.example.views.discovery.ViewDetailReadmoreProducts;
import com.example.views.discovery.ViewMainDiscovery;

public class DiscoveryActivity extends BaseActivity implements OnEventControlListener {
	
	LinearLayout mainContainerDiscovery;
	Animation animation;
	
	ViewMainDiscovery viewMainDiscovery;
	ViewDetailProducts viewDetailProducts;
	ViewDetailReadmoreProducts viewDetailReadmoreProducts;
	DialogDetailCommentProducts viewDetailCommentProducts;
	
	Context mContext;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_discovery);
		mContext = this;
		mainContainerDiscovery = (LinearLayout)findViewById(R.id.mainContainerDiscovery);
		viewMainDiscovery = new ViewMainDiscovery(this, this);
		mainContainerDiscovery.addView(viewMainDiscovery);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}

	@Override
	public void onEvent(int eventType, View control, Object data) {
		switch (eventType) {
		case ActionEventConstantDiscovery.ACTION_CHANGE_VIEW_MAIN_DISCOVERY:
		{
			mainContainerDiscovery.removeAllViews();
			viewMainDiscovery = new ViewMainDiscovery(this, this);
			animation = AnimationUtils.loadAnimation(mContext, R.anim.rail_from_right_to_left);
			viewMainDiscovery.startAnimation(animation);
			mainContainerDiscovery.addView(viewMainDiscovery);
			break;
		}
		case ActionEventConstantDiscovery.ACTION_CHANGE_VIEW_DETAILS:
		{
			mainContainerDiscovery.removeAllViews();
			viewDetailProducts = new ViewDetailProducts(this, this);
			viewDetailProducts.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
			animation = AnimationUtils.loadAnimation(mContext, R.anim.rail_from_right_to_left);
			viewDetailProducts.startAnimation(animation);
			mainContainerDiscovery.addView(viewDetailProducts);
			break;
		}
			
		
		case ActionEventConstantDiscovery.ACTION_CHANGE_VIEW_DETAILS_READMORE_PPRODUCT:
		{
			mainContainerDiscovery.removeAllViews();
			viewDetailReadmoreProducts = new ViewDetailReadmoreProducts(this, this);
			animation = AnimationUtils.loadAnimation(mContext, R.anim.rail_from_right_to_left);
			viewDetailReadmoreProducts.startAnimation(animation);
			mainContainerDiscovery.addView(viewDetailReadmoreProducts);
			break;
		}
		case ActionEventConstantDiscovery.ACTION_CHANGE_VIEW_DETAILS_COMMENT_PPRODUCT:
		{
			mainContainerDiscovery.removeAllViews();
			viewDetailCommentProducts = new DialogDetailCommentProducts(this, this);
			animation = AnimationUtils.loadAnimation(mContext, R.anim.rail_from_right_to_left);
			viewDetailCommentProducts.startAnimation(animation);
			mainContainerDiscovery.addView(viewDetailCommentProducts);
			break;
		}
		
		case ActionEventConstantDiscovery.ACTION_CHANGE_VIEW_DETAILS_ADD_SHOPPING_CART:
		{
			ShoppingCartItem item = (ShoppingCartItem)data;
				String price = item.price;
				// buy
				boolean isDuplicate = false;
				int vitri = 0;
//				if(Common.shoppingCart != null && Common.shoppingCart.size() > 0)
//				{
//					for(ShoppingCartItem index : Common.shoppingCart)
//					{	
//						if(index.itemId.equals(item.itemId))
//						{
//							isDuplicate = true;
//							vitri = Common.shoppingCart.indexOf(index);
//							break;
//						}
//						else
//						{
//							isDuplicate = false;
//						}
//					}
//					//
//					if(isDuplicate)
//					{
//						if(Common.shoppingCart.get(vitri).price.equals(price))
//						{
//							Common.shoppingCart.get(vitri).count ++;
//							Common.shoppingCart.get(vitri).totalItem = (Double.parseDouble(Common.shoppingCart.get(vitri).price) * Common.shoppingCart.get(vitri).count)+"";
//						}
//						else
//						{
//							Common.shoppingCart.add(item);
//						}
//					}
//					else
//					{
//						Common.shoppingCart.add(item);
//					}
//				}
//				else
				{
					Common.shoppingCart.add(item);
				}
				LoadTabGreen tab;
		 	   	tab = (LoadTabGreen)getParent();
				//tab = (LoadTabGreen)mContext;
		 	   	Common.badgeNum ++;
		 	   	tab.setBadge(Common.badgeNum);
//		 	   	QMessage.showMessageAndChangeTab(DiscoveryActivity.this, getString(R.string.textCongratulation1), getString(R.string.congratulation_order_success), 
//		 	   		getString(R.string.textGoToCart), getString(R.string.btnCancel), StaticValue.tabMyCart);
			
			
		}
		default:
			break;
		}
	}

}
