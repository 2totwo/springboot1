package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity // JPA API -> create table book
// JPA API(엔진 : Hibernate)
// Object -> table Mapping : ORM -> SQL 생성
public class Book {
    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동증가컬럼
    private Long id;

    // name=DB명칭 설정할 수 있다, unique=중복, nullable=null여부, length = default 255
    @Column(name = "title", unique = true, nullable = false, length = 40)
    private String title; 
    private int price;
    private String author;
    private int page;
}
