package com.example.views.discovery;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.RelativeLayout;

import com.example.ishoopingcaffe.R;
import com.example.listener.OnEventControlListener;

public class ViewAddReview extends Dialog implements OnClickListener
{
	Context mContext;
	RelativeLayout layoutMainView;
	public Button buttonBackAddReviewSpa;
	public Button buttonDoneAddReviewSpa;
	public EditText edittextContentAddReview;
	public RatingBar ratingAddReviewOverall;
	public float overall;
	OnEventControlListener mListener;
	//contructor for add
	public ViewAddReview(Context context,OnEventControlListener listener) {
		super(context);
		this.mContext = context;
		this.mListener = listener;
		
	}
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.layout_add_comment_review);
        getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);		
		
		layoutMainView  		= (RelativeLayout) findViewById(R.id.layoutMainView);
		//for add review for spa
    	buttonBackAddReviewSpa = (Button)findViewById(R.id.btnAddReviewBack);
    	buttonDoneAddReviewSpa = (Button)findViewById(R.id.btnAddReviewDone);
    	edittextContentAddReview = (EditText)findViewById(R.id.edit_contentAddReviews);
    	ratingAddReviewOverall = (RatingBar)findViewById(R.id.ratingOverralAddReview);
    	
    	buttonBackAddReviewSpa.setOnClickListener(this);
    	
	}

	@Override
	public void onClick(View v) {
		if(v == buttonBackAddReviewSpa)
			dismiss();
	}
	public void actionForAddReview()
	{
		ratingAddReviewOverall.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
			@Override
			public void onRatingChanged(RatingBar ratingBar, float rating,
					boolean fromUser) {
				overall = rating;
			}
		});
	}
}
