
package com.example.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dto.MenuContent;
import com.example.ishoopingcaffe.R;


/** 
  * @Description: adapter menu
  * @author:truonglt2
  * @since:Feb 7, 2014 3:51:10 PM
  * @version: 1.0
  * @since: 1.0
  * 
  */
public class MenuListAdapter extends BaseAdapter {

	ArrayList<MenuContent> arr = new ArrayList<MenuContent>();
	LayoutInflater inflater = null;

	/**
	 * @param context
	 */
	public MenuListAdapter(Context context) {
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
	public MenuContent get(int pos) {
		return arr.get(pos);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		MoredealsViewHolder viewHolder;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.item_list_menu, null);
			viewHolder = new MoredealsViewHolder();
			viewHolder.imageCatagory = (ImageView) convertView
					.findViewById(R.id.img_item);
			viewHolder.nameCatagory = (TextView) convertView
					.findViewById(R.id.txt_Title);
			viewHolder.priceCatagory = (TextView) convertView
					.findViewById(R.id.txt_price);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (MoredealsViewHolder) convertView.getTag();
		}
		viewHolder.nameCatagory.setText(arr.get(position).getTitle());
		viewHolder.priceCatagory.setText(arr.get(position).getPrice());
//		viewHolder.imageCatagory.setImageResource(R.drawable.icon_config_language);
		switch (position) {
		case 0:
			viewHolder.imageCatagory.setImageResource(R.drawable.cafekem);
			break;
		case 1:
			viewHolder.imageCatagory.setImageResource(R.drawable.capuchino);
			break;
		case 2:
			viewHolder.imageCatagory.setImageResource(R.drawable.tradaxay);
			break;
		case 3:
			viewHolder.imageCatagory.setImageResource(R.drawable.chocolate_daxay);
			break;
		case 4:
			viewHolder.imageCatagory.setImageResource(R.drawable.soda_y);
			break;
		case 5:
			viewHolder.imageCatagory.setImageResource(R.drawable.soda_y_vidau);
			break;
		default:
			break;
		}
		return convertView;
	}


	/**
	*  them item vao vi tri
	*  @author: truonglt2
	*  @param item
	*  @return: void
	*  @throws: 
	*/
	public void addItem(MenuContent item) {
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
		return (MenuContent) arr.get(position);
	}

	/** 
	  * @author:truonglt2
	  * @since:Feb 7, 2014 3:12:00 PM
	  * @Description: lop temp
	  */
	class MoredealsViewHolder {
		public TextView nameCatagory;
		public TextView priceCatagory;
		public ImageView imageCatagory;
	}
}