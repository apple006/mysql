package cn.haitu.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;

/**
 * 
 * @author wangxing
 *
 */
public final class DateUtil extends DateUtils{

    private static String DATETIME_FORMAT = "yyyy-MM-dd HH:mm";
    private static String DATE_FORMAT = "yyyy-MM-dd";
    private static String TIME_FORMAT = "HH:mm";
	public static final String DATETIME_FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss";
	public static final String DATETIME_FORMAT_PATTERN2 = "yyyyMMddHHmmss";
	
    public static final long TIME_ONE_HOUR = 3600L * 1000L;

    public static final long TIME_ONE_DAY = 24L * TIME_ONE_HOUR;

    /**
     * Get the previous time, from how many days to now.
     * 
     * @param days How many days.
     * @return The new previous time.
     */
    public static long previous(int days) {
        return System.currentTimeMillis() - 3600000L * 24L * days;
    }

    /**
     * Get the next time, from how many days to now.
     * 
     * @param days How many days.
     * @return The new next time.
     */
    public static long next(int days) {
        return System.currentTimeMillis() + 3600000L * 24L * days;
    }

    /**
     * Convert date and time to string like "yyyy-MM-dd HH:mm".
     */
    public static String formatDateTime(Date d) {
        return new SimpleDateFormat(DATETIME_FORMAT).format(d);
    }
    /**
     * Convert date and time to string like "yyyy-MM-dd HH:mm:ss".
     */
    public static String formatDatehms(Date d){
    	if(d==null) d = new Date();
    	return new SimpleDateFormat(DATETIME_FORMAT_PATTERN).format(d);
    }
    /**
     * Convert date and time to string like "yyyyMMddHHmmss".
     */
    public static String formatDatehms2(Date d){
    	return new SimpleDateFormat(DATETIME_FORMAT_PATTERN2).format(d);
    }
    /**
     * Convert time to string like "HH:mm".
     */
    public static String formatTime(Date date) {
        return new SimpleDateFormat(TIME_FORMAT).format(date);
    }

    /**
     * Convert date and time to string like "yyyy-MM-dd HH:mm".
     */
    public static String formatDateTime(long d) {
        return new SimpleDateFormat(DATETIME_FORMAT).format(d);
    }

    /**
     * Convert date to String like "yyyy-MM-dd".
     */
    public static String formatDate(Date d) {
        return new SimpleDateFormat(DATE_FORMAT).format(d);
    }

    /**
     * Parse date like "yyyy-MM-dd".
     */
    public static Date parseDate(String d) {
        try {
            return new SimpleDateFormat(DATE_FORMAT).parse(d);
        }
        catch(ParseException e) {}
        return null;
    }

    /**
     * Parse date and time like "yyyy-MM-dd hh:mm".
     */
    public static Date parseDateTime(String dt) {
        try {
            return new SimpleDateFormat(DATETIME_FORMAT).parse(dt);
        }
        catch(Exception e) {}
        return null;
    }

    /**
     * Parse date and time like "yyyy-MM-dd hh:mm:ss".
     */
    public static Date parseDateTimeSecond(String dt) {
        try {
            return new SimpleDateFormat(DATETIME_FORMAT_PATTERN).parse(dt);
        }
        catch(Exception e) {}
        return null;
    }
    
    private static final int[] DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    /**
     * Return today's year, month(1-12), day(1-31), week(0-6, for SUN, MON, ... SAT).
     */
    public static int[] getToday() {
        return getDate(Calendar.getInstance());
    }

