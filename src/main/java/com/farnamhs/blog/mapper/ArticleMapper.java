package com.farnamhs.blog.mapper;

import com.farnamhs.blog.dto.ArticleRequestDto;
import com.farnamhs.blog.dto.ArticleResponseDto;
import com.farnamhs.blog.model.Article;

import java.time.LocalDate;

import static com.farnamhs.blog.util.LocalDateFormatter.*;

public class ArticleMapper {

    public static Article toEntity(ArticleRequestDto articleRequestDto) {
        String title = articleRequestDto.getTitle();
        String content = articleRequestDto.getContent();
        LocalDate publishDate = parseFromRequest(articleRequestDto.getRequestFormatPublishDate());
        return new Article(title, content, publishDate);
    }

    public static Article toEntity(Article article, ArticleRequestDto articleRequestDto) {
        article.setTitle(articleRequestDto.getTitle());
        article.setContent(articleRequestDto.getContent());
        article.setPublishDate(parseFromRequest(articleRequestDto.getRequestFormatPublishDate()));
        return article;
    }

    public static ArticleResponseDto toDto(Article article) {
        String id = article.getId();
        String title = article.getTitle();
        String content = article.getContent();
        String responseFormatPublishDate = formatToResponse(article.getPublishDate());
        return new ArticleResponseDto(id, title, content, responseFormatPublishDate);
    }
}
