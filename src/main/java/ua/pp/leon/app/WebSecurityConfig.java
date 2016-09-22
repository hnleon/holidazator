package ua.pp.leon.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import ua.pp.leon.service.UserService;

/**
 *
 * @author Andrii Zalevskyi <azalevskyi@gmail.com>
 */
@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses = UserService.class)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
 
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**", "/static/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/resources/**", "/static/**").permitAll()
                .antMatchers("/", "/home").permitAll()
                .antMatchers("/secure/**").authenticated()//hasAnyRole("USER", "ADMIN")
//                .antMatchers("/user/**").hasRole("USER")
//                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().permitAll()//authenticated()
            .and()
                .formLogin().loginPage("/login").failureUrl("/home?error")
                    .defaultSuccessUrl("/secure").permitAll()
            .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/home?logout")
            .and()
                .exceptionHandling().accessDeniedPage("/403")
        ;
    }
}
