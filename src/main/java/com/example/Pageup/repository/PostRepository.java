package com.example.Pageup.repository;

import com.example.Pageup.entity.Registration;
import com.example.Pageup.payload.PostDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Registration, String> {
    PostDto findByEmail(String email);
    PostDto findByUsername(String username);
    PostDto findByMobile(String mobile);
}
