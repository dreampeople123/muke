package com.dream.muke.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 获取时间的工具
 * @author dream
 *
 */
public class DateUtil {
	private static Date d=new Date();
	private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm");
	
	/**
	 * 获取当前时间
	 * @return
	 */
	public static String getDate(){
		String date = "";
		date=sdf.format(d);
		return date;
	}
}
