package com.example.ishoopingcaffe;

import com.example.listener.OnEventControlListener;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

public class ManagermentActivity extends BaseActivity implements OnEventControlListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_managerment);


	}

	@Override
	public void onEvent(int eventType, View control, Object data) {
		// TODO Auto-generated method stub
		
	}

	

}
