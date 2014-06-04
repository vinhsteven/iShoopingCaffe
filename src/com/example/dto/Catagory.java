
package com.example.dto;

import java.io.Serializable;

/** 
  * @Description: lop menu content
  * @author:truonglt2
  * @since:Feb 7, 2014 4:13:46 PM
  * @version: 1.0
  * @since: 1.0
  * 
  */
@SuppressWarnings("serial")
public class Catagory implements Serializable{

	public String id;
	public String title;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
