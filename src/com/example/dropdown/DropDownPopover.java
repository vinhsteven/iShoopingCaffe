package com.example.dropdown;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;

import com.example.ishoopingcaffe.R;

public class DropDownPopover{
	PopupWindow mWindow;
	DropDownView mView;
	DropDownArrowView mArrowView;
	int w;
	
	
//	public DropDownPopover(Context ctx, ArrayList<View> arr, DropDownView.OnItemClicked listener, boolean arrowBelow){
//		mView = new DropDownView(ctx, arr, listener, arrowBelow);
//		mWindow  = new PopupWindow(ctx);
//		mWindow.setContentView(mView);
//		mWindow.setTouchable(true);
//		mWindow.setFocusable(true);
//		mWindow.setOutsideTouchable(true);
//		mWindow.setTouchInterceptor(new OnTouchListener() {
//			@Override
//			public boolean onTouch(View v, MotionEvent event) {
//				if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
//					mWindow.dismiss();					
//					return true;
//				}
//				return false;
//			}
//		});
//		mWindow.setBackgroundDrawable(ctx.getResources().getDrawable(R.drawable.bg_transparent));
//	}
	
	public DropDownPopover(Context ctx, View v, boolean haveArrow){
		mView = new DropDownView(ctx, v, haveArrow);
		mWindow  = new PopupWindow(ctx);
		mWindow.setContentView(mView);
		mWindow.setTouchable(true);
		mWindow.setFocusable(true);
		mWindow.setOutsideTouchable(true);
		mWindow.setTouchInterceptor(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
					mWindow.dismiss();					
					return true;
				}
				return false;
			}
		});
		mWindow.setBackgroundDrawable(ctx.getResources().getDrawable(R.drawable.bg_transparent));
	}
	
	//use for form arrow right
	public DropDownPopover(Context ctx, View v){
		mArrowView = new DropDownArrowView(ctx, v);
		mWindow  = new PopupWindow(ctx);
		mWindow.setContentView(mArrowView);
		mWindow.setTouchable(true);
		mWindow.setFocusable(true);
		mWindow.setOutsideTouchable(true);
		mWindow.setTouchInterceptor(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
					mWindow.dismiss();					
					return true;
				}
				return false;
			}
		});
		mWindow.setBackgroundDrawable(ctx.getResources().getDrawable(R.drawable.bg_transparent));
	}
	
