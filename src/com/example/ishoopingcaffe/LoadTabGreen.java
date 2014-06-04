package com.example.ishoopingcaffe;

import java.io.File;
import java.util.ArrayList;
import java.util.Locale;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.AppcConfig.ApplicationConfig;
import com.example.AppcConfig.Common;
import com.example.AppcConfig.StaticValue;
import com.example.views.BadgeView;

@SuppressWarnings("deprecation")
public class LoadTabGreen extends TabActivity {
	private static String TAG = "Mobclix Advertising View";
	ArrayList<String> department;
	int tab;
	Common common = new Common();
	public Context context;
	static TabHost tabHost;
	int indexTab = 0;
	static boolean comeback = false;
	static int tabComeback = 0;
	Locale locale;
	
	static ImageButton a;
	static ImageButton b;
	static ImageButton c;
	static ImageButton d;
	//static ImageButton e;
	static FrameLayout frame;
	static LinearLayout tabLayout;
	static LinearLayout layoutHome, layoutCart, layoutWallet, layoutSetting;
	TextView textHome, textCart, textWallet, textSetting;
	public ViewGroup viewRoot;

	TabHost.TabSpec specHome;
	/*TabHost.TabSpec specDeal;
	TabHost.TabSpec specGift;*/
	TabHost.TabSpec specCart;
	TabHost.TabSpec specWallet;
	TabHost.TabSpec specSetting;
	Intent intentHome;
	/*Intent intentDeal;
	Intent intentGift;*/
	Intent intentCart;
	Intent intentWallet;
	Intent intentSetting;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context = this;
        
        Log.e("on create", "create");
        ApplicationConfig.IS_CLEAR_CACHE = false;
        ApplicationConfig.IS_FIRST_LOAD = true;
        //ApplicationConfig.IS_CLEAR_CACHE = true;
        
//        try
//        {
//	        Locale.setDefault(ApplicationConfig.locale);
//	        Configuration config = new Configuration();
//			config.locale = ApplicationConfig.locale;
//			getBaseContext().getResources().updateConfiguration(config,
//			      getBaseContext().getResources().getDisplayMetrics());
//        }
//		catch (Exception e) {
//			e.printStackTrace();
//		}
        
        setContentView(R.layout.loadtabgreen);
        
        tabHost = getTabHost();  // The activity TabHost
        Resources res = getResources(); // Resource object to get Drawables
        
        String hom 		= LoadTabGreen.this.getString(R.string.textKhamPha);
        String search	= LoadTabGreen.this.getString(R.string.textTim);
        String quanly 	= LoadTabGreen.this.getString(R.string.textQuanly);
        String mycart 	= LoadTabGreen.this.getString(R.string.textGioHang);
        
        
        // Create an Intent to launch an Activity for the tab (to be reused)
        intentHome = new Intent().setClass(LoadTabGreen.this, DiscoveryActivity.class);
        // Initialize a TabSpec for each tab and add it to the TabHost
        specHome = tabHost.newTabSpec("home").setIndicator(hom,
                          res.getDrawable(R.drawable.icon))
                      .setContent(intentHome);
        indexTab = 0;
        StaticValue.tabHome = indexTab;
        
     // Do the same for the other tabs
        intentSetting = new Intent().setClass(LoadTabGreen.this, SearchActivity.class);
        specSetting = tabHost.newTabSpec("search").setIndicator(mycart,
                          res.getDrawable(R.drawable.icon))
                      .setContent(intentSetting);
        indexTab++;
        StaticValue.tabSetting = indexTab;
        
     // Do the same for the other tabs
        intentWallet = new Intent().setClass(LoadTabGreen.this, ManagermentActivity.class);
        specWallet = tabHost.newTabSpec("wallet").setIndicator(quanly,
                          res.getDrawable(R.drawable.icon))
                      .setContent(intentWallet);
        indexTab++;
        StaticValue.tabWallet = indexTab;
        
        intentCart = new Intent().setClass(LoadTabGreen.this, ShoppingCartActivity.class);       
        // Initialize a TabSpec for each tab and add it to the TabHost
        specCart = tabHost.newTabSpec("cart").setIndicator(search,
                          res.getDrawable(R.drawable.icon))
                      .setContent(intentCart);
        indexTab++;
        StaticValue.tabMyCart = indexTab;

