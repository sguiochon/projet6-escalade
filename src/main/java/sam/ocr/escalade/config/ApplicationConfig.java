package sam.ocr.escalade.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Propriétés de l'application
 */
@Configuration
@PropertySource("classpath:vertigo.properties")
@EnableAsync
public class ApplicationConfig {

    public final int tableSize;

    public final int nbItemNavigation;

    @Autowired
    public ApplicationConfig(@Value("${frontend.table.size}") int tableSize, @Value("${frontend.table.nbnavitem}") int nbItemNavigation){
        this.tableSize = tableSize;
        this.nbItemNavigation = nbItemNavigation;
    }

}
