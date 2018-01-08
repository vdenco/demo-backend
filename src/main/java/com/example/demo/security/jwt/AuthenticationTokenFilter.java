package com.example.demo.security.jwt;

import com.example.demo.security.SecurityUserDetails;
import com.example.demo.users.UserModel;
import jdk.nashorn.internal.parser.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class AuthenticationTokenFilter extends UsernamePasswordAuthenticationFilter{

    @Autowired
    TokenUtils tokenUtils;

    @Autowired
    SecurityUserDetails securityUserDetails;

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req ;

        String authToken = httpServletRequest.getHeader(TokenUtils.TOKEN_HEADER);

        System.out.println("AUTH TOKEN   " + authToken);

        String login = null;

        try {
            if(authToken != null){
                login = this.tokenUtils.getUsernameFromToken(authToken);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        if(login != null && SecurityContextHolder.getContext().getAuthentication() != null){

            UserModel userModel = null;

            try{

                userModel = (UserModel) this.securityUserDetails.loadUserByUsername(login);

            }catch (Exception e){
                e.printStackTrace();
            }

            if(this.tokenUtils.validadeToken(authToken, userModel)){
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userModel, null);

                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));

                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
        chain.doFilter(req, res);
    }
}
