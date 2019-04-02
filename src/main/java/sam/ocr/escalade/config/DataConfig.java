package sam.ocr.escalade.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * Cette classe peut être omise si l'on utilise une seule datasource. En effet,
 * dans ce cas, sa configuration se fait en utilisant les paramètre 'spring.datasource.xxx'
 * spécifiés dans le fichier applicaion.context.
 * En revanche, si l'on veut utiliser plusieurs datasources, on doit donc distinguer leurs
 * paramètres. Pour ce faire, on utilisera un prefix (exemple oracledb.datasource et mysql.datasource)
 * et il faudra donc utliser l'annotation @ConfigurationProperties pour l'indiquer....
 */
//@Configuration
//@ComponentScan(basePackages = {"sam.ocr.escalade", "sam.ocr.escalade.repository"})
//@EnableJpaRepositories(basePackages = {"sam.ocr.escalade.repository"})
//@EnableTransactionManagement
public class DataConfig {

    //@Bean
    //@ConfigurationProperties("app.datasource")
    //public DataSource dataSource() {
     //   return DataSourceBuilder.create().build();
    //}
    @Autowired
    DataSource dataSource;

}
