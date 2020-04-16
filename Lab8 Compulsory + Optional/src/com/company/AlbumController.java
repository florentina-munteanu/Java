package com.company;

import Singleton.Database;

import java.sql.*;

public class AlbumController {
    public void create(String name, int artistId, int releaseYear) throws SQLException {
        try {
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultCount = statement.executeQuery("select count(*) from albums");
            PreparedStatement preparedStatement = connection.prepareStatement("insert into albums values(?,?,?)");
            resultCount.next();
            preparedStatement.setObject(1, resultCount.getInt(1) + 1);
            preparedStatement.setObject(2, name);
            preparedStatement.setObject(3, artistId);
            preparedStatement.setObject(4, releaseYear);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
        }

        public Integer findByArtist (int artistId) throws SQLException{
            try {
                Connection connection = Database.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("select name from albums where id=" + artistId);
                preparedStatement.setObject(1, artistId);
                ResultSet resultSet = preparedStatement.executeQuery();
                Integer id = resultSet.next() ? resultSet.getInt(1) : null;
                resultSet.close();
                connection.close();
                return id;
        }
    }
}