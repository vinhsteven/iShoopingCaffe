package com.example.views.discovery;

import java.util.ArrayList;
import java.util.Date;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.adapter.CommentAdapter;
import com.example.dropdown.DropDownPopover;
import com.example.dto.Comment;
import com.example.ishoopingcaffe.R;
import com.example.listener.ActionEventConstantDiscovery;
import com.example.listener.OnEventControlListener;

public class DialogDetailCommentProducts extends LinearLayout implements OnClickListener,OnEventControlListener {
	TextView txtTitle;
	Button btnBack,btnBecomeFirst,btnAddMore;
	ListView listviewComment;
	CommentAdapter adapter;
	OnEventControlListener mListener;
	Context mContext;
	DropDownPopover mPopOver;
	public DialogDetailCommentProducts(Context context, OnEventControlListener listenner) {
		super(context);
		mContext = context;
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.view_details_comment_product, this,true);
		mListener = listenner;
		btnBack = (Button)findViewById(R.id.btnBack);
		btnBack.setOnClickListener(this);
		btnBecomeFirst = (Button)findViewById(R.id.btnBecomeFirst);
		btnBecomeFirst.setOnClickListener(this);
		btnAddMore = (Button)findViewById(R.id.btnAddMore);
		btnAddMore.setOnClickListener(this);
		listviewComment = (ListView)findViewById(R.id.listviewComment);
		txtTitle =(TextView)findViewById(R.id.txtTitle);
		
//		adapter.notifyDataSetChanged();
//		ArrayList<Comment> arrComment = new ArrayList<Comment>();
//		for (int i = 0; i < 6; i++) {
//			Comment content = new Comment();
//			content.setId("" + i);
//			content.setTitle("Thức uống " + i);
//			arrComment.add(content);
//		}
//		adapter = new CommentListArrayAdapter(mContext,R.layout.item_list_comment, arrComment);
//		listviewComment.setAdapter(adapter);
		
		ArrayList<Comment> arrComment = new ArrayList<Comment>();
		for (int i = 0; i < 7; i++) {
			Comment comment = new Comment();
			comment.setId(""+i);
			comment.setUserName("User "+ i);
			Date date = new Date();
//			date.toLocaleString();
			comment.setDatetimeComment(""+date.toLocaleString());
			comment.setContenComment("Noi dung comment cua user Noi dung comment cua user Noi dung comment cua user");
			comment.setTimeDuration(i+"");
			comment.setCountFeedback(""+i);
			arrComment.add(comment);
		}
		CommentAdapter adapter = new CommentAdapter(mContext, R.layout.item_comment, arrComment);
				
		listviewComment.setAdapter(adapter);
		adapter.notifyDataSetChanged();
		
		listviewComment.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
//				Intent intent = new Intent(DiscoveryActivity.this,
//						DetailProductsActivity.class);
//				startActivity(intent);
				mListener.onEvent(ActionEventConstantDiscovery.ACTION_CHANGE_VIEW_DETAILS, null, null);
			}
		});
	}
	public void setTitle(String textTitle)
	{
		txtTitle.setText(textTitle);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v == btnBack)
		{
			mListener.onEvent(ActionEventConstantDiscovery.ACTION_CHANGE_VIEW_DETAILS, null, null);
		}
		else if(v==btnAddMore)
		{
//			mListener.onEvent(ActionEventConstantDiscovery.ACTION_CHANGE_VIEW_DETAILS_ADD_COMMENT_PPRODUCT, null, null);
			ViewAddReview viewAddReview = new ViewAddReview(mContext, this);
			WindowManager.LayoutParams params = viewAddReview.getWindow().getAttributes();
			params.gravity = Gravity.TOP;
			viewAddReview.getWindow().setAttributes(params);
			viewAddReview.show();
		}
		else if(v==btnBecomeFirst)
		{
			mListener.onEvent(ActionEventConstantDiscovery.ACTION_CHANGE_VIEW_DETAILS_ADD_COMMENT_PPRODUCT, null, null);
		}
	}
	@Override
	public void onEvent(int eventType, View control, Object data) {
		// TODO Auto-generated method stub
		
	}
	
}
