package com.codecool.web.service;

import com.codecool.web.model.Poet;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;

public interface LoginService {

    Poet loginUser(String name, String password) throws SQLException, ServiceException;
}
