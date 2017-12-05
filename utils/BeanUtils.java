package cn.haitu.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

public class BeanUtils {

	public static <T> T converMap2Bean(Map<String, Object> map, T t) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException, InstantiationException{
		Class<? extends Object> clz = t.getClass();
		if(map != null && map.size()>0){
			for(Map.Entry<String, Object> entry : map.entrySet()) {    
                String propertyName = entry.getKey();       //属性名  
                Object value = entry.getValue();    
                String setMethodName = "set"+ propertyName.substring(0, 1).toUpperCase()  + propertyName.substring(1);    
                Field field = ReflectionUtils.getClassField(clz, propertyName);    
                if(field==null)  
                    continue;  
                Class<?> fieldTypeClass = field.getType();    
                value = ReflectionUtils.convertValType(value, fieldTypeClass);   
                try{
                	if(value instanceof Date){
                		value = (Date)value;
                	}
                	Class<?> type = field.getType();
                	if(type.equals(Date.class)){
                		value = DateUtil.parseDate(value.toString());
                	}else if(type.equals(Integer.class)){
                		value = Integer.parseInt(value.toString());
                	}else if(type.equals(Double.class)){
                		value = Double.valueOf(value.toString());
                	}
                	clz.getMethod(setMethodName, field.getType()).invoke(t, value);   
                }catch(NoSuchMethodException e){  
                    e.printStackTrace();  
                }  
            }   
		}
		return t;
	}
}
