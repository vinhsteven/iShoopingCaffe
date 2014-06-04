package com.example.views.discovery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ishoopingcaffe.R;
import com.example.listener.ActionEventConstantDiscovery;
import com.example.listener.OnEventControlListener;

public class ViewDetailReadmoreProducts extends LinearLayout implements OnClickListener{
	TextView txtTitle;
	Button btnBack;
	OnEventControlListener mListener;
	Context mContext;
	public ViewDetailReadmoreProducts(Context context, OnEventControlListener listenner) {
		super(context);
		mContext = context;
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.view_details_readmore_product, this,true);
		mListener = listenner;
		btnBack = (Button)findViewById(R.id.btnBack);
		btnBack.setOnClickListener(this);
		txtTitle =(TextView)findViewById(R.id.txtTitle);
		txtTitle.setText(mContext.getString(R.string.readmore));
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v == btnBack)
		{
			mListener.onEvent(ActionEventConstantDiscovery.ACTION_CHANGE_VIEW_DETAILS, null, null);
		}
	}
	
}
