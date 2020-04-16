package repo;

import controller.ArtistController;
import entity.Artist;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class ArtistRepository {
    private EntityManagerFactory entityManagerFactory;

    public ArtistRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public void create(Artist artist) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(artist);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Artist> findById(int artistId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("select a from Artist a where a.artistId=" + artistId);
        List<Artist> artists = query.setParameter("artistId", artistId).getResultList();
        entityManager.close();

        return artists.isEmpty() ? null : artists;
    }

    public Artist findByName(String artistName) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("select a from Artist a where a.name=" + artistName);
        List<Artist> artistList = query.setParameter("name",artistName).getResultList();
        entityManager.close();
        return artistList.isEmpty()? null : artistList.get(0);
    }
}
