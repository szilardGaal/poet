package com.codecool.web.service;

import com.codecool.web.model.Art;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public interface ArtService {

    List<Art> getArts() throws SQLException;

    List<Art> getArtByPoetId(int poetId) throws SQLException, ServiceException;

    List<String> getArtTitlesByPoetId(int id) throws SQLException;

    String getPoemByTitle(String title) throws SQLException;

}
