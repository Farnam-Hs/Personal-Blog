package com.farnamhs.blog.config;

import com.farnamhs.blog.repository.ArticleRepository;
import com.farnamhs.blog.service.ArticleService;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class WebAppConfig implements ServletContextListener {

    private static final String REPOSITORY_DIRECTORY_PATH = "/articles";

    @Override
    public void contextInitialized(ServletContextEvent contextEvent) {
        RepositoryInitializer.initialize(REPOSITORY_DIRECTORY_PATH);

        ArticleService articleService = new ArticleService(new ArticleRepository(REPOSITORY_DIRECTORY_PATH));

        contextEvent.getServletContext().setAttribute("articleService", articleService);
    }

}
