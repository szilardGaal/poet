package com.codecool.web.servlet;

import com.codecool.web.dao.PoetDao;
import com.codecool.web.dao.database.DatabasePoetDao;
import com.codecool.web.model.Poet;
import com.codecool.web.service.LoginService;
import com.codecool.web.service.exception.ServiceException;
import com.codecool.web.service.simple.SimpleLoginService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/login")
public final class LoginServlet extends AbstractServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            PoetDao userDao = new DatabasePoetDao(connection);
            LoginService loginService = new SimpleLoginService(userDao);

            String name = req.getParameter("name");
            String password = req.getParameter("password");

            Poet poet = loginService.loginUser(name, password);
            req.getSession().setAttribute("poet", poet);

            sendMessage(resp, HttpServletResponse.SC_OK, poet);
        } catch (ServiceException ex) {
            sendMessage(resp, HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage());
        } catch (SQLException ex) {
            handleSqlError(resp, ex);
        }
    }
}
