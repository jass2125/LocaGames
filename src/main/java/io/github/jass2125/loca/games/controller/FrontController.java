/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.loca.games.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import io.github.jass2125.loca.games.core.actions.Command;

/**
 * @author Anderson Souza
 * @since 15:31:16, 20-Feb-2016
 * @version 1.0
 *
 */
@WebServlet(urlPatterns = {"/front"})
public class FrontController extends HttpServlet {

    /**
     * Recebe todas as requisições do cliente e depois redireciona para página
     * específica
     *
     * @param request Requisição do cliente
     * @param response Resposta do cliente
     * @throws ServletException if the HTTP request cannot be handled
     * @throws IOException Se ocorrrer algum erro de entrada e saída enquanto o
     * servlet for tratar a requisiçao HTTP
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Command command = CommandFactory.getCommand(request);
        String view = command.execute(request, response);
        response.sendRedirect(view);
    }
}
