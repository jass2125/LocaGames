/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.jass2125.loca.games.core.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Anderson Souza 
 * @since 15:32:48, 20-Feb-2016 
 */
public interface Command {
    
    public String execute(HttpServletRequest request, HttpServletResponse response);

}
