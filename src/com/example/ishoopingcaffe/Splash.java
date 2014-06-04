package com.example.ishoopingcaffe;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.AppcConfig.ApplicationConfig;

public class Splash extends Activity implements OnClickListener {

	private static int SPLASH_TIME = 1000;
	int mTimerStep = 300;
	int timer = 1;

	private static final long MINIMUM_DISTANCE_CHANGE_FOR_UPDATES = 0; // in
																		// Meters
	private static final long MINIMUM_TIME_BETWEEN_UPDATES = 1000; // in
																	// Milliseconds

	Double latitude = 1000.0, longitude = 1.0;
	String vtag = "Valueble QGS Booking:";
	String btag = "Valueble QGS Booking:";
	ImageView splashView;
	LocationManager lm;
	boolean isLoadServerInforFinished = false;
	String versionFromeClient = "", versionFromeMarket = "";
	// if state == 0 : use pin code at first screen
	// if state == 1 : don't use pin code
	int state = 0;
	String keyLocale = "en";

	@Override
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);

		setContentView(R.layout.splash);
		splashView = (ImageView) findViewById(R.id.bgImage_screenFirst);
		try {
			int width = ((WindowManager) getSystemService(Context.WINDOW_SERVICE))
					.getDefaultDisplay().getWidth();
			ApplicationConfig.screenWidth = width;
			ApplicationConfig.screenHeight = ((WindowManager) getSystemService(Context.WINDOW_SERVICE))
					.getDefaultDisplay().getHeight();
			Log.e("ApplicationConfig.screenWidth",
					ApplicationConfig.screenWidth + "");
			Log.e("ApplicationConfig.screenHeight",
					ApplicationConfig.screenHeight + "");
			switch (width) {
			case 240:
				splashView.setImageResource(R.drawable.bg_first240x320);
				break;
			case 320:
				splashView.setImageResource(R.drawable.bg_first320x480);
				break;
			case 480:
				splashView.setImageResource(R.drawable.bg_first480x800);
				break;
			default:
				splashView.setImageResource(R.drawable.bg_first320x480);
			}
			if (width > 480)
				splashView.setImageResource(R.drawable.bg_first480x800);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// configServices = new QGSConfigServices();
		splashView.setOnClickListener(this);
		// start splash screen
		startSplash();
	}

	boolean isFirstTime = true;

	@Override
	public void onResume() {
		super.onResume();
	}

	@Override
	public void onClick(View v) {
		if (v == splashView) {
			timer += SPLASH_TIME;
		}
	}

	public void startSplash() {
		// select background base on screen size
		Thread splashThread = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(300);
						timer += mTimerStep;
						if ((timer > SPLASH_TIME )
								|| (timer > 30 * SPLASH_TIME)) {
							break;
						}
					} catch (Exception ex) {
						ex.printStackTrace();
						break;
					}
				}
				try {
//					String sta = readfile("passcode.txt", "0");
//					state = Integer.parseInt(sta);
					Intent main;
					main = new Intent(Splash.this, LoadTabGreen.class);

					Splash.this.startActivity(main);
				} catch (Exception e) {
					e.printStackTrace();
				}
				Splash.this.finish();
			}
		});
		splashThread.start();
	}


}
