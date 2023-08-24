package uz.shakh.apprestjwt.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JWTFilter extends OncePerRequestFilter {

    @Autowired
     JWTProvider jwtProvider;

    @Override
    protected void doFilterInternal(
                                    HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String authorization = request.getHeader("Authorization");
        if (authorization != null && authorization.startsWith("Bearer")){
            authorization = authorization.substring(7);
            boolean validateToken = jwtProvider.validateToken(authorization);
            if (validateToken){
                String usernameFromToken = jwtProvider.getUsernameFromToken(authorization);
                System.out.println(usernameFromToken);
            }
        }
    }
}