//	//use for form not arrow - ex: add tip
//	//cus = 0;
//	public DropDownPopover(Context ctx, View v, boolean notArrow ){
//		mArrowView = new DropDownArrowView(ctx, v, notArrow);
//		mWindow  = new PopupWindow(ctx);
//		mWindow.setContentView(mArrowView);
//		mWindow.setTouchable(true);
//		mWindow.setFocusable(true);
//		mWindow.setOutsideTouchable(true);
//		mWindow.setTouchInterceptor(new OnTouchListener() {
//			@Override
//			public boolean onTouch(View v, MotionEvent event) {
//				if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
//						mWindow.dismiss();					
//					return true;
//				}
//				return false;
//			}
//		});
//		mWindow.setBackgroundDrawable(ctx.getResources().getDrawable(R.drawable.bg_transparent));
//	}
	//use for form not arrow - ex: add tip
		//cus = 0;
		public DropDownPopover(Context ctx, boolean notArrow, View viewEdit ){
			mArrowView = new DropDownArrowView(ctx, viewEdit, notArrow);
			mWindow  = new PopupWindow(ctx);
			mWindow.setContentView(mArrowView);
			mWindow.setTouchable(true);
			mWindow.setFocusable(false);
			mWindow.setOutsideTouchable(true);
			mWindow.setTouchInterceptor(new OnTouchListener() {
				@Override
				public boolean onTouch(View v, MotionEvent event) {
					if(event.getAction() == MotionEvent.ACTION_OUTSIDE) {
							mWindow.dismiss();					
						return true;
					}
					return false;
				}
			});
			mWindow.setBackgroundDrawable(ctx.getResources().getDrawable(R.drawable.bg_transparent));
		}
	
	//use for form arrow above
	public DropDownPopover(Context ctx, View v, View viewClick){
		mArrowView = new DropDownArrowView(ctx, v, viewClick);
		mWindow  = new PopupWindow(ctx);
		mWindow.setContentView(mArrowView);
		mWindow.setTouchable(true);
		mWindow.setFocusable(true);
		mWindow.setOutsideTouchable(true);
		mWindow.setTouchInterceptor(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
					mArrowView = null;
					mWindow.dismiss();					
					return true;
				}
				return false;
			}
		});
		mWindow.setBackgroundDrawable(ctx.getResources().getDrawable(R.drawable.bg_transparent));
		
		Activity a = (Activity)ctx;
		DisplayMetrics metric = new DisplayMetrics();
		a.getWindowManager().getDefaultDisplay().getMetrics(metric);
		w = metric.widthPixels;
	}
	
	//use for form arrow above for send Email
		public DropDownPopover(boolean sendEmail, Context ctx, View v, View viewClick){
			mArrowView = new DropDownArrowView(sendEmail,ctx, v, viewClick);
			mWindow  = new PopupWindow(ctx);
			mWindow.setContentView(mArrowView);
			mWindow.setTouchable(true);
			mWindow.setFocusable(true);
			mWindow.setOutsideTouchable(true);
			mWindow.setTouchInterceptor(new OnTouchListener() {
				@Override
				public boolean onTouch(View v, MotionEvent event) {
					if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
						mArrowView = null;
						mWindow.dismiss();					
						return true;
					}
					return false;
				}
			});
			mWindow.setBackgroundDrawable(ctx.getResources().getDrawable(R.drawable.bg_transparent));
			
			Activity a = (Activity)ctx;
			DisplayMetrics metric = new DisplayMetrics();
			a.getWindowManager().getDefaultDisplay().getMetrics(metric);
			w = metric.widthPixels;
		}
	
	//use for form arrow above and nail tech
	public DropDownPopover(Context ctx, View v, View viewClick, int nailtech){
		mArrowView = new DropDownArrowView(ctx, v, viewClick, nailtech);
		mWindow  = new PopupWindow(ctx);
		mWindow.setContentView(mArrowView);
		mWindow.setTouchable(true);
		mWindow.setFocusable(true);
		mWindow.setOutsideTouchable(true);
		mWindow.setTouchInterceptor(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
					mArrowView = null;
					mWindow.dismiss();					
					return true;
				}
				return false;
			}
		});
		mWindow.setBackgroundDrawable(ctx.getResources().getDrawable(R.drawable.bg_transparent));
		
		Activity a = (Activity)ctx;
		DisplayMetrics metric = new DisplayMetrics();
		a.getWindowManager().getDefaultDisplay().getMetrics(metric);
		w = metric.widthPixels;
	}
	//use for form arrow below
	public DropDownPopover(Context ctx, View v, View viewClick, boolean arrowBelow){
		mArrowView = new DropDownArrowView(ctx, v, viewClick, arrowBelow);
		mWindow  = new PopupWindow(ctx);
		mWindow.setContentView(mArrowView);
		mWindow.setTouchable(true);
		mWindow.setFocusable(true);
		mWindow.setOutsideTouchable(true);
		mWindow.setTouchInterceptor(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
					mArrowView = null;
					mWindow.dismiss();					
					return true;
				}
				return false;
			}
		});
		mWindow.setBackgroundDrawable(ctx.getResources().getDrawable(R.drawable.bg_transparent));
	}
	public void dismiss(){
		mWindow.dismiss();
	}
	public void searchDismiss(){
		
		mWindow.dismiss();
	}
	
	public void show(View v){
		mWindow.showAsDropDown(v);
		mWindow.update(200, 300);
	}
	public void showTop(View v){
		int[] arr = new int[2];
		v.getLocationOnScreen(arr);
		int x = arr[0] - v.getWidth()/2;
		int y = arr[1] - 305;
		mWindow.showAtLocation(v, Gravity.NO_GRAVITY, x, y );
		mWindow.update(150,300);
	}
	public void showArrowBelow(View v)
	{
		int[] arr = new int[2];
		v.getLocationOnScreen(arr);
		int x = arr[0] - 175 + v.getWidth()/2;
		int y = arr[1] - 450;
		mWindow.showAtLocation(v, Gravity.NO_GRAVITY, x, y);
		mWindow.update(350, 450);
	}
	//
	public void showArrowAbove(View v)
	{
		int[] arr = new int[2];
		v.getLocationOnScreen(arr);
		int x = (arr[0]  + v.getWidth()/2) - 170;
		int y = arr[1] - 180;
		mWindow.showAtLocation(v, Gravity.NO_GRAVITY, x, y);
		mWindow.update(350, 270);
	}
	public void showSelectTime(View v){
		int[] arr = new int[2];
		v.getLocationOnScreen(arr);
		int x = arr[0] - 150;
		int y = arr[1] - 300;
		mWindow.showAtLocation(v, Gravity.NO_GRAVITY, x, y);
		mWindow.update(150,300);
	}
	
	public void showSelectTimeZone(View v){
		int[] arr = new int[2];
		v.getLocationOnScreen(arr);
		int x = arr[0] - 300;
		int y = arr[1] - 350;
		mWindow.showAtLocation(v, Gravity.NO_GRAVITY, x, y);
		mWindow.update(300,350);
	}
	
	public void showSelectCountry(View v){
		int[] arr = new int[2];
		v.getLocationOnScreen(arr);
		int x = arr[0] - 150;
		int y = arr[1] - 100;
		mWindow.showAtLocation(v, Gravity.NO_GRAVITY, x, y);
		mWindow.update(150,100);
	}
	
	public void showTicketServices(View v)
	{
		int[] arr = new int[2];
		v.getLocationOnScreen(arr);
		int x = arr[0] - 350;
		int y = arr[1] - 165 + (v.getHeight()/2);
		System.out.println("hehehe "+ arr[0] + " "+arr[1]+ " x " + x + " y "+y + " v.heght "+ v.getHeight());
		mWindow.showAtLocation(v, Gravity.NO_GRAVITY, x, y);
		mWindow.update(350, 330);
	}
	
	public void showCaculator(View v)
	{
		int[] arr = new int[2];
		v.getLocationOnScreen(arr);
		int x = arr[0] - 400;
		int y = arr[1] - 200 + (v.getHeight()/2);
		mWindow.showAtLocation(v, Gravity.NO_GRAVITY, x, y);
		mWindow.update(400, 400);
	}
	

}
