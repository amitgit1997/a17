package com.example.Pageup.controller;

import com.example.Pageup.payload.PostDto;
import com.example.Pageup.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("post")
@CrossOrigin("http://localhost:4200")
public class PostController {

    @Autowired
    private PostService service;

    @PostMapping("save")
    public ResponseEntity<PostDto> savePost(@RequestBody PostDto postDto){
        PostDto dto = service.savePost(postDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deletePost(@PathVariable String id)
    {

        service.deletePost(id);
        return new ResponseEntity<>("Post is Deleted",HttpStatus.OK);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<PostDto> updatePost(@PathVariable String id,@RequestBody PostDto postDto)
    {
        PostDto dto = service.updatePost(id, postDto);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    @GetMapping("getAll")
    public ResponseEntity<List<PostDto>> getAll()
    {
        List<PostDto> dto = service.getAll();
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    @GetMapping("getById")
    public ResponseEntity<PostDto> getById(@RequestParam String id)
    {
        PostDto dto = service.getById(id);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
}
