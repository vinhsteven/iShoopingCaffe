/*
 * Copyright 2006 Viettel Telecom. All rights reserved.
 * VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.example.dto;

import java.io.Serializable;

/**
 *  class acttribute product game
 *  @author: truonglt2
 *  @version: 1.0
 *  @since: Mar 10, 2014
 */
@SuppressWarnings("serial")
public class Comment implements Serializable {
	private String id;
	private String userName;
	private String datetimeComment;
	private String contenComment;
	private String timeDuration;
	private String countFeedback;
	public String getTimeDuration() {
		return timeDuration;
	}

	public void setTimeDuration(String timeDuration) {
		this.timeDuration = timeDuration;
	}

	public String getCountFeedback() {
		return countFeedback;
	}

	public void setCountFeedback(String countFeedback) {
		this.countFeedback = countFeedback;
	}

	/**
	*  Mo ta chuc nang cua Constructor
	*  @author: truonglt2
	*  @Since: Mar 10, 2014
	*  @throws: 
	*/
	public Comment() {
		super();
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the datetimeComment
	 */
	public String getDatetimeComment() {
		return datetimeComment;
	}

	/**
	 * @param datetimeComment the datetimeComment to set
	 */
	public void setDatetimeComment(String datetimeComment) {
		this.datetimeComment = datetimeComment;
	}

	/**
	 * @return the contenComment
	 */
	public String getContenComment() {
		return contenComment;
	}

	/**
	 * @param contenComment the contenComment to set
	 */
	public void setContenComment(String contenComment) {
		this.contenComment = contenComment;
	}


}
