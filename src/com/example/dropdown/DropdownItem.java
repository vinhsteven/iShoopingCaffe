package com.example.dropdown;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ishoopingcaffe.R;

public class DropdownItem extends LinearLayout {
	protected TextView name;
	public DropdownItem(Context context) {
		super(context);
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.item, this, true);
		name = (TextView) findViewById(R.id.name);
	}

}
