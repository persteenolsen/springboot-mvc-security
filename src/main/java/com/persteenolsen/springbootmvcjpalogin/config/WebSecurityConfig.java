package com.persteenolsen.springbootmvcjpalogin.config;

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
   // Produced from BCrypt-Generator "BcryptEncoderController" 
   // and the plain text password "persteen1967" must be
   // removed in a real world application before deployment to production!
   private String ENCODED_PASSWORD = "$2a$10$BU4mPFHW8stXWMVH8clcZ.yZ7wl54oJq.f0Lu2HnUK6.WdooEoTZ2";
     
   @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

      // I am using inMemoryAuthentication but it is possible to use JDBC anbd LDAP too!
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
            .antMatchers("/", "/demo/mvclistpersons", "/home", "/welcome","/bcrypt").permitAll()
            .anyRequest().authenticated()

           .and()
              .formLogin()
              // With no costum login page the default Spring Boot Security login 
              // page will be displayed when the user try to request a page in
              // which he is not authenticated

              // Here I am using a costum login page and if login is ok, the list of persons will be displayed
              // Note: A request to "/" is redirected "/demo/mvclistpersons" 
              // in the controller to show the list of persons 
              .loginPage("/login")

              // NOTE: Maybe all login request need to be post like in the form !!
              //.loginProcessingUrl("/perform_login")

              .defaultSuccessUrl("/")
              .failureUrl("/login?error=true")

              .permitAll()
            .and()
                 .logout()

                 // NOTE: If CSRF NOT is disabled ALL logout request need to be POST
                 //.logoutUrl("/perform_logout")
                 
                 // NOTE: Maybe it is not needed due to Logout handling in the controller
                 .deleteCookies("JSESSIONID")

                 // A custom logout
                .logoutSuccessUrl("/login?logout=true")
                
                // Note: It may already be taking care of in the ontroller Login/logout
                .invalidateHttpSession(true)

                .permitAll()
             .and()
             
                 // TESTING!!
                 //.portMapper()
                 //.http(8080).mapsTo(8443)
                 //.and()

                // TESTING!!
                // Enable HTTPS on all requests
                //.requiresChannel().anyRequest().requiresSecure()
                //.and()

               // Now csrf is disabled and it is possible to perform logout GET like in link
               // Note: csrf is enabled by default and then logout is performed by POST
               .csrf()
               .disable();
              

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