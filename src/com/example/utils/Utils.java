package com.example.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import com.example.AppcConfig.Common;
import com.example.ishoopingcaffe.R;

public class Utils {
	
	private static Bitmap bmpCache;
	public static Bitmap getImgCache(){
		return bmpCache;
	}
	public void fillImageToView(String imgUrl, ImageView view, boolean isNeedToCache){		
		new AsyncGetImage(view, isNeedToCache).execute(imgUrl);		
	}
	private class AsyncGetImage extends AsyncTask<String, Void, Bitmap>{
		ImageView img;		
		boolean isOut = false;
		
		public AsyncGetImage(ImageView img, boolean isNeedToCache){
			this.img = img;
			this.isOut = isNeedToCache;
		}	
		@Override
		protected Bitmap doInBackground(String... params) {		
			String url = params[0];
			if(!url.contains("http"))
				url = Common.serverName + params[0];
			return downloadFile(url);						
		}
		@Override
		public void onPostExecute(Bitmap ret){
			if(ret != null){
				Log.e("lay dc", "jkahdajkd");
				img.setImageBitmap(ret);
				if(isOut){
					bmpCache = ret;
				}
			}
		}
	}
	public static Bitmap downloadFile(String fileUrl){
		Bitmap bmImg = null;
		URL myFileUrl =null;
		try {
		myFileUrl= new URL(fileUrl);
		} catch (MalformedURLException e) {
		e.printStackTrace();
		}
		try {
			HttpURLConnection conn= (HttpURLConnection)myFileUrl.openConnection();
			conn.setDoInput(true);
			conn.connect();
			InputStream is = conn.getInputStream();	
			bmImg = BitmapFactory.decodeStream(is);
			
		} catch (IOException e) {
		
			e.printStackTrace();
		}		
		return bmImg;
	}
	public static String get12HString(String _24hString){
		// get string
		if(_24hString.equals("0FF"))
			return "OFF";
		if(_24hString.contains("OFF") || _24hString.contains("off"))
			return "OFF";
		
		String time = "";
		try{
			String[] arrTime = _24hString.split(":");
			String strMidDay = "AM";
			int hour = Integer.parseInt(arrTime[0]);
			if(hour >= 12){
				strMidDay = "PM";
				if(hour > 12)
					hour -= 12;				
			}
			time = hour < 10 ? ("0" + hour) : ("" + hour); 
			time+= ":" + arrTime[1] +" " + strMidDay;
		}
		catch(Exception ex){
			ex.printStackTrace();
			time = "error";
		}
		return time;
	}
	public static String get24HString(String _12hString){
		String time = "";
		// get string
		if(_12hString.equals("0FF"))
				return "OFF";
		if(_12hString.length() < 6)
			return "OFF";
		
		String shour = _12hString.substring(0, 2);
		String smin = _12hString.substring(3,5);
		
		// get integer to calculate
		int hour = Integer.parseInt(shour);
		int min = Integer.parseInt(smin);
		
		try{
			boolean isWrongFormat = true;
			if(_12hString.contains("AM")){				
				isWrongFormat = false;
			}
			else if( _12hString.contains("PM")){
				if(hour != 12)
					hour+= 12;
				isWrongFormat = false;
				
			}
			
			// check if string not contain AM or PM
			if(isWrongFormat){
				time = "error";
				return time;
			}
			
			shour = hour < 10 ? "0" + hour : "" + hour;
			smin = min < 10 ? "0" + min : "" + min;
			time = shour+":"+smin;
		}
		catch(Exception ex){
			ex.printStackTrace();
			time = "error";
		}
		return time;
	}

	// srcPlace & destPlace must be format :    		latitude + "," + longitude;
	public static String[] getDirectionData(String srcPlace, String destPlace) {

        String urlString = "http://maps.google.com/maps?f=d&hl=en&sa" +
        		"ddr="
                + srcPlace + "&daddr=" + destPlace
                + "&ie=UTF8&0&om=0&output=kml";
        Log.e("srcPlace", srcPlace);
        Log.e("destPlace", destPlace);
        Log.e("URL", urlString);
        
        Document doc = null;
        HttpURLConnection urlConnection = null;
        URL url = null;
        String pathConent = "";
        try {

            url = new URL(urlString.toString());
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setDoOutput(true);
            urlConnection.setDoInput(true);
            urlConnection.connect();
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(urlConnection.getInputStream());

        } catch (Exception e) {
        	return null;
        }

        if(doc!=null)
        {
	        NodeList nl = doc.getElementsByTagName("LineString");
	        for (int s = 0; s < nl.getLength(); s++) {
	            Node rootNode = nl.item(s);
	            NodeList configItems = rootNode.getChildNodes();
	            for (int x = 0; x < configItems.getLength(); x++) {
	                Node lineStringNode = configItems.item(x);
	                NodeList path = lineStringNode.getChildNodes();
	                pathConent = path.item(0).getNodeValue();
	            }
	        }
	        String[] tempContent = pathConent.split(" ");
	        return tempContent;
        }
        else
        	return null;
    }
	public static String roundNumber(double num,int delta)
	{
		String result = "0.00";
		
		long a = (long )(num * Math.pow(10, delta + 1));
		int du = (int) (a % 10);
		a = a / 10;
		
		double rs;
		if(du <5)
			rs = a / Math.pow(10, delta);
		else
			rs = (a+1) /Math.pow(10, delta);
		
		
		try {
			result = String.format("%."+delta+"f", rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	public static String parseCurrencySymbolGiftASCII(String currencySymbolASCII)
	{
		try {
			URLDecoder.decode(currencySymbolASCII);
			String[] chuoiSplit = currencySymbolASCII.split(";");
			String Ck = "";
			for (int j = 0; j < chuoiSplit.length; j++) {
				int parse = Integer.parseInt(chuoiSplit[j]);
				char pass = (char)parse;
				Log.d("Chuoi currency sau khi parse",":-----------: "+pass);
				Ck += pass;
			}
			Log.d("Chuoi currency cuoi cung sau khi parse",":-----------: "+Ck);
			return Ck;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
			
		}
	}
	public static String parseCurrencySymbolASCII(String currencySymbolASCII)
	{
		return URLDecoder.decode(currencySymbolASCII);
	}
}
