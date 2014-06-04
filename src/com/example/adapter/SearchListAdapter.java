package com.example.adapter;

import java.util.ArrayList;

import webdev.dto.DiaDiemDTO;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import dev.danang.R;


/** 
  * @author:truonglt2
  * @since:Jan 21, 2014 4:05:44 PM
  * @Description: 
  */
public class SearchListAdapter extends BaseAdapter {

	ArrayList<DiaDiemDTO> arr = new ArrayList<DiaDiemDTO>();
	LayoutInflater inflater = null;

	/**
	 * @param context
	 */
	public SearchListAdapter(Context context) {
		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public DiaDiemDTO get(int pos) {
		return arr.get(pos);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		MoredealsViewHolder viewHolder;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.item_list_search, null);
			viewHolder = new MoredealsViewHolder();
			viewHolder.imagePlaces = (ImageView) convertView
					.findViewById(R.id.image_item);
			viewHolder.namePlaces = (TextView) convertView
					.findViewById(R.id.tvt_name);
			viewHolder.addressPlaces = (TextView) convertView
					.findViewById(R.id.tvt_address);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (MoredealsViewHolder) convertView.getTag();
		}

		viewHolder.namePlaces.setText(arr.get(position).getTitle());
		viewHolder.addressPlaces.setText(arr.get(position).getAddress());
		
		return convertView;
	}

	public void setSelectedPosition(int pos) {
		notifyDataSetChanged();
	}

	public void addItem(DiaDiemDTO item) {
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
		return (DiaDiemDTO) arr.get(position);
	}

	class MoredealsViewHolder {
		public TextView namePlaces;
		public ImageView imagePlaces;
		public TextView addressPlaces;
	}
}