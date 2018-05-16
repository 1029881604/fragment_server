package team.antelope.fg.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * ���ڹ�����
 * @author ���Ĳ�
 * @time:2018��5��14�� ����8:13:19
 * @Description:TODO
 */
public class DateUtil {
	  /*
	    * ����ʱ��*/
	    private static final SimpleDateFormat DATETIME = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    /*
	    * ����*/
	    private static final SimpleDateFormat DATE = new SimpleDateFormat("yyyy-MM-dd");
	    private static final SimpleDateFormat TIME = new SimpleDateFormat("HH:mm:ss");
	    /*
	    * ʱ��*/
	    public static String formatDataTime(long date) {
	        return DATETIME.format(new Date(date));
	    }
	    public static String formatDataTime2(Date date) {
	        return DATETIME.format(date);
	    }

	    public static String formatDate(long date) {
	        return DATE.format(new Date(date));
	    }

	    public static String formatTime(long date) {
	        return TIME.format(new Date(date));
	    }
	    /**
	     * @Description �ַ���תΪ����
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
}
