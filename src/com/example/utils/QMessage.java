package com.example.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.example.ishoopingcaffe.LoadTabGreen;
import com.example.ishoopingcaffe.R;

public class QMessage {
	public static void showMessage(Context context, String title, String message, String textButton)
    {
		LinearLayout titleView = new LinearLayout(context);
		titleView.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, 50));
		titleView.setGravity(Gravity.CENTER);
		TextView textTitle = new TextView(context);
		textTitle.setBackgroundColor(Color.TRANSPARENT);
		textTitle.setText(title);
		textTitle.setTypeface(Typeface.DEFAULT_BOLD);
		textTitle.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 17);
		textTitle.setTextColor(context.getResources().getColor(R.color.white));
		titleView.addView(textTitle);
		
		LinearLayout contentView = new LinearLayout(context);
		contentView.setGravity(Gravity.CENTER);
		TextView textContent = new TextView(context);
		textContent.setBackgroundColor(Color.TRANSPARENT);
		textContent.setText(message);
		textContent.setPadding(5, 0, 5, 0);
		textContent.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 17);
		textContent.setTextColor(context.getResources().getColor(R.color.white));
		contentView.addView(textContent);
		
		
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder
        		.setCustomTitle(titleView)
        		.setView(contentView)
        		.setCancelable(false)
        		.setPositiveButton(textButton, new DialogInterface.OnClickListener() 
        		{
                   public void onClick(DialogInterface dialog, int id) 
                   {
                   }
        		});
        builder.show();
    }
	public static void showMessageAndChangeTab(Context context, String title, 
			String message, String textButtonYes, String textButtonNo, final int tab)
    {
		LinearLayout titleView = new LinearLayout(context);
		titleView.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, 50));
		titleView.setGravity(Gravity.CENTER);
		TextView textTitle = new TextView(context);
		textTitle.setBackgroundColor(Color.TRANSPARENT);
		textTitle.setText(title);
		textTitle.setTypeface(Typeface.DEFAULT_BOLD);
		textTitle.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 17);
		textTitle.setTextColor(context.getResources().getColor(R.color.white));
		titleView.addView(textTitle);
		
		LinearLayout contentView = new LinearLayout(context);
		contentView.setGravity(Gravity.CENTER);
		TextView textContent = new TextView(context);
		textContent.setBackgroundColor(Color.TRANSPARENT);
		textContent.setText(message);
		textContent.setPadding(5, 0, 5, 0);
		textContent.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 17);
		textContent.setTextColor(context.getResources().getColor(R.color.white));
		contentView.addView(textContent);
		
		
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder
        		.setCustomTitle(titleView)
        		.setView(contentView)
        		.setCancelable(false)
        		.setPositiveButton(textButtonYes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    	try {
							try {
								LoadTabGreen.switchTab(tab, true, LoadTabGreen.getCurrentTab());
							} catch (Exception e) {
								e.printStackTrace();
							}
						} catch (OutOfMemoryError e) {
							e.printStackTrace();
						}
                    	
                    }
                })
                .setNegativeButton(textButtonNo, new DialogInterface.OnClickListener() {
 				@Override
 				public void onClick(DialogInterface dialog, int which) {
 					dialog.dismiss();
 				}
 			});
         builder.show();
    }
	public static void showMessageAttachRequestExit(final Context context, String title, String message, String textButton)
    {
		LinearLayout titleView = new LinearLayout(context);
		titleView.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, 50));
		titleView.setGravity(Gravity.CENTER);
		TextView textTitle = new TextView(context);
		textTitle.setBackgroundColor(Color.TRANSPARENT);
		textTitle.setText(title);
		textTitle.setTypeface(Typeface.DEFAULT_BOLD);
		textTitle.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 17);
		textTitle.setTextColor(context.getResources().getColor(R.color.white));
		titleView.addView(textTitle);
		
		LinearLayout contentView = new LinearLayout(context);
		contentView.setGravity(Gravity.CENTER);
		TextView textContent = new TextView(context);
		textContent.setBackgroundColor(Color.TRANSPARENT);
		textContent.setText(message);
		textContent.setPadding(5, 0, 5, 0);
		textContent.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 17);
		textContent.setTextColor(context.getResources().getColor(R.color.white));
		contentView.addView(textContent);
		
		
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder
        		.setCustomTitle(titleView)
        		.setView(contentView)
        		.setCancelable(false)
        		.setPositiveButton(textButton, new DialogInterface.OnClickListener() 
        		{
                   public void onClick(DialogInterface dialog, int id) 
                   {
                	   dialog.dismiss();
                	   ((Activity) context).finish();
                   }
        		});
        builder.show();
    }
}
