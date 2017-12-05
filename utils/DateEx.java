package cn.haitu.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateEx extends Date {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 返回"yyyy-MM-dd HH:mm:ss.SSS"
	 * @return
	 */
	public String toFullString(){
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(this);
	}

	/**
	 * 返回"yyyy-MM-dd HH:mm:ss"
	 * @return
	 */
	public String toDateTimeString(){
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this);
	}

	/**
	 * 返回"yyyy-MM-dd"
	 * @return
	 */
	public String toDateString(){
		return new SimpleDateFormat("yyyy-MM-dd").format(this);
	}

	/**
	 * 返回"HH:mm:ss"
	 * @return
	 */
	public String toTimeString(){
		return new SimpleDateFormat("HH:mm:ss").format(this);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
