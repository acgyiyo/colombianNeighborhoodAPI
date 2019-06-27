package com.acgyiyo.colombianneighborhood.controller;

import com.acgyiyo.colombianneighborhood.model.City;
import com.acgyiyo.colombianneighborhood.model.Department;
import com.acgyiyo.colombianneighborhood.repository.CityRepository;
import com.acgyiyo.colombianneighborhood.repository.DepartmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Service {

  @Autowired
  private DepartmentRepository depRepo;

  @Autowired
  private CityRepository cityRepo;

  @GetMapping
  public String welcome() {
    return "Welcome to Colombian City and Neighborhood API";
  }

  @GetMapping("/department/{id}")
  public Department findDepartment(@PathVariable("id") Integer id) {
    return depRepo.findById(id).get();
  }

  @GetMapping("/city/{id}")
  public City findCityById(@PathVariable("id") Integer id) {
    return cityRepo.findById(id).get();
  }
}