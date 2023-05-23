package domain.repositories;

import domain.models.ProfilePhoto;

public interface ProfilePhotoPersistenceRepository {
    void save(String customerId, ProfilePhoto profilePhoto);
}
