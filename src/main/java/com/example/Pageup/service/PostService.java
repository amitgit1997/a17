package com.example.Pageup.service;

import com.example.Pageup.payload.PostDto;

import java.util.List;

public interface PostService {
    PostDto savePost(PostDto postDto);

    void deletePost(String id);

    PostDto updatePost(String id, PostDto postDto);

    List<PostDto> getAll();

    PostDto getById(String id);
}
