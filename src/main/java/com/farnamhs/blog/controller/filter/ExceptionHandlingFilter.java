package com.farnamhs.blog.controller.filter;

import com.farnamhs.blog.exception.NoSuchArticleException;
import com.farnamhs.blog.exception.RepositoryFailException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static jakarta.servlet.http.HttpServletResponse.*;

@WebFilter("/*")
public class ExceptionHandlingFilter extends HttpFilter {

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException {
        try {
            chain.doFilter(request, response);
        } catch (NoSuchArticleException e) {
            response.sendError(SC_NOT_FOUND, "Article Not Found");
        } catch (RepositoryFailException e) {
            response.sendError(SC_INTERNAL_SERVER_ERROR, "Repository Fail");
            e.printStackTrace();
        } catch (ServletException e) {
            response.sendError(SC_INTERNAL_SERVER_ERROR, "Servlet Error");
            e.printStackTrace();
        } catch (Exception e) {
            response.sendError(SC_INTERNAL_SERVER_ERROR, "Internal Server Error");
            e.printStackTrace();
        }
    }
}
