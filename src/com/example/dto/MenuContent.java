/**
 * Copyright 2014 Viettel Telecom. All rights reserved.
 * VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
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
public class MenuContent implements Serializable{

	private String idMenu;
	private String title;
	private String price;
	private String content;
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	/**
	 * @return the idMenu
	 */
	public String getIdMenu() {
		return idMenu;
	}
	/**
	 * @param idMenu the idMenu to set
	 */
	public void setIdMenu(String idMenu) {
		this.idMenu = idMenu;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
}
