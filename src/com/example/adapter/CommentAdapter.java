

package com.example.adapter;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dto.Comment;
import com.example.ishoopingcaffe.R;

/**
 * Category adapter
 * 
 * @author: nhantd
 * @version: 1.0
 * @since: Feb 28, 2014
 */

public class CommentAdapter extends ArrayAdapter<Comment> {

	public Context context;
	public int resourceId;
	public ArrayList<Comment> arrComment = null;

	/**
	 * 
	 * Constructor
	 * 
	 * @author: nhantd
	 * @Since: Feb 28, 2014
	 * @throws:
	 */
	public CommentAdapter(Context context, int resource,
			ArrayList<Comment> objects) {
		super(context, resource, objects);
		this.context = context;
		this.resourceId = resource;
		this.arrComment = objects;
	}

	/**
	 * noi dung sua
	 * 
	 * @author:nhantd
	 * @since:Feb 28, 2014
	 */
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return arrComment.size();
	}
	

	/**
	 * noi dung sua
	 * 
	 * @author:nhantd
	 * @since:Feb 28, 2014
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		CommentHolder categoryHolder = null;
		if (row == null) {
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
			row = inflater.inflate(resourceId, parent, false);
			categoryHolder = new CommentHolder();
			
			categoryHolder.imvUser = (ImageView) row
					.findViewById(R.id.imv_User);
			categoryHolder.txtUserName = (TextView) row
					.findViewById(R.id.txtUserName);
			categoryHolder.txtDateTime = (TextView) row
					.findViewById(R.id.txtDateTime);
			categoryHolder.txtContentComment = (TextView) row
					.findViewById(R.id.txtContentComment);
			categoryHolder.txtTimeComment = (TextView) row
					.findViewById(R.id.txtTimeComment);
			
			row.setTag(categoryHolder);
		} else {
			categoryHolder = (CommentHolder) row.getTag();
		}

		// set information for item
		Comment comment = arrComment.get(position);
		categoryHolder.txtUserName.setText(comment.getUserName());
		categoryHolder.txtDateTime.setText(comment.getDatetimeComment());
		categoryHolder.txtContentComment.setText(comment.getContenComment());
		categoryHolder.txtTimeComment.setText("Cách đây "+comment.getTimeDuration()+" ngày. "+comment.getCountFeedback()+" phản hồi.");
		
//		categoryHolder.imv_category.setImageResource(context
//				.getResources().getIdentifier(category.getIconName(),
//						"drawable", context.getPackageName()));
		
		return row;
	}

	/**
	 * class define widgets of view in listview comment
	 *  @author: truonglt2
	 *  @version: 1.0
	 *  @since: Mar 14, 2014
	 */
	private class CommentHolder {
		ImageView imvUser;
		TextView txtUserName;
		TextView txtDateTime;
		TextView txtContentComment,txtTimeComment;
	}
}
