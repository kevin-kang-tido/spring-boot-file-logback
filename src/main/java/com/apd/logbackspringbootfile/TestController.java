package com.apd.logbackspringbootfile;



import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
    @GetMapping("/new")
    public String testingHttpsStatus() {

        System.out.println("Hello World , From Spring Boot");

        int numnber = 10/0;

        return "Hello World , From Spring Boot";
    }

    // Testing with file upLoad
    @PostMapping("/upload")
    public String handleFileUpload(
            @RequestParam("file") MultipartFile file
    ){
        return "File uploaded successfully.";
    }



}
