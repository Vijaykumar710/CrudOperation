package com.curdoperation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity // identify the class
public class Student {// encapulation_process

    @Id // indicate primary key
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // provide specification values to primary key
    private Long id;
    private String name;
    private String role;
    private Long number;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", number=" + number +
                '}';
    }
}
