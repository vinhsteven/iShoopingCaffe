package com.example.views.discovery;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import com.example.adapter.MenuListAdapter;
import com.example.dto.MenuContent;
import com.example.ishoopingcaffe.DiscoveryActivity;
import com.example.ishoopingcaffe.R;
import com.example.listener.ActionEventConstantDiscovery;
import com.example.listener.OnEventControlListener;

public class ViewMainDiscovery extends LinearLayout {
	ListView listMenu;
	MenuListAdapter adapter;
	Button btnCoffe, btnDrinkOther, btnFavourite;
	Context mContext;
	LinearLayout layoutContain;
	OnEventControlListener mListener;
	public ViewMainDiscovery(Context context, OnEventControlListener listenner) {
		super(context);
		mContext = context;
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.view_main_discovery, this,true);
		mListener = listenner;
		layoutContain = (LinearLayout)findViewById(R.id.layoutContain);
		listMenu = (ListView) findViewById(R.id.listview_Drinks);
		btnCoffe = (Button) findViewById(R.id.btnCoffe);
		btnDrinkOther = (Button) findViewById(R.id.btnDrinkOther);
		btnFavourite = (Button) findViewById(R.id.btnFavourite);
		adapter = new MenuListAdapter(mContext);
		listMenu.setAdapter(adapter);
		btnCoffe.setSelected(true);
		btnDrinkOther.setSelected(false);
		btnFavourite.setSelected(false);
		for (int i = 0; i < 6; i++) {
			MenuContent content = new MenuContent();
			content.setIdMenu("" + i);
			content.setTitle("Thức uống " + i);
			content.setPrice("Đ" + " " + i + "000");
			adapter.addItem(content);
		}
		adapter.notifyDataSetChanged();
		listMenu.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
//				Intent intent = new Intent(DiscoveryActivity.this,
//						DetailProductsActivity.class);
//				startActivity(intent);
				mListener.onEvent(ActionEventConstantDiscovery.ACTION_CHANGE_VIEW_DETAILS, null, null);
			}
		});
		btnCoffe.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				btnCoffe.setSelected(true);
				btnDrinkOther.setSelected(false);
				btnFavourite.setSelected(false);
			}
		});
		btnDrinkOther.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				btnCoffe.setSelected(false);
				btnDrinkOther.setSelected(true);
				btnFavourite.setSelected(false);
			}
		});
		btnFavourite.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				btnCoffe.setSelected(false);
				btnDrinkOther.setSelected(false);
				btnFavourite.setSelected(true);
			}
		});
		
		layoutContain.setFocusableInTouchMode(true);
		layoutContain.requestFocus();
		layoutContain.setOnKeyListener(new OnKeyListener() {
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if(keyCode == KeyEvent.KEYCODE_BACK 
						&& event.getAction() == KeyEvent.ACTION_UP)
				{
//					mListener.onBackListener();
					return true;
				}
				return false;
			}
		});
		
	}
	public void destroy()
	{
		removeAllViews();
		destroyDrawingCache();
	}

}
