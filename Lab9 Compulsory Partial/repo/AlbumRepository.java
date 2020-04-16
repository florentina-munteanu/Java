package repo;

import controller.ArtistController;
import entity.Album;
import entity.Artist;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class AlbumRepository {
    private EntityManagerFactory entityManagerFactory;

    public AlbumRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public void create(Album album) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(album);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Album> findById(int albumId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("select alb from Album alb where alb.albumId=" + albumId);
        List<Album> albumList = query.setParameter("albumId", albumId).getResultList();
        entityManager.close();
        return albumList.isEmpty() ? null : albumList;
    }

    public Artist findByName(String albumName) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("select alb from Album alb where alb.name=" + albumName);
        List<Album> albumList = query.setParameter("name",artistName).getResultList();
        entityManager.close();
        return albumList.isEmpty()? null : albumList.get(0);
    }
}
