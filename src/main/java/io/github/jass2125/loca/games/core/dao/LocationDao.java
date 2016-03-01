/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.loca.games.core.dao;

import io.github.jass2125.loca.games.core.business.Location;
import io.github.jass2125.loca.games.core.factory.IDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Anderson Souza
 * @since 13:49:16, 24-Feb-2016
 */
public class LocationDao implements IDao {

    private String url;

    public LocationDao() {
        this.url = "jdbc:mysql://localhost:3306/locagames";
    }

    public void save(Location location) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, "root", "12345");
        String sql = "insert into location(idUser, idGame, dateLocation, dateDevolution, strategy) values(?, ? ,? ,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, location.getIdUser());
        preparedStatement.setLong(2, location.getIdGame());
        preparedStatement.setString(3, location.getDateLocation().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        preparedStatement.setString(4, location.getDateDevolution().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        preparedStatement.setString(5, location.getStrategy());
        preparedStatement.execute();
    }

    public List<Location> listLocations() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, "root", "12345");
        String sql = "select * from location;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resulSet = preparedStatement.executeQuery();
        List<Location> listGames = new ArrayList<>();
        Location location = null;
        while (resulSet.next()) {
            Long idLocation = resulSet.getLong("idLocation");
            String idUser = resulSet.getString("idUser");
            Long idGame = resulSet.getLong("idGame");
            LocalDate dateLocation = resulSet.getDate("dateLocation").toLocalDate();
            LocalDate dateDevolution = resulSet.getDate("dateDevolution").toLocalDate();
            String strategy = resulSet.getString("strategy");
            location = new Location(idLocation, idUser, idGame, dateLocation, dateDevolution, strategy);
            listGames.add(location);
        }
        return listGames;
    }

//    public List<Long> listLocationsByUser(String cpf) throws SQLException, ClassNotFoundException{
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection connection = DriverManager.getConnection(url, "root", "12345");
//        String sql = "select idGame from location where idUser = ?;";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setString(1, cpf);
//        ResultSet resultSet = preparedStatement.executeQuery();
//        List<Long> listGames = new ArrayList<>();
//        
//        while (resultSet.next()) {
//            Long idGame = resultSet.getLong("idGame");
//            listGames.add(idGame);
//        }
//        return listGames;
//    }
}
