package sam.ocr.escalade.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

@Configuration
public class ExceptionConfig {

    protected Logger logger;

    public ExceptionConfig() {
        logger = LoggerFactory.getLogger(getClass());
        logger.info("Creating ExceptionConfiguration");
    }

    /**
     * Setup the classic SimpleMappingExceptionResolver. This provides useful
     * defaults for logging and handling exceptions. It has been part of Spring
     * MVC since Spring V2 and you will probably find most existing Spring MVC
     * applications are using it.
     * <p>
     * Only invoked if the "global" profile is active.
     *
     * @return The new resolver
     */
    @Bean(name = "simpleMappingExceptionResolver")
    public SimpleMappingExceptionResolver createSimpleMappingExceptionResolver() {
        logger.info("Creating SimpleMappingExceptionResolver");
        SimpleMappingExceptionResolver r = new SimpleMappingExceptionResolver();

        Properties mappings = new Properties();
        mappings.setProperty("DatabaseException", "databaseException");
        //mappings.setProperty("InvalidCredentialsException", "credentialsException");

        r.setExceptionMappings(mappings); // None by default

        r.setExceptionAttribute("ex"); // Default is "exception"
        r.setWarnLogCategory("sam.ocr.escalade.ExceptionLogger"); // No default

        r.setDefaultErrorView("error");
        return r;
    }
}
