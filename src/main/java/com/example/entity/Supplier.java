package com.example.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Table(name = "supplier")
@Entity
@Getter
@Setter
public class Supplier extends BaseTimeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "description")
    private String description;
}