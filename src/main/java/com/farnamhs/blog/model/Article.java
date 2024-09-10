package com.farnamhs.blog.model;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

import static java.time.LocalDate.MIN;

public class Article implements Comparable<Article> {

    private static final String EMPTY_CONTENT_VALUE = "No Content";
    private static final String EMPTY_TITLE_VALUE = "No Title";

    private final String id;
    private String title;
    private String content;
    private LocalDate publishDate;

    public Article(String title, String content, LocalDate publishDate) {
        this.id = UUID.randomUUID().toString();
        this.title = getValidTitle(title);
        this.content = getValidContent(content);
        this.publishDate = Objects.requireNonNullElse(publishDate, MIN);
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = getValidTitle(title);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = getValidContent(content);
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = Objects.requireNonNullElse(publishDate, MIN);
    }

    @Override
    public int compareTo(Article other) {
        return other.publishDate.compareTo(this.publishDate);
    }

    private String getValidTitle(String title) {
        String validTitle = Objects.requireNonNullElse(title, EMPTY_TITLE_VALUE).strip();
        return (validTitle.isEmpty()) ? EMPTY_TITLE_VALUE : validTitle;
    }

    private String getValidContent(String content) {
        String validContent = Objects.requireNonNullElse(content, EMPTY_CONTENT_VALUE).strip();
        return (validContent.isEmpty()) ? EMPTY_CONTENT_VALUE : validContent;
    }
}
