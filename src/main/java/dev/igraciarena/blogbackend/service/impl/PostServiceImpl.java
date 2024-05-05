package dev.igraciarena.blogbackend.service.impl;

import dev.igraciarena.blogbackend.domain.dto.PostResponse;
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
}