    /**
     * Return today's time with hour offset.
     */
    public static long getToday(int hourOffset) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(System.currentTimeMillis());
        c.set(Calendar.HOUR_OF_DAY, hourOffset);
        c.clear(Calendar.MINUTE);
        c.clear(Calendar.SECOND);
        c.clear(Calendar.MILLISECOND);
        return c.getTimeInMillis();
    }

    /**
     * Return day's year, month(1-12), day(1-31), week(0-6, for SUN, MON, ... SAT).
     */
    public static int[] getDate(long t) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(t);
        return getDate(c);
    }

    /**
     * Return day's year, month(1-12), day(1-31), week(0-6, for SUN, MON, ... SAT).
     */
    public static int[] getDate(Calendar c) {
        int week = c.get(Calendar.DAY_OF_WEEK)-1;
        if(week==0)
            week = 7;
        return new int[] {
                c.get(Calendar.YEAR),
                c.get(Calendar.MONTH) + 1,
                c.get(Calendar.DAY_OF_MONTH),
                week
        };
    }
    /**
     * Return day's year, month(1-12), day(1-31), week(0-6, for SUN, MON, ... SAT).
     */
    public static int[] getDate(){
    	Calendar c = Calendar.getInstance();
    	return getDate(c);
    }
    /**
     * Return day's year, month(1-12), day(1-31), week(0-6, for SUN, MON, ... SAT), hour, minute, second.
     */
    public static int[] getTime(long t) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(t);
        return getTime(c);
    }

    /**
     * Return day's year, month(1-12), day(1-31), week(0-6, for SUN, MON, ... SAT), hour, minute, second.
     */
    public static int[] getTime(Calendar c) {
        int week = c.get(Calendar.DAY_OF_WEEK)-1;
        if(week==0)
            week = 7;
        return new int[] {
                c.get(Calendar.YEAR),
                c.get(Calendar.MONTH) + 1,
                c.get(Calendar.DAY_OF_MONTH),
                week,
                c.get(Calendar.HOUR_OF_DAY),
                c.get(Calendar.MINUTE),
                c.get(Calendar.SECOND)
        };
    }
    /**
     * Return day's year, month(1-12), day(1-31), week(0-6, for SUN, MON, ... SAT), hour, minute, second.
     */
    public static int[] getTime() {
    	Calendar c = Calendar.getInstance();
    	return getTime(c);
    }
    /**
     * Get Calendar instance by specified year, month and day.
     * 
     * @param year 4-digit year.
     * @param month Month range is 1-12.
     * @param day Day range is 1-?, end depends on year and month.
     * @return A Calendar instance.
     */
    public static Calendar getCalendar(int year, int month, int day) {
        if(year<2000 || year>2100)
            throw new IllegalArgumentException();
        if(month<1 || month>12)
            throw new IllegalArgumentException();
        if(day<1)
            throw new IllegalArgumentException();
        if(month==2 && isLeapYear(year)) {
            if(day>29)
                throw new IllegalArgumentException();
        }
        else {
            if(day>DAYS[month-1])
                throw new IllegalArgumentException();
        }
        month--;
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, day);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c;
    }

    public static boolean isLeapYear(int year) {
        if(year % 100==0) {
            return year % 400==0;
        }
        return year % 4==0;
    }

    public static String format(int hour, int minute, String format) {
        if("HH-mm".equals(format)) {
            StringBuilder sb = new StringBuilder(5);
            if(hour<10)
                sb.append('0');
            sb.append(hour).append(':');
            if(minute<10)
                sb.append('0');
            return sb.append(minute).toString();
        }
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, hour);
        c.set(Calendar.MINUTE, minute);
        c.set(Calendar.SECOND, 0);
        return new SimpleDateFormat(format).format(c.getTime());
    }

    public static String format(int year, int month, int day, String format) {
        if("MM-dd".equals(format)) {
            StringBuilder sb = new StringBuilder(5);
            return sb.append(month).append('-').append(day).toString();
        }
        if("yyyy-MM-dd".equals(format)) {
            StringBuilder sb = new StringBuilder(10);
            return sb.append(year).append('-').append(month).append('-').append(day).toString();
        }
        Calendar c = getCalendar(year, month, day);
        return new SimpleDateFormat(format).format(c.getTime());
    }

    public static int[] getPreviousDay(int year, int month, int day) {
        day--;
        if (day < 1) {
            month --;
            if (month < 1) {
                year --;
                month = 12;
            }
            int lastDay = DAYS[month-1];
            if(month==2 && isLeapYear(year))
                lastDay++;
            day = lastDay;
        }
        return new int[] { year, month, day };
    }

    public static int[] getNextDay(int year, int month, int day) {
        day++;
        int max = DAYS[month-1];
        if(month==2 && isLeapYear(year))
            max++;
        if (day > max) {
            day = 1;
            month ++;
            if (month > 12) {
                year++;
                month = 1;
            }
        }
        return new int[] { year, month, day };
    }
    /**
     * 一个月的天数
     * @param Year
     * @param Month
     * @return
     * @throws Exception
     */
    public static int getDaysofMonth(int Year, int Month){
    	Calendar c = Calendar.getInstance();
    	c.set(Calendar.YEAR, Year);
    	c.set(Calendar.MONTH, Month - 1);
    	return c.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
    
    /**
     * 返回一天的小时数
     * @return
     */
    public static int getHoursOfDay(){
    	return 24;
    }
    
    /**
     * 返回一年的月数
     * @param year
     * @return
     */
    public static int getMonthesOfYear(){
    	return 12;
    }
    
    /**
     * 返回一年的周数
     * @param year
     * @return
     */
    public static int getWeeksOfYear(int year){
    	Calendar c = Calendar.getInstance();
    	c.set(Calendar.YEAR, year);
    	return c.getActualMaximum(Calendar.WEEK_OF_YEAR);
    }
    
    /**
     * 返回月的第一天 
     * @param year
     * @param month
     * @return
     */
    public static String getFirstDateOfMonth(int year, int month){
    	Calendar c = Calendar.getInstance();
    	c.set(Calendar.YEAR, year);
    	c.set(Calendar.MONTH, month-1);
    	c.set(Calendar.DAY_OF_MONTH,1);
    	return formatDate(c.getTime());
    }
    
    /**
     * 返回月的最后一天
     * @param year
     * @param month
     * @return
     */
    public static String getLastDateOfMonth(int year, int month){
    	Calendar c = Calendar.getInstance();
    	c.set(Calendar.YEAR, year);
    	c.set(Calendar.MONTH, month);
    	c.set(Calendar.DAY_OF_MONTH,0);
    	return formatDate(c.getTime());
    }
    
    public static void main(String[] args) {
    	
    	System.out.println(getFirstDateOfMonth(2017,2));
	}
    
    /**
     * 根据指定格式格式化日期
     * @param date
     * @param pattern
     * @return
     */
    public static String formateDateByPattern(Date date, String pattern){
    	SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    	return sdf.format(date);
    }
    
    /**
     * 比较大小
     * @param anotherDate
     * @return
     */
    public static int compareTo(Date date1, Date date2) {
        long thisTime = date1.getTime();
        long anotherTime = date2.getTime();
        return (thisTime<anotherTime ? -1 : (thisTime==anotherTime ? 0 : 1));
    }
    
    /**
     * 返回指定时间前n天的时间集合
     * @param date 指定时间
     * @param n 前几天
     * @return
     */
    public static List<String> getDateList(Date date, int n){
    	DateFormat df = new SimpleDateFormat(DATE_FORMAT);
    	List<String> list = new ArrayList<String>();
    	if(n==0){
    		return list;
    	}else if(n<0){
    		n = -n;
    		for(int i=1;i<=n;i++){
    			list.add(df.format(addDays(date, 0-i)));
    		}
    	}else {
    		for(int i=1;i<=n;i++){
    			list.add(df.format(addDays(date, i)));
    		}
    	}
    	return list;
    }
    
}
