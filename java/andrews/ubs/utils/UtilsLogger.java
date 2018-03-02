package andrews.ubs.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import andrews.ubs.Reference;

public class UtilsLogger {
	
	public static Logger logger;
	
	public static Logger getLogger() {
		if(logger == null)
			logger = LogManager.getFormatterLogger(Reference.MODID);
		return logger;
	}

}
