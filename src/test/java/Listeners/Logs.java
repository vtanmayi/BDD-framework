package Listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logs {
	private static Logger logger = LogManager.getLogger(Logs.class);
	public static void main(String[] args) {
		System.out.println("\n  Hello world.........\n");
		logger.info("This is information message");
		logger.error("This is an error message");
		logger.warn("This is a fatal message");
		logger.fatal("This is a fatal message");
		System.out.println("\n completed");
		logger.info("asdf");
	}


}
