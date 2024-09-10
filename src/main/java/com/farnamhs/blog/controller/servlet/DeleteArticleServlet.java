package com.farnamhs.blog.controller.servlet;

import com.farnamhs.blog.service.ArticleService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/delete/*")
public class DeleteArticleServlet extends HttpServlet {

    private ArticleService articleService;

    @Override
    public void init() {
        articleService = (ArticleService) getServletContext().getAttribute("articleService");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        articleService.deleteArticleById(request.getPathInfo().split("/")[1]);

        request.getSession().setAttribute("message", "Article deleted successfully");

        response.sendRedirect(request.getContextPath() + "/admin");
    }
}
