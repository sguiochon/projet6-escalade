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

@SpringBootApplication//(scanBasePackages = {"sam.ocr.escalade"})
@EnableJpaRepositories(basePackages = {"sam.ocr.escalade"})
public class Main extends SpringBootServletInitializer {

    /**
     * How should a <code>SimpleMappingExceptionResolver</code> be created?
     * <ul>
     * <li>DEMO (default) - Java Config is used and a custom
     * <code>SimpleMappingExceptionResolver</code> is setup that can be enabled or
     * disabled programmatically (just for the purpose of this demo).
     * <li>XML - Traditional XML bean configuration is used - see
     * <code>mvc-configuration.xml</code>.
     * <li>JAVA - Java Configuration is used - see {@link ExceptionConfiguration}.
     * <li>NONE - No <code>SimpleMappingExceptionResolver</code> is created.
     * </ul>
     * <p>
     * Demo mode is the default - set to "java-config" or "xml-config" to match
     * however you intend to use Spring for a more realistic setup.
     *
     * @see Profiles
     */
    public static final String activeProfile = Profiles.DEMO_CONFIG_PROFILE;
    private static final Logger log = LoggerFactory.getLogger(Main.class);


    // Holds Spring Boot configuration properties
    protected Properties props = new Properties();

    /**
     * We are using the constructor to perform some useful initializations:
     * <ol>
     * <li>Set the Spring Profile to use 'controller' or 'global' which in turn
     * selects how exceptions will be handled. Profiles are a Spring feature from
     * V3.1 onwards.
     * <li>Disable Thymeleaf caching so templates (HTML files with Thymeleaf
     * namespace attributes) can be modified whilst the application is running.</li>
     * <li>Enable DEBUG level logging so you can see Spring MVC as its working.</li>
     * </ol>
     */
    public Main() {
        //logger = LoggerFactory.getLogger(getClass());
        log.info("Application starting ");
    }

    /**
     * Retrieve requested Profiles. Depends on the value of {@link #activeProfile}.
     *
     * @return Comma-separated list of profiles.
     */
    public static String getProfiles() {
        return activeProfile;
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
        configure(application);
        application.run(args);
        log.info("Go to this URL: http://localhost:8080/");
    }

    /**
     * Configure the application using the supplied builder when running as a WAR.
     * This method is invoked automatically when running in a container and
     * explicitly by {@link #runAsJavaApplication(String[])}.
     *
     * @param application Spring Boot application builder.
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        application.sources(Main.class);

        log.info("Spring Boot configuration: profiles = " + activeProfile);
        application.profiles(activeProfile);

        // Set additional properties.
        log.info("Spring Boot configuratoon: properties = " + props);
        application.properties(props);

        return application;
    }


    @Bean
    public CommandLineRunner demo(UserRepository userRepository, PasswordEncoder encoder, RoleRepository roleRepository, PrivilegeRepository privilegeRepository) {
/*
        return (args) -> {
            // save a couple of customers

            Privilege privilege = new Privilege("USER");
            Privilege savedPrivilege = privilegeRepository.save(privilege);

            Role role1 = new Role("visiteur");
            role1.addPrivilege(savedPrivilege);
            Role savedRole = roleRepository.save(role1);

            User user1 = new User().setEmail("user@hell.com").setFirstName("Jack").setLastName("Bauer").setPassword(encoder.encode("1234"));
            user1.addRole(savedRole);
            User savedUser = userRepository.save(user1);

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (User user: userRepository.findAll()) {
                log.info(user.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            userRepository.findById(1L)
                    .ifPresent(customer -> {
                        log.info("Customer found with findById(1L):");
                        log.info("--------------------------------");
                        log.info(customer.toString());
                        log.info("");
                    });

            // fetch customers by last name
            log.info("Customer found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            userRepository.findAll().forEach(bauer -> {
                log.info(bauer.toString());
            });
            // for (Customer bauer : repository.findByLastName("Bauer")) {
            // 	log.info(bauer.toString());
            // }
            log.info("");
        };
        */
        return (args) -> {
        };
    }

}
