package dev.igraciarena.blogbackend.repository;

import dev.igraciarena.blogbackend.domain.entities.PostEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ivan.graciarena
 * @project blog-backend
 */
@Repository
public interface PostRepository extends MongoRepository<PostEntity, String> {
}
