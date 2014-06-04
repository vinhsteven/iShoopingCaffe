package com.example.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.adapter.CatagoryListBaseAdapter.CatagoryViewHolder;
import com.example.dto.Catagory;
import com.example.ishoopingcaffe.R;
import com.example.listener.OnEventControlListener;

public class CatagoryListArrayAdapter extends
ArrayAdapter<Catagory> {
	Context mContext;
	int resourceLayoutId;
	OnEventControlListener listener;
	public CatagoryListArrayAdapter(Context context, int resourceLayoutId,
			ArrayList<Catagory> checkinCustomerarray
			) {

		super(context, resourceLayoutId,
				checkinCustomerarray);
		mContext = context;
		this.resourceLayoutId = resourceLayoutId;
//		this.listener = listener;

	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		View row = convertView;
		CatagoryViewHolder viewHolder;
	     
		if (row == null) {
			LayoutInflater inflater = (LayoutInflater) mContext
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			
			convertView = inflater.inflate(resourceLayoutId, null);
			viewHolder = new CatagoryViewHolder();
			viewHolder.titleCatagory = (TextView) convertView
					.findViewById(R.id.txt_Title);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (CatagoryViewHolder) row.getTag();
		}
		viewHolder.titleCatagory.setText(getItem(position).title);
		
		return row;

	}
	/** 
	  * @author:truonglt2
	  * @since:Feb 7, 2014 3:12:00 PM
	  * @Description: lop temp
	  */
	class CatagoryViewHolder {
		public TextView titleCatagory;
	}
}
