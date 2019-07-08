package com.acgyiyo.colombianneighborhood.controller;

import java.util.List;

import com.acgyiyo.colombianneighborhood.model.City;
import com.acgyiyo.colombianneighborhood.model.Department;
import com.acgyiyo.colombianneighborhood.model.Neighborhood;
import com.acgyiyo.colombianneighborhood.repository.CityRepository;
import com.acgyiyo.colombianneighborhood.repository.DepartmentRepository;
import com.acgyiyo.colombianneighborhood.repository.NeighborhoodRepository;

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

  @Autowired
  private NeighborhoodRepository neighRepo;

  @GetMapping
  public String welcome() {
    return "Welcome to Colombian City and Neighborhood API";
  }

  @GetMapping("/department/{id}")
  public Department findDepartment(@PathVariable("id") Integer id) {
    return depRepo.findById(id).get();
  }

  @GetMapping("/departmentName/{name}")
  public List<Department> findDepartmentByName(@PathVariable("name") String name) {
    return depRepo.findbyName(name);
  }

  @GetMapping("/city/{id}")
  public City findCityById(@PathVariable("id") Integer id) {
    return cityRepo.findById(id).get();
  }

  @GetMapping("/cities/{name}")
  public List<City> findCityByName(@PathVariable("name") String name) {
    return cityRepo.findCityByName(name);
  }

  @GetMapping("/neighborhoods/{name}")
  public List<Neighborhood> findNeighborhoodByName(@PathVariable("name") String name) {
    return neighRepo.findNeighborhoodByName(name);
  }

}