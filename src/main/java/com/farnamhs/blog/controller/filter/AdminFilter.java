package com.farnamhs.blog.controller.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import static java.lang.Boolean.*;

@WebFilter(urlPatterns = {"/admin", "/new", "/edit/*", "/delete/*"})
public class AdminFilter extends HttpFilter {

    public static final String IS_ADMIN = "isAdmin";

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (isAdmin(request.getSession(false))) {
            chain.doFilter(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }

    private boolean isAdmin(HttpSession session) {
        return session != null && session.getAttribute(IS_ADMIN) != null && session.getAttribute(IS_ADMIN).equals(TRUE);
    }
}
