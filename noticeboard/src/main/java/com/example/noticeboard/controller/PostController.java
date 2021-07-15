package com.example.noticeboard.controller;


import com.example.noticeboard.dto.PostRequestDto;
import com.example.noticeboard.model.Post;
import com.example.noticeboard.repository.PostRepository;
import com.example.noticeboard.service.PostService;
import lombok.RequiredArgsConstructor;


import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostRepository postRepository;
    private final PostService postService;

    @PostMapping("/api/posts")
    public Post createPost(@RequestBody PostRequestDto requestDto) {
        Post post = new Post(requestDto.getTitle(), requestDto.getAuthor(), requestDto.getContents());
        return postRepository.save(post);
    }



    @GetMapping("/api/posts")
    public List<Post> getPosts() {
        LocalDateTime start = LocalDateTime.now().minusDays(1);
        LocalDateTime end = LocalDateTime.now();
        System.out.println(postRepository.findAll(Sort.by(Sort.Direction.DESC,"createdAt")));
        return postRepository.findAll(Sort.by(Sort.Direction.DESC,"createdAt"));

    }

    @GetMapping("/api/posts/{id}")
    public Optional<Post> getDetail(@PathVariable Long id) {
        LocalDateTime start = LocalDateTime.now().minusDays(1);
        LocalDateTime end = LocalDateTime.now();
        System.out.println(postRepository.findById(id));
        return postRepository.findById(id);

    }
}
