package com.example.Pageup.service;

import com.example.Pageup.entity.Registration;
import com.example.Pageup.exception.ResourceNotFound;
import com.example.Pageup.payload.PostDto;
import com.example.Pageup.repository.PostRepository;
import com.example.Pageup.util.MapsStruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository repo;

    @Autowired
    private MapsStruct map;

    public PostDto mapToDto(Registration registration){
        PostDto dto = map.mapToDto(registration);
        return dto;
    }
    public Registration mapToEntity(PostDto postDto)
    {
        return map.mapToEntity(postDto);

    }

    @Override
    public PostDto savePost(PostDto postDto) {
        String string = UUID.randomUUID().toString();
        postDto.setId(string);
        Registration registration = map.mapToEntity(postDto);
        Registration save = repo.save(registration);
        PostDto dto = map.mapToDto(save);
        return dto;
    }

    @Override
    public void deletePost(String id) {
        Registration registration = repo.findById(id).orElseThrow(() -> new
                ResourceNotFound("User Not Found With id : " + id));
        repo.deleteById(id);
    }

    @Override
    public PostDto updatePost(String id, PostDto postDto) {
        Registration registration = repo.findById(id).orElseThrow(() ->
                new ResourceNotFound("User Not Found with id : " + id));
        if(registration != null) {
            map.updateRegistration(postDto, registration);
            Registration save = repo.save(registration);
            PostDto dto = mapToDto(save);
            return dto;
        }
        return null;
    }

    @Override
    public List<PostDto> getAll() {
        List<Registration> all = repo.findAll();
        List<PostDto> dto = all.stream().map(this::mapToDto).collect(Collectors.toList());
        return dto;
    }

    @Override
    public PostDto getById(String id) {
        Registration registration = repo.findById(id).orElseThrow(() -> new ResourceNotFound("User Not Found with Id : " + id));
        PostDto dto = mapToDto(registration);
        return dto;

    }


}
