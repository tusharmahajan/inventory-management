package com.amazon.inventory.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.naming.AuthenticationException;

@Component
public class InventoryInterceptor implements HandlerInterceptor {

    @Value("${auth.username}")
    private String authUser;

    @Value("${auth.password}")
    private String authPassword;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String username = request.getHeader("username");
        String password = request.getHeader("password");

        if(username == null || password == null || !username.equals(authUser) || !password.equals(authPassword)){
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid auth data");
            return false;
        }
        return true;
    }

}
