package com.example.Pageup.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Pinnacle_1")
public class Registration {
    @Id
    private String id;
    private String username;
    private String firstName;
    private String lastName;
    private long mobile;
    private String email;
    private String password;
}
