package ftn.IsaProjekat.security.auth;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import ftn.IsaProjekat.security.TokenUtils;

//Filter that will intercept client requests to the server
//Except the paths that are specified in WebSecurityConfig.configure(WebSecurity web)
public class TokenAuthenticationFilter extends OncePerRequestFilter{

	private TokenUtils tokenUtils;

	private UserDetailsService userDetailsService;

	public TokenAuthenticationFilter(TokenUtils tokenHelper, UserDetailsService userDetailsService) {
		this.tokenUtils = tokenHelper;
		this.userDetailsService = userDetailsService;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
			String email;
			String authToken = tokenUtils.getToken(request);
			
			if (authToken != null) {
				email = tokenUtils.getEmailFromToken(authToken);
				if (email != null) {
					UserDetails userDetails = userDetailsService.loadUserByUsername(email);
					if (tokenUtils.validateToken(authToken, userDetails)) {
						TokenBasedAuthentication authentication = new TokenBasedAuthentication(userDetails);
						authentication.setToken(authToken);
						SecurityContextHolder.getContext().setAuthentication(authentication);
					}
				}
			}
			
			chain.doFilter(request, response);
		}
}