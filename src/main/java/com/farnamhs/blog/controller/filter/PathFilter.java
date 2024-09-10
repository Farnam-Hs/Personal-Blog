package com.farnamhs.blog.controller.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static jakarta.servlet.http.HttpServletResponse.*;

@WebFilter(urlPatterns = {"/article", "/article/", "/edit", "/edit/", "/delete", "/delete/", "/pages/*"})
public class PathFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException {
        response.sendError(SC_BAD_REQUEST);
    }
}