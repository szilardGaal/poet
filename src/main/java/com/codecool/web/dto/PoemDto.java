package com.codecool.web.dto;

public class PoemDto {

    private String title;
    private String content;

    public PoemDto (String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
