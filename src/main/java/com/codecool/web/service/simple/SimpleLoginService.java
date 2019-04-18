package com.codecool.web.service.simple;

import com.codecool.web.dao.PoetDao;
import com.codecool.web.model.Poet;
import com.codecool.web.service.LoginService;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;

public final class SimpleLoginService implements LoginService {

    private final PoetDao poetDao;

    public SimpleLoginService(PoetDao userDao) {
        this.poetDao = userDao;
    }

    @Override
    public Poet loginUser(String name, String password) throws SQLException, ServiceException {
        try {
            Poet poet = poetDao.findByName(name);
            if (poet == null || !poet.getPassword().equals(password)) {
                throw new ServiceException("Bad login");
            }
            return poet;
        } catch (IllegalArgumentException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }
}
