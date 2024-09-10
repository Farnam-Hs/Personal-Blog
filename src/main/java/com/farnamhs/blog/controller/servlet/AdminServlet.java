package com.farnamhs.blog.controller.servlet;

import com.farnamhs.blog.service.ArticleService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

    private ArticleService articleService;

    @Override
    public void init() {
        articleService = (ArticleService) getServletContext().getAttribute("articleService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("articles", articleService.getAllArticles());

        request.getRequestDispatcher("/pages/dashboard.jsp").forward(request, response);

        request.getSession().removeAttribute("message");
    }
}
