package entity;

public class Chart {
    private int id;
    private String albumName;
    private String artistName;
    private int views;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    @Override
    public String toString() {
        return "Chart{" +
                "id=" + id +
                ", albumName='" + albumName + '\'' +
                ", artistName='" + artistName + '\'' +
                ", views=" + views +
                '}';
    }
}
