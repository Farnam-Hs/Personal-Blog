package com.farnamhs.blog.controller.servlet;

import com.farnamhs.blog.service.ArticleService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/article/*")
public class ArticleServlet extends HttpServlet {

    private ArticleService articleService;

    @Override
    public void init() {
        articleService = (ArticleService) getServletContext().getAttribute("articleService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getPathInfo().split("/")[1];

        request.setAttribute("article", articleService.getArticleById(id));

        request.getRequestDispatcher("/pages/article.jsp").forward(request, response);
    }
}
