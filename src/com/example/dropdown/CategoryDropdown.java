package com.example.dropdown;

import android.content.Context;

import com.example.dto.Catagory;

public class CategoryDropdown extends DropdownItem {
	Catagory catagory;
	public CategoryDropdown(Context context,Catagory item) {
		super(context);
		this.catagory = item;
		name.setText(item.title);
		
	}
	public String getIdCatagory(){
		return catagory.id;
	}
	public String getName(){
		return name.getText().toString();
	}
	
	

}
