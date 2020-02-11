package hnatiuk.tests.loggers;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggerWithLombokTest {
    public static void main(String[] args) {
        String myParameter = "PARAMETER";
        log.info("Info log {}", myParameter);
        log.warn("Warn log {}, {}", myParameter, myParameter);
        log.error("Error log");
        log.debug("Debug log");
    }
}
