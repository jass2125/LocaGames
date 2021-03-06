/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.locagames.core.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Anderson Souza
 *
 */
public class LogoutCommand implements Command {

    /**
     * Finaliza a sessão do cliente
     *
     * @param request Requisiçao {@link HttpServletRequest} do cliente
     * @param response Reposta {@link HttpServletResponse} do cliente
     * @return URL da pagina de resposta
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        session.removeAttribute("user");
        session.removeAttribute("success");
        session.removeAttribute("listGames");
        session.removeAttribute("listLocations");
        session.removeAttribute("price");
        session.removeAttribute("info");
        session.removeAttribute("error");
        session.invalidate();
        return "home.jsp";
    }

}
