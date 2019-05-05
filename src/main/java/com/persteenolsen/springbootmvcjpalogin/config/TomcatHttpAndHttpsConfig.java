package com.persteenolsen.springbootmvcjpalogin.config;

import org.apache.catalina.connector.Connector;

//import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
//import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;


import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;

import org.springframework.context.annotation.Configuration;

// Used when @Bean are enabled !!!
//import org.springframework.context.annotation.Bean;

@Configuration
public class TomcatHttpAndHttpsConfig {

   // Note: When enabling @Bean notation here and disable @Bean in 
   // "TomcatRedirectHttpToHttpsConfig.java" then both HTTP AND HTTPS are served!!!
   // @Bean
    public ServletWebServerFactory servletContainer(){
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory ();
        tomcat.addAdditionalTomcatConnectors(httpConnector());
        return tomcat;
    }

    private Connector httpConnector(){
        Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
        connector.setScheme("http");
        connector.setPort(8080);
        connector.setSecure(false);
        return connector;
    }
}
