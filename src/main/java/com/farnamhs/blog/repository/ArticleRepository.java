package com.farnamhs.blog.repository;

import com.farnamhs.blog.exception.RepositoryFailException;
import com.farnamhs.blog.model.Article;
import com.farnamhs.blog.util.FileHandler;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class ArticleRepository {

    private final Path directoryPath;

    public ArticleRepository(String directoryPathUri) {
        this.directoryPath = Path.of(directoryPathUri);
    }

    public void saveArticle(Article article) {
        try {
            FileHandler.writeFile(getArticlePath(article), article);
        } catch (IOException e) {
            throw new RepositoryFailException("Failed to save article: " + article.getId(), e);
        }
    }

    public Article getArticleById(String articleId) {
        try {
            return FileHandler.readFile(getArticlePath(articleId), Article.class);
        } catch (IOException e) {
            throw new RepositoryFailException("Failed to get article: " + articleId, e);
        }
    }

    public List<Article> getArticles() {
        try {
            return FileHandler.readAllFiles(directoryPath, Article.class);
        } catch (IOException e) {
            throw new RepositoryFailException("Failed to get all articles", e);
        } catch (RuntimeException e) {
            throw new RepositoryFailException("Failed to get all articles", e);
        }
    }

    public void deleteArticleById(String articleId) {
        try {
            FileHandler.removeFile(getArticlePath(articleId));
        } catch (IOException e) {
            throw new RepositoryFailException("Failed to delete article: " + articleId, e);
        }
    }

    public boolean isArticleNotExists(String articleId) {
        return FileHandler.notExists(getArticlePath(articleId));
    }

    private Path getArticlePath(Article article) {
        return getArticlePath(article.getId());
    }

    private Path getArticlePath(String articleId) {
        return directoryPath.resolve(getArticleFileName(articleId));
    }

    private String getArticleFileName(String articleId) {
        return articleId + ".json";
    }
}
