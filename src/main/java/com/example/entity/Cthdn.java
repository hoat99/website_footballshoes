package com.example.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Table(name = "cthdn")
@Entity
@Setter
@Getter
public class Cthdn extends BaseTimeModel {
    @EmbeddedId
    private CthdnId id;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

  
}