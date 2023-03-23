package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Student;

@Repository
public interface StudentRepositoryClone extends PagingAndSortingRepository<Student, Integer> {
    List<Student> findAllByOrderByAgeDescIeltsScoreAsc();
}

