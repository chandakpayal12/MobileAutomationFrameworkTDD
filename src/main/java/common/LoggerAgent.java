package main.java.common;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

/**
* @author Payal Chandak
*
*/
public class LoggerAgent {
static Logger logger = null;
	
	static{
		
		logger = Logger.getLogger(LoggerAgent.class.getName());
		DOMConfigurator.configure(System.getProperty("user.dir")+"\\src\\main\\resources\\Log4j.xml");
	}
	
	/**
	 * Logs message to the log file with INFO status
	 * @paramMessage to be logged
	 */ 
	public static void LogInfo(String message){
		logger.info(message);
		
	}
	/**
	 * Logs message to the log file with ERROR status
	 * @paramMessage to be logged
	 */
	public static void LogError(String message){
		logger.error(message);
	}

}
