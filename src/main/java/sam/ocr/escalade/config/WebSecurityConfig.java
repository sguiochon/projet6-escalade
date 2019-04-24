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

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/sites", "/site", "/sample", "/topos", "/commentValidation","/register", "/confirmRegistration", "/pays", "/nomSite","/sujetTopo","/*.jpg", "/*.png", "/*.css", "/*.js").permitAll()
                .antMatchers("/resa", "/pret").hasAuthority("USER")
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
