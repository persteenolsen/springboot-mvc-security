A Java Spring Boot MVC Web Application secured by login and Spring Security

This Java Spring Boot MVC Web application ( Spring Security ) was made by the following technology: 

Last updated: 22-01-2025

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
