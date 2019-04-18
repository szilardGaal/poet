package com.codecool.web.dto;

import com.codecool.web.model.Art;
import com.codecool.web.model.Poet;

import java.util.List;

public final class ContentDto {

    private final List<Art> arts;
    private final Poet poet;


    public ContentDto(List<Art> arts, Poet poet) {
        this.arts = arts;
        this.poet = poet;
    }

    public List<Art> getArts() {
        return arts;
    }

    public Poet getPoet() {
        return poet;
    }
}


