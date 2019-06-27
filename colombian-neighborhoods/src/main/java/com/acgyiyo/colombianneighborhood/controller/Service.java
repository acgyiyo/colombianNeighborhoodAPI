package com.acgyiyo.colombianneighborhood.controller;

import com.acgyiyo.colombianneighborhood.model.Department;
import com.acgyiyo.colombianneighborhood.repository.DepartmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Service {

  @Autowired
  private DepartmentRepository depRepo;

  @GetMapping
  public String welcome() {
    return "welcome";
  }

  @GetMapping("/hello")
  public String hello() {
    return "hello";
  }

  @GetMapping("/department")
  public Department findDepartment() {
    return depRepo.findAll().get(6);
  }

}