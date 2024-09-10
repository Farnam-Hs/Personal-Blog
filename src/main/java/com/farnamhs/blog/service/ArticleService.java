package com.farnamhs.blog.service;

import com.farnamhs.blog.dto.ArticleRequestDto;
import com.farnamhs.blog.dto.ArticleResponseDto;
import com.farnamhs.blog.exception.NoSuchArticleException;
import com.farnamhs.blog.model.Article;
import com.farnamhs.blog.repository.ArticleRepository;
import com.farnamhs.blog.mapper.ArticleMapper;

import java.util.List;

import static com.farnamhs.blog.mapper.ArticleMapper.*;

import static java.time.LocalDate.*;

public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public void addArticle(ArticleRequestDto newArticle) {
        articleRepository.saveArticle(toEntity(newArticle));
    }

    public ArticleResponseDto getArticleById(String articleId) {
        return toDto(getArticleFromRepositoryById(articleId));
    }

    public List<ArticleResponseDto> getAllArticles() {
        return articleRepository.getArticles().stream()
                .sorted()
                .map(ArticleMapper::toDto)
                .toList();
    }

    public List<ArticleResponseDto> getPresentArticles() { // Articles with before today's publish date
        return articleRepository.getArticles().stream()
                .filter(article -> !article.getPublishDate().isAfter(now()))
                .sorted()
                .map(ArticleMapper::toDto)
                .toList();
    }

    public void updateArticleById(String articleId, ArticleRequestDto updatedArticle) {
        articleRepository.saveArticle(toEntity(getArticleFromRepositoryById(articleId), updatedArticle));
    }

    public void deleteArticleById(String articleId) {
        checkArticleExistence(articleId);
        articleRepository.deleteArticleById(articleId);
    }

    private Article getArticleFromRepositoryById(String articleId) {
        checkArticleExistence(articleId);
        return articleRepository.getArticleById(articleId);
    }

    private void checkArticleExistence(String articleId) {
        if (articleRepository.isArticleNotExists(articleId))
            throw new NoSuchArticleException();
    }
}
