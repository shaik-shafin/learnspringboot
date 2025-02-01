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
* */