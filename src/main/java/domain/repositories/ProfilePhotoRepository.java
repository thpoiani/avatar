package domain.repositories;

import domain.models.ProfilePhoto;

public interface ProfilePhotoRepository {
    void save(String customerId, ProfilePhoto profilePhoto);
}
