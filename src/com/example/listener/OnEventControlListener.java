/**
 * Copyright 2014 Viettel Telecome. All rights reserved.
 * VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.listener;

import android.view.View;

/**
 *  tao inteface lang nghe va xu ly su kien (interface)
 *  @author: truonglt2
 *  @version: 1.0
 *  @since: 1.0
 */
public interface OnEventControlListener {
	void onEvent( int eventType, View control, Object data);
}
