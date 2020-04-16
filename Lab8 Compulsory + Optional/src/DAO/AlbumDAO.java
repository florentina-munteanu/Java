package DAO;

import Singleton.Database;
import entity.Album;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AlbumDAO {
    public Album getAlbum(int id) {
        try {
            Album album = new Album();
            album.setId(id);
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select name, artist_id, release_year from ALBUMS where id=" + id);
            resultSet.next();
            String name = resultSet.getString(1);
            int artistId = resultSet.getInt(2);
            int releaseYear = resultSet.getInt(3);
            album.setName(name);
            album.setArtistId(artistId);
            album.setReleaseYear(releaseYear);
            album.setArtistName(this.getAlbumArtistId(album.getId()));
            return album;
        } catch (Exception ex) { System.out.println(ex); }
        return null;
    }

    public String getAlbumArtistId(int albumId) throws SQLException {
        try {
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select name from Artists where id=" + albumId);
            resultSet.next();
            return resultSet.getString(1);
        } catch (Exception ex) { System.out.println(ex); }
        return null;
    }
}