package com.example.musicstreamingplatform.crud1;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "user")
public class UEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long Id;
private String name;
private String email;
private String password;
private String subscriptionType;
private String dateOfBirth;
}