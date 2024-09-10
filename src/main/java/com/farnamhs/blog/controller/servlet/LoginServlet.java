package com.farnamhs.blog.controller.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import static java.lang.Boolean.TRUE;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin";
    private static final String IS_ADMIN_ATTRIBUTE = "isAdmin";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (isAdmin(request.getSession(false))) {
            response.sendRedirect("/admin");
        } else {
            request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username"), password = request.getParameter("password");

        if (username.stripTrailing().equals(ADMIN_USERNAME) && password.stripTrailing().equals(ADMIN_PASSWORD)) {
            HttpSession session = request.getSession();
            session.setAttribute(IS_ADMIN_ATTRIBUTE, true);
            response.sendRedirect(request.getContextPath() + "/admin");
        } else {
            request.setAttribute("loginError", "Invalid username or password.");
            request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
        }
    }

    private boolean isAdmin(HttpSession session) {
        return session != null
                && session.getAttribute(IS_ADMIN_ATTRIBUTE) != null
                && session.getAttribute(IS_ADMIN_ATTRIBUTE).equals(TRUE);
    }
}
