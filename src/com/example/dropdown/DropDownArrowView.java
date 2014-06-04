package com.example.dropdown;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.ishoopingcaffe.R;

public class DropDownArrowView extends LinearLayout
{
	public ImageView arrow;
	public DropDownArrowView(Context context, View v) {
		super(context);
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.drop_down_arow_popover, this, true);
		ViewGroup container = (ViewGroup) findViewById(R.id.listAction);
		container.addView(v);
	}
	//use for form not arrow
	public DropDownArrowView(Context context, View v, boolean notArrow) {
		super(context);
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.drop_down_not_arow_popover, this, true);
		ViewGroup container = (ViewGroup) findViewById(R.id.listAction);
		container.addView(v);
	}
	
	//use for form arrow above
	public DropDownArrowView(Context context, View v, View viewClick) {//v: view show
		super(context);
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.drop_down_arow_above_popover, this, true);
		ViewGroup container = (ViewGroup) findViewById(R.id.listAction);
		arrow = (ImageView)findViewById(R.id.imageArrowAbove);
		
		Activity a = (Activity)context;
		DisplayMetrics metric = new DisplayMetrics();
		a.getWindowManager().getDefaultDisplay().getMetrics(metric);
		int w = metric.widthPixels;
		
		int[] arr = new int[2];
		viewClick.getLocationOnScreen(arr);
		int x = arr[0];
		System.out.println("hehehe "+ arr[0] + " "+arr[1]+ " x " + x + " v.heght "+ viewClick.getHeight() + " v.getWidth() " + viewClick.getWidth() + " arrow " + arrow.getWidth());
		LayoutParams lp = new LayoutParams(350, LayoutParams.WRAP_CONTENT);
		int l = 175 - (w - x) + viewClick.getWidth()/2 - 5;// tru 5 la width cua arrow/2
		System.out.println("l "+ l);
		lp.setMargins(l, 0, 0, 0);
		arrow.setLayoutParams(lp);
		container.addView(v);
	}
	
	//use for form arrow above @ Trong
		public DropDownArrowView(boolean sendEmail,Context context, View v, View viewClick) {//v: view show
			super(context);
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			inflater.inflate(R.layout.drop_down_arow_above_popover, this, true);
			ViewGroup container = (ViewGroup) findViewById(R.id.listAction);
			arrow = (ImageView)findViewById(R.id.imageArrowAbove);
			
			Activity a = (Activity)context;
			DisplayMetrics metric = new DisplayMetrics();
			a.getWindowManager().getDefaultDisplay().getMetrics(metric);
			int w = metric.widthPixels;
			
			int[] arr = new int[2];
			viewClick.getLocationOnScreen(arr);
			int x = arr[0];
			System.out.println("hehehe "+ arr[0] + " "+arr[1]+ " x " + x + " v.heght "+ viewClick.getHeight() + " v.getWidth() " + viewClick.getWidth() + " arrow " + arrow.getWidth());
			LayoutParams lp = new LayoutParams(350, LayoutParams.WRAP_CONTENT);
			int l = 175 - (w - x) + viewClick.getWidth()/2 + 25;
			System.out.println("l "+ l);
			lp.setMargins(l, 0, 0, 0);
			arrow.setLayoutParams(lp);
			container.addView(v);
		}
	
	
	//use for form arrow above
	public DropDownArrowView(Context context, View v, View viewClick, int forNailTech) {//v: view show
		super(context);
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.drop_down_arow_above_popover, this, true);
		ViewGroup container = (ViewGroup) findViewById(R.id.listAction);
		arrow = (ImageView)findViewById(R.id.imageArrowAbove);
		
		Activity a = (Activity)context;
		DisplayMetrics metric = new DisplayMetrics();
		a.getWindowManager().getDefaultDisplay().getMetrics(metric);
		int w = metric.widthPixels;
		
		int[] arr = new int[2];
		viewClick.getLocationOnScreen(arr);
		int x = arr[0];
		LayoutParams lp = new LayoutParams(300, LayoutParams.WRAP_CONTENT);
		int l = 150 - (w - x) + viewClick.getWidth()/2 - 5;// tru 5 la width cua arrow/2
		System.out.println("l "+ l);
		lp.setMargins(l, 0, 0, 0);
		arrow.setLayoutParams(lp);
		container.addView(v);
	}
	
	//use for form arrow below
	public DropDownArrowView(Context context, View v, View viewClick, boolean arrowBelow) {//v: view show
		super(context);
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.drop_down_arow_below_popover, this, true);
		ViewGroup container = (ViewGroup) findViewById(R.id.listAction);
		arrow = (ImageView)findViewById(R.id.imageArrowAbove);
		
		int[] arr = new int[2];
		viewClick.getLocationOnScreen(arr);
		int x = arr[0];
		LayoutParams lp = new LayoutParams(20, 10);
		int l = 165;
		if(x < (175 - (viewClick.getWidth()/2)))
		{
			l = viewClick.getWidth()/2 - 10;// tru 5 la width cua arrow/2
		}
		lp.setMargins(l, 0, 0, 0);
		arrow.setLayoutParams(lp);
		container.addView(v);
	}
	
}
