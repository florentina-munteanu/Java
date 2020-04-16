package com.company;

import DAO.AlbumDAO;
import DAO.ArtistDAO;
import Singleton.Database;
import entity.Album;
import entity.Artist;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
	    try {
	    	/*Instantierea si testarea metodelor*/
	        ArtistController artist = new ArtistController();
	        AlbumController album = new AlbumController();
	        artist.create("ArtistName1", "Country1");
	        Database.commit();
			System.out.println(ArtistController.findByName("Name1"));
			album.create("AlbumName1",5,2020);
			System.out.println(album.findByArtist);
	        Database.commit();

	        /*optional*/
			Artist entityArtist= new ArtistDAO().getArtist(1);
			Album entityAlbum = new AlbumDAO().getAlbum(3);
			System.out.println(entityArtist);
			System.out.println(entityAlbum);
			ChartController chartController = new ChartController();
			System.out.println(chartController.getTop());

			Database.closeConnection();
        }
    	catch (SQLException e) {
	        System.err.println(e.getMessage());
            Database.rollback();
        }
    }
}
