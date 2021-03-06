package team.antelope.fg.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * 日期工具类
 * @author 华文财
 * @time:2018年5月14日 下午8:13:19
 * @Description:TODO
 */
public class DateUtil {
	  /*
	    * 日期时间*/
	    private static final SimpleDateFormat DATETIME = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    /**
	     * 日期时间2
	     */
	    private static final SimpleDateFormat DATETIME2 = new SimpleDateFormat("MM-dd HH:mm");
	    /*
	    * 日期*/
	    private static final SimpleDateFormat DATE = new SimpleDateFormat("yyyy-MM-dd");
	    private static final SimpleDateFormat TIME = new SimpleDateFormat("HH:mm:ss");
	    /*
	    * 时间*/
	    public static String formatDataTime(long date) {
	        return DATETIME.format(new Date(date));
	    }
	    public static String formatDataTime2(Date date) {
	        return DATETIME.format(date);
	    }
	    public static String formatDataTime3(Date date) {
	    	return DATETIME2.format(date);
	    }

	    public static String formatDate(long date) {
	        return DATE.format(new Date(date));
	    }

	    public static String formatTime(long date) {
	        return TIME.format(new Date(date));
	    }
	    /**
	     * @Description 字符串转为日期
	     * @date 2017/12/5
	     */
	    public static Date string2Date(String s, String style) {
	        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
	        simpleDateFormat.applyPattern(style);
	        Date date = null;
	        if (s == null || s.length() < 6) {
	            return null;
	        }
	        try {
	            date = simpleDateFormat.parse(s);
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        return date;
	    }
	    
	    /** 
	     * 获取随机日期 
	     * @param beginDate 起始日期，格式为：yyyy-MM-dd HH:mm:ss 
	     * @param endDate 结束日期，格式为：yyyy-MM-dd HH:mm:ss
	     * @return 
	     */  
	    public static Date randomDate(String beginDate,String endDate){  
	        try {  
	            SimpleDateFormat format = DATETIME;
	            Date start = format.parse(beginDate);  
	            Date end = format.parse(endDate);  
	              
	            if(start.getTime() >= end.getTime()){  
	                return null;  
	            }  
	              
	            long date = random(start.getTime(),end.getTime());  
	              
	            return new Date(date);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        return null;  
	    }  
	      
	    private static long random(long begin,long end){  
	        long rtn = begin + (long)(Math.random() * (end - begin));  
	        if(rtn == begin || rtn == end){  
	            return random(begin,end);  
	        }  
	        return rtn;  
	    }  
}
