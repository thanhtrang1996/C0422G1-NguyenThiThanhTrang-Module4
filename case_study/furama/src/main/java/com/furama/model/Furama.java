package com.furama.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "furama")
public class Furama {
    @Id
    private Integer id;
}
