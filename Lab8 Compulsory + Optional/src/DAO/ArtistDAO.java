package DAO;

import Singleton.Database;
import entity.Artist;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ArtistDAO {
    public Artist getArtist(int id){
        try {
            String query="select NAME,COUNTRY from artists where id="+id;
            Artist artist=new Artist();
            artist.setId(id);
            Connection connection= Database.getConnection();
            Statement statement= connection.createStatement();
            ResultSet resultSet= statement.executeQuery("select name, country from artists where id="+id);
            resultSet.next();
            String name= resultSet.getString(1);
            String country= resultSet.getString(2);
            artist.setName(name);
            artist.setCountry(country);
            return artist;
        } catch(Exception ex) { System.out.println(ex); }
        return null;
    }
}
