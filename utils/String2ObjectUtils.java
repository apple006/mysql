package cn.haitu.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class String2ObjectUtils {
  
	public static Float String2Float(String str){
		if(str==null||str.length()==0){
			return null;
		}else{
		  Float	f=Float.parseFloat(str);
		  
		  return f;
		}
		
	}
	public static Integer String2Integer(String str){
		if(str==null||str.length()==0){
			return null;
		}else{
		Integer integer= Integer.parseInt(str);
		    return integer;
		}
		
	}
	public static Date String2Date(String str){
		if(str==null||str.length()==0){
			return null;
		}else{
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		try {
		Date date = sdf.parse(str);
		return date;
		} catch (Exception e) {
		e.printStackTrace();
		}
		return null;
	}
  }
	 public static String stampToDate(String s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
	  }
}
