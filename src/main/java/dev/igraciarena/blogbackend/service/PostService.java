package dev.igraciarena.blogbackend.service;

import dev.igraciarena.blogbackend.domain.dto.request.PostCreateRequest;
import dev.igraciarena.blogbackend.domain.dto.request.PostUpdateRequest;
import dev.igraciarena.blogbackend.domain.dto.response.PostResponse;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ivan.graciarena
 * @project blog-backend
 */
@Service
public interface PostService {
    List<PostResponse> getPosts();

    PostResponse addPost(final PostCreateRequest post);

    PostResponse updatePost(final PostUpdateRequest post) throws Exception;
    void deletePost(final String title) throws Exception;
}
