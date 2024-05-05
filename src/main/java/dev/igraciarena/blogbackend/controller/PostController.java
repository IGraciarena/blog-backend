package dev.igraciarena.blogbackend.controller;

import dev.igraciarena.blogbackend.domain.dto.PostResponse;
import dev.igraciarena.blogbackend.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

/**
 * @author ivan.graciarena
 * @project blog-backend
 */
@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    public PostController(final PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<List<PostResponse>> getPosts() {
        var posts = postService.getPosts();
        return new ResponseEntity<>(posts, OK);
    }
}
