package com.codecool.web.dao.database;

import com.codecool.web.dao.ArtDao;
import com.codecool.web.model.Art;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public final class DatabaseArtDao extends AbstractDao implements ArtDao {

    public DatabaseArtDao(Connection connection) {
        super(connection);
    }

    @Override
    public String findPoemByTitle(String title) throws SQLException {
        String content = "";
        String sql = "SELECT title, content FROM arts WHERE title = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, title);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    content = resultSet.getString("content");
                }
            }
        }
        return content;
    }

    @Override
    public List<String> findArtTitlesByPoetId(int poet_id) throws SQLException {
        List<String> titles = new ArrayList<>();
        String sql = "SELECT poet_id, title FROM arts WHERE poet_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, poet_id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    titles.add(resultSet.getString("title"));
                }
            }
        }
        return titles;
    }

    @Override
    public List<Art> findAll() throws SQLException {
        List<Art> arts = new ArrayList<>();
        String sql = "SELECT id, title, content, poet_id FROM Arts";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                arts.add(fetchArt(resultSet));
            }
        }
        return arts;
    }

    @Override
    public List<Art> findByPoetId(int poet_id) throws SQLException {
        List<Art> arts = new ArrayList<>();
        String sql = "SELECT id, poet_id, title, content FROM Arts WHERE poet_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, poet_id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    arts.add(fetchArt(resultSet));
                }
            }
        }
        return arts;
    }

    private Art fetchArt(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String title = resultSet.getString("title");
        String content = resultSet.getString("content");
        int poet_id = resultSet.getInt("poet_id");
        return new Art(id, title, content, poet_id);
    }
}
