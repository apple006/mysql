package cn.haitu.utils;

import java.sql.Types;
import java.util.Map;


public class StringUtil {
	public static String fixStr(int i){
		if (i<10){
			return "000" + i;
		}
		else if(i<100){
			return "00" + i;
		}
		else if(i<1000){
			return "0" + i;
		}
		return i + "";
	}

	public static String fixStr(String i){
		if (i.length()==1){
			return "000" + i;
		}
		else if(i.length()==2){
			return "00" + i;
		}
		else if(i.length()==3){
			return "0" + i;
		}
		return i + "";
	}
	
	public static int parseInt(Object str){
		int num = 0;
		if(str != null){
			try{
				num = parseInt(str.toString());
			}catch(Exception e){
				
			}
		}
		return num;
	}
	public static int parseInt(String str){
		int num = 0;
		try{
			num = Integer.parseInt(str);
		}catch(Exception e){
			
		}
		return num;
	}
	public static String get(Object row,String key){
		if(row != null){
			if( row instanceof Map<?, ?>){
				return get( (Map<?, ?>)row,key);
			}
		}
		return "";
	}
	
	private static String get(Map<?, ?> row,String key){
		Object obj = row.get(key);
		return obj==null ? "" : obj.toString().trim();
	}
	
	public static boolean testPara(Object para,String key){
		return get(para,key).length()>0;
	}

	public static String duplicate(String str,int num){
		StringBuffer bf = new StringBuffer();
		for(int i=0; i<num; i++){
			if(i==0){
				bf.append(str);
			}
			else{
				bf.append(",").append(str);
			}
		}
		return bf.toString();
	}
	public static String duplicate(String str,String sep,int num){
		StringBuffer bf = new StringBuffer();
		for(int i=0; i<num; i++){
			if(i==0){
				bf.append(str);
			}
			else{
				bf.append(sep).append(str);
			}
		}
		return bf.toString();
	}
//	public static Map<Object, Comparable> getJSONMap(Map<Object, Comparable> map){
//		Object[] keys = map.keySet().toArray();
//		for(Object key:keys){
//			if (map.get(key) == null){
//				map.put(key, "");
//			}
//			else if(map.get(key) instanceof java.util.Date){
//				java.util.Date dt = (java.util.Date)map.get(key);
//				map.put(key+"_DATE", DateUtil.formatDate(dt));
//				map.put(key+"_DATETIME", DateUtil.formatDateTime(dt));
//				map.put(key+"_TIME", DateUtil.formatTime(dt));
//				map.put(key+"_LONG", dt.getTime());
//				map.put(key+"_DATEHMS", DateUtil.formatDatehms(dt));
//			}else if(map.get(key) instanceof String){
//				map.put(key, map.get(key).toString().trim());
//			}
//		}
//		return map;
//	}

	public static String duplicate(String str, String sep, int[] argTypes) {
		StringBuffer bf = new StringBuffer();
		for(int i=0; i<argTypes.length; i++){
			String pattenStr = str;
			if(argTypes[i] == Types.DATE){
				pattenStr = "to_date(?,'yyyy-mm-dd')";
			}
			else if(argTypes[i] == Types.TIME){
				pattenStr = "to_date(?,'yyyy-mm-dd hh24:mi')";
			}
			if(i==0){
				bf.append(pattenStr);
			}
			else{
				bf.append(sep).append(pattenStr);
			}
		}
		return bf.toString();
	}
	
	public static Short parseShort(String str){
		try{
			return Short.parseShort(str);
		}catch(Exception e){
			return 0;
		}
	}
	
	public static Double parseDouble(String str){
		try{
			return Double.parseDouble(str);
		}catch(Exception e){
			return 0D;
		}
	}

	public static boolean isEmpty(String str) {
		return (str == null || "".equals(str.trim()));
	}
	
//	public static ObjectMapper mapper = new ObjectMapper();
//	
//	static {
//		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
//	}
//	
//	public static String ObjectAsString(Object value){
//		String str = null;
//		try{
//			str = mapper.writeValueAsString(value);
//		}catch(JsonProcessingException e){
//			e.printStackTrace();
//		}
//		return str; 
//	}
	
	
}
