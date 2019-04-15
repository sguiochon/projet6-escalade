package sam.ocr.escalade.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import sam.ocr.escalade.service.VertigoUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private VertigoUserDetailsService userDetailsService;

    /*
    @Autowired
    private DataSource datasource;


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //Use Spring Boot UserDetails Manager
        JdbcUserDetailsManager userDetailsService = new JdbcUserDetailsManager();

        //Set our Datasource to use the one defined in application.properties
        userDetailsService.setDataSource(datasource);

        //Create BCryptPassword encoder
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        //add components
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
        auth.jdbcAuthentication().dataSource(datasource);

        // add new user "user" with password "password" - password will be encrypted
        if (!userDetailsService.userExists("inferno@hell.com")) {
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("USER"));
            authorities.add(new SimpleGrantedAuthority("ADMIN"));
            User userDetails = new User("inferno@hell.com", encoder.encode("1234"), authorities);
            userDetailsService.createUser(userDetails);
        }
    }
*/
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/sites", "/sample", "/topos", "/*.jpg", "/*.png", "/*.css", "/*.js").permitAll()
                .antMatchers("/resa").hasAuthority("USER")
                .antMatchers("/admin/**").hasAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .successForwardUrl("/")
                    .failureForwardUrl("/login-error")
                    .permitAll()
                .and()
                    .logout()
                    //.logoutSuccessHandler(logoutSuccessHandler)
                    .invalidateHttpSession(true)
                    //.logoutSuccessUrl("/")//logout.html?logSucc=true")
                    .deleteCookies("JSESSIONID")
                    .permitAll()
                .and()
                    .rememberMe()
                .and().csrf().disable();
    }


    @Bean
    public DaoAuthenticationProvider authProvider() {
        final DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(encoder());
        return authProvider;
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(11);
    }


}
