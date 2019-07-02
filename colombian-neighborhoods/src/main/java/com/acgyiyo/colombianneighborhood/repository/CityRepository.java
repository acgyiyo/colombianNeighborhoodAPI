package com.acgyiyo.colombianneighborhood.repository;

import java.util.List;

import com.acgyiyo.colombianneighborhood.model.City;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

  List<City> findCityByName(@Param("name") String name);

}