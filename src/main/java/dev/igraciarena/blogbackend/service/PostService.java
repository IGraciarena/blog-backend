package dev.igraciarena.blogbackend.service;

import dev.igraciarena.blogbackend.domain.dto.PostResponse;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ivan.graciarena
 * @project blog-backend
 */
@Service
public interface PostService {
    List<PostResponse> getPosts();
}
