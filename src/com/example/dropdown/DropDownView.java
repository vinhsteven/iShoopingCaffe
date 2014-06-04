package com.example.dropdown;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.example.ishoopingcaffe.R;

public class DropDownView extends ScrollView implements OnClickListener{

	OnItemClicked mListener;
	public DropDownView(Context context, ArrayList<View> views, OnItemClicked listener) {
		super(context);
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.drop_down_popover, this, true);
		ViewGroup container = (ViewGroup) findViewById(R.id.listAction);
		container.removeAllViews();
		for(View v : views){
			container.addView(v);
			v.setOnClickListener(this);
		}
		this.mListener = listener;
	}
	// arrow below
	public DropDownView(Context context, View views, boolean haveArrow) {
		super(context);
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.drop_down_arow_below_center_popover, this, true);
		ViewGroup container = (ViewGroup) findViewById(R.id.listAction);
		container.removeAllViews();
		container.addView(views);
	}
	public void onClick(View v){
		mListener.onItemClicked(v);
	}
	
	public interface OnItemClicked{
		public void onItemClicked(View v);
	}

}
