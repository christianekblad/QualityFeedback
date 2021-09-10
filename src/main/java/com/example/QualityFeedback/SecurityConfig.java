package com.example.QualityFeedback;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

// Security configuration allowing everyone to enter and save Quality feedback,
// but only users with ADMIN role to list and explore the collected Quality feedback.
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
//                    .antMatchers("/", "/form", "/thankYou", "/saveFeedback", "/productnumhelp.html").permitAll()
                    .antMatchers("/h2", "/h2/**", "/feedbacks").hasRole("ADMIN")
//                    .anyRequest().authenticated()
                    .anyRequest().permitAll()
                    .and()
                .formLogin()
                    //.defaultSuccessUrl("/index", true)
                  .permitAll()
                .and()
                    .logout()
                    .logoutSuccessUrl("/");
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withDefaultPasswordEncoder().username("user").password("123").roles("USER").build());
        manager.createUser(User.withDefaultPasswordEncoder().username("Mija").password("123").roles("ADMIN").build()); // removed "user"
        manager.createUser(User.withDefaultPasswordEncoder().username("Neha").password("123").roles("ADMIN").build()); // removed "user"
        manager.createUser(User.withDefaultPasswordEncoder().username("Annica").password("123").roles("ADMIN").build()); // removed "user"
        manager.createUser(User.withDefaultPasswordEncoder().username("Christian").password("123").roles("ADMIN").build()); // removed "user"
        return manager;
    }
}