package com.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ewan on 18/7/13.
 */
public class Log4j2Test {

    private static final Logger LOGGER = LoggerFactory.getLogger(Log4j2Test.class);

    public static void main(String[] args) {
        LOGGER.debug("test");
    }
}
