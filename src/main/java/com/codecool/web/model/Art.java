package com.codecool.web.model;

import java.util.Objects;

public final class Art extends AbstractModel {

    private final String title;
    private final String content;
    private final int poetId;

    public Art(int id, String title, String content, int poetId) {
        super(id);
        this.title = title;
        this.content = content;
        this.poetId = poetId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getPoetId() {
        return poetId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), title, poetId);
    }
}
