/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.loca.games.core.business;

import java.io.Serializable;

/**
 * @author Anderson Souza
 * @since 14:17:38, 20-Feb-2016
 */
public class Game implements Serializable {

    private Long idGame;
    private String name;
    private String gender;
    private String state;

    public Game() {
//        state = GameStateEnum.getAVAILABLE();
    }

    public Game(Long idGame, String name, String gender, String state) {
        this.idGame = idGame;
        this.name = name;
        this.gender = gender;
        this.state = state;
    }

    public Long getIdGame() {
        return idGame;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
