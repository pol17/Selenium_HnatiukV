package hnatiuk.tests.loggers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerTest {
    private static Logger log = LoggerFactory.getLogger(LoggerTest.class);

    public static void main(String[] args) {
        String myParameter = "PARAMETER";
        log.info("Info log {}", myParameter);
        log.warn("Warn log {}, {}", myParameter, myParameter);
        log.error("Error log");
        log.debug("Debug log");
    }
}
