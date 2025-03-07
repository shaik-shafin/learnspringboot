package com.shaik.acknowledge.security.config;

import com.shaik.acknowledge.security.filters.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration // Telling spring that it is a configuration class
@EnableWebSecurity // Telling spring that do not use default filters instead used mine.
public class AppConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtFilter JwtFilter;

    @Bean
    public SecurityFilterChain getSecurityFilterChain(HttpSecurity http) throws Exception {

        return http
                .csrf(customizer -> customizer.disable()) // disable csrf so that post man can do CRUD operations
                .authorizeHttpRequests(request -> request
                        .requestMatchers("auth/register", "auth/login").permitAll()
                        .anyRequest().authenticated()) // all requests should be authenticated
                .formLogin(Customizer.withDefaults()) // enable form login for browser
                .httpBasic(Customizer.withDefaults()) // enable http basic (enable form login for postman or RestAPI)
                .addFilterBefore(JwtFilter, UsernamePasswordAuthenticationFilter.class)
                .oauth2Login(Customizer.withDefaults()) //For Oauth2 login
                .build();

    }

    @Bean
    public AuthenticationProvider getAuthenticationProvider() {

        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(getBCryptPasswordEncoder());
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }

    //We are telling to spring that don't go with default setting in application properties, go we specified in this method
    //this is the static way, but if you want to get from db it will not work
   /* @Bean
    public UserDetailsService getUserDetailsService() {

        UserDetails user1 = User
                .withDefaultPasswordEncoder()
                .username("shaik shafin")
                .password("spring_boot_security")
                .roles("USER")
                .build();

        UserDetails user2 = User
                .withDefaultPasswordEncoder()
                .username("shaik shafiya")
                .password("spring_boot_security")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user1, user2);
    }*/

    @Bean
    public BCryptPasswordEncoder getBCryptPasswordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    public AuthenticationManager getAuthenticationManager(AuthenticationConfiguration config) throws Exception {

        return config.getAuthenticationManager();
    }
}
