package DAO;

import Singleton.Database;
import entity.Chart;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ChartDAO {
    public Chart getChart (int id) {
        try {
            Chart chart = new Chart();
            chart.setId(id);
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select album_name, artist_name, likes from charts where id="+id);
            resultSet.next();
            String albumName = resultSet.getString(1);
            String artistName = resultSet.getString(2);
            int views = resultSet.getInt(3);
            chart.setAlbumName(albumName);
            chart.setArtistName(artistName);
            chart.setViews(views);
            return chart;
        } catch (Exception ex) { System.out.println(ex); }
        return null;
    }
}
