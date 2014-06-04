
package com.example.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dto.Catagory;
import com.example.ishoopingcaffe.R;


/** 
  * @Description: adapter menu
  * @author:truonglt2
  * @since:Feb 7, 2014 3:51:10 PM
  * @version: 1.0
  * @since: 1.0
  * 
  */
public class CatagoryListBaseAdapter extends BaseAdapter {

	ArrayList<Catagory> arr = new ArrayList<Catagory>();
	LayoutInflater inflater = null;

	/**
	 * @param context
	 */
	public CatagoryListBaseAdapter(Context context) {
		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	/**
	*  lay vi tri menuContent
	*  @author: truonglt2
	*  @param pos
	*  @return
	*  @return: MenuContent
	*  @throws: 
	*/
	public Catagory get(int pos) {
		return arr.get(pos);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		CatagoryViewHolder viewHolder;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.item_list_catagory, null);
			viewHolder = new CatagoryViewHolder();
			viewHolder.titleCatagory = (TextView) convertView
					.findViewById(R.id.txt_Title);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (CatagoryViewHolder) convertView.getTag();
		}
		viewHolder.titleCatagory.setText(arr.get(position).getTitle());
		
		return convertView;
	}


	/**
	*  them item vao vi tri
	*  @author: truonglt2
	*  @param item
	*  @return: void
	*  @throws: 
	*/
	public void addItem(Catagory item) {
		arr.add(item);
	}

	public void clearAll() {
		arr.clear();
		notifyDataSetChanged();
	}

	public int getCount() {
		return arr.size();
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public Object getItem(int position) {
		return (Catagory) arr.get(position);
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