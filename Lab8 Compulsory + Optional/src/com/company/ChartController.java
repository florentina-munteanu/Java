package com.company;

import Singleton.Database;

import java.sql.*;
import java.util.ArrayList;

public class ChartController {
    public void create(String nameAlbum, String nameArtist) throws SQLException {
        try {
            Connection connection = Database.getConnection();
            String count = "select max(id) from charts";
            Statement statement = connection.createStatement();
            ResultSet resultCount = statement.executeQuery(count);
            PreparedStatement preparedStatement = connection.prepareStatement("insert into charts (id, album_name, artist_name, views) values (?, ?, ?, 0)");
            resultCount.next();
            preparedStatement.setObject(1, resultCount.getInt(1) + 1);
            preparedStatement.setObject(2, nameAlbum);
            preparedStatement.setObject(3, nameArtist);
            preparedStatement.executeUpdate();
            connection.commit();
            connection.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }
    public ArrayList<String> getTop() throws SQLException {
        Connection connection = Database.getConnection();
        String artistName;
        ArrayList<String> top = new ArrayList<>();
        int count = 5;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select artist_name from charts order by views desc");
            while (resultSet.next() && count > 0) {
                artistName = resultSet.getString(1);
                top.add(artistName);
                count--;
            }
            resultSet.close();
            connection.close();
            return top;
        } catch (Exception ex) {
            ex.getMessage();
        }
        return null;
    }
}

