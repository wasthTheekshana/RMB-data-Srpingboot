package com.example.RMB.data.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "User")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    "name", "licenseNumber", "address", "NICNumber"
    private String name;
    private String licenseNumber;
    private String address;
    private String NICNumber;
}
