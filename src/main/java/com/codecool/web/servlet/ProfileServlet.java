package com.codecool.web.servlet;

import com.codecool.web.dao.ArtDao;
import com.codecool.web.dao.PoetDao;
import com.codecool.web.dao.database.DatabaseArtDao;
import com.codecool.web.dao.database.DatabasePoetDao;
import com.codecool.web.dto.ContentDto;
import com.codecool.web.model.Art;
import com.codecool.web.model.Poet;
import com.codecool.web.service.LoginService;
import com.codecool.web.service.exception.ServiceException;
import com.codecool.web.service.simple.SimpleArtService;
import com.codecool.web.service.simple.SimpleLoginService;

import javax.servlet.ServletException;
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
            List<Art> arts = artService.getArtByPoetId(poetId);

            ContentDto pack = new ContentDto(arts, poet);

            sendMessage(resp, HttpServletResponse.SC_OK, pack);

        } catch (ServiceException ex) {
            sendMessage(resp, HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage());
        } catch (SQLException ex) {
            handleSqlError(resp, ex);
        }
    }
}
