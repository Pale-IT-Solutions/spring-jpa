package com.kmh.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kmh.spring.entity.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer> {

}
