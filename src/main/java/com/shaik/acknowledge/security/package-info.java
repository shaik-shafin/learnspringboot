package com.shaik.acknowledge.security;

/*
 * @author shaik shafin
 * @since 01-02-2025 10:00 PM
 *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *                              SESSION BASED AUTHENTICATION
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * 1. Add dependency in the pom.xml spring-boot-starter-security
 * 2. When you do that it will provide few default behaviours like providing login page
 * 3. And Security filters and userName - user, password - {printed in console}
 * 4. If you want to use provided credentials then add in the application.properties
 * 5. If you don't want to go with default behaviour then add in the AppConfig
 * 6. Add this annotation @EnableWebSecurity to tell spring to use your security filters
 * 7. Add a bean getSecurityFilterChain(HttpSecurity http) in AppConfig as mentioned.
 * 8. Which tell spring to what to use, allow form submission and API call to be authenticated
 * 9. If you want to use you authentication provider then add in the AppConfig
 * 10. add a bean getAuthenticationProvider() in AppConfig
 * 11. which you have declare two properties one is passwordEncoder and other is userDetailsService
 * 12. DaoAuthenticationProvider make use of userDetailsService
 * 13. UserDetailService make use of UserDetails
 * 14. These all are interfaces so you have to implement them to achieve the spring authentication
 * 15. If you want to encrypt the user password then you have to encrypt before saving in to the database
 * 16. {@link AuthRegisterService#register} method and on submitting the credentials you have to decrypt it.
 * 17. {@link AppConfig#getAuthenticationProvider} method and set the passwordEncoder and userDetailsService
 *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*                                  JWT BASED AUTHENTICATION
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * 1. First add three dependencies in the pom.xml those are jjwt-api, jjwt-impl, jjwt-jackson
 * 2. Later declare the AuthenticationManager In AppConfig class and implement the validate functionality in service
 * 3. If user validated then implement the code to generate the jwt token
 * 4. In next step instead of sending the credentials we send the generated jwt token
 * 5. Guess what it won't work, because we have done the part of generating the token
 * 6. But we need to implement token validate functionality to achieve it, add a filter in appConfig class
 * 7. This filter runs before the UsernamePasswordAuthenticationFilter
 * 8. UsernamePasswordAuthenticationFilter is responsible for validating the credentials
 * 9. Before this we have to validate the token create JWTFilter class
 * 10. And handle the logic to check the token validate or not
 * 11. Using the postman either we can pass credentials or we can send the token both will work.
 *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *                                      OAuth2 Login
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * 1. First add dependencies in pom.xml
 * 2. get clientId and clientSecret from google developer console or github
 * 3. add the clientId and clientSecret in the application.properties
 * 4. add authlogic2 filter in appConfig class
 * 5. This feature main purpose of to use other API's logic instead of ours logic form
* */