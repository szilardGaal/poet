package com.codecool.web.servlet;

import com.codecool.web.dao.ArtDao;
import com.codecool.web.dao.database.DatabaseArtDao;
import com.codecool.web.model.Poet;
import com.codecool.web.service.simple.SimpleArtService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/protected/profile")
public final class ProfileServlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            ArtDao artDao = new DatabaseArtDao(connection);

            SimpleArtService artService = new SimpleArtService(artDao);

            Poet poet = (Poet) req.getSession().getAttribute("poet");
            int poetId = poet.getId();
            List<String> titles = artService.getArtTitlesByPoetId(poetId);

            sendMessage(resp, HttpServletResponse.SC_OK, titles);

        } catch (SQLException ex) {
            handleSqlError(resp, ex);
        }
    }
}
