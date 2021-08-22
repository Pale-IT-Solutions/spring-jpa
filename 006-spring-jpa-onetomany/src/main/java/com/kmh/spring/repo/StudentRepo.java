package com.kmh.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kmh.spring.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

	Student findAllById(int i);

}
