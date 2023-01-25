package ftn.IsaProjekat.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import ftn.IsaProjekat.security.TokenUtils;
import ftn.IsaProjekat.security.auth.RestAuthenticationEntryPoint;
import ftn.IsaProjekat.security.auth.TokenAuthenticationFilter;
import ftn.IsaProjekat.service.UserService;


@Configuration
//Enable annotation "@Pre*" & "@Post*" which are going to check authorization for every method access
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	//Implementing of PasswordEncoder with BCrypt hashing function
	//BCrypt by default does 10 rounds of forwarded value hashing.
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//Service which is used for reading data about application users
	@Autowired
	private UserService jwtUserDetailsService;
	
	//Handler for returning 401 when client with incorrect username and password tries to access the resource
	@Autowired
	private RestAuthenticationEntryPoint restAuthenticationEntryPoint;
	
	//We register an authentication manager who is going to do user authentication for us
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	//We define instructions for the authentication manager which service uses to extract data about the user who wants to be authenticated,
    //as well as through which encoder is going to pass the password received from the client in the request to compare the adequate hash obtained as a result of the bcrypt algorithm with the one in the database
	//We dont have plain password in the database
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
	}
	
	//We inject an implementation from the TokenUtils class so we can use its methods to work with JWT in the TokenAuthenticationFilter
	@Autowired
	private TokenUtils tokenUtils;
	
	//ACCES TO SPECIFIC URL'S
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        	//REST application
        	.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
        	
        	//Send a 401 error for every unathorized request
        	.exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint).and()
        	//Allow all users to access defined paths
        	.authorizeRequests().antMatchers("/auth/**").permitAll()
			.antMatchers("/clinic/all").permitAll()

        	//For every other request the user must be authenticated 
        	.anyRequest().authenticated().and()
        	
        	//For development purposes include configuration for CORS from the WebConfig class
        	.cors().and()
        	
        	//Insert custom filter TokenAuthenticationFilter to check JWT tokens instead of pure username and password (performed by BasicAuthenticationFilter)
        	.addFilterBefore(new TokenAuthenticationFilter(tokenUtils, jwtUserDetailsService),
        			BasicAuthenticationFilter.class);
        //Due to simplicity of the example	
        http.csrf().disable();	 
    }
	
	//GENERAL SECURITY OF THE APPLICATION
	@Override
    public void configure(WebSecurity web) throws Exception {
		
		web.ignoring().antMatchers(HttpMethod.GET, "/", "/webjars/**", "/*.html", "/favicon.ico", "/**/*.html",
				"/**/*.css", "/**/*.js");
	}
}