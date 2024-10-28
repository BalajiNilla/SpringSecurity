package com.balaji.springSecurityExample.Security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity  // to tell spring that follow this security flow
public class SecurityConfig {

    @Bean  //to make our customization work we have to define beans
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //by enabling this the default security filters will get disabled

        http
                .csrf(customizer->customizer.disable()) // to make changes to application without sending token
                .authorizeHttpRequests(request->request.anyRequest().authenticated())// to authenticate request coming to server
//                .formLogin(Customizer.withDefaults()) this will call login page again and again because of statelessness
                .httpBasic(Customizer.withDefaults()) // to make requests from the postman(testing applications)
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
                //to make our application stateless, it will create a new session everytime user sends a request.
                //all these are internally functional interfaces so we have used lambda expressions, we can also do it in imaparitive way


        return http.build();
    }
}
