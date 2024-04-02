package com.example.ovi.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.ovi.dao.UserDao;

@org.springframework.context.annotation.Configuration
@EnableMethodSecurity
public class Configuration {
	
	@Autowired
	UserDao udao;
	
	 
	
	

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService getdetailservice() {

		return new CustomUserdetailService();
	}

	@Bean
	public DaoAuthenticationProvider authenticationprovider() {
		DaoAuthenticationProvider authenticationprovider = new DaoAuthenticationProvider();
		authenticationprovider.setUserDetailsService(getdetailservice());
		authenticationprovider.setPasswordEncoder(passwordEncoder());

		return authenticationprovider;

	}

	@Bean

	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		
		  http.authorizeHttpRequests( (authorize) ->
		  authorize.requestMatchers("/").permitAll().anyRequest().authenticated())
		  .httpBasic(Customizer.withDefaults()).formLogin(Customizer.withDefaults());
		  
		  return http.build();
		 
		 
		
			/*
			 * return http .httpBasic(AbstractHttpConfigurer::disable)
			 * .cors(Customizer.withDefaults()) .csrf(AbstractHttpConfigurer::disable)
			 * .authorizeHttpRequests(c ->
			 * c.requestMatchers("/register").permitAll().requestMatchers("/users").
			 * hasAnyAuthority("USER", "ADMIN")) .formLogin().disable() .build();
			 */
		
		

	}
}


/*
 * @Bean public ObjectMapper objectMapper() { ObjectMapper objectMapper = new
 * ObjectMapper();
 * 
 * // Disable FAIL_ON_EMPTY_BEANS
 * objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
 * 
 * // Optionally, you can disable other features if needed
 * objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
 * 
 * return objectMapper; }
 */
/*
 * @Bean public SecurityFilterChain filterChain(HttpSecurity http) throws
 * Exception { http.authorizeHttpRequests( auth -> auth
 * .requestMatchers("*").permitAll() .anyRequest().authenticated())
 * .httpBasic(null).formLogin(null) .csrf() return http.build();
 */
/*
 * .requestMatchers("/user/**","/apps/**").hasAuthority("ADMIN")
 * .requestMatchers("/gfdfgfdg/**").hasAnyAuthority("CLIENT")
 */

/*
 * @Bean public SecurityFilterChain filterChain(HttpSecurity http) throws
 * Exception { http.authorizeHttpRequests((authorize) ->
 * authorize.requestMatchers("/").permitAll()
 * .anyRequest().authenticated()).httpBasic(Customizer.withDefaults())
 * .formLogin(Customizer.withDefaults());
 * 
 * return http.build();
 * 
 * }
 */

/*
 * @Bean public UserDetailsService userDetailsService() {
 * 
 * 
 * return (UserDetailsService) new UserService(); }
 * 
 * 
 * 
 * 
 * 
 * @Bean public AuthenticationProvider authenticationManager(UserDetailsService
 * userDetailsService, PasswordEncoder passwordEncoder) {
 * DaoAuthenticationProvider authenticationProvider = new
 * DaoAuthenticationProvider();
 * authenticationProvider.setUserDetailsService(userDetailsService);
 * authenticationProvider.setPasswordEncoder(passwordEncoder);
 * 
 * return authenticationProvider; }
 * 
 * @Bean public PasswordEncoder passwordEncoder() { return new
 * BCryptPasswordEncoder(); }
 */
