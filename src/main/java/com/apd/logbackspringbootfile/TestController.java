package com.apd.logbackspringbootfile;



import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(TestController.class);

    @GetMapping
    public String test() {

        logger.debug("Debug message logged.");
        logger.info("Info message logged.");
        logger.error("Error message logged.");
        logger.warn("Warn message logged.");
        logger.trace("Trace message logged.");

        return "Hello World , From Spring Boot";
    }
}
