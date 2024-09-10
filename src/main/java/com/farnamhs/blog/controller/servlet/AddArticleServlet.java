package com.farnamhs.blog.controller.servlet;

import com.farnamhs.blog.dto.ArticleRequestDto;
import com.farnamhs.blog.service.ArticleService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/new")
public class AddArticleServlet extends HttpServlet {

    private ArticleService articleService;

    @Override
    public void init() {
        articleService = (ArticleService) getServletContext().getAttribute("articleService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/pages/add.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title = request.getParameter("title");
        String publishDate = request.getParameter("publishDate");
        String content = request.getParameter("content");

        articleService.addArticle(new ArticleRequestDto(title, content, publishDate));

        request.getSession().setAttribute("message", "Article added successfully");

        response.sendRedirect(request.getContextPath() + "/admin");
    }
}
