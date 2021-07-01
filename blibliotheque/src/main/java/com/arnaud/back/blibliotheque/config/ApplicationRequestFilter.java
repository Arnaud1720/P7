package com.arnaud.back.blibliotheque.config;

import com.arnaud.back.blibliotheque.auth.JwtUtils;
import com.arnaud.back.blibliotheque.services.auth.ApplicationUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class ApplicationRequestFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    ApplicationUserDetailsService applicationUserDetailsService;
    @Override

    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        /**
         * recupere    le header avec la valeur qui s'appel Authorization
         */
        final String authHeader = request.getHeader("Authorization");
        String mail = null;
        String jwt= authHeader;
        /**
         *
         */
        if(StringUtils.hasLength(authHeader)&& authHeader.startsWith("Bearer ")){

            jwt = jwt.substring(7);
            mail = jwtUtils.extractUsername(jwt);
        }
        if(StringUtils.hasLength(mail)&& SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails userDetails = applicationUserDetailsService.loadUserByUsername(mail);
            if(jwtUtils.validateToken(jwt,userDetails)){
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities()
                        );
                usernamePasswordAuthenticationToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }

        }
        chain.doFilter(request,response);
    }
}
