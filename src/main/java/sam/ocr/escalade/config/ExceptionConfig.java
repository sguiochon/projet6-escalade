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

        /*
         * Normally Spring MVC has no default error view and this class is the
         * only way to define one. A nice feature of Spring Boot is the ability
         * to provide a very basic default error view (otherwise the application
         * server typically returns a Java stack trace which is not acceptable
         * in production). See Blog for more details.
         *
         * To stick with the Spring Boot approach, DO NOT set this property of
         * SimpleMappingExceptionResolver.
         *
         * Here we are choosing to use SimpleMappingExceptionResolver since many
         * Spring applications have used the approach since Spring V1. Normally
         * we would specify the view as "error" to match Spring Boot, however so
         * you can see what is happening, we are using a different page.
         */
        //r.setDefaultErrorView("error");
        return r;
    }
}
