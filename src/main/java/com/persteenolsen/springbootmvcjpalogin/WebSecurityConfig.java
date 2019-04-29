package com.persteenolsen.springbootmvcjpalogin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// NOTE: For demos only because of the password is in plain-text
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;

// NOTE: For production because the password is NOT in plain-text but match a plain text
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
   // NOTE: To be used in production 
   // Produced from BCrypt-Generator "GreetingController" 
   // and the plain text password "persteen1967" must be
   // removed in a real world application before deployment to production!
   private String ENCODED_PASSWORD = "$2a$10$BU4mPFHW8stXWMVH8clcZ.yZ7wl54oJq.f0Lu2HnUK6.WdooEoTZ2";
     
   @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.inMemoryAuthentication()
         .passwordEncoder(passwordEncoder())
         .withUser("user").password(ENCODED_PASSWORD).roles("USER");
     }
  
   @Bean
   public PasswordEncoder passwordEncoder() {
       return new BCryptPasswordEncoder();
   }
    
   @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
          .authorizeRequests()

            // The list of pages/views the users can request without being authenticated
            .antMatchers("/", "/demo/mvclistpersons", "/home", "/welcome", "/bcrypt").permitAll()
            .anyRequest().authenticated()
            .and()
          .formLogin()
              // With no costum login page the default Spring Boot Security login 
              // page will be displayed when the user try to request a page in
              // which he is not authenticated
              //.loginPage("/login")
              .permitAll()
              .and()
            .logout()
               .permitAll();
    }

    // NOTE: For demos only because of the password is in plain-text
    /*@Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
             User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }*/

}