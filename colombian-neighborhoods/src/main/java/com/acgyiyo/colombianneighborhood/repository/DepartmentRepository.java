package com.acgyiyo.colombianneighborhood.repository;

import java.util.List;

import com.acgyiyo.colombianneighborhood.model.Department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer>{
  
  List<Department> findbyName(@Param("name") String name);
  
}