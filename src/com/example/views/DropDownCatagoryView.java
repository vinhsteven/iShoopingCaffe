package com.example.views;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.adapter.CommentAdapter;
import com.example.dto.Catagory;
import com.example.dto.Comment;
import com.example.ishoopingcaffe.R;

public class DropDownCatagoryView extends LinearLayout
{
	Context mContext;
	public ListView lisCatagory;
	
	
	public DropDownCatagoryView(Context context) {
		super(context);
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.layout_list_catagory, this, true);
		
		mContext = context;
		
		lisCatagory 	 = (ListView)findViewById(R.id.listCatagory);
		ArrayList<Comment> arr = new ArrayList<Comment>();
		for (int i = 0; i < 10; i++) {
			Comment catagory = new Comment();
			catagory.setId(""+1);
			catagory.setUserName("abc");
			arr.add(catagory);
		}
		CommentAdapter adapter = new CommentAdapter(mContext, R.layout.item_comment, arr);
		lisCatagory.setAdapter(adapter);
		lisCatagory.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) 
			{
				System.out.println("Qua day hehe");
			}
		});
	}
	
	
}
