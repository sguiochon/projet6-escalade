package sam.ocr.escalade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;
import sam.ocr.escalade.repository.PrivilegeRepository;
import sam.ocr.escalade.repository.RoleRepository;
import sam.ocr.escalade.repository.UserRepository;

import java.util.Properties;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"sam.ocr.escalade"})
public class Main extends SpringBootServletInitializer {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    // Holds Spring Boot configuration properties
    protected Properties props = new Properties();

    public Main() {
        //logger = LoggerFactory.getLogger(getClass());
        logger.info("Demarrage de l'application...");
    }

    /**
     * Back to the future: run the application as a Java application and it will
     * pick up a container (Tomcat, Jetty) automatically if present. Pulls in Tomcat
     * by default, running in embedded mode.
     * <p>
     * This application can also run as a traditional war file because it extends
     * <code>SpringBootServletInitializer</code> as well.
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // Create an instance and invoke run(); Allows the contructor to perform
        // initialisation regardless of whether we are running as an application
        // or in a container.
        new Main().runAsJavaApplication(args);
    }

    /**
     * Run the application using Spring Boot. <code>SpringApplication.run</code>
     * tells Spring Boot to use this class as the initialiser for the whole
     * application (via the class annotations above). This method is only used when
     * running as a Java application.
     *
     * @param args Any command line arguments.
     */
    protected void runAsJavaApplication(String[] args) {
        SpringApplicationBuilder application = new SpringApplicationBuilder();
        application.sources(Main.class);
        application.run(args);
        logger.info("L'application a demarre.");
    }

}
