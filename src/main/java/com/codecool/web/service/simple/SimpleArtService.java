package com.codecool.web.service.simple;

import com.codecool.web.dao.ArtDao;
import com.codecool.web.model.Art;
import com.codecool.web.service.ArtService;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public final class SimpleArtService implements ArtService {

    private final ArtDao artDao;

    public SimpleArtService(ArtDao artDao) {
        this.artDao = artDao;
    }

    @Override
    public List<Art> getArts() throws SQLException {
        return artDao.findAll();
    }

    @Override
    public List<Art> getArtByPoetId(int id) throws SQLException, ServiceException {
        try {
            return artDao.findByPoetId(id);
        } catch (IllegalArgumentException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

}
