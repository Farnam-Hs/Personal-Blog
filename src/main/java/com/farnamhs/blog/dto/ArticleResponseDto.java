package com.farnamhs.blog.dto;

public class ArticleResponseDto {

    private final String id;
    private final String title;
    private final String content;
    private final String responseFormatPublishDate;

    public ArticleResponseDto(String id, String title, String content, String responseFormatPublishDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.responseFormatPublishDate = responseFormatPublishDate;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getResponseFormatPublishDate() {
        return responseFormatPublishDate;
    }
}
