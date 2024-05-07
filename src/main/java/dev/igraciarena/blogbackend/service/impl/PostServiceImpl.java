package dev.igraciarena.blogbackend.service.impl;

import dev.igraciarena.blogbackend.domain.dto.request.PostCreateRequest;
import dev.igraciarena.blogbackend.domain.dto.request.PostUpdateRequest;
import dev.igraciarena.blogbackend.domain.dto.response.PostResponse;
import dev.igraciarena.blogbackend.mapper.PostMapper;
import dev.igraciarena.blogbackend.repository.PostRepository;
import dev.igraciarena.blogbackend.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ivan.graciarena
 * @project blog-backend
 */
@Service
public class PostServiceImpl implements PostService {

    private static final PostMapper POST_MAPPER = PostMapper.INSTANCE;
    private final PostRepository postRepository;

    public PostServiceImpl(final PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<PostResponse> getPosts() {
        return POST_MAPPER.mapToResponseList(postRepository.findAll());
    }

    @Override
    public PostResponse addPost(final PostCreateRequest post) {
        var entity = postRepository.save(POST_MAPPER.mapToEntity(post));
        return POST_MAPPER.mapToResponse(entity);
    }

    @Override
    public PostResponse updatePost(PostUpdateRequest post) throws Exception {
        var postToBeUpdated = postRepository
                .findByTitle(post.getTitle())
                .orElseThrow(() -> new Exception("not found"));
        var postToBeSaved = POST_MAPPER.mapToUpdated(postToBeUpdated, post);
        return POST_MAPPER.mapToResponse(postRepository.save(postToBeSaved));
    }

    @Override
    public void deletePost(String title) throws Exception {
        var post = postRepository
                .findByTitle(title)
                .orElseThrow(() -> new Exception("not found"));
        postRepository.delete(post);
    }
}
