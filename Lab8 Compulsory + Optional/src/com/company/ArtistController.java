package com.company;

import Singleton.Database;

import java.sql.*;

public class ArtistController {
    public void create(String name, String country) {
        try {
            Connection connection = Database.getConnection();
            String count = "select count(*) from artists";
            Statement statement = connection.createStatement();
            ResultSet resultCount = statement.executeQuery(count);
            PreparedStatement preparedStatement = connection.prepareStatement("insert into artists values (?,?)");
            resultCount.next();
            preparedStatement.setObject(1, resultCount.getInt(1) + 1);
            preparedStatement.setObject(2, name);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public Integer findByName(String name) throws ClassNotFoundException, SQLException {
        try {
            Connection connection = Database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select id from artists where name='"+ name +"'");
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt(1);
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }
}
