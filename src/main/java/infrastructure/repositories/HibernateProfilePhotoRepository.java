package infrastructure.repositories;

import domain.models.ProfilePhoto;
import domain.repositories.ProfilePhotoRepository;
import infrastructure.repositories.entities.CustomerProfilePhotos;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class HibernateProfilePhotoRepository implements ProfilePhotoRepository {
    private final EntityManager entityManager;

    public HibernateProfilePhotoRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(String customerId, ProfilePhoto profilePhoto) {
        entityManager.merge(CustomerProfilePhotos.fromDomain(customerId, profilePhoto));
    }
}
