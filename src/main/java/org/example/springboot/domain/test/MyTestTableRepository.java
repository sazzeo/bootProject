package org.example.springboot.domain.test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface MyTestTableRepository extends JpaRepository {


    @Query("SELECT p FROM MyTestTable p ORDER BY p.reqNo DESC")
    List<MyTestTable> findAllDesc();

}
