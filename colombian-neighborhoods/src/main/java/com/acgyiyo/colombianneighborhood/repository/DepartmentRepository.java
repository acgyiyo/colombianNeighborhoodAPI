package com.acgyiyo.colombianneighborhood.repository;

import com.acgyiyo.colombianneighborhood.model.Department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer>{

}