package com.example.demo.repository;

import com.example.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// jpa api
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // JpaRepository가 이미 만들어 놔서 상속 받으면 됨..
    // entity(table 정보)와 pk의 자료형 적어주어야 함
    // 그걸 보고 구현해준다....?

    // -- 1. JPA에서 제공해주는 메서드를 사용
    // 책 번호(id)가 일치하는 책을 가져오자.
    // public Optional<Book> findById(Long id);
    // select * from Book b where b.id = id;

    // -- 2. 쿼리메서드(규칙을 가지고 메서드를 만들면 자동으로 SQL을 생성)
    // 책 제목(title)이 일치하는 책을 가져오자
    // public Optional<Book> findByTitle(String title);
    // findBy + 가지고 올 컬럼명 -> JPA가 알아서 해석하여 가져옴
    // select * from Book b where b.title = title;
    // findByTitleAndPage(String title, int page);



}
/*
  public class EntityManager implements BookRepository{
        // JDBC
        public List<Book> findAll(){
            1. SQL(JPQL:사용자정의SQL) : select * from Book(Table명 Entity명이므로 대소문자 주의)
            2. Book
            3. List
        }
  }

 */
