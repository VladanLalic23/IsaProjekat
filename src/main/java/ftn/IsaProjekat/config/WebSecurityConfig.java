package ftn.IsaProjekat.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import ftn.IsaProjekat.security.TokenUtils;
import ftn.IsaProjekat.security.auth.RestAuthenticationEntryPoint;
import ftn.IsaProjekat.security.auth.TokenAuthenticationFilter;
import ftn.IsaProjekat.service.UserService;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {
	

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	private UserService jwtUserService;
	
	@Autowired
	private RestAuthenticationEntryPoint restAuthenticationEntryPoint;



	@Bean
	AuthenticationManager authenticationManager(
			AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
	

	
	// Definisemo nacin autentifikacije
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(jwtUserService).passwordEncoder(passwordEncoder());
	}
	
	@Autowired
	private TokenUtils tokenUtils;
	// Definisemo prava pristupa odredjenim URL-ovima
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
        	.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
        	
			.exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint).and()
        	
        	.authorizeRequests().antMatchers("/auth/**").permitAll()

        	.anyRequest().authenticated().and()
        	
        	.cors().and()
        	
        	.addFilterBefore(new TokenAuthenticationFilter(tokenUtils, jwtUserService),
        			BasicAuthenticationFilter.class);
 
        http.csrf().disable();	 

		return http.build();
    }
	 // Generalna bezbednost aplikacije
	@Bean
    public WebSecurityCustomizer webSecurityCustomizer() throws Exception {
		
		return (web)-> web.ignoring().antMatchers(HttpMethod.GET, "/", "/webjars/**", "/*.html", "/favicon.ico", "/**/*.html",			"/**/*.css", "/**/*.js");
	
	}
}