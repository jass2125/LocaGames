/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.jass2125.locagames.core.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Anderson Souza 
 * @since 15:32:48, 20-Feb-2016 
 * @version 1.0
 */
public interface Command {
    /**
     * 
     * @param request Requisiçao {@link HttpServletRequest} do cliente
     * @param response Reposta {@link HttpServletResponse} do cliente
     * @return URL da pagina de resposta
     */
    public String execute(HttpServletRequest request, HttpServletResponse response);

}
