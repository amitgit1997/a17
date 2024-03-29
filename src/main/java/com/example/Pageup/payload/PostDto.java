package com.example.Pageup.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

    private String id;
    private String username;
    private String firstName;
    private String lastName;
    private long mobile;
    private String email;
    private String password;
}
