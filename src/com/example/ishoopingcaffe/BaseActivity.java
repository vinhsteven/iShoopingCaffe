package com.example.ishoopingcaffe;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

public class BaseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,   
	            WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_main);
        
    }
	
	@Override
	protected void onDestroy() {
		System.gc();
		System.runFinalization();
		super.onDestroy();
	}

	@Override
	public void finish() {
		super.finish();
	}

	@Override
	public void finishActivity(int requestCode) {
		super.finishActivity(requestCode);
	}
    @Override
    protected void onPause() {
    	super.onPause();
    }
    @Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case android.R.id.home:
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // getSupportMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
	/*@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK)
		{
             onBackPressed();
         }
		return super.onKeyDown(keyCode, event);
	}*/
	public void onBackPressed() {
        Log.d("CDA", "onBackPressed Called");
        super.onBackPressed();
    }



}
