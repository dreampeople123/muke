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
	private static SimpleDateFormat fn=new SimpleDateFormat("yyyyMMddHHmmssSS");
	
	/**
	 * 获取当前时间
	 * @return
	 */
	public static String getDate(){
		String date = "";
		date=sdf.format(d);
		return date;
	}
	
	/**
	 * 取文件名
	 * @return
	 */
	public static String getFileName(){
		String date = "";
		date=fn.format(d);
		return date;
	}
}
