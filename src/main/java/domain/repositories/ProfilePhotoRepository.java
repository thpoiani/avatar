package domain.repositories;

import domain.models.ProfilePhoto;

import java.util.Map;

public interface ProfilePhotoRepository {
    void registerEntities(Map<String, ProfilePhoto> entities);
    void commit();
    void rollback();
}
