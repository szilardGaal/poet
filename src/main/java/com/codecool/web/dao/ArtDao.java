package com.codecool.web.dao;

import com.codecool.web.model.Art;

import java.sql.SQLException;
import java.util.List;

public interface ArtDao {

    List<Art> findAll() throws SQLException;

    Art findByPoetId(int poet_id) throws SQLException;

}