        setContent();
        
	}
	public void setContent()
	{
       	tab = common.getTab();
       	if(tab == -1)
       		tab = 0;
		switch (ApplicationConfig.screenWidth) {
		case 240:
			tabHost.setBackgroundResource(R.drawable.bg240x320);			
			break;
		case 320:
			tabHost.setBackgroundResource(R.drawable.bg320x480);
			break;
		case 480:
			tabHost.setBackgroundResource(R.drawable.bg480x800);
			break;
		default:
			tabHost.setBackgroundResource(R.drawable.bg320x480);
			break;
		}
		a = (ImageButton) findViewById(R.id.a);
        b = (ImageButton) findViewById(R.id.b);
        c = (ImageButton) findViewById(R.id.c);
        d = (ImageButton) findViewById(R.id.d);
        //e = (ImageButton) findViewById(R.id.e);
        layoutHome = (LinearLayout) findViewById(R.id.linearHome);
        layoutSetting = (LinearLayout) findViewById(R.id.linearSetting);
        layoutCart = (LinearLayout) findViewById(R.id.linearCart);
        layoutWallet = (LinearLayout) findViewById(R.id.linearWallet);
        
        
        
        textHome 	= (TextView) findViewById(R.id.textHome);
        textCart 	= (TextView) findViewById(R.id.textCart);
        textWallet	= (TextView) findViewById(R.id.textWallet);
        textSetting	= (TextView) findViewById(R.id.textSetting);
        
        frame 		= (FrameLayout)findViewById(R.id.frame);
        tabLayout 	= (LinearLayout) findViewById(R.id.tab);
        badge		= (BadgeView) findViewById(R.id.badCount);
        badge.hide();
//        badge.setText(String.valueOf(3));
        
        LayoutParams layout = new LayoutParams(0, LayoutParams.MATCH_PARENT);
        LayoutParams layoutMargin = new LayoutParams(0, LayoutParams.MATCH_PARENT);
        layout.topMargin = 0;layout.weight=1;
        layoutMargin.topMargin = 10;
        layoutMargin.weight=1;
        a.setSelected(true);
        layoutHome.setLayoutParams(layout);
        layoutHome.setBackgroundResource(R.drawable.icon_bar_left);
        layoutCart.setLayoutParams(layoutMargin);
        layoutWallet.setLayoutParams(layoutMargin);
        layoutSetting.setLayoutParams(layoutMargin);
        
        layoutCart.setBackgroundColor(Color.TRANSPARENT);
        layoutWallet.setBackgroundColor(Color.TRANSPARENT);
        layoutSetting.setBackgroundColor(Color.TRANSPARENT);
       	
        tabHost.addTab(specHome);
        tabHost.addTab(specSetting);
        tabHost.addTab(specWallet);
        tabHost.addTab(specCart);
        
        tabHost.setCurrentTab(tab);
        viewRoot = (ViewGroup) tabHost.getRootView();
	}
	public static  void tabHandler(View target)
	{
		
	    try {
	        a.setSelected(false);
	        b.setSelected(false);
	        c.setSelected(false);
	        d.setSelected(false);
	        //e.setSelected(false);
	        layoutHome.setBackgroundColor(Color.TRANSPARENT);
	        layoutCart.setBackgroundColor(Color.TRANSPARENT);
	        layoutWallet.setBackgroundColor(Color.TRANSPARENT);
	        layoutSetting.setBackgroundColor(Color.TRANSPARENT);
	        
	        LayoutParams layout = new LayoutParams(0, LayoutParams.MATCH_PARENT);
	        LayoutParams layoutMargin = new LayoutParams(0, LayoutParams.MATCH_PARENT);
	        layout.topMargin = 0;layout.weight=1;
	        layoutMargin.topMargin = 10;
	        layoutMargin.weight=1;
	        
	        if(target.getId() == R.id.linearHome || target.getId() == R.id.a){
	        	
	        	tabHost.setCurrentTab(0);
	            a.setSelected(true);
	            layoutHome.setLayoutParams(layout);
	            layoutHome.setBackgroundResource(R.drawable.icon_bar_left);
	            layoutCart.setLayoutParams(layoutMargin);
	            layoutWallet.setLayoutParams(layoutMargin);
	            layoutSetting.setLayoutParams(layoutMargin);
	            frame.setBackgroundResource(R.drawable.wallettabbar_home);
	         }
	        else if(target.getId() == R.id.linearSetting  || target.getId() == R.id.d){
	        	tabHost.setCurrentTab(1);
	            d.setSelected(true);
	            layoutSetting.setLayoutParams(layout);
	            layoutSetting.setBackgroundResource(R.drawable.icon_bar_right);
	            layoutHome.setLayoutParams(layoutMargin);
	            layoutCart.setLayoutParams(layoutMargin);
	            layoutWallet.setLayoutParams(layoutMargin);
	            frame.setBackgroundResource(R.drawable.wallettabbar_setting);
	        }
	        else if(target.getId() == R.id.linearWallet  || target.getId() == R.id.c){
	        	tabHost.setCurrentTab(2);
	            c.setSelected(true);
	            layoutWallet.setLayoutParams(layout);
	            layoutWallet.setBackgroundResource(R.drawable.icon_bar_center);
	            layoutHome.setLayoutParams(layoutMargin);
	            layoutSetting.setLayoutParams(layoutMargin);
	            layoutCart.setLayoutParams(layoutMargin);
	            frame.setBackgroundResource(R.drawable.wallettabbar_wallet);
	        }
	        
	        else if(target.getId() == R.id.linearCart || target.getId() == R.id.b){
	        	tabHost.setCurrentTab(3);
	            b.setSelected(true);
	            layoutCart.setLayoutParams(layout);
	            layoutCart.setBackgroundResource(R.drawable.icon_bar_center);
	            layoutHome.setLayoutParams(layoutMargin);
	            layoutWallet.setLayoutParams(layoutMargin);
	            layoutSetting.setLayoutParams(layoutMargin);
	            frame.setBackgroundResource(R.drawable.wallettabbar_cart);
	        }
	    } catch (Exception e) {
		    e.printStackTrace();
		}
	    finally
	    {
	    	a.setSelected(false);
	        b.setSelected(false);
	        c.setSelected(false);
	        d.setSelected(false);
	        //e.setSelected(false);
	        layoutHome.setBackgroundColor(Color.TRANSPARENT);
	        layoutCart.setBackgroundColor(Color.TRANSPARENT);
	        layoutWallet.setBackgroundColor(Color.TRANSPARENT);
	        layoutSetting.setBackgroundColor(Color.TRANSPARENT);
	        
	        LayoutParams layout = new LayoutParams(0, LayoutParams.MATCH_PARENT);
	        LayoutParams layoutMargin = new LayoutParams(0, LayoutParams.MATCH_PARENT);
	        layout.topMargin = 0;layout.weight=1;
	        layoutMargin.topMargin = 10;
	        layoutMargin.weight=1;
	        
	        if(target.getId() == R.id.linearHome || target.getId() == R.id.a){
	        	
	        	tabHost.setCurrentTab(0);
	            a.setSelected(true);
	            layoutHome.setLayoutParams(layout);
	            layoutHome.setBackgroundResource(R.drawable.icon_bar_left);
	            layoutCart.setLayoutParams(layoutMargin);
	            layoutWallet.setLayoutParams(layoutMargin);
	            layoutSetting.setLayoutParams(layoutMargin);
	            frame.setBackgroundResource(R.drawable.wallettabbar_home);
	         }
	        else if(target.getId() == R.id.linearSetting  || target.getId() == R.id.d){
	        	tabHost.setCurrentTab(1);
	            d.setSelected(true);
	            layoutSetting.setLayoutParams(layout);
	            layoutSetting.setBackgroundResource(R.drawable.icon_bar_right);
	            layoutHome.setLayoutParams(layoutMargin);
	            layoutCart.setLayoutParams(layoutMargin);
	            layoutWallet.setLayoutParams(layoutMargin);
	            frame.setBackgroundResource(R.drawable.wallettabbar_setting);
	        }
	        else if(target.getId() == R.id.linearWallet  || target.getId() == R.id.c){
	        	tabHost.setCurrentTab(2);
	            c.setSelected(true);
	            layoutWallet.setLayoutParams(layout);
	            layoutWallet.setBackgroundResource(R.drawable.icon_bar_center);
	            layoutHome.setLayoutParams(layoutMargin);
	            layoutSetting.setLayoutParams(layoutMargin);
	            layoutCart.setLayoutParams(layoutMargin);
	            frame.setBackgroundResource(R.drawable.wallettabbar_wallet);
	        }
	        
	        else if(target.getId() == R.id.linearCart || target.getId() == R.id.b){
	        	tabHost.setCurrentTab(3);
	            b.setSelected(true);
	            layoutCart.setLayoutParams(layout);
	            layoutCart.setBackgroundResource(R.drawable.icon_bar_center);
	            layoutHome.setLayoutParams(layoutMargin);
	            layoutWallet.setLayoutParams(layoutMargin);
	            layoutSetting.setLayoutParams(layoutMargin);
	            frame.setBackgroundResource(R.drawable.wallettabbar_cart);
	        }
	    	
	    }
    }
	public static void switchTab(int tab)
	{             
		tabHost.setCurrentTab(tab); 
		switch (tab)
		{
		case 0:
			tabHandler(layoutHome);
			break;
		case 1:
			tabHandler(layoutCart);
			break;
		case 2:
			tabHandler(layoutWallet);
			break;
		case 3:
			tabHandler(layoutSetting);
			break;
		}
	}
	public static void switchTab(int tabNew, boolean comeback, int tabComeBack)
	{   
		try {
			try {
				LoadTabGreen.comeback = comeback;
				tabComeback = tabComeBack;
				try {
					tabHost.setCurrentTab(tabNew);
				} catch (Exception e) {
					try {
						tabHost.setCurrentTab(tabNew);
					} catch (Exception e2) {
					}
					
				}
				switch (tabNew)
				{
					case 0:
						tabHandler(layoutHome);
						break;
					case 1:
						tabHandler(layoutCart);
						break;
					case 2:
						tabHandler(layoutWallet);
						break;
					case 3:
						tabHandler(layoutSetting);
						break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (OutOfMemoryError e) {
			e.printStackTrace();
		}
		
	}
	public static int getCurrentTab()
	{
		return tabHost.getCurrentTab();
	}
	public static int getHeighTab()
	{
		return tabLayout.getHeight();
	}
	public void disableBadge(){
		if(badge!= null)
			badge.hide();
	}
	public void enableBadge(){
		if(badge!= null)
			badge.show();
	}
	public void setBadge(int num){
		badge.toggle(true);
		badge.show();
		badge.setText(String.valueOf(num));
	}
	BadgeView badge;
	@Override
	public void onResume()
	{
		Log.e("resume app", "resume app");
		super.onResume();
		checkCacheResume();
	}
	private void checkCacheResume()
	{
		try
		{
			File cache = getCacheDir();
	        long size = getDirSize(cache);
	        Log.e("size cache", size+"");
	        if(size <= 0 && ApplicationConfig.IS_CLEAR_CACHE)
	        {
	        	ApplicationConfig.IS_CLEAR_CACHE = false;
	        	ApplicationConfig.IS_FIRST_LOAD = true;
	        	Log.e("restart app again", "restart app again");
	        	Intent i = getApplicationContext().getPackageManager()
	        			 .getLaunchIntentForPackage(getApplicationContext().getPackageName() );

	        			 i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK );
	        			 startActivity(i);
	        }
	        else if(size > 0)
	        	ApplicationConfig.IS_CLEAR_CACHE = true;
	        System.gc();
		    Runtime.getRuntime().gc();  
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	protected void onStop() {
		Log.e("onStop app", "onStop app");
	    super.onStop();
	}
	@Override
	protected void onRestart() {
		Log.e("onRestart app", "onRestart app");
	    super.onRestart();  // Always call the superclass method first
	}
	@Override
	public void onDestroy()
	{
		Log.e("onDestroy app", "onDestroy app");
		super.onDestroy();
	}
	private long getDirSize(File dir) 
	{
        long size = 0;
        try
        {
	        File[] files = dir.listFiles();
	
	        for (File file : files) {
	            if (file.isFile()) {
	                size += file.length();
	            }
	        }
        }
        catch (Exception e) {
        	e.printStackTrace();
		}
        return size;
    }
	@Override
	public void onPause()
	{
		Log.e("pause app", "pause app");
		super.onPause();
		System.gc();
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) 
	{
		super.onKeyDown(keyCode, event);
    	if (keyCode == KeyEvent.KEYCODE_BACK 
    			|| keyCode == KeyEvent.KEYCODE_HOME
    			|| event.getKeyCode() == KeyEvent.KEYCODE_BACK
    			|| event.getKeyCode() == KeyEvent.KEYCODE_HOME) 
    	{
    		Log.e("nhan phim home | back", "tat app");
    		finish();
    	}
    	return false;
    }
}