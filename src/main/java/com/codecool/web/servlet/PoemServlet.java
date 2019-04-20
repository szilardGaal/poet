package com.codecool.web.servlet;

import com.codecool.web.dao.ArtDao;
import com.codecool.web.dao.database.DatabaseArtDao;
import com.codecool.web.dto.PoemDto;
import com.codecool.web.service.simple.SimpleArtService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/protected/poem")
public final class PoemServlet extends AbstractServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            ArtDao artDao = new DatabaseArtDao(connection);

            SimpleArtService artService = new SimpleArtService(artDao);
            String title = req.getParameter("title");

            String content = artService.getPoemByTitle(title);

            req.setAttribute("content", content);
            req.setAttribute("title", title);

            doGet(req, resp);
        } catch (SQLException ex) {
            handleSqlError(resp, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String title = (String) req.getAttribute("title");
        String content = (String) req.getAttribute("content");
        PoemDto poemDto = new PoemDto(title, content);
        try {
            sendMessage(resp, HttpServletResponse.SC_OK, poemDto);
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
