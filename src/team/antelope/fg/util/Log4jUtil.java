package team.antelope.fg.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//import org.apache.log4j.Logger;  
//import org.apache.log4j.PropertyConfigurator;  

/**
 * ��¼��־�Ĺ����� ��Ҫ����ַ��� </br>
 * 
 * @version 1.0
 * @since 2017/03/08</br>
 * @author bluetata
 */
public class Log4jUtil {
	// log4j�����ļ�
	// private static final String PROPERTIES_FILE_NAME = "log4j.properties";
	private static Log4jUtil instance = null;
	// private static Logger logger = null;
	// ����JCL(commons-logging)���
	private static Log jclLogger = null;

	static {
		// PropertyConfigurator.configure(PROPERTIES_FILE_NAME);
		// logger = Logger.getRootLogger();
		jclLogger = LogFactory.getLog(Log4jUtil.class); // ����JCL��Logʵ��
		// logger = Logger.getLogger(Log4jUtil.class);
	}

	private Log4jUtil() {
	}

	public static Log4jUtil getInstance() {
		synchronized (Log4jUtil.class) {
			if (instance == null) {
				instance = new Log4jUtil();
			}
		}
		return instance;
	}

	public static void debug(String str) {
		// logger.debug(str);
		jclLogger.debug(str);
	}

	public static void debug(String str, Exception e) {
		// logger.debug(str, e);
	}

	public static void info(String str) {
		// logger.info(str);
		jclLogger.info(str);
	}

	public static void info(String str, Exception e) {
		// logger.info(str, e);
	}

	public static void warn(String str) {
		// logger.warn(str);
		jclLogger.warn(str);
	}

	public static void warn(String str, Exception e) {
		// logger.warn(str, e);
	}

	public static void error(String str) {
		// logger.error(str);
		jclLogger.error(str);
	}

	public static void error(String str, Exception e) {
		// logger.error(str, e);
	}

	public static void fatal(String str) {
		// logger.fatal(str);
		jclLogger.fatal(str);
	}

	public static void fatal(String str, Exception e) {
		// logger.fatal(str, e);
	}
}