package com.kit.pos.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.kit.pos.service.JWTService;
import com.kit.pos.service.impl.UserServiceImpl;

/**
 * @author Zubayer Ahamed
 * @since Jul 24, 2022
 */
@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private JWTService jwtService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		System.out.println("I am in filter now");
		final String authoriazationHeader = request.getHeader("Authorization");

		String username = null;
		String jwt = null;

		if (authoriazationHeader != null && authoriazationHeader.startsWith("Bearer ")) {
			jwt = authoriazationHeader.substring(7);
			username = jwtService.extractUsername(jwt);
		}

		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = this.userService.loadUserByUsername(username);
			if (Boolean.TRUE.equals(jwtService.validateToken(jwt, userDetails))) {
				UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				upat.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(upat);
			}
		}

		filterChain.doFilter(request, response);
	}

}
