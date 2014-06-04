package com.example.views.discovery;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ishoopingcaffe.R;
import com.example.listener.ActionEventConstantDiscovery;
import com.example.listener.OnEventControlListener;
import com.example.views.cart.ShoppingCartItem;

public class ViewDetailProducts extends LinearLayout implements OnClickListener{
	Button btnBack, btnAddCart;
	
	TextView textDescription,txtReadMore,txtComment;
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.layout_details_discovery);
	OnEventControlListener mListener;
	Context mContext;
	
	String popUpContents[];
    PopupWindow popupWindowDogs;
    int widthbtn;
    
	public ViewDetailProducts(Context context, OnEventControlListener listenner) {
		super(context);
		mContext = context;
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.view_details_product_discovery, this,true);
		mListener = listenner;
		btnBack = (Button)findViewById(R.id.btnBack);
		btnAddCart = (Button)findViewById(R.id.btnAddCart);
		btnAddCart.setOnClickListener(this);
//		textDescription =(TextView)findViewById(R.id.textDescription);
//		textDescription.setOnClickListener(this);
		
		txtReadMore =(TextView)findViewById(R.id.txtReadMore);
		txtReadMore.setOnClickListener(this);
		txtComment =(TextView)findViewById(R.id.txtComment);
		txtComment.setOnClickListener(this);
		
		btnBack.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mListener.onEvent(ActionEventConstantDiscovery.ACTION_CHANGE_VIEW_MAIN_DISCOVERY, null, null);
			}
		});
		
//		ArrayList<View> arr = new ArrayList<View>();
//		for (int i = 0; i < 10; i++) {
//			Catagory catagory = new Catagory();
//			catagory.id = ""+1;
//			catagory.title =""+(i+1);
//			CategoryDropdown item = new CategoryDropdown(this,catagory);
//			arr.add(item);
//		}
//		mPopOver = new DropDownPopover(this, arr, this, true);
		// initialize pop up window items list
        
        // add items on the array dynamically
        // format is DogName::DogID
        List<String> dogsList = new ArrayList<String>();
        for (int i = 1; i < 10; i++) {
        	dogsList.add(""+i);
		} 
        // convert to simple array
        popUpContents = new String[dogsList.size()];
        dogsList.toArray(popUpContents);
 
        ViewTreeObserver vto = btnAddCart.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {

              int widthbtn = btnAddCart.getWidth();
              int height = btnAddCart.getHeight(); 

              System.out.println("ket qua:"+widthbtn +"/" +height);
            }
        });
     // initialize pop up window
        popupWindowDogs = popupWindowDogs();
		
	}
	public PopupWindow popupWindowDogs() {
		 
        // initialize a pop up window type
        PopupWindow popupWindow = new PopupWindow(mContext);
 
        // the drop down list is a list view
        ListView listViewDogs = new ListView(mContext);
         
        // set our adapter and pass our pop up window contents
        listViewDogs.setAdapter(dogsAdapter(popUpContents));
         
        // set the item click listener
        listViewDogs.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				// add some animation when a list item was clicked
		        Animation fadeInAnimation = AnimationUtils.loadAnimation(mContext, android.R.anim.fade_in);
		        fadeInAnimation.setDuration(10);
		        view.startAnimation(fadeInAnimation);
		         
		        // dismiss the pop up
		        popupWindowDogs.dismiss();
		         
		         
		        // get the id
		        String selectedItemTag = ((TextView) view).getTag().toString();
		        Toast.makeText(mContext, "ID is: " + selectedItemTag, Toast.LENGTH_SHORT).show();
		        
		        ShoppingCartItem item = new ShoppingCartItem(randomString(),"Caffe Càfuchno", "20000.0","đ",1);
		        mListener.onEvent(ActionEventConstantDiscovery.ACTION_CHANGE_VIEW_DETAILS_ADD_SHOPPING_CART, null, item);
			}
		});
 
        // some other visual settings
        popupWindow.setFocusable(true);
       
        popupWindow.setWidth(300);
//        popupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        popupWindow.setHeight(250);
        // set the list view as pop up window content
        popupWindow.setContentView(listViewDogs);
 
        return popupWindow;
    }
	private String randomString()
	{
		Random random = new Random();
		int randomNumber = random.nextInt(10 - 1) + 1;
		return randomNumber+"";
	}
    /*
     * adapter where the list values will be set
     */
    private ArrayAdapter<String> dogsAdapter(String dogsArray[]) {
 
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, dogsArray) {
 
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
 
                // setting the ID and text for every items in the list
                String item = getItem(position);
//                String[] itemArr = item.split("::");
//                String text = itemArr[0];
//                String id = itemArr[1];
 
                // visual settings for the list item
                TextView listItem = new TextView(mContext);
 
                listItem.setText(item);
                listItem.setTag(position);
                listItem.setTextSize(18);
                listItem.setPadding(10, 10, 10, 10);
                listItem.setTextColor(Color.WHITE);
                 
                return listItem;
            }
        };
         
        return adapter;
    }
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v == btnAddCart)
		{
			
			// show the list view as dropdown
//            popupWindowDogs.showAsDropDown(v, -5, 0);
			 popupWindowDogs.showAsDropDown(v);
		}
//		else if(v==textDescription)
//		{
//			mListener.onEvent(ActionEventConstantDiscovery.ACTION_CHANGE_VIEW_DETAILS_DESCRIPTION_PPRODUCT, null, null);
//		}
		else if(v==txtReadMore)
		{
			mListener.onEvent(ActionEventConstantDiscovery.ACTION_CHANGE_VIEW_DETAILS_READMORE_PPRODUCT, null, null);
		}
		else if(v==txtComment)
		{
			mListener.onEvent(ActionEventConstantDiscovery.ACTION_CHANGE_VIEW_DETAILS_COMMENT_PPRODUCT, null, null);
		}
	}

	 
}
