package dev.igraciarena.blogbackend.controller;

import dev.igraciarena.blogbackend.domain.dto.request.PostCreateRequest;
import dev.igraciarena.blogbackend.domain.dto.request.PostUpdateRequest;
import dev.igraciarena.blogbackend.domain.dto.response.PostResponse;
import dev.igraciarena.blogbackend.service.PostService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
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

    @PostMapping
    public ResponseEntity<PostResponse> addPost(@RequestBody @Valid final PostCreateRequest post) {
        var response = postService.addPost(post);
        return new ResponseEntity<>(response, CREATED);
    }

    @PutMapping
    public ResponseEntity<PostResponse> updatePost(@RequestBody @Valid final PostUpdateRequest post) throws Exception {
        var response = postService.updatePost(post);
        return new ResponseEntity<>(response, OK);
    }

    @DeleteMapping("/{title}")
    public ResponseEntity<PostResponse> deletePost(@PathVariable final String title) throws Exception {
        postService.deletePost(title);
        return new ResponseEntity<>(OK);
    }
}
