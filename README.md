A Java Spring Boot 2 MVC Web Application secured by login and Spring Security

This Java Spring Boot MVC Web application ( Spring Security ) was made by the following technology: 

Last updated: 30-01-2025

- Running by Java Version 11 
- Tested with Java 17 on the Dev PC but with Java 11 in pom.xml
- Spring Boot 2 
- springboot-mvc-security at GitHub
- Visual Studio Code with the Microsoft Java Extension Pack
- Microsoft Azure App Service with a Free App Service Plan for web hosting
- MS SQL Database
- Spring Security for protecting some of the views by a Login
- Spring Boot Security Bcrypt Encoder for encoding password based on the
  Blowfish cipher that generates a random salt while encoding passwords on a String
  value with a lenght 60. Then the password are not stored in pain text!
- MVC as well as a Service and JPA Repository layer
- Maven as build tool
- Hibernate for initializing the Database and implement JPA
- Hibernate Validator and Apache Commons Validater for server side form validation
- JSP for the View part ( GUI )
- Bootstrap for the responsive design


# Config at Azure App Service

- Java 11
- Tomecat 8.5
- Copy the ROOT.war to wwwroot - webapps ( Stop / Start the Web App by Azure Portal )

# Usage

- Download or fork the source code from GitHub

# Create the file application.properties with the content below and place the file in the resources folder

spring.datasource.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver
 
spring.datasource.url=jdbc:sqlserver:// The name of the MySQL server;
databaseName= The name of the Database

spring.datasource.username= The username of the MySQL server

spring.datasource.password= The password of the MySQL server

spring.jpa.hibernate.ddl-auto = none

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.SQLServer2012Dialect

spring.jpa.properties.hibernate.id.new_generator_mappings=false

spring.jpa.properties.hibernate.format_sql=true

spring.mvc.view.prefix: /WEB-INF/jsp/

spring.mvc.view.suffix: .jsp
