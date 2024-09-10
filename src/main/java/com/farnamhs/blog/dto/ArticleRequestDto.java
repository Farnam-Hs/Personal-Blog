package com.farnamhs.blog.dto;

public class ArticleRequestDto {

    private final String title;
    private final String content;
    private final String requestFormatPublishDate;

    public ArticleRequestDto(String title, String content, String requestFormatPublishDate) {
        this.title = title;
        this.content = content;
        this.requestFormatPublishDate = requestFormatPublishDate;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getRequestFormatPublishDate() {
        return requestFormatPublishDate;
    }
}
