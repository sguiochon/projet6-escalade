package sam.ocr.escalade.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:vertigo.properties")
public class ApplicationConfig {

    public final int tableSize;

    public final int nbItemNavigation;

    @Autowired
    public ApplicationConfig(@Value("${frontend.table.size}") int tableSize, @Value("${frontend.table.nbnavitem}") int nbItemNavigation){
        this.tableSize = tableSize;
        this.nbItemNavigation = nbItemNavigation;
    }

}
