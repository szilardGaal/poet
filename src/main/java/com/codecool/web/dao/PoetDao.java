package com.codecool.web.dao;

import com.codecool.web.model.Poet;

import java.sql.SQLException;

public interface PoetDao {

    Poet findByName(String name) throws SQLException;
}
