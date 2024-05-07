package dev.igraciarena.blogbackend.repository;

import dev.igraciarena.blogbackend.domain.entities.PostEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author ivan.graciarena
 * @project blog-backend
 */
@Repository
public interface PostRepository extends MongoRepository<PostEntity, String> {
    Optional<PostEntity> findByTitle(final String title);
}
