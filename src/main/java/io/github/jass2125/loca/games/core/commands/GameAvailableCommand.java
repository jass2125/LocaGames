/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.loca.games.core.commands;

import io.github.jass2125.loca.games.core.dao.GameDao;
import io.github.jass2125.loca.games.core.factory.DaoFactory;
import io.github.jass2125.loca.games.core.util.DaoEnum;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Anderson Souza
 * @since 15:18:13, 24-Feb-2016
 */
public class GameAvailableCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String cpf = request.getParameter("cpf");
        Long idGame = Long.parseLong(request.getParameter("idGame"));
        GameDao dao = (GameDao) DaoFactory.createDao(DaoEnum.GAME.getOption());
        return "devolver.jsp";
    }
}
